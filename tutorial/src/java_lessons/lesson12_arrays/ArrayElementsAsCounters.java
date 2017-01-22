package java_lessons.lesson12_arrays;

import java.util.Random;

/**
 *  ArrayElementsAsCounters class.
 *  Use an array to tell use the distribution of numbers stored in another
 *  array.
 */
public final class ArrayElementsAsCounters {

    /** Constructor. */
    private ArrayElementsAsCounters() { }

    /**
     * Unit tests.
     * @param args the arguments.
     */
   public static void main(final String[] args) {

       Random rand = new Random(System.currentTimeMillis());
       final int size = 101;
       int[] numbers = new int[size];
       // Store the number of occurrences in the first array.
       int[] distribution = new int[size];

       // Create array of random numbers from 1 - 100.
       for (int i = 0; i < size; ++i) {
           numbers[i] = rand.nextInt(100 - 1 + 1) + 1;
       }

       // Count the distribution of numbers in the numbers array.
       for (int i = 0; i < size; ++i) {
           ++distribution[numbers[i]];
       }

       // Print out the list of distribution.
       for (int i = 1; i < size; ++i) {
           if (distribution[i] != 0) {
               System.out.println("Number " + i + " occurs " + distribution[i]
                       + " times.");
           }
       }
   }
}
