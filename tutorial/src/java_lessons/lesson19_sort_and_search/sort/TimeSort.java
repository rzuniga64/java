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

        final int size = 10000;
        int[] numbers = new int[size];
        int[] copy = new int[size];
        long startTime;
        long stopTime;
        long duration;

        for (int i = 0; i < size; i++)
            numbers[i] = (int) (Math.random() * 10000);

        copy = numbers.clone();

        startTime = System.nanoTime();
        BubbleSort.bubbleSort(numbers);
        stopTime = System.nanoTime();
        duration = stopTime - startTime;
        System.out.println("Bubble sort took \t" +  duration + " nanoseconds");

        numbers = copy.clone();
        startTime = System.nanoTime();
        InsertionSort.insertionSort(numbers);
        stopTime = System.nanoTime();
        duration = stopTime - startTime;
        System.out.println("Insertion sort  \t" +  duration + " nanoseconds");

        numbers = copy.clone();
        startTime = System.nanoTime();
        ShellSort.shellsort(numbers);
        stopTime = System.nanoTime();
        duration = stopTime - startTime;
        System.out.println("Shell sort  \t\t" +  duration + " nanoseconds");

        numbers = copy.clone();
        startTime = System.nanoTime();
        QuickSort.quickSort(numbers, 0, size - 1);
        stopTime = System.nanoTime();
        duration = stopTime - startTime;
        System.out.println("Quick sort took \t" +  duration + " nanoseconds");

        numbers = copy.clone();
        startTime = System.nanoTime();
        MergeSort.mergeSort(numbers, 0, size - 1);
        stopTime = System.nanoTime();
        duration = stopTime - startTime;
        System.out.println("Merge sort took \t" +  duration + " nanoseconds");
    }
}
