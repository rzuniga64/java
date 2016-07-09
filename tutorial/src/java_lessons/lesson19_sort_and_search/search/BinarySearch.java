package java_lessons.lesson19_sort_and_search.search;

import java.util.Arrays;
import java.util.Scanner;

/**
 * The type Binary search.
 */
public class BinarySearch {
    /**
     * this method displays the data to be binary sorted.
     *
     * @param arr the arr
     */
    public static void display(int [] arr) {
        for (int i = 0; i < arr.length; i++) {
            if ( i % 10 == 0)
                System.out.println();
            System.out.print(arr[i] + " ");
        }
    }

    /**
     * This method performs a Binary search.
     *
     * @param arr the arr
     * @param key the key
     * @return the int
     */
    static int binarySearch(int[] arr, int key) {
        int first = 0;
        int last = arr.length-1;
        while (first <= last) {
            int mid = (first + last) / 2;
            if (key > arr[mid])
                first = mid + 1;
            else if (key < arr[mid])
                last = mid -1;
            else
                return mid;
        }
        return -1;
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        final int size = 100;
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++)
            numbers[i] = (int)(Math.random() * 100);
        Arrays.sort(numbers);
        display(numbers);
        Scanner input = new Scanner(System.in);
        System.out.print("\nEnter a number to search for: ");
        int num = input.nextInt();
        int found =  binarySearch(numbers, num);
        if (found >= 0)
            System.out.println("Found key at position " + found);
        else
            System.out.println("Key not found.");
    }
}
