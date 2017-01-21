package java_lessons.lesson6_methods;

/**
 *  PassByValue class. Compiler makes a copy of the value and works with the
 *  copy within the method definition.
 *  Java passes by value by default.
 */
public final class PassByValue {

   /** Constructor. */
   private PassByValue() { }

   /**
    * Unit tests.
    * @param args the arguments.
    */
   public static void main(final String[] args) {
      int number = 12;
      System.out.println("number squared: " + square(number));
      System.out.println("original number: " + number);
   }

   /**
    * Square a number.
    * @param num the number
    * @return the square of a number
    */
   private static int square(int num) {

      num *= num;
      System.out.println("num in square method: " + num);
      return num;
   }
}
