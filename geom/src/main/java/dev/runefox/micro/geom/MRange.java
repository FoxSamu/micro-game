package dev.runefox.micro.geom;

import java.util.Objects;

public class MRange implements Range {
    private double a;
    private double l;

    public MRange(double a, double l) {
        set(a, l);
    }

    public MRange(Range o) {
        set(o);
    }

    public MRange() {
        reset();
    }

    @Override
    public Range set(double a, double l) {
        this.a = a;
        this.l = l;
        change();
        return this;
    }

    public void change() {
    }

    @Override
    public double a() {
        return a;
    }

    @Override
    public double l() {
        return l;
    }

    @Override
    public Range a(double a) {
        this.a = a;
        change();
        return this;
    }

    @Override
    public Range l(double l) {
        this.l = l;
        change();
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
