package java_lessons.lesson6_methods;

import java.util.Scanner;

/**
 * Calculator class.
 */
public final class Calculator {

   /** Constructor. */
   private Calculator() { }

   /**
    *
    * @param n1 number
    * @param n2 number
    * @return the sum
    */
   static double add(final double n1, final double n2) { return n1 + n2; }

   /**
    *
    * @param n1 number
    * @param n2 number
    * @return the result
    */
   static double subtract(final double n1, final double n2) {
      return n1 - n2;
   }

   /**
    *
    * @param n1 number
    * @param n2 number
    * @return the result
    */
   static double mult(final double n1, final double n2) {
      return n1 * n2;
   }

   /**
    *
    * @param n1 number
    * @param n2 number
    * @return the result
    */
   static double div(final double n1, final double n2) { return n1 / n2; }

    /**
     * Unit tests.
     * @param args the arguments.
     */
    public static void main(final String[] args) {

        double num1, num2;
        String op;

        Scanner inputNum1 = new Scanner(System.in);
        Scanner inputNum2 = new Scanner(System.in);
        Scanner input = new Scanner(System.in);

        System.out.print("Enter first number: ");
        num1 = inputNum1.nextDouble();
        System.out.print("Enter second number: ");
        num2 = inputNum2.nextDouble();
        System.out.print("Enter operator: ");
        op = input.next();

        if (op.equals("+")) {
            System.out.println(add(num1, num2));
        } else if (op.equals("-")) {
            System.out.println(subtract(num1, num2));
        } else if (op.equals("*")) {
            System.out.println(mult(num1, num2));
        } else if (op.equals("/")) {
            System.out.println(div(num1, num2));
        } else {
            System.out.println("Bad operator");
        }
    }
}
