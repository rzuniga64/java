package java_lessons.lesson18_data_structures;

import java.util.LinkedList;

/**
 *  This class is an example of radix sorting as an application for a queue.
 *  Radix sort creates an array of queues which will hold numbers 0-9, 10-19,
 *  20-29, etc. Then we will take the numbers in the array that we are
 *  trying to sort and distribute them among the queues based on their values.
 *  Then once all the numbers have been distributed then we simply going to
 *  go back and collect them into one array. By taking the queues in order
 *  from the 0-9s, 10-19s then we'll have our numbers in sorted order.
 *
 *  Radix sort is a non-comparative integer sorting algorithm that sorts data
 *  with integer keys by grouping keys by the individual digits which share the
 *  same significant position and value. A positional notation is required, but
 *  because integers can represent strings of characters (e.g., names or dates)
 *  and specially formatted floating point numbers, radix sort is not limited to
 *  integers.
 */
public final class LinkedListRadixSort {

    /** Constructor. */
    private LinkedListRadixSort() { }

    /**
     * Distribute.
     *
     * @param arr       the arr
     * @param digits    the digits
     * @param digitType the digit type
     */
    private static void distribute(final int[] arr,
                                   final LinkedList<Integer>[] digits,
                                   final String digitType) {

        for (int i = 0; i < arr.length; i++) {
            if (digitType.equals("ones")) {
                digits[arr[i] % 10].addLast(arr[i]);
            } else {
                digits[arr[i] / 10].addLast(arr[i]);
            }
        }
    }

    /**
     * Collect.
     *
     * @param digits the digits
     * @param arr    the arr
     */
    private static void collect(final LinkedList[] digits, final int[] arr) {

        int i = 0;

        for (int digit = 0; digit < 10; ++digit) {
            while (!digits[digit].isEmpty()) {
                arr[i++] = (Integer) digits[digit].removeFirst();
            }
        }
    }

    /**
     * Display the contents of the array.
     * @param arr the arr
     */
    private static void display(final int[] arr) {

        int i = 0;

        while (i < arr.length) {
            System.out.print(arr[i] + " ");
            if (++i % 10 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    /**
     *  Unit tests for LinkedListRadixSort class.
     *  @param args the input arguments
     */
    public static void main(final String[] args) {

        final int size = 50;
        final int numQueues = 10;

        // Create an array of queues.
        LinkedList<Integer>[] digits = new LinkedList[numQueues];

        for (int i = 0; i < numQueues; ++i) {
            digits[i] = new LinkedList<>();
        }
        // create array for final sorted list
        int[] numbers = new int[size];

        // Create an array of random integers
        for (int i =  0; i < size; ++i) {
            numbers[i] = (int) (Math.random() * 100);
        }
        display(numbers);
        distribute(numbers, digits, "ones");
        collect(digits, numbers);

        display(numbers);
        distribute(numbers, digits, "tens");
        collect(digits, numbers);

        display(numbers);
    }
}
