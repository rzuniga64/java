package java_lessons.lesson7_arraylist;

import java.util.Random;
import java.util.ArrayList;

/**
 *  MaxValue class.
 */
public final class MaxValue {

    /** Constructor. */
    private MaxValue() { }

    /**
     *  Display the array.
     *  @param arr the array
     */
    private static void display(final ArrayList arr) {

        for (Object item : arr) {
          System.out.print(arr + " ");
      }
      System.out.println();
    }

    /**
     *  Build an ArrayList.
     * @param arr the array
     * @param num the number of items in the array
     */
    private static void buildAL(final ArrayList<Integer> arr, final int num) {

        Random rand = new Random(System.currentTimeMillis());
        for (int i = 0; i < num; ++i) {
            arr.add(rand.nextInt(101));
        }
    }

    /**
     *  Find the maximum item in an array.
     * @param arr the array
     * @return the maximum item.
     */
    private static int maximum(final ArrayList<Integer> arr) {

        int maxPos = 0;
        for (int i = 1; i < arr.size(); ++i) {
            if (arr.get(i) > arr.get(maxPos)) {
                maxPos = i;
            }
        }
      return maxPos;
   }

    /**
     * Unit tests.
     * @param args the arguments.
     */
    public static void main(final String[] args) {

        ArrayList<Integer> numbers = new ArrayList<>();
        buildAL(numbers, 10);
        int max = maximum(numbers);
        display(numbers);
        System.out.println("The maximum value is " + numbers.get(max));
    }
}
