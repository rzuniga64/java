package java_lessons.lesson7_arraylist;

import java.util.Random;
import java.util.ArrayList;

/**
 * GenerateRandomNumbers class.
 */
public final class GenerateRandomNumbers {

    /**
     * Constructor.
     */
    private GenerateRandomNumbers() { }

    /**
     * Display the array.
     * @param arr the array
     */
   private static void display(final ArrayList arr) {
      for (Object item : arr) {
          System.out.print(item + " ");
      }
   }

    /**
     * Unit tests.
     * @param args the arguments.
     */
    public static void main(final String[] args) {

        int number;
        // Seed the random number generator is the system clock in ms
        Random rand = new Random(System.currentTimeMillis());
        ArrayList<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < 10; ++i) {
            // to specify a range you put a number as an argument to nextInt
            // that is in the range of n - 1 of the numbers that you want
            number = rand.nextInt(101);
            numbers.add(number);
        }
        display(numbers);
    }
}
