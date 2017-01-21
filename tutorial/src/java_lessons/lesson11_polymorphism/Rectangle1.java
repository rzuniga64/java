package java_lessons.lesson11_polymorphism;

/**
 * Rectangle1 interface.
 * Develop a class from an interface
 * An interface is another way to build complex
 * hierchies in Java.
 */
public class Rectangle1 implements ShapeInterface {

    /** x ooordinate. */
    private int x;
    /** y coordinate. */
    private int y;
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
    Rectangle1(final int xcoor, final int ycoor, final int w, final int h) {
      x = xcoor;
      y = ycoor;
      width = w;
      height = h;
   }

    /**
     * Get the width.
     * @return the width
     */
   public int getWidth()  {

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

   // Must implement the methods listed in the ShapeInterface interface
   @Override
   /**
    * Get the x-coordinate.
    * @return the x-coordinate
    */
   public int getX() {

       return x;
   }

   @Override
   /**
    * Get the y-coordinate.
    * @return the y-coordinate
    */
   public int getY() {

       return y;
   }

   @Override
   /**
    * Set the x-coordinate.
    * @param xcoor x-coordinate
    */
   public void setX(final int xcor) {

       x = xcor;
   }

   @Override
   /**
    * Set the y-coordinate.
    * @param ycoor y-coordinate
    */
   public void setY(final int ycor) {

       y = ycor;
   }

   @Override
   /**
    * The draw method.
    */
   public void draw() {
       System.out.println("Drawing a rectangle at x: " + getX() + ", y: "
               + getY() + "width: " + getWidth() + ", height: " + getHeight());
   }
}
