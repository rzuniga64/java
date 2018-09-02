package structural.bridge.shapes;

/**
 *  Circle class.
 *  Refined abstraction.
 */
public class Circle implements Shape {

    /** x coordinate. */
    private double x;
    /** y coordinate. */
    private double y;
    /** radius. */
    private double radius;

    /** Reference to implementor. */
    private DrawingAPI drawingAPI;

    /**
     * Constructor.
     * @param newX x-coordinate
     * @param newY y-coordinate
     * @param newRadius radius
     * @param newDrawingAPI DrawingAPI
     */
    Circle(final double newX,
                  final double newY,
                  final double newRadius,
                  final DrawingAPI newDrawingAPI) {

        this.x = newX;
        this.y = newY;
        this.radius = newRadius;
        this.drawingAPI = newDrawingAPI;
    }

    /** Draw method. */
    public void draw() {

        drawingAPI.drawCircle(x, y, radius);
    }

    /**
     * Resize by percentage method.
     * @param pct percentage.
     */
    public void resizeByPercentage(final double pct) {

        radius = pct;
    }
}
