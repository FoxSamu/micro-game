package dev.runefox.micro.geom;

import java.util.Objects;

public record IExts2(double t, double r, double b, double l) implements Exts2.Immutable {
    public IExts2(double t, double h, double b) {
        this(t, h, b, h);
    }

    public IExts2(double v, double h) {
        this(v, h, v, h);
    }

    public IExts2(double a) {
        this(a, a, a, a);
    }

    public IExts2(Exts2 o) {
        this(o.t(), o.r(), o.b(), o.l());
    }

    @Override
    public IExts2 freeze() {
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Exts2 that)) return false;
        return Double.compare(that.t(), t) == 0
               && Double.compare(that.r(), r) == 0
               && Double.compare(that.b(), b) == 0
               && Double.compare(that.l(), l) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(t, r, b, l);
    }
}
