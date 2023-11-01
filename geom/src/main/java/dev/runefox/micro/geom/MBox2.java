package dev.runefox.micro.geom;

import java.util.Objects;

public class MBox2 implements Box2 {
    private double x, y, w, h;

    public MBox2(double x, double y, double w, double h) {
        set(x, y, w, h);
    }

    public MBox2(Vec2 c, double w, double h) {
        set(c, w, h);
    }

    public MBox2(Vec2 c, Dim2 d) {
        set(c, d);
    }

    public MBox2(Box2 b) {
        set(b);
    }

    public MBox2() {
        reset();
    }

    @Override
    public Box2 set(double x, double y, double w, double h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
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
    public double w() {
        return w;
    }

    @Override
    public double h() {
        return h;
    }

    @Override
    public Box2 x(double x) {
        this.x = x;
        change();
        return this;
    }

    @Override
    public Box2 y(double y) {
        this.y = y;
        change();
        return this;
    }

    @Override
    public Box2 w(double w) {
        this.w = w;
        change();
        return this;
    }

    @Override
    public Box2 h(double h) {
        this.h = h;
        change();
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Box2 that)) return false;
        return Double.compare(that.x(), x) == 0
               && Double.compare(that.y(), y) == 0
               && Double.compare(that.w(), w) == 0
               && Double.compare(that.h(), h) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, w, h);
    }
}
