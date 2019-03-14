package sort;

import static sort.SortUtility.generateRandomArray;
import static sort.SortUtility.printHorizontalArray;

/**
 *  This method performs a Merge sort. It passes through an array, merging sub arrays of size 1. Repeat for sub arrays
 *  of size 2 4 8 16, etc. No recursion needed!
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
 *  Copy the array to an auxiliary array and copy the two sub arrays back to the original array in sorted order.
 *  Compare the first element in each sub array and copy the minimum and move up the pointer. Continue comparing the
 *  minimum in each subarray and moving the pointers until both sub arrays are copied to the original array.
 *  Goal. Given two sorted sub arrays a[lo] to a[mid] and a[mid+1] to a[hi], replace with sorted subarray a[lo] to a[hi].
 *
 *                          0   1   2   3   4   5   6   7   8   9   10  11  12  13  14  15
 *  sz=1                    M   E   R   G   E   S   O   R   T   E   X   A   M   P   L   E
 *  merge(a, 0, 0, 1)       E   M
 *  merge(a, 2, 2, 3)               G   R
 *  merge(a, 4, 4, 5)                       E   S
 *  merge(a, 6, 6, 7)                               O   R
 *  merge(a, 8, 8, 9)                                       E   T
 *  merge(a, 10, 10, 11)                                           A   X
 *  merge(a, 12, 12, 13)                                                    M   P
 *  merge(a, 14, 14, 15)                                                            E   L
 *  sz = 2
 *  merge(a, 0, 1, 3)       E   G   M   R
 *  merge(a, 4, 5, 7)                       E   O   R   S
 *  merge(a, 8, 9, 11)                                      A   E   T   X
 *  merge(a, 12, 13, 15)                                                    E   L   M   P
 *  sz=4
 *  merge(a, 0, 3, 7)       E   E   G   M   O   R   R   S
 *  merge(a  8, 11, 15)                                     A   E   E   L   M   P   T   X
 *  sz-8
 *  merge(a, 0, 7, 15)      A   E   E   E   E   G   L   M   M   O   P   R   R   S   T   X
 **/
public class MergeBUSort {

    private static Integer[] theArray = new Integer[10];

    // This class should not be instantiated
    private MergeBUSort() {}

    /**
     *  Sort routine.
     *  Creates an auxiliary array used to sort the data. Don't create the auxiliary array in the recursive sort
     *  routine because that can lead to extensive cost of extra array creation. Can lead to poor merge sort performance.
     *  @param a the array to sort
     */
    public static void sort(Comparable[] a) {

        int N = a.length;
        Comparable[] aux = new Comparable[N]; // create a auxiliary array used as a placeholder to sort the data

        for (int sz = 1; sz < N; sz = sz + sz)
            for (int low = 0; low < N - sz; low += sz + sz)
                merge(a, aux, low, low + sz - 1, Math.min(low + sz + sz -1, N - 1));
        assert isSorted(a);
    }

    /**
     *  This method is a helper function which does the actual sorting and merging.
     *  Stably merge a[lo...mid] with a[mid+1...hi] using aux[lo..hi]
     *  @param a the array to merge
     *  @param low index of the array
     *  @param middle index of the array
     *  @param high index of the array
     */
    @SuppressWarnings("Duplicates")
    private static void merge(Comparable[] a, Comparable[] aux, int low, int middle, int high) {

        assert isSorted(a ,low, middle);            // precondition: a[lo..mid] sorted
        assert isSorted(a, middle + 1, high);   // precondition: a[mid+1..hi] sorted

        for (int i = low; i <= high; ++i) {         // copy everything to the auxiliary array
            aux[i] = a[i];
        }

        int i = low, j = middle + 1;

        for (int k = low; k <= high; k++) {
            if      (i > middle)           a[k] = aux[j++];
            else if (j > high)             a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else                           a[k] = aux[i++];
        }

        assert isSorted(a, low, high);              // post condition: a[low..high] sorted
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    @SuppressWarnings("Duplicates")
    public static void main(String[] args) {

        generateRandomArray(MergeBUSort.theArray, MergeBUSort.theArray.length);
        System.out.println("Before merge bottom up sort: ");
        printHorizontalArray(MergeBUSort.theArray, MergeBUSort.theArray.length, -1,-1);
        MergeBUSort.sort(MergeBUSort.theArray);
        System.out.println("\nAfter merge bottom up sort: ");
        printHorizontalArray(MergeBUSort.theArray, MergeBUSort.theArray.length, -1,-1);
    }

    /*******************************************************************************************************************
     *  Helper sorting functions
     ******************************************************************************************************************/

    /**
     *  Is v < w?
     *  @param v a Comparable
     *  @param w a Comparable
     *  @return true if v < w
     */
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    /*******************************************************************************************************************
     *  Check if array is sorted - useful for debugging.
     ******************************************************************************************************************/

    /**
     *  Is the array a[] sorted?
     *  @param a the array
     *  @return true if sorted
     */
    private static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    @SuppressWarnings("Duplicates")
    private static boolean isSorted(Comparable[] a, int lo, int hi) {

        for (int i = lo + 1; i <= hi; i++) {
            if (less(a[i], a[i-1])) return false;
        }
        return true;
    }
}
