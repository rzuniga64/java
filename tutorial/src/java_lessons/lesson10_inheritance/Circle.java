package java_lessons.lesson10_inheritance;

/**
 * Circle class.
 */
public final class Circle extends Shape {

    /** The radius of the circle. */
    private int radius;

    /**
     * Constructor.
     * @param xcoor x-ccordinate
     * @param ycoor y-coordinate
     * @param r the radius
     */
    private Circle(final int xcoor, final int ycoor, final int r) {
        super(xcoor, ycoor);
        setRadius(r);
    }

    /**
     * Get the radius.
     * @return the radius
     */
    public int getRadius() {

        return radius;
    }

    /**
     * Set the radius.
     * @param r the radius
     */
    public void setRadius(final int r) {

        radius = r;
    }

    /**
     * Unit tests.
     * @param args the arguments
     */
    public static void main(final String[] args) {

        Circle c1 = new Circle(50, 50, 10);
        System.out.println("x = " + c1.getX());
        System.out.println("y = " + c1.getY());
        System.out.println("radius = " + c1.getRadius());
    }
}
