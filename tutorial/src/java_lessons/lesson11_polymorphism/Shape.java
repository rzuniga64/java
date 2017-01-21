package java_lessons.lesson11_polymorphism;

/**
 * Shape class.
 *
 * An abstract class that can be inherited from but can not be instantiated
 * directly.  Used as a basis to create other classes. For Example, we don't
 * normally want to create a Shape we want to implement a type of Shape
 * (Circle, Rectangle,etc).
 *
 * To make a class a superclass while not allowing a
 * user to instantaiate it is to make it abstract.
*/

public abstract class Shape {
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

   /**
    * Abstract method. A class that inherits from Shape must implement a
    * draw method but not necessarily inherit the Shape's draw method.  It
    * doesn't make sense to have a draw method for shape because we haven't
    * defined the shape.  So rather than have a body that does something
    * meaningless it's better to make the method abstract and then implement
    * in a subclass for a particular type of shape.
    */
    public abstract void draw();
}

