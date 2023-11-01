package dev.runefox.micro.geom;

/**
 * An axis-aligned rectangle. Represented using a bottom-left corner (X, Y) and a size (W, H).
 */
public interface Box2 {
    double x();
    double y();
    double w();
    double h();

    Box2 x(double x);
    Box2 y(double y);
    Box2 w(double w);
    Box2 h(double h);

    default Box2 set(double x, double y, double w, double h) {
        x(x);
        y(y);
        w(w);
        h(h);
        return this;
    }

    default Box2 set(double x, double y, double sq) {
        return set(x, y, sq, sq);
    }

    default Box2 set(double x, double y, Dim2 d) {
        return set(x, y, d.w(), d.h());
    }

    default Box2 set(Box2 b) {
        return set(b.x(), b.y(), b.w(), b.h());
    }

    default Box2 set(Vec2 c, double w, double h) {
        return set(c.x(), c.y(), w, h);
    }

    default Box2 set(Vec2 c, double sq) {
        return set(c.x(), c.y(), sq, sq);
    }

    default Box2 set(Vec2 c, Dim2 d) {
        return set(c.x(), c.y(), d.w(), d.h());
    }

    default Box2 setExtents(double t, double r, double b, double l) {
        return setCorners(l, b, r, t);
    }

    default Box2 setExtents(double t, double h, double b) {
        return setExtents(t, h, b, h);
    }

    default Box2 setExtents(double v, double h) {
        return setExtents(v, h, v, h);
    }

    default Box2 setExtents(double a) {
        return setExtents(a, a, a, a);
    }

    default Box2 setExtents(Exts2 exts) {
        return setExtents(exts.t(), exts.r(), exts.b(), exts.l());
    }

    default Box2 setCorners(double x1, double y1, double x2, double y2) {
        return set(x1, y1, x2 - x1, y2 - y1);
    }

    default Box2 setCorners(Vec2 c1, double x2, double y2) {
        return setCenter(c1.x(), c1.y(), x2, y2);
    }

    default Box2 setCorners(double x1, double y1, Vec2 c2) {
        return setCorners(x1, y1, c2.x(), c2.y());
    }

    default Box2 setCorners(Vec2 c1, Vec2 c2) {
        return setCorners(c1.x(), c1.y(), c2.x(), c2.y());
    }

    default Box2 setCenter(double cx, double cy, double w, double h) {
        return set(cx - w / 2, cy - h / 2, w, h);
    }

    default Box2 setCenter(double cx, double cy, double sq) {
        return setCenter(cx, cy, sq, sq);
    }

    default Box2 setCenter(double cx, double cy, Dim2 d) {
        return setCenter(cx, cy, d.w(), d.h());
    }

    default Box2 setCenter(Vec2 c, double w, double h) {
        return setCenter(c.x(), c.y(), w, h);
    }

    default Box2 setCenter(Vec2 c, double sq) {
        return setCenter(c.x(), c.y(), sq, sq);
    }

    default Box2 setCenter(Vec2 c, Dim2 d) {
        return setCenter(c.x(), c.y(), d.w(), d.h());
    }

    default Box2 setCell(double gridW, double gridH, int x, int y) {
        return set(gridW * x, gridH * y, gridW, gridH);
    }

    default Box2 setCell(double gridS, int x, int y) {
        return set(gridS * x, gridS * y, gridS, gridS);
    }

    default Box2 setCell(int x, int y) {
        return set(x, y, 1, 1);
    }

    default Box2 setPoint(double x, double y) {
        return set(x, y, 0, 0);
    }

    default Box2 reset() {
        return set(0, 0, 0, 0);
    }

    default double t() {
        return y() + h();
    }

    default double b() {
        return y();
    }

    default double l() {
        return x();
    }

    default double r() {
        return x() + w();
    }

    default double cx() {
        return x() + w() / 2;
    }

    default double cy() {
        return y() + h() / 2;
    }

    default double area() {
        return w() * h();
    }

    default double diag2() {
        double w = w(), h = h();
        return w * w + h * h;
    }

    default double diag() {
        return Math.sqrt(diag2());
    }

    default double perim() {
        return w() * 2 + h() * 2;
    }

    default Vec2 corner(int idx, Vec2 res) {
        return switch (idx & 3) {
            default -> bl(res);
            case 1 -> br(res);
            case 2 -> tr(res);
            case 3 -> tl(res);
        };
    }

    default Vec2 corner(Dir2 d, int idx, Vec2 res) {
        return switch (d) {
            case UP -> (idx & 1) == 1 ? tl(res) : tr(res);
            case DOWN -> (idx & 1) == 1 ? br(res) : bl(res);
            case LEFT -> (idx & 1) == 1 ? bl(res) : tl(res);
            case RIGHT -> (idx & 1) == 1 ? tr(res) : br(res);
        };
    }

    default double min(Dir2 d) {
        return switch (d) {
            case UP -> b();
            case DOWN -> -t();
            case LEFT -> -r();
            case RIGHT -> l();
        };
    }

    default double max(Dir2 d) {
        return switch (d) {
            case UP -> t();
            case DOWN -> -b();
            case LEFT -> -l();
            case RIGHT -> r();
        };
    }

    default double min(Axis2 d) {
        return switch (d) {
            case X -> l();
            case Y -> b();
        };
    }

    default double max(Axis2 d) {
        return switch (d) {
            case X -> r();
            case Y -> t();
        };
    }

    default double size(Dir2 d) {
        return switch (d) {
            case UP, DOWN -> h();
            case LEFT, RIGHT -> w();
        };
    }

    default double size(Axis2 d) {
        return switch (d) {
            case X -> w();
            case Y -> h();
        };
    }

    default Range xr(Range res) {
        return res.set(x(), w());
    }

    default Range yr(Range res) {
        return res.set(y(), h());
    }

    default Range range(Dir2 d, Range res) {
        return switch (d) {
            case UP -> res.set(t(), h());
            case DOWN -> res.set(-b(), h());
            case LEFT -> res.set(-l(), w());
            case RIGHT -> res.set(r(), w());
        };
    }

    default Range range(Axis2 d, Range res) {
        return switch (d) {
            case X -> res.set(r(), w());
            case Y -> res.set(t(), h());
        };
    }

    default Vec2 tl(Vec2 tl) {
        return tl.set(l(), t());
    }

    default Vec2 tr(Vec2 tr) {
        return tr.set(r(), t());
    }

    default Vec2 bl(Vec2 bl) {
        return bl.set(l(), b());
    }

    default Vec2 br(Vec2 br) {
        return br.set(r(), b());
    }

    default Vec2 c(Vec2 br) {
        return br.set(cx(), cy());
    }

    default Dim2 size(Dim2 size) {
        return size.set(w(), h());
    }

    default Box2 move(double x, double y, Box2 res) {
        return res.set(x() + x, y() + y, w(), h());
    }

    default Box2 move(Vec2 o, Box2 res) {
        return move(o.x(), o.y(), res);
    }

    default Box2 move(double x, double y) {
        return move(x, y, this);
    }

    default Box2 move(Vec2 o) {
        return move(o.x(), o.y(), this);
    }

    default Box2 movescl(double x, double y, double s, Box2 res) {
        return res.set(x() + x * s, y() + y * s, w(), h());
    }

    default Box2 movescl(Vec2 o, double s, Box2 res) {
        return movescl(o.x(), o.y(), s, res);
    }

    default Box2 movescl(double x, double y, double s) {
        return movescl(x, y, s, this);
    }

    default Box2 movescl(Vec2 o, double s) {
        return movescl(o.x(), o.y(), s, this);
    }

    default Box2 grow(double s, Box2 res) {
        return grow(s, s, s, s, res);
    }

    default Box2 grow(double s) {
        return grow(s, this);
    }

    default Box2 grow(double v, double h, Box2 res) {
        return grow(v, h, v, h, res);
    }

    default Box2 grow(double v, double h) {
        return grow(v, h, this);
    }

    default Box2 grow(double t, double h, double b, Box2 res) {
        return grow(t, h, b, h, res);
    }

    default Box2 grow(double t, double h, double b) {
        return grow(t, h, b, this);
    }

    default Box2 grow(double t, double r, double b, double l, Box2 res) {
        return res.set(x() - l, y() - b, w() + l + r, h() + t + b);
    }

    default Box2 grow(double t, double r, double b, double l) {
        return grow(t, r, b, l, this);
    }

    default Box2 grow(Exts2 exts, Box2 res) {
        return grow(exts.t(), exts.r(), exts.b(), exts.l(), res);
    }

    default Box2 grow(Exts2 exts) {
        return grow(exts, this);
    }

    default Box2 shrink(double s, Box2 res) {
        return shrink(s, s, s, s, res);
    }

    default Box2 shrink(double s) {
        return shrink(s, this);
    }

    default Box2 shrink(double v, double h, Box2 res) {
        return shrink(v, h, v, h, res);
    }

    default Box2 shrink(double v, double h) {
        return shrink(v, h, this);
    }

    default Box2 shrink(double t, double h, double b, Box2 res) {
        return shrink(t, h, b, h, res);
    }

    default Box2 shrink(double t, double h, double b) {
        return shrink(t, h, b, this);
    }

    default Box2 shrink(double t, double r, double b, double l, Box2 res) {
        return res.set(x() + l, y() + b, w() - l - r, h() - t - b);
    }

    default Box2 shrink(double t, double r, double b, double l) {
        return shrink(t, r, b, l, this);
    }

    default Box2 shrink(Exts2 exts, Box2 res) {
        return shrink(exts.t(), exts.r(), exts.b(), exts.l(), res);
    }

    default Box2 shrink(Exts2 exts) {
        return shrink(exts, this);
    }

    default Box2 include(double x, double y, Box2 res) {
        double l = l(), r = r();
        double t = t(), b = b();

        if (x < l) l = x;
        if (x > r) r = x;
        if (y < b) b = y;
        if (y > t) t = y;
        return res.setExtents(t, r, b, l);
    }

    default Box2 include(double x, double y) {
        return include(x, y, this);
    }

    default Box2 include(Vec2 v, Box2 res) {
        return include(v.x(), v.y(), res);
    }

    default Box2 include(Vec2 v) {
        return include(v, this);
    }

    default boolean contains(double x, double y) {
        return x >= l() && x <= r() && y >= b() && y <= t();
    }

    default boolean contains(Vec2 v) {
        return contains(v.x(), v.y());
    }

    default IBox2 freeze() {
        return new IBox2(x(), y(), w(), h());
    }

    default MBox2 copy() {
        return new MBox2(x(), y(), w(), h());
    }

    public static boolean intersect(Box2 a, Box2 b) {
        return overlap(a.l(), a.r(), b.l(), b.r()) && overlap(a.b(), a.t(), b.b(), b.t());
    }

    private static boolean overlap(double a1, double a2, double b1, double b2) {
        return a2 >= b1 && b2 >= a1;
    }

    interface Immutable extends Box2 {
        @Override
        default Box2 x(double x) {
            throw new UnsupportedOperationException("Unable to change immutable box");
        }

        @Override
        default Box2 y(double y) {
            throw new UnsupportedOperationException("Unable to change immutable box");
        }

        @Override
        default Box2 w(double w) {
            throw new UnsupportedOperationException("Unable to change immutable box");
        }

        @Override
        default Box2 h(double h) {
            throw new UnsupportedOperationException("Unable to change immutable box");
        }
    }

    class Mirror implements Immutable {
        private final Box2 mirror;

        public Mirror(Box2 mirror) {
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
        public double w() {
            return mirror.w();
        }

        @Override
        public double h() {
            return mirror.h();
        }
    }
}
