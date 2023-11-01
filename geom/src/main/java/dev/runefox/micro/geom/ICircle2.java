package dev.runefox.micro.geom;

import java.util.Objects;

public record ICircle2(double x, double y, double r) implements Circle2.Immutable {
    public ICircle2(Vec2 c, double r) {
        this(c.x(), c.y(), r);
    }

    public ICircle2(double r) {
        this(0, 0, r);
    }

    public ICircle2(Circle2 o) {
        this(o.x(), o.y(), o.r());
    }

    @Override
    public ICircle2 freeze() {
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Circle2 that)) return false;
        return Double.compare(that.x(), x) == 0
               && Double.compare(that.y(), y) == 0
               && Double.compare(that.r(), r) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, r);
    }
}
