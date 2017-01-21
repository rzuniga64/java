package java_lessons.lesson6_methods;

import java.util.Scanner;

/**
 * MultipleParameters class.
 */
public final class TwoMethodsExample {

    /** Constructor. */
    private TwoMethodsExample() { }

    /**
     * Unit tests.
     * @param args the arguments.
     */
    public static void main(final String[] args) {
       double bill, tip;
       double amt, disc;

       Scanner input = new Scanner(System.in);
       Scanner input1 = new Scanner(System.in);

       /* System.out.print("Enter the amount of your bill: ");
       bill = input.nextDouble();
       tip = tipCalc(bill);
       System.out.println("Your tip should be " + tip + ".");*/

       System.out.print("Enter the original cost: ");
       amt = input.nextDouble();
       System.out.print("Enter the discount in whole number form: ");
       disc = input1.nextDouble();
       System.out.println("Your discount is " + discount(amt, disc));
   }

    /**
     * Calculate a discount for an amount.
     * @param amount the amount
     * @param percent the percent
     * @return discount for an amount
     */
   private static double discount(final double amount, final double percent) {

       return (amount - (amount * (percent / 100)));
   }

    /**
     * Calculate the dip on an amount.
     * @param amount the amount
     * @return the tip
     */
   private static double tipCalc(final double amount) {

       return amount * .15;
   }
}
