package java_lessons.lesson14_file_processing;

import java.util.Scanner;

/**
 *  TryCatchStatement class.
 *  try {
 *      set of statements;
 *  } catch (Exception object) {
 *      set of statements;
 *  } catch (Exception object) {
 *      set of statements;
 *  }
*/
public final class TryCatchStatement {

    /** Numerator, denomator, result. */
    private static int numerator, denominator, result;
    /** Input from the keyboard. */
    private static Scanner input = new Scanner(System.in);

    /** Constructor. */
    private TryCatchStatement() { }
    /**
     * Unit tests.
     * @param args the arguments.
     */
    public static void main(final String[] args) {

        try {
            System.out.print("Enter the numerator: ");
            numerator = input.nextInt();
            System.out.print("Enter the denominator: ");
            denominator = input.nextInt();
            result = numerator / denominator;
            System.out.println("The result is " + result);
        } catch (ArithmeticException ae) {
            System.out.println("You tried to divide by zero. Try again.");
            System.out.print("Enter a new denominator: ");
            denominator = input.nextInt();
            result = numerator / denominator;
            System.out.println("The result is " + result);
        }
    }
}