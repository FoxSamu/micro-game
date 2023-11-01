package dev.runefox.micro.geom;

/**
 * A vector. Represented as a pair of cartesian coordinates (X, Y).
 */
public interface Vec2 {
    double x();
    double y();

    Vec2 x(double x);
    Vec2 y(double y);

    default Vec2 set(double x, double y) {
        x(x);
        y(y);
        return this;
    }

    default Vec2 set(Vec2 o) {
        return set(o.x(), o.y());
    }

    default Vec2 set(Dir2 dir, double len) {
        return set(dir.x() * len, dir.y() * len);
    }

    default Vec2 setUp(double l) {
        return set(0, l);
    }

    default Vec2 setDown(double l) {
        return set(0, -l);
    }

    default Vec2 setLeft(double l) {
        return set(-l, 0);
    }

    default Vec2 setRight(double l) {
        return set(l, 0);
    }

    default Vec2 reset() {
        return set(0, 0);
    }

    default double mag2() {
        double x = x();
        double y = y();
        return x * x + y * y;
    }

    default double mag() {
        return Math.sqrt(mag2());
    }

    default double dot(Vec2 o) {
        return x() * o.x() + y() * o.y();
    }

    default double dot(double x, double y) {
        return x() * x + y() * y;
    }

    default double cross(Vec2 o) {
        return x() * o.y() - y() * o.x();
    }

    default double cross(double x, double y) {
        return x() * y - y() * x;
    }

    default boolean isNaN() {
        return Double.isNaN(x()) || Double.isNaN(y());
    }

    default Vec2 norm(Vec2 res) {
        double x = x();
        double y = y();
        double mag = mag();
        if (mag == 0)
            return res.set(1, 0);
        else
            return res.set(x / mag, y / mag);
    }

    default Vec2 norm() {
        return norm(this);
    }

    default Vec2 lperp(Vec2 res) {
        return res.set(y(), -x());
    }

    default Vec2 lperp() {
        return lperp(this);
    }

    default Vec2 rperp(Vec2 res) {
        return res.set(y(), -x());
    }

    default Vec2 rperp() {
        return rperp(this);
    }

    default Vec2 neg(Vec2 res) {
        return res.set(-x(), -y());
    }

    default Vec2 neg() {
        return neg(this);
    }

    default Vec2 add(double x, double y, Vec2 res) {
        return res.set(x() + x, y() + y);
    }

    default Vec2 add(Vec2 o, Vec2 res) {
        return add(o.x(), o.y(), res);
    }

    default Vec2 add(double x, double y) {
        return add(x, y, this);
    }

    default Vec2 add(Vec2 o) {
        return add(o.x(), o.y(), this);
    }

    default Vec2 addscl(double x, double y, double s, Vec2 res) {
        return res.set(x() + x * s, y() + y * s);
    }

    default Vec2 addscl(Vec2 o, double s, Vec2 res) {
        return addscl(o.x(), o.y(), s, res);
    }

    default Vec2 addscl(double x, double y, double s) {
        return addscl(x, y, s, this);
    }

    default Vec2 addscl(Vec2 o, double s) {
        return addscl(o.x(), o.y(), s, this);
    }

    default Vec2 sub(double x, double y, Vec2 res) {
        return res.set(x() - x, y() - y);
    }

    default Vec2 sub(Vec2 o, Vec2 res) {
        return sub(o.x(), o.y(), res);
    }

    default Vec2 sub(double x, double y) {
        return sub(x, y, this);
    }

    default Vec2 sub(Vec2 o) {
        return sub(o.x(), o.y(), this);
    }

    default Vec2 subscl(double x, double y, double s, Vec2 res) {
        return res.set(x() - x * s, y() - y * s);
    }

    default Vec2 subscl(Vec2 o, double s, Vec2 res) {
        return subscl(o.x(), o.y(), s, res);
    }

    default Vec2 subscl(double x, double y, double s) {
        return subscl(x, y, s, this);
    }

    default Vec2 subscl(Vec2 o, double s) {
        return subscl(o.x(), o.y(), s, this);
    }

    default Vec2 mul(double x, double y, Vec2 res) {
        return res.set(x() * x, y() * y);
    }

    default Vec2 mul(double s, Vec2 res) {
        return mul(s, s, res);
    }

    default Vec2 mul(Vec2 o, Vec2 res) {
        return mul(o.x(), o.y(), res);
    }

    default Vec2 mul(double x, double y) {
        return mul(x, y, this);
    }

    default Vec2 mul(double s) {
        return mul(s, s, this);
    }

    default Vec2 mul(Vec2 o) {
        return mul(o.x(), o.y(), this);
    }

    default Vec2 div(double x, double y, Vec2 res) {
        return res.set(x() / x, y() / y);
    }

    default Vec2 div(double s, Vec2 res) {
        return div(s, s, res);
    }

    default Vec2 div(Vec2 o, Vec2 res) {
        return div(o.x(), o.y(), res);
    }

    default Vec2 div(double x, double y) {
        return div(x, y, this);
    }

    default Vec2 div(double s) {
        return div(s, s, this);
    }

    default Vec2 div(Vec2 o) {
        return div(o.x(), o.y(), this);
    }

    default double val(Dir2 axis) {
        return switch (axis) {
            case UP -> y();
            case DOWN -> -y();
            case LEFT -> -x();
            case RIGHT -> x();
        };
    }

    default IVec2 freeze() {
        return new IVec2(x(), y());
    }

    default MVec2 copy() {
        return new MVec2(x(), y());
    }

    interface Immutable extends Vec2 {
        @Override
        default Vec2 x(double x) {
            throw new UnsupportedOperationException("Unable to change immutable vector");
        }

        @Override
        default Vec2 y(double y) {
            throw new UnsupportedOperationException("Unable to change immutable vector");
        }
    }

    class Mirror implements Immutable {
        private final Vec2 mirror;

        public Mirror(Vec2 mirror) {
            this.mirror = mirror;
        }

        @Override
        public double x() {
            return mirror.x();
        }

        @Override
        public double y() {
            return mirror.y();
        }
    }
}
