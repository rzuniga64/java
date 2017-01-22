package java_lessons.lesson13_flow_control;

import java.util.Scanner;
import java.util.Random;

/**
 * DoWhileExercise.
 */
public final class DoWhileExercise {

    /** Constructor. */
    private DoWhileExercise() { }

    /**
     * Unit tests.
     * @param args the arguments.
     */
    public static void main(final String[] args) {
        Scanner inputNum = new Scanner(System.in);
        Scanner input = new Scanner(System.in);
        Random rand = new Random(System.currentTimeMillis());
        String contChar;
        int number, guess;
        number = rand.nextInt(11);
        char cont;
        do {
            System.out.print("Guess a number: ");
            guess = inputNum.nextInt();
            if (guess == number) {
                System.out.println("That's right!");
                break;
            }
            System.out.print("Sorry. Do you want to guess again? (y/n) ");
            contChar = input.nextLine();
            cont = contChar.charAt(0);
        } while (cont != 'n');
    }
}
