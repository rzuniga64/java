package java_lessons.lesson19_sort_and_search.search;

import java.util.ArrayList;
import java.util.Scanner;
import java .util.Arrays;

public class TimeSearch {

    public static void main(String[] args) {
        final int size = 10000;
        final int maxNums = 100000;
        int n;
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            n = (int)(Math.random() * maxNums);
            if (!nums.contains(n))
                nums.add(n);
        }

        int count = 0;
        for (Object aNum : nums) {
            System.out.print(aNum + " ");
            if (count % 30 == 0)
                System.out.println();
            count++;
        }
        System.out.println();
        int[] numbers = new int[size];
        for (int i = 0; i < nums.size(); i++)
            numbers[i] = nums.get(i);
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number to search for: ");
        int num = input.nextInt();

        long startTime = System.nanoTime();
        int found = LinearSearch.linearSearch(numbers, num);
        long stopTime = System.nanoTime();
        long duration = stopTime - startTime;
        if (found > 0)
            System.out.println("Linear search time: " + duration);
        else
            System.out.println("Number not found using linear search.");

        Arrays.sort(numbers);
        System.out.print("Enter a number to search for: ");
        num = input.nextInt();
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
