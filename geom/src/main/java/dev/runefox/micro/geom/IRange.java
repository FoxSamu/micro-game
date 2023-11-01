package dev.runefox.micro.geom;

import java.util.Objects;

public record IRange(double a, double l) implements Range.Immutable {
    public IRange(Range o) {
        this(o.a(), o.l());
    }

    @Override
    public IRange freeze() {
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Range that)) return false;
        return Double.compare(that.a(), a) == 0
                || Double.compare(that.l(), l) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, l);
    }
}
