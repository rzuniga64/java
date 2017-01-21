package java_lessons.lesson11_polymorphism;

import java.util.ArrayList;

/**
 * Polymorphism class. W
 *
 * We can have an ambiguous reference to an object and call draw on that
 * object and have the compiler figure out which one is necessary.
 *
 * Test program where we aren't even sure what type of object it is but we
 * are going to call the Draw method for it and see if it picks the right
 * type of method for that object.
 */
public final class Polymorphism {

    /** Constructor. */
    private Polymorphism() { }

   /**
    * Unit tests.
    * @param args the arguments.
    */
   public static void main(final String[] args) {

       // Not an example of polymorphism
       Circle c1 = new Circle(10, 20, 5);
       Rectangle r1 = new Rectangle(50, 100, 10, 20);
       c1.draw();
       r1.draw();
       System.out.println();

       // Example of polymorphism
       ArrayList<Shape> shapes = new ArrayList<Shape>();
       Circle c2 = new Circle(10, 20, 5);
       Rectangle r2 = new Rectangle(50, 50, 10, 20);
       shapes.add(c2);
       shapes.add(r2);
       for (Shape shape : shapes) {
           shape.draw();
      }
   }
}

