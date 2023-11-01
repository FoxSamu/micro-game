package dev.runefox.micro.geom;

import java.util.Objects;

public record IVec2(double x, double y) implements Vec2.Immutable {
    public IVec2(Vec2 o) {
        this(o.x(), o.y());
    }

    @Override
    public IVec2 freeze() {
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vec2 that)) return false;
        return Double.compare(that.x(), x) == 0 && Double.compare(that.y(), y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public static IVec2 up(double l) {
        return new IVec2(0, l);
    }

    public static IVec2 down(double l) {
        return new IVec2(0, -l);
    }

    public static IVec2 left(double l) {
        return new IVec2(-l, 0);
    }

    public static IVec2 right(double l) {
        return new IVec2(l, 0);
    }
}
