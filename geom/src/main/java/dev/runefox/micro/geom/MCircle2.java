package dev.runefox.micro.geom;

import java.util.Objects;

public class MCircle2 implements Circle2 {
    private double x, y, r;

    public MCircle2(double x, double y, double r) {
        set(x, y, r);
    }

    public MCircle2(Vec2 c, double r) {
        set(c, r);
    }

    public MCircle2(double r) {
        set(r);
    }

    public MCircle2(Circle2 c) {
        set(c);
    }

    public MCircle2() {
        reset();
    }

    @Override
    public Circle2 set(double x, double y, double r) {
        this.x = x;
        this.y = y;
        this.r = r;
        change();
        return this;
    }

    protected void change() {
    }

    @Override
    public double x() {
        return x;
    }

    @Override
    public double y() {
        return y;
    }

    @Override
    public double r() {
        return r;
    }

    @Override
    public Circle2 x(double x) {
        this.x = x;
        change();
        return this;
    }

    @Override
    public Circle2 y(double y) {
        this.y = y;
        change();
        return this;
    }

    @Override
    public Circle2 r(double r) {
        this.r = r;
        change();
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
