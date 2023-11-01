package dev.runefox.micro.geom;

import java.util.Objects;

public class MExts2 implements Exts2 {
    private double t, r, b, l;

    public MExts2(double t, double r, double b, double l) {
        set(t, r, b, l);
    }

    public MExts2(double t, double h, double b) {
        set(t, h, b);
    }

    public MExts2(double v, double h) {
        set(v, h);
    }

    public MExts2(double i) {
        set(i);
    }

    public MExts2(Exts2 e) {
        set(e);
    }

    public MExts2() {
        reset();
    }

    @Override
    public Exts2 set(double t, double r, double b, double l) {
        this.t = t;
        this.r = r;
        this.b = b;
        this.l = l;
        change();
        return this;
    }

    protected void change() {
    }

    @Override
    public double t() {
        return t;
    }

    @Override
    public double r() {
        return r;
    }

    @Override
    public double b() {
        return b;
    }

    @Override
    public double l() {
        return l;
    }

    @Override
    public Exts2 t(double t) {
        this.t = t;
        change();
        return this;
    }

    @Override
    public Exts2 r(double r) {
        this.r = r;
        change();
        return this;
    }

    @Override
    public Exts2 b(double b) {
        this.b = b;
        change();
        return this;
    }

    @Override
    public Exts2 l(double l) {
        this.l = l;
        change();
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
