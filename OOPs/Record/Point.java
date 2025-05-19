package Java_Bootcamp.OOPs.Record;

// Record definition with two components
record Point(int x, int y) {
    // Custom compact constructor (optional)
    public Point {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("Coordinates must be non-negative");
        }
    }

    // Additional method
    public double distanceFromOrigin() {
        return Math.sqrt(x * x + y * y);
    }

    // Static field and method
    public static final Point ORIGIN = new Point(0, 0);

    public static Point shift(Point p, int dx, int dy) {
        return new Point(p.x() + dx, p.y() + dy);
    }
}
