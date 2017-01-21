package java_lessons.lesson11_polymorphism;

/**
 * Shape1 interface.
 *
 * An interface is a class that has method names only but no method
 * definitions.  When you inherit from an interface the class will have these
 * features and in the inherited class you will define how those features
 * work. An interface is a contract that you are going to define a list of
 * methods in the interface and any class that implements the interface must
 * define those methods listed in the interface definition.
 */
public interface Shape1 {
   /**
    * Get the x-coordinate.
    * @return the x-coordinate
    */
   int getX();

   /**
    * Get the y-coordinate.
    * @return the y-coordinate
    */
   int getY();

    /**
     * Set the x-coordinate.
     * @param xcor the x-coordinate
     */
   void setX(int xcor);

    /**
     * Set the y-coordinate.
     * @param ycor the y-coordinate
     */
   void setY(int ycor);

    /** The draw function. */
   void draw();
}
