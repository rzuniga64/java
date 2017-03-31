package structural.bridge.shapes;

/**
 *  DrawingAPI1 class.
 *  Concrete implementer.
 */
public class DrawingAPI1 implements DrawingAPI {

    /**
     * drawCircle method.
     * @param x x-coordinate
     * @param y y-coordinate
     * @param radius radius
     */
    public void drawCircle(final double x,
                           final double y,
                           final double radius) {

        System.out.printf("API1.circle is at %.2f:%.2f radius %.2f\n", x, y, radius);
    }
}
