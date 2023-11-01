package dev.runefox.micro.geom;

import java.util.Objects;

public class MDim2 implements Dim2 {
    private double w;
    private double h;

    public MDim2(double w, double h) {
        set(w, h);
    }

    public MDim2(Dim2 o) {
        set(o);
    }

    public MDim2() {
        reset();
    }

    @Override
    public Dim2 set(double w, double h) {
        this.w = w;
        this.h = h;
        changed();
        return this;
    }

    protected void changed() {
    }

    @Override
    public double w() {
        return w;
    }

    @Override
    public double h() {
        return h;
    }

    @Override
    public Dim2 w(double w) {
        this.w = w;
        changed();
        return this;
    }

    @Override
    public Dim2 h(double h) {
        this.h = h;
        changed();
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
