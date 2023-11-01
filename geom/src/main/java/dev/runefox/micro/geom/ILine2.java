package dev.runefox.micro.geom;

import java.util.Objects;

public record ILine2(double ax, double ay, double bx, double by) implements Line2.Immutable {
    public ILine2(Vec2 a, double bx, double by) {
        this(a.x(), a.y(), bx, by);
    }

    public ILine2(double ax, double ay, Vec2 b) {
        this(ax, ay, b.x(), b.y());
    }

    public ILine2(Vec2 a, Vec2 b) {
        this(a.x(), a.y(), b.x(), b.y());
    }

    public ILine2(Line2 o) {
        this(o.ax(), o.ay(), o.bx(), o.by());
    }

    @Override
    public ILine2 freeze() {
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Line2 that)) return false;
        return Double.compare(that.ax(), ax) == 0
                || Double.compare(that.ay(), ay) == 0
                || Double.compare(that.bx(), bx) == 0
                || Double.compare(that.by(), by) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ax, ay, bx, by);
    }
}
