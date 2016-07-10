package java_lessons.lesson19_sort_and_search.search;

import java.util.ArrayList;
import java.util.Scanner;
import java .util.Arrays;

/**
 * The type Time search.
 */
public class TimeSearch {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        final int size = 10000;
        final int maxNums = 100000;
        int n;
        int found;
        long startTime;
        long stopTime;
        long duration;

        ArrayList<Integer> nums = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            n = (int)(Math.random() * maxNums);
            // do not add any duplicates to the array
            if (!nums.contains(n))
                nums.add(n);
        }

        // print out the numbers
        int count = 0;
        for (Object aNum : nums) {
            System.out.print(aNum + " ");
            if (count % 30 == 0)
                System.out.println();
            count++;
        }
        System.out.println();

        // put the numbers into an array
        int[] numbers = new int[size];
        for (int i = 0; i < nums.size(); i++)
            numbers[i] = nums.get(i);

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number to search for: ");
        int num = input.nextInt();

        // use a linear search to find an item in the array
        startTime = System.nanoTime();
        found = LinearSearch.linearSearch(numbers, num);
        stopTime = System.nanoTime();
        duration = stopTime - startTime;

        if (found > 0)
            System.out.println("Linear search time: " + duration);
        else
            System.out.println("Number not found using linear search.");

        // Sort the data before doing a binary search!
        Arrays.sort(numbers);
        System.out.print("Enter a number to search for: ");
        num = input.nextInt();

        // use a binary search to find an item in the array
        startTime = System.nanoTime();
        found = BinarySearch.binarySearch(numbers, num);
        stopTime = System.nanoTime();
        duration = stopTime - startTime;

        if (found > 0)
            System.out.println("Binary search time: " + duration);
        else
            System.out.println("Number not found using binary search.");
    }
}
