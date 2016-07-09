package java_lessons.lesson19_sort_and_search;

import java.util.ArrayList;
import java.util.Scanner;
import java .util.Arrays;

public class TimeSearch {

    private static int linearSearch(int[] arr, int key) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == key)
                return i;
        }
        return -1;
    }

    private static int binarySearch(int[] arr, int key) {
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
        int found = linearSearch(numbers, num);
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
        found = binarySearch(numbers, num);
        stopTime = System.nanoTime();
        duration = stopTime - startTime;
        if (found > 0)
            System.out.println("Binary search time: " + duration);
        else
            System.out.println("Number not found using binary search.");
    }
}
