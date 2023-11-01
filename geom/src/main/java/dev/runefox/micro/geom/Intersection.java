package dev.runefox.micro.geom;

public class Intersection {
    public final Line2 a;
    public final Line2 b;

    public boolean intersect;
    public double au;
    public double bu;
    public boolean parallel;
    public boolean onA;
    public boolean onB;

    public final MVec2 point = new MVec2();

    public Intersection(Line2 a, Line2 b) {
        this.a = a;
        this.b = b;
    }

    public Intersection() {
        this(new MLine2(), new MLine2());
    }

    public void calculate() {
        double x1 = a.ax();
        double y1 = a.ay();
        double x2 = a.bx();
        double y2 = a.by();
        double x3 = b.ax();
        double y3 = b.ay();
        double x4 = b.bx();
        double y4 = b.by();

        double d = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4);

        parallel = d == 0;

        au = ((x1 - x3) * (y3 - y4) - (y1 - y3) * (x3 - x4)) / d;
        bu = ((x1 - x3) * (y1 - y2) - (y1 - y3) * (x1 - x2)) / d;

        a.lerp(au, point);

        onA = au >= 0 && au <= 1;
        onB = bu >= 0 && bu <= 1;
    }
}
