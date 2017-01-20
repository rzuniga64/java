package java_lessons.lesson4_io;

import java.util.Scanner;

/**
 *  Scanner 1 class.
 *  Console represented by System.out.
 *  Keyboard represented by System.in.
 */
public final class Scanner1 {

    /** Constructor. */
    private Scanner1() { }

    /**
     * Unit tests.
     * @param args the arguments.
     */
   public static void main(final String[] args) {

       double number, number1, sum;
       Scanner input = new Scanner(System.in);

       System.out.print("Enter the first number: ");
       number = input.nextDouble();
       System.out.print("Enter the second number: ");
       number1 = input.nextDouble();

       sum = number + number1;
       System.out.printf("Sum = %.2f\n", sum);
   }
}
