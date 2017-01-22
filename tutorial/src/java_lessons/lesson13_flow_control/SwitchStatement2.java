package java_lessons.lesson13_flow_control;

import java.util.Scanner;

/**
 * SwitchStatement2 class.
 */
public final class SwitchStatement2 {

    /** Constructor. */
    private SwitchStatement2() { }

    /**
     * Unit tests.
     * @param args the arguments
     */
    public static void main(final String[] args) {

        char letter;
        String letterGrade;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a letter grade: ");
        letterGrade = input.nextLine();
        letter = letterGrade.charAt(0);

        switch (letter) {
            case 'A':
            case 'B':
            case 'C':
                System.out.println("Pass");
                break;
            default:
                System.out.println("Fail");
        }
    }
}
