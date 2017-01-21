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
    * Unit tests.
    * @param args the arguments.
    */
   public static void main(final String[] args) {

       int number;
        Random rand = new Random(System.currentTimeMillis());
       ArrayList<Integer> numbers = new ArrayList<>();
       for (int i = 0; i < 10; ++i) {
            number = rand.nextInt(101);
            numbers.add(number);
       }
       display(numbers);
   }

    /**
     * Display the array.
     * @param arr the array
     */
   private static void display(final ArrayList arr) {
      for (Object item : arr) {
          System.out.print(item + " ");
      }
   }
}
