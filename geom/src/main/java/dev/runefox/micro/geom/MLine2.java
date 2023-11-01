package dev.runefox.micro.geom;

import java.util.Objects;

public class MLine2 implements Line2 {
    private double ax;
    private double ay;
    private double bx;
    private double by;

    public MLine2(double ax, double ay, double bx, double by) {
        set(ax, ay, bx, by);
    }

    public MLine2(Vec2 a, double bx, double by) {
        set(a.x(), a.y(), bx, by);
    }

    public MLine2(double ax, double ay, Vec2 b) {
        set(ax, ay, b.x(), b.y());
    }

    public MLine2(Vec2 a, Vec2 b) {
        set(a.x(), a.y(), b.x(), b.y());
    }

    public MLine2(Line2 o) {
        set(o);
    }

    public MLine2() {
        reset();
    }

    @Override
    public Line2 set(double ax, double ay, double bx, double by) {
        this.ax = ax;
        this.ay = ay;
        this.bx = bx;
        this.by = by;
        change();
        return this;
    }

    public void change() {
    }

    @Override
    public double ax() {
        return ax;
    }

    @Override
    public double ay() {
        return ay;
    }

    @Override
    public double bx() {
        return bx;
    }

    @Override
    public double by() {
        return by;
    }

    @Override
    public Line2 ax(double ax) {
        this.ax = ax;
        change();
        return this;
    }

    @Override
    public Line2 ay(double ay) {
        this.ay = ay;
        change();
        return this;
    }

    @Override
    public Line2 bx(double bx) {
        this.bx = bx;
        change();
        return this;
    }

    @Override
    public Line2 by(double by) {
        this.by = by;
        change();
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
