package java_lessons.lesson19_sort_and_search.sort;

/**
 * The type Quick sort.
 */
public class QuickSort {

    /**
     * this method performs a Quick sort.
     *
     * @param arr   the arr
     * @param left  the left
     * @param right the right
     */

    /**
     *  This method performs a Quick sort. In most situations the Quick sort is the fastest sorting algorithm.
     *
     *  @param arr  the arr
     *  @param low  the low
     *  @param high the high
     *
     *  Runtime analysis
     *  Best        Average     Worst
     *  O(n log n)  O(n log n)  O(n*n)
     *
     *  Quick sort is an efficient, general-purpose, divide and conquer sorting algorithm. When implemented well, it
     *  can be about two or three times faster than its main competitors, merge sort and heapsort.
     *
     *  The Quick sort works by partitioning arrays that the smaller numbers are on the left and the larger are on the
     *  right.  It then recursively sends small parts of larger arrays to itself and partitions again.
     *  https://en.wikipedia.org/wiki/Quicksort.
     *
     *  In Quick sort you pick a pivot point. The pivot point then becomes a tool for comparing values. The array is
     *  continuously bisected. The pivot is always found as the approximate midpoint until the data is sorted.
     *
     *  Array Position           0   1   2   3   4   5
     *  ----------------------------------------------
     *  Initial behavorial.state            6    5   3   1   8   7   2   4    3 is the pivot
     *
     *  After 1st pass sorted    2    5   3   1   8   7   6   4
     *                           -                        -
     *  After 2nd pass sorted    2    5   3   1   8   7   6   4
     *                                -               -
     *  After 3rd pass sorted    2    5   3   1   8   7   6   4
     *                                -           -
     *  After 4th pass sorted    2    1   3   5   8   7   6   4
     *                                -       -
     *  After 5th pass sorted    1    2   3   5   8   7   6   4    1 is the pivot
     *                           -    -
     *  After 6th pass sorted    1    2   3   4   8   7   6   5    4 is the pivot
     *                                        -               -
     *  After 7th pass sorted    1    2   3   4   8   7   6   5
     *                                            -       _
     *  After 8th pass sorted    1    2   3   4   8   7   6   5
     *                                            -   -
     *  After 9th pass sorted    1    2   3   4   5   7   6   8     6 is the pivot
     *                                            -           -
     *  After 10th pass sorted    1    2   3   4  5   6   7   8
     *                                                -   -
     *  After 11th pass sorted    1    2   3   4  5   6   7   8
     *                                                -   -
     *  After 12th pass sorted    1    2   3   4  5   6   7   8     5 is the pivot
     *                                            -   -
     *  After 13th pass sorted    1    2   3   4  5   6   7   8     8 is the pivot
     *                                                    -   -
     **/
    static void quickSort(int[] arr, int left, int right) {
        int i = left;
        int j = right;
        int temp;
        int pivot = arr[(left + right)/2];

        while (i <= j) {
            while (arr[i] < pivot)
                i++;
            while (arr[j] > pivot)
                j--;
            if (i <= j) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        if (left < j)
            quickSort(arr, left, j);
        if (i < right)
            quickSort(arr, i, right);
    }

    /**
     * Display.
     *
     * @param arr the arr
     */
    public static void display(int[] arr) {
        for (int num : arr) {
            System.out.println(num);
        }
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        int[] data = new int[] {5,10,1,9,4,8,3,6,2,7};
        System.out.println("Unsorted array: ");
        display(data);
        quickSort(data, 0 , data.length -1);
        System.out.println("Sorted array: ");
        display(data);
    }
}
