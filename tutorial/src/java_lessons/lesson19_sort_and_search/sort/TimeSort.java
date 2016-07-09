package java_lessons.lesson19_sort_and_search.sort;

/**
 * A class to test the runtime of different sort algorithms.
 */
public class TimeSort {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        final int size = 100;
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++)
            numbers[i] = (int) (Math.random() * 1000);

        long startTime = System.nanoTime();
        BubbleSort.bubbleSort(numbers);
        long stoptime = System.nanoTime();
        long duration = stoptime - startTime;
        System.out.println("Bubble sort took \t" +  duration + " nanoseconds");

        startTime = System.nanoTime();
        InsertionSort.insertionSort(numbers);
        stoptime = System.nanoTime();
        duration = stoptime - startTime;
        System.out.println("Insertion sort  \t" +  duration + " nanoseconds");

        startTime = System.nanoTime();
        QuickSort.quickSort(numbers, 0, size - 1);
        stoptime = System.nanoTime();
        duration = stoptime - startTime;
        System.out.println("Quick sort took \t" +  duration + " nanoseconds");

        startTime = System.nanoTime();
        MergeSort.mergeSort(numbers, 0, size - 1);
        stoptime = System.nanoTime();
        duration = stoptime - startTime;
        System.out.println("Merge sort took \t" +  duration + " nanoseconds");
    }
}
