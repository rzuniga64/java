package java_lessons.lesson12_arrays;

import java.util.Random;

/**
 * DisplayHistogram class.
 */
public final class DisplayHistrogram {

    /** Constructor. */
    private DisplayHistrogram() { }

    /**
     * Unit tests.
     * @param args the arguments.
     */
    public static void main(final String[] args) {

        final int size = 101;
        int[] numbers = new int[size];
        int[] distribution = new int[size];
        Random rand = new Random(System.currentTimeMillis());

        // Create array of random numbers from 1 - 100.
        for (int i = 0; i < size; ++i) {
            numbers[i] = rand.nextInt(100 - 1 + 1) + 1;
        }

        // Count the distribution of numbers in the numbers array.
        for (int i = 0; i < size; ++i) {
            ++distribution[numbers[i]];
        }

        // Display a historgram of the distribution.
        for (int i = 1; i < size; ++i) {
            System.out.println("Number " + i + " occurs " + distribution[i]
                    + " times.");
        }
        showHistogram(distribution, size);
   }

    /**
     * Display a histogram of the data.
     * @param arr the array
     * @param size the array size
     */
    private static void showHistogram(final int[] arr, final int size) {
        String stars = "";
        int totStars;
        for (int i = 0; i < size; ++i) {
            totStars = arr[i];
            for (int j = 1; j <= totStars; ++j) {
                stars += "*";
            }
            System.out.println(i + ": " + stars);
            stars = "";
            totStars = 0;
      }
   }
}
