package java_lessons.lesson6_methods;

import java.util.Scanner;

/**
 * MultipleParameters class.
 */
public final class MultipleParameters {

   /** Constructor. */
   private MultipleParameters() { }

   /**
    * Converts fahrenheit to celsius.
    * @param temp the temperature
    * @return the temperatur in fahrenheit
    */
    static double ftoc(final double temp) {
      double celsius;
      celsius = (temp - 32.0) * (5.0 / 9.0);
      return celsius;
   }

   /**
    * Converts celsius to fahrenheit.
    * @param temp the temperature
    * @return the temperatur in fahrenheit
    */
   static double ctof(final double temp) {
      double fahrenheit;
      fahrenheit = temp * (9.0 / 5.0) + 32.0;
      return fahrenheit;
   }

    /**
     * Convert method.
     * @param temp the temperature
     * @param type the type
     * @return the temperature
     */
   static double convert(final double temp, final String type) {
      if (type.equals("C"))
         return (temp - 32.0) * (5.0 / 9.0);
      else
         return temp * (9.0 / 5.0) + 32.0;
   }

    /**
     * Unit tests.
     * @param args the arguments.
     */
    public static void main(final String[] args) {

        double temperature;
        String type;

        Scanner inputTemp = new Scanner(System.in);
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a temperature to convert: ");
        temperature = inputTemp.nextDouble();
        System.out.print("Enter type to convert to (C or F): ");
        type = input.next();
        System.out.println("The converted temperature is "
                + convert(temperature, type));
    }
}
