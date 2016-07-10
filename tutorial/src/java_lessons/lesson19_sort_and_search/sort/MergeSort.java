package java_lessons.lesson19_sort_and_search.sort;


/**
 * The type Merge sort.
 */
public class MergeSort {

    /**
     *  This method performs a Merge sort.
     *
     *  @param arr  the arr
     *  @param low  the low
     *  @param high the high
     *
     *  Runtime analysis
     *  Best        Average     Worst
     *  O(n log n)  O(n log n)      O(n log n)
     *
     *  Merge sort has fewer comparisons compared with Quick sort but more swapping (copying).
     *  In Java, comparing objects can be expensive while swapping (copying) objects is relatively cheap.
     *  Therefore, Merge sort is the sorting routine commonly used in Java libraries.
     *
     *  Merge sort is an efficient, general-purpose, divide and conquer sorting algorithm.
     *  Merge sort works by splitting up the array into individual pieces. It compares adjacent elements and puts them
     *  in order. Next it looks at adjacent elements of each pair and orders those.  Finally, both parts are merged and
     *  sorted into their final correct order.
     *
     *  Array Position           0   1   2   3   4   5
     *  ----------------------------------------------
     *  Initial state            6    5   3   1   8   7   2   4
     *
     *  After 1st pass sorted    5   5  | 1   3 | 7   8 | 2   4     sort each pair
     *
     *  After 2nd pass sorted    1   3    5   6 | 2   4   7   8     sort adjacent elements of each pair
     *
     *  After 3rd pass sorted    1   2    3   4   5   6   7   8     both parts merged and sorted
     **/
    static void mergeSort(int[] arr, int low, int high) {

        int size = arr.length;

        if (low < high) {
            int middle = (low + high) / 2;
            mergeSort(arr, low, middle);
            mergeSort(arr, middle + 1, high);
            merge(arr, low, middle, high);
        }
    }

    private static void merge(int[] arr, int low, int middle, int high) {

        int size = arr.length;
        int[] temp = new int[size];

        for (int i = low; i <= high; ++i) {
            temp[i] = arr[i];
        }

        int i = low;
        int j = middle + 1;
        int k = low;

        while (i <= middle && j <= high) {
            if (temp[i] <= temp[j]) {
                arr[k] = temp[i];
                ++i;
            } else {
                arr[k] = temp[j];
                ++j;
            }
            ++k;
        }

        while ( i <= middle) {
            arr[k] = temp[i];
            ++k;
            ++i;
        }
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        int size = 10;
        int[] data = new int[]{5,10,1,6,2,9,3,8,7,4};
        int low = 0;
        int high = 9;

        System.out.println("Before sorting: ");
        for (int i = 0; i < size; i++)
            System.out.println(data[i]);

        mergeSort(data, low, high);

        System.out.println("\nAfter sorting: ");
        for (int i = 0; i < size; i++)
            System.out.println(data[i]);
    }
}
