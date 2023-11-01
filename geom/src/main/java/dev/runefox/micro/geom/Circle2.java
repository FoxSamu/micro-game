package dev.runefox.micro.geom;

/**
 * A circle. Represented using a center point (X, Y), and a radius (R).
 */
public interface Circle2 {
    double x();
    double y();
    double r();

    Circle2 x(double x);
    Circle2 y(double y);
    Circle2 r(double r);

    default Circle2 set(double x, double y, double r) {
        x(x);
        y(y);
        r(r);
        return this;
    }

    default Circle2 set(Vec2 c, double r) {
        return set(c.x(), c.y(), r);
    }

    default Circle2 set(double r) {
        return set(0, 0, r);
    }

    default Circle2 set(Circle2 c) {
        return set(c.x(), c.y(), c.r());
    }

    default Circle2 setUnit(double x, double y) {
        return set(x, y, 1);
    }

    default Circle2 setUnit(Vec2 c) {
        return set(c, 1);
    }

    default Circle2 setUnit() {
        return set(1);
    }

    default Circle2 setPoint(double x, double y) {
        return set(x, y, 0);
    }

    default Circle2 setPoint(Vec2 c) {
        return set(c, 0);
    }

    default Circle2 reset() {
        return set(0, 0, 0);
    }

    default Vec2 c(Vec2 res) {
        return res.set(x(), y());
    }

    default double r2() {
        double r = r();
        return r * r;
    }

    default double d() {
        return r() * 2;
    }

    default Circle2 d(double d) {
        return r(d / 2);
    }

    default double area() {
        return r2() * Math.PI;
    }

    default double perim() {
        return d() * Math.PI;
    }

    default Circle2 move(double x, double y, Circle2 res) {
        return res.set(x() + x, y() + y, r());
    }

    default Circle2 move(Vec2 v, Circle2 res) {
        return move(v.x(), v.y(), res);
    }

    default Circle2 move(double x, double y) {
        return move(x, y, this);
    }

    default Circle2 move(Vec2 v) {
        return move(v, this);
    }

    default Circle2 movescl(double x, double y, double s, Circle2 res) {
        return res.set(x() + x * s, y() + y * s, r());
    }

    default Circle2 movescl(Vec2 v, double s, Circle2 res) {
        return movescl(v.x(), v.y(), s, res);
    }

    default Circle2 movescl(double x, double y, double s) {
        return movescl(x, y, s, this);
    }

    default Circle2 movescl(Vec2 v, double s) {
        return movescl(v, s, this);
    }

    default Circle2 grow(double s, Circle2 res) {
        return res.set(x(), y(), r() + s);
    }

    default Circle2 grow(double s) {
        return grow(s, this);
    }

    default Circle2 shrink(double s, Circle2 res) {
        return res.set(x(), y(), r() - s);
    }

    default Circle2 shrink(double s) {
        return shrink(s, this);
    }

    default Box2 boundingBox(Box2 res) {
        return res.setCenter(x(), y(), d());
    }

    default boolean contains(double x, double y) {
        double dx = x() - x;
        double dy = y() - y;
        return dx * dx + dy * dy <= r2();
    }

    default boolean contains(Vec2 v) {
        return contains(v.x(), v.y());
    }

    default ICircle2 freeze() {
        return new ICircle2(x(), y(), r());
    }

    default MCircle2 copy() {
        return new MCircle2(x(), y(), r());
    }

    public static boolean intersect(Circle2 a, Circle2 b) {
        double dx = a.x() - b.x();
        double dy = a.y() - b.y();
        return dx * dx + dy * dy <= a.r2() + b.r2();
    }

    interface Immutable extends Circle2 {
        @Override
        default Circle2 x(double x) {
            throw new UnsupportedOperationException("Unable to change immutable circle");
        }

        @Override
        default Circle2 y(double y) {
            throw new UnsupportedOperationException("Unable to change immutable circle");
        }

        @Override
        default Circle2 r(double r) {
            throw new UnsupportedOperationException("Unable to change immutable circle");
        }
    }

    class Mirror implements Immutable {
        private final Circle2 mirror;

        public Mirror(Circle2 mirror) {
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

        @Override
        public double r() {
            return mirror.r();
        }
    }
}
