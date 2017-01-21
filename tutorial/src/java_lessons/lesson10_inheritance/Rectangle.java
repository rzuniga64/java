package java_lessons.lesson10_inheritance;

/**
 * Rectangle class.
 */
public class Rectangle extends Shape {

    /** Width of rectangle. */
    private int width;
    /** Height of rectangle. */
    private int height;

    /**
     * Constructor.
     * @param xcoor x-coordinate
     * @param ycoor y-coordinate
     * @param w width
     * @param h height
     */
    Rectangle(final int xcoor, final int ycoor, final int w, final int h) {

        super(xcoor, ycoor);
        width = w;
        height = h;
    }

    /**
     * Get the width.
     * @return the width
     */
    public int getWidth() {

        return width;
    }

    /**
     * Get the height.
     * @return the height.
     */
    public int getHeight() {

        return height;
    }

    /**
     * Set the width.
     * @param w the width
     */
    public void setWidth(final int w) {

        width = w;
    }

    /**
     * Set the height.
     * @param h the height
     */
    public void setHeight(final int h) {

        height = h;
    }

    /**
     * Unit tests.
     * @param args the arguments
     */
    public static void main(final String[] args) {

        Rectangle r1 = new Rectangle(10,200,5,8);
        System.out.println("x = " + r1.getX());
        System.out.println("y = " + r1.getY());
        System.out.println("width = " + r1.getWidth());
        System.out.println("height = " + r1.getHeight());
    }
}
