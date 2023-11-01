package dev.runefox.micro.geom;

/**
 * Four extents, one for each direction. Represented using top (T), right (R), bottom (B) and left (L), for the
 * directions up, right, down and left respectively.
 */
public interface Exts2 {
    double t();
    double r();
    double b();
    double l();

    Exts2 t(double t);
    Exts2 r(double r);
    Exts2 b(double b);
    Exts2 l(double l);

    default Exts2 set(double t, double r, double b, double l) {
        t(t);
        r(r);
        b(b);
        l(l);
        return this;
    }

    default Exts2 set(double t, double h, double b) {
        return set(t, h, b, h);
    }

    default Exts2 set(double v, double h) {
        return set(v, h, v, h);
    }

    default Exts2 set(double i) {
        return set(i, i, i, i);
    }

    default Exts2 set(Exts2 b) {
        return set(b.t(), b.r(), b.b(), b.l());
    }

    default Exts2 reset() {
        return set(0, 0, 0, 0);
    }

    default double val(Dir2 d) {
        return switch (d) {
            case UP -> t();
            case DOWN -> b();
            case LEFT -> l();
            case RIGHT -> r();
        };
    }

    default double lr() {
        return l() + r();
    }

    default double tb() {
        return t() + b();
    }

    default Exts2 grow(double s, Exts2 res) {
        return res.set(t() - s, r() + s, b() + s, l() - s);
    }

    default Exts2 grow(double s) {
        return grow(s, this);
    }

    default Exts2 shrink(double s, Exts2 res) {
        return res.set(t() + s, r() - s, b() - s, l() + s);
    }

    default Exts2 shrink(double s) {
        return shrink(s, this);
    }

    default IExts2 freeze() {
        return new IExts2(t(), r(), b(), l());
    }

    default MExts2 copy() {
        return new MExts2(t(), r(), b(), l());
    }

    interface Immutable extends Exts2 {
        @Override
        default Exts2 t(double t) {
            throw new UnsupportedOperationException("Unable to change immutable extents");
        }

        @Override
        default Exts2 r(double r) {
            throw new UnsupportedOperationException("Unable to change immutable extents");
        }

        @Override
        default Exts2 b(double b) {
            throw new UnsupportedOperationException("Unable to change immutable extents");
        }

        @Override
        default Exts2 l(double l) {
            throw new UnsupportedOperationException("Unable to change immutable extents");
        }
    }

    class Mirror implements Immutable {
        private final Exts2 mirror;

        public Mirror(Exts2 mirror) {
            this.mirror = mirror;
        }

        @Override
        public double t() {
            return mirror.t();
        }

        @Override
        public double r() {
            return mirror.r();
        }

        @Override
        public double b() {
            return mirror.b();
        }

        @Override
        public double l() {
            return mirror.l();
        }
    }
}
