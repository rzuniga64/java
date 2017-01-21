package java_lessons.lesson10_inheritance;

/**
 * Shape class.
 */
public class Shape {

    /** x ooordinate. */
    private int x;
    /** y coordinate. */
    private int y;

    /**
     * Constructor.
     * @param xcoor x-coordinate
     * @param ycoor y-coordinate
     */
    Shape(final int xcoor, final int ycoor) {
        x = xcoor;
        y = ycoor;
    }

    /**
     * Get the x-coordinate.
     * @return the x-coordinate
     */
    public int getX() {

        return x;
    }

    /**
     * Get the y-coordinate.
     * @return the y-coordinate
     */
    public int getY() {

        return y;
    }

    /**
     * Set the x-coordinate.
     * @param xcoor x-coordinate
     */
    public void setX(final int xcoor) {

        x = xcoor;
    }

    /**
     * Set the y-coordinate.
     * @param ycoor y-coordinate
     */
    public void setY(final int ycoor) {

        y = ycoor;
    }

    /**
     * Set the x-coordinate and y-coordinate.
     * @param xcoor x-coordinate
     * @param ycoor y-coordinate
     */
    public void set(final int xcoor, final int ycoor) {
        setX(xcoor);
        setY(ycoor);
    }

    /**
     * Moves the x-coordinate and y-coordinate.
     * @param x1 x-coordinate
     * @param y1 y-coordinate
     */
    public void move(final int x1, final int y1) {

        set(getX() + x1, getY() + y1);
    }
}
