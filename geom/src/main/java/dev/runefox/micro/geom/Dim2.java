package dev.runefox.micro.geom;

/**
 * A pair of dimensions. Represented as a width (W) and a height (H).
 */
public interface Dim2 {
    double w();
    double h();

    Dim2 w(double w);
    Dim2 h(double h);

    default Dim2 set(double w, double h) {
        w(w);
        h(h);
        return this;
    }

    default Dim2 set(Dim2 o) {
        return set(o.w(), o.h());
    }

    default Dim2 reset() {
        return set(0, 0);
    }

    default double area() {
        return w() * h();
    }

    default IDim2 freeze() {
        return new IDim2(w(), h());
    }

    default MDim2 copy() {
        return new MDim2(w(), h());
    }

    interface Immutable extends Dim2 {
        @Override
        default Dim2 w(double w) {
            throw new UnsupportedOperationException("Unable to change immutable dimensions");
        }

        @Override
        default Dim2 h(double h) {
            throw new UnsupportedOperationException("Unable to change immutable dimensions");
        }
    }

    class Mirror implements Immutable {
        private final Dim2 mirror;

        public Mirror(Dim2 mirror) {
            this.mirror = mirror;
        }

        @Override
        public double w() {
            return mirror.w();
        }

        @Override
        public double h() {
            return mirror.h();
        }
    }
}
