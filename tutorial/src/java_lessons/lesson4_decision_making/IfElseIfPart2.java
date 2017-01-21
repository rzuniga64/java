package java_lessons.lesson4_decision_making;

import java.util.Scanner;

/**
 *  IfElseIfPart2 class.
 *
 *  Temperature Activity
 *  > 85        Swimming
 *  70-85       Tennis
 *  32-69       Golf
 *  0 - 31      Dancing
 *  Below 0     Sit by the fire
*/
public final class IfElseIfPart2 {

    /**
     * Constructor.
     */
    private IfElseIfPart2() {}

    /**
     * Unit tests.
     *
     * @param args the arguments.
     */
    public static void main(final String[] args) {

        int temp;
        String message = "The recommended activity is ";

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the temperature: ");
        temp = input.nextInt();
        if (temp > 85) {
            message = message + "swimming.";
        } else if (temp >= 70) {
            message = message + "tennis.";
        } else if (temp >= 32) {
            message = message + "golf.";
        } else if (temp >= 0) {
            message = message + "dancing.";
        } else {
            message = message + "sitting by the fire.";
        }
        System.out.println(message);
   }
}

