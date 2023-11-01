package dev.runefox.micro.geom;

public enum Axis2 implements Vec2.Immutable {
    X(1, 0) {
        @Override
        public Dir2 positive() {
            return Dir2.RIGHT;
        }

        @Override
        public Dir2 negative() {
            return Dir2.LEFT;
        }
    },
    Y(0, 1) {
        @Override
        public Dir2 positive() {
            return Dir2.UP;
        }

        @Override
        public Dir2 negative() {
            return Dir2.DOWN;
        }
    };

    private final int x, y;

    Axis2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public abstract Dir2 positive();
    public abstract Dir2 negative();

    public int ix() {
        return x;
    }

    public int iy() {
        return y;
    }

    @Override
    public double x() {
        return x;
    }

    @Override
    public double y() {
        return y;
    }
}
