package dev.runefox.micro.geom;

import java.util.Objects;

public record IDim2(double w, double h) implements Dim2.Immutable {
    public IDim2(Dim2 dim) {
        this(dim.w(), dim.h());
    }

    @Override
    public IDim2 freeze() {
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dim2 that)) return false;
        return Double.compare(that.w(), w) == 0 && Double.compare(that.h(), h) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(w, h);
    }
}
