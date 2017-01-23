package java_lessons.lesson19_sort_and_search.search;

import java.util.Arrays;
import java.util.Scanner;

/**
 * The BinarySearch class.
 *
 *  Binary search is a search algorithm that finds the position of a target
 *  value within a sorted array. It compares the target value to the middle
 *  element of the array; if they are unequal, the half in which the target
 *  cannot lie is eliminated and the search continues on the remaining half
 *  until it is successful.
 *
 *  Runtime analysis
 *  O(1)    O(log n)    O(log n)
 */
public final class BinarySearch {

    /** Constructor. */
    private BinarySearch() { }

    /**
     *  This method performs a Binary search.
     *
     *  @param arr the arr
     *  @param key the key
     *  @return the int
     */
    static int binarySearch(final int[] arr, final int key) {

        int first = 0;
        int last = arr.length - 1;

        while (first <= last) {

            int mid = (first + last) / 2;
            if (key > arr[mid]) {
                first = mid + 1;
            } else if (key < arr[mid]) {
                last = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    /**
     * This method displays the data to be binary sorted. A Binary search works
     * on sorted data.
     *
     * @param arr the arr
     */
    public static void display(final int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            if (i % 10 == 0) {
                System.out.println();
            }
            System.out.print(arr[i] + " ");
        }
    }

    /**
     * Unit tests for BinarySearch class.
     * @param args the input arguments
     */
    public static void main(final String[] args) {

        final int size = 100;
        int[] numbers = new int[size];

        for (int i = 0; i < size; i++) {
            numbers[i] = (int) (Math.random() * 100);
        }
        Arrays.sort(numbers);
        display(numbers);

        Scanner input = new Scanner(System.in);
        System.out.print("\nEnter a number to search for: ");
        int num = input.nextInt();
        int found =  binarySearch(numbers, num);
        if (found >= 0) {
            System.out.println("Found key at position " + found);
        } else {
            System.out.println("Key not found.");
        }
    }
}
