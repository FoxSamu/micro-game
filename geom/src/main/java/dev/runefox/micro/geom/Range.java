package dev.runefox.micro.geom;

/**
 * A range of real numbers. Represented using a start (A) and a length (L). It essentially is like Box2 but in 1D.
 */
public interface Range {
    double a();
    double l();

    Range a(double a);
    Range l(double l);

    default Range set(double a, double l) {
        a(a);
        l(l);
        return this;
    }

    default Range setCenter(double c, double l) {
        return set(c - l / 2, l);
    }

    default Range setEnds(double a, double b) {
        return set(a, b - a);
    }

    default Range setPoint(double d) {
        return set(d, 0);
    }

    default Range set(Range o) {
        return set(o.a(), o.l());
    }

    default Range reset() {
        return set(0, 0);
    }

    default double b() {
        return a() + l();
    }

    default double c() {
        return a() + l() / 2;
    }

    default Range move(double d, Range res) {
        return res.set(a() + d, l());
    }

    default Range move(double d) {
        return move(d, this);
    }

    default Range include(double d, Range res) {
        double a = a(), b = b();
        if (d < a) a = d;
        if (d > b) b = d;
        return res.setEnds(a, b);
    }

    default Range include(double d) {
        return include(d, this);
    }

    default Range grow(double s, Range res) {
        return grow(s, s, res);
    }

    default Range grow(double s) {
        return grow(s, this);
    }

    default Range grow(double l, double r, Range res) {
        return res.set(a() - l, l() + l + r);
    }

    default Range grow(double l, double r) {
        return grow(l, r, this);
    }

    default Range shrink(double s, Range res) {
        return shrink(s, s, res);
    }

    default Range shrink(double s) {
        return shrink(s, this);
    }

    default Range shrink(double l, double r, Range res) {
        return res.set(a() + l, l() - l - r);
    }

    default Range shrink(double l, double r) {
        return shrink(l, r, this);
    }

    default boolean contains(double t) {
        return t >= a() && t <= b();
    }

    default double lerp(double t) {
        return a() + t * l();
    }

    default IRange freeze() {
        return new IRange(a(), l());
    }

    default MRange copy() {
        return new MRange(a(), l());
    }

    interface Immutable extends Range {
        @Override
        default Range a(double a) {
            throw new UnsupportedOperationException("Unable to change immutable range");
        }

        @Override
        default Range l(double l) {
            throw new UnsupportedOperationException("Unable to change immutable range");
        }
    }

    class Mirror implements Immutable {
        private final Range mirror;

        public Mirror(Range mirror) {
            this.mirror = mirror;
        }

        @Override
        public double a() {
            return mirror.a();
        }

        @Override
        public double l() {
            return mirror.l();
        }
    }
}
