package java_lessons.lesson11_polymorphism;

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

    @Override
    /** Draw method. */
    public void draw() {
        System.out.println("Drawing a circle at x: " + getX() + ", y: " + getY()
                + " with radius of: " + getRadius());
    }
}
