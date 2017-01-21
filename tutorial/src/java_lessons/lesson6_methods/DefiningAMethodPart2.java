package java_lessons.lesson6_methods;

import java.util.Scanner;

/**
 * DefiningMethodPart2 class.
 */
public final class DefiningAMethodPart2 {

   /** Constructor. */
   private DefiningAMethodPart2() { }

   /**
    * Converts fahrenheit to celsius.
    * @param temp the temperature
    * @return the temperatur in fahrenheit
    */
   private static double ftoc(final double temp) {
      double celsius;
      celsius = (temp - 32.0) * (5.0 / 9.0);
      return celsius;
   }

   /**
    * Converts celsius to fahrenheit.
    * @param temp the temperature
    * @return the temperatur in fahrenheit
    */
   private static double ctof(final double temp) {
      double fahrenheit;
      fahrenheit = temp * (9.0 / 5.0) + 32.0;
      return fahrenheit;
   }

   /**
    * Unit tests.
    * @param args the arguments.
    */
   public static void main(final String[] args) {

       double ctemp, ftemp;
       Scanner input = new Scanner(System.in);

       System.out.print("Enter a temparature in Fahrenheit: ");
       ftemp = input.nextDouble();
       ctemp = ftoc(ftemp);
       System.out.println(ftemp + " F is equal to " + ctemp + " C.");

       System.out.print("Enter a temparature in Celcius: ");
       ctemp = input.nextDouble();
       ftemp = ctof(ctemp);
       System.out.println(ctemp + " F is equal to " + ftemp + " C.");
   }
}
