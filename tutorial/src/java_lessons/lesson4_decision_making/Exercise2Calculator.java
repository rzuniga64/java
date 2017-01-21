package java_lessons.lesson4_decision_making;

import java.util.Scanner;

/**
 * ExerciseCalculator
 */
public final class Exercise2Calculator {

    /** Constructor. */
    private Exercise2Calculator() { }

    /**
     * Unit tests.
     * @param args the arguments.
     */
    public static void main(final String[] args) {

        String op;
        double number1, number2;

        Scanner inputOp = new Scanner(System.in);
        Scanner inputNumber = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        number1 = inputNumber.nextDouble();
        System.out.print("Enter the second number: ");
        number2 = inputNumber.nextDouble();
        System.out.print("Enter the operator: ");
        op = inputOp.next();

        if (op.equals("+")) {
            System.out.println(number1 + number2);
        } else if (op.equals("-")) {
            System.out.println(number1 - number2);
        } else if (op.equals("*")) {
            System.out.println(number1 * number2);
        } else if (op.equals("/")) {
            System.out.println(number1 / number2);
        } else {
            System.out.println("Didn't recognize operator.");
        }
   }
}
