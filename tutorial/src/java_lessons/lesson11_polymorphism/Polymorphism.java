package java_lessons.lesson11_polymorphism;

/**
 * Polymorphism class.
 * Test program to show how draw differs for a Circle object and a Rectangle
 * object using polymorphism.
 */
public final class Polymorphism {

   /** Constructor. */
   private Polymorphism() { }
   /**
    * Unit tests.
    * @param args the arguments.
    */
   public static void main(final String[] args) {
      Circle c1 = new Circle(10, 20, 5);
      Rectangle r1 = new Rectangle(50, 100, 10, 20);
      c1.draw();
      System.out.println();
      r1.draw();
   }
}
