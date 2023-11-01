package dev.runefox.micro.geom;

import java.util.Objects;

public record IBox2(double x, double y, double w, double h) implements Box2.Immutable {
    public IBox2(Vec2 c, double w, double h) {
        this(c.x(), c.y(), w, h);
    }

    public IBox2(Vec2 c, Dim2 d) {
        this(c.x(), c.y(), d.w(), d.h());
    }

    public IBox2(Box2 o) {
        this(o.x(), o.y(), o.w(), o.h());
    }

    @Override
    public IBox2 freeze() {
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Box2 that)) return false;
        return Double.compare(that.x(), x) == 0
               && Double.compare(that.y(), y) == 0
               && Double.compare(that.w(), w) == 0
               && Double.compare(that.h(), h) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, w, h);
    }
}
