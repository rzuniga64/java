package structural.bridge.shapes;

/**
 * TestShapes class.
 * Client.
 */
public final class TestShapes {

    /** Default constructor. */
    private TestShapes() { }

    /**
     * Unit tests.
     * @param args args
     */
    public static void main(final String[] args) {

        Shape[] shapes = new Shape[2];
        shapes[0] = new Circle(1, 2, 3, new DrawingAPI1());
        shapes[1] = new Circle(5, 7, 11, new DrawingAPI2());

        for (Shape shape : shapes) {
            shape.resizeByPercentage(2.5);
            shape.draw();
        }
    }
}
