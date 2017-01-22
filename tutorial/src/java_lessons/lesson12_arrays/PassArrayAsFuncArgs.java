package java_lessons.lesson12_arrays;

import java.util.Random;

/**
 *  PassArrayAsFuncArgs class.
 *  When passing an array as a parameter to a function you must pass the
 *  array and its size.
 */
public final class PassArrayAsFuncArgs {

    /** Constructor. */
    private PassArrayAsFuncArgs() { }
    /**
     *  Create an array of random numbers from 1 - 100.
     *  @param arr the array
     *  @param size the size of the array
     */
    private static void buildArray(final int[] arr, final int size) {

        Random rand = new Random(System.currentTimeMillis());
        for (int i = 0; i < size; ++i) {
            arr[i] = rand.nextInt(101);
        }
    }

    /**
     *  Display an array.
     *  @param arr the array
     *  @param size the size of the arraay
     */
    private static void displayArr(final int[] arr, final int size) {

        for (int i = 0; i < size; ++i) {
            System.out.print(arr[i] + " ");
            if ((i + 1) % 10 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    /**
     *  Sum the items in an array.
     *  @param arr the array
     *  @param size the size
     *  @return the sum
     */
    private static int sumArray(final int[] arr, final int size) {

        int total = 0;
        for (int item : arr) {
            total += item;
        }
        return total;
    }

    /**
     * Unit tests.
     * @param args the arguments.
     */
    public static void main(final String[] args) {

        final int size = 100;
        int[] numbers = new int[size];
        buildArray(numbers, size);
        displayArr(numbers, size);
        System.out.println("The sum of the elements is: "
                + sumArray(numbers, size));
   }
}
