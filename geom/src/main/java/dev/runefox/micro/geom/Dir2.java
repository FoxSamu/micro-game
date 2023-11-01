package dev.runefox.micro.geom;

public enum Dir2 implements Vec2.Immutable {
    UP(0, 1) {
        @Override
        public Dir2 rleft() {
            return LEFT;
        }

        @Override
        public Dir2 rright() {
            return RIGHT;
        }

        @Override
        public Dir2 opposite() {
            return DOWN;
        }
    },
    RIGHT(1, 0) {
        @Override
        public Dir2 rleft() {
            return UP;
        }

        @Override
        public Dir2 rright() {
            return DOWN;
        }

        @Override
        public Dir2 opposite() {
            return LEFT;
        }
    },
    DOWN(0, -1) {
        @Override
        public Dir2 rleft() {
            return RIGHT;
        }

        @Override
        public Dir2 rright() {
            return LEFT;
        }

        @Override
        public Dir2 opposite() {
            return UP;
        }
    },
    LEFT(-1, 0) {
        @Override
        public Dir2 rleft() {
            return DOWN;
        }

        @Override
        public Dir2 rright() {
            return UP;
        }

        @Override
        public Dir2 opposite() {
            return RIGHT;
        }
    };

    private final int x, y;

    Dir2(int x, int y) {
        this.x = x;
        this.y = y;
    }

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

    public abstract Dir2 rleft();
    public abstract Dir2 rright();
    public abstract Dir2 opposite();

    public Axis2 axis() {
        return vert() ? Axis2.Y : Axis2.X;
    }

    public boolean vert() {
        return this == UP || this == DOWN;
    }

    public boolean horiz() {
        return this == LEFT || this == RIGHT;
    }
}
