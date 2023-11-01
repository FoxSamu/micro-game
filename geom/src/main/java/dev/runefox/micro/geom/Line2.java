package dev.runefox.micro.geom;

/**
 * A straight line. Represented using two points (AX, AY, BX, BY). Can also represent a segment or ray.
 */
public interface Line2 {
    double ax();
    double ay();
    double bx();
    double by();

    Line2 ax(double ax);
    Line2 ay(double ay);
    Line2 bx(double bx);
    Line2 by(double by);

    default Line2 set(double ax, double ay, double bx, double by) {
        ax(ax);
        ay(ay);
        bx(bx);
        by(by);
        return this;
    }

    default Line2 set(Vec2 a, double bx, double by) {
        return set(a.x(), a.y(), bx, by);
    }

    default Line2 set(double ax, double ay, Vec2 b) {
        return set(ax, ay, b.x(), b.y());
    }

    default Line2 set(Vec2 a, Vec2 b) {
        return set(a.x(), a.y(), b.x(), b.y());
    }

    default Line2 setCenter(double cx, double cy, double dx, double dy) {
        return set(cx - dx / 2, cy - dy / 2, cx + dx / 2, cy + dy / 2);
    }

    default Line2 setCenter(Vec2 c, double dx, double dy) {
        return setCenter(c.x(), c.y(), dx, dy);
    }

    default Line2 setCenter(double cx, double cy, Vec2 d) {
        return setCenter(cx, cy, d.x(), d.y());
    }

    default Line2 setCenter(Vec2 c, Vec2 d) {
        return setCenter(c.x(), c.y(), d.x(), d.y());
    }

    default Line2 set(Line2 o) {
        return set(o.ax(), o.ay(), o.bx(), o.by());
    }

    default Line2 reset() {
        return set(0, 0, 0, 0);
    }

    default double len2() {
        double dx = bx() - ax(), dy = by() - ay();
        return dx * dx + dy * dy;
    }

    default double len() {
        return Math.sqrt(len2());
    }

    default double dx() {
        return bx() - ax();
    }

    default double dy() {
        return by() - ay();
    }

    default Vec2 a(Vec2 res) {
        return res.set(ax(), ay());
    }

    default Vec2 b(Vec2 res) {
        return res.set(bx(), by());
    }

    default Vec2 c(Vec2 res) {
        double ax = ax(), ay = ay(), bx = bx(), by = by();
        return res.set(ax + (bx - ax) / 2, ay + (by - ay) / 2);
    }

    default Vec2 ab(Vec2 res) {
        return res.set(bx() - ax(), by() - ay());
    }

    default Vec2 ba(Vec2 res) {
        return res.set(ax() - bx(), ay() - by());
    }

    default Vec2 tan(Vec2 res) {
        return ab(res).norm();
    }

    default Vec2 lerp(double t, Vec2 res) {
        double ax = ax(), ay = ay(), bx = bx(), by = by();
        return res.set(ax + t * (bx - ax), ay + t * (by - ay));
    }

    default Line2 move(double x, double y, Line2 res) {
        return res.set(ax() + x, ay() + y, bx() + x, by() + y);
    }

    default Line2 move(double x, double y) {
        return move(x, y, this);
    }

    default Line2 move(Vec2 v, Line2 res) {
        return move(v.x(), v.y(), res);
    }

    default Line2 move(Vec2 v) {
        return move(v, this);
    }

    default Line2 movescl(double x, double y, double s, Line2 res) {
        return res.set(ax() + x * s, ay() + y * s, bx() + x * s, by() + y * s);
    }

    default Line2 movescl(double x, double y, double s) {
        return movescl(x, y, s, this);
    }

    default Line2 movescl(Vec2 v, double s, Line2 res) {
        return movescl(v.x(), v.y(), s, res);
    }

    default Line2 movescl(Vec2 v, double s) {
        return movescl(v, s, this);
    }

    default ILine2 freeze() {
        return new ILine2(ax(), ay(), bx(), by());
    }

    default MLine2 copy() {
        return new MLine2(ax(), ay(), bx(), by());
    }

    interface Immutable extends Line2 {
        @Override
        default Line2 ax(double ax) {
            throw new UnsupportedOperationException("Unable to change immutable line");
        }

        @Override
        default Line2 ay(double ay) {
            throw new UnsupportedOperationException("Unable to change immutable line");
        }

        @Override
        default Line2 bx(double bx) {
            throw new UnsupportedOperationException("Unable to change immutable line");
        }

        @Override
        default Line2 by(double by) {
            throw new UnsupportedOperationException("Unable to change immutable line");
        }
    }

    class Mirror implements Immutable {
        private final Line2 mirror;

        public Mirror(Line2 mirror) {
            this.mirror = mirror;
        }

        @Override
        public double ax() {
            return mirror.ax();
        }

        @Override
        public double ay() {
            return mirror.ay();
        }

        @Override
        public double bx() {
            return mirror.bx();
        }

        @Override
        public double by() {
            return mirror.by();
        }
    }
}
