package java_lessons.lesson1;

/**
 * MathClass.
 * x / y - 3.
 * 1 / (x + y)
 * the square root of x to the 6th plus y to the 5th
 * absolute value of x + y
 */
public final  class MathClass {

   /**Constructor. */
   private MathClass() { }

   /**
    * Unit tests.
    * @param args the arguments
    */
   public static void main(final String[] args) {

        int number = 100;
        int number2 = 30;
        int number3 = -10;

        System.out.println("Absolute value = " + Math.abs(number));
        System.out.println("Max number is " + Math.max(number, number2));
        System.out.println("4 raised to power of 3 is " + Math.pow(4,3));
        System.out.println("Absolute value is " + Math.abs(number3));

        final double pi = 3.14159;
        System.out.println("Pi rounded is "+ Math.round(pi));  // rounds down
        final double pie = 3.64159;
       System.out.println("Pi rounded is "+ Math.round(pie));  // rounds up
   }
}
