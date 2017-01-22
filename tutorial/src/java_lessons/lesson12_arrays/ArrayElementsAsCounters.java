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

       final int size = 101;
       int[] numbers = new int[size];
       int[] distribution = new int[size];
       Random rand = new Random(System.currentTimeMillis());

       for (int i = 0; i < size; ++i) {
           numbers[i] = rand.nextInt(100 - 1 + 1) + 1;
       }

       for (int i = 0; i < size; ++i) {
           ++distribution[numbers[i]];
       }

       for (int i = 0; i < size; ++i) {
            System.out.print(numbers[i] + " ");
            if ((i + 1) % 10 == 0) {
                System.out.println();
            }
       }

       for (int i = 1; i < size; ++i) {
           if (distribution[i] != 0) {
               System.out.println("Number " + i + " occurs " + distribution[i]
                       + " times.");
           }
       }
   }
}
