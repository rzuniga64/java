package java_lessons.lesson1;

/**
 * Class Final.
 */
public final class Final {

   /** Constructor. */
   private Final() { }

   /**
    * Unit tests.
    * @param args the arguments.
    */
   public static void main(final String[] args) {
      final double pi = 3.14159;
      double radius = 2.0;
      double area = pi * (radius * radius);
      System.out.println("area = " + area);
   }
}