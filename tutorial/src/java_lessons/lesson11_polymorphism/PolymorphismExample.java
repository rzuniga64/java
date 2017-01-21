package java_lessons.lesson11_polymorphism;

import java.util.ArrayList;

/**
 * PolymorphismExample class.
 * Test program where we aren't even sure what type of object it is but we
 * are going to call the Draw method for it and see if it picks the right
 * type of method for that object.
 */
public final class PolymorphismExample {

    /** Constructor. */
    private PolymorphismExample() { }

   /**
    * Unit tests.
    * @param args the arguments.
    */
   public static void main(final String[] args) {

      ArrayList<Shape> shapes = new ArrayList<Shape>();
      Circle c1 = new Circle(10, 20, 5);
      Rectangle r1 = new Rectangle(50, 50, 10, 20);
      shapes.add(c1);
      shapes.add(r1);
      for (int i = 0; i < shapes.size(); ++i) {
          shapes.get(i).draw();
      }
   }
}

