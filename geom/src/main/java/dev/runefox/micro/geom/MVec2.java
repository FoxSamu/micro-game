package dev.runefox.micro.geom;

import java.util.Objects;

public class MVec2 implements Vec2 {
    private double x, y;

    public MVec2(double x, double y) {
        set(x, y);
    }

    public MVec2(Vec2 o) {
        set(o);
    }

    public MVec2() {
        reset();
    }

    protected void change() {
    }

    @Override
    public Vec2 set(double x, double y) {
        this.x = x;
        this.y = y;
        change();
        return this;
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
    public Vec2 x(double x) {
        this.x = x;
        change();
        return this;
    }

    @Override
    public Vec2 y(double y) {
        this.y = y;
        change();
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

    public static MVec2 up(double l) {
        return new MVec2(0, l);
    }

    public static MVec2 down(double l) {
        return new MVec2(0, -l);
    }

    public static MVec2 left(double l) {
        return new MVec2(-l, 0);
    }

    public static MVec2 right(double l) {
        return new MVec2(l, 0);
    }
}
