package sort;

import static sort.SortUtility.generateRandomArray;
import static sort.SortUtility.printHorizontalArray;

/**
 *  This method performs a Merge sort. It recursively splits the list into sub arrays until sub array size is 1, then
 *  merges those sub arrays to produce a sorted array. It is an abstract in-place merge.
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
 *  Array Position           0   1   2   3   4   5
 *  -------------------------------------------------------
 *                           lo              mid mid+1           hi     auxiliary array
 *  Initial state            E   E   G   M   R   A   C   E   R   T      E   E   G   M   R | A   C   E   R   T
 *                           k                                          i                   j
 *                           -----------------   -----------------
 *                                  sorted            sorted
 *
 *  After 1st pass sorted    A   E   G   M   R   A   C   E   R   T      E   E   G   M   R | A   C   E   R   T
 *                               k                                      i                       j
 *
 *  After 2nd pass sorted    A   C   G   M   R   A   C   E   R   T      E   E   G   M   R | A   C   E   R   T
 *                                   k                                      i                       j
 *
 *  After 3rd pass sorted    A   C   E   M   R   A   C   E   R   T      E   E   G   M   R | A   C   E   R   T
 *                                       k                                  i                       j
 *
 *  After 4th pass sorted    A   C   E   E   R   A   C   E   R   T      E   E   G   M   R | A   C   E   R   T
 *                                           k                                  i                   j
 *
 *  After 4th pass sorted    A   C   E   E   E   A   C   E   R   T      E   E   G   M   R | A   C   E   R   T
 *                                               k                              i                       j
 *
 *  After 5th pass sorted    A   C   E   E   E   G   C   E   R   T      E   E   G   M   R | A   C   E   R   T
 *                                                   k                              i                   j
 *
 *  After 6th pass sorted    A   C   E   E   E   G   M   E   R   T      E   E   G   M   R | A   C   E   R   T
 *                                                       k                              i               j
 *
 *  After 7th pass sorted    A   C   E   E   E   G   M   R   R   T      E   E   G   M   R | A   C   E   R   T
 *                                                           k                          i               j
 *
 *  After 8th pass sorted    A   C   E   E   E   G   M   R   R   T      E   E   G   M   R | A   C   E   R   T
 *                                                               k                      i                   j
 *
 *  After 9th pass sorted    A   C   E   E   E   G   M   R   R   T      E   E   G   M   R | A   C   E   R   T
 *                                                               k                      i                   j
 **/
public class MergeSort {

    private static Integer[] theArray = new Integer[10];

    // This class should not be instantiated
    private MergeSort() {}

    /**
     *  Sort routine.
     *  Creates an auxiliary array used to sort the data. Don't create the auxiliary array in the recursive sort
     *  routine because that can lead to extensive cost of extra array creation. Can lead to poor merge sort performance.
     *  @param a the array to sort
     */
    public static void sort(Comparable[] a) {

        Comparable[] aux = new Comparable[a.length]; // create a auxiliary array used as a placeholder to sort the data
        sort(a, aux, 0, a.length-1);
        assert isSorted(a);
    }

    @SuppressWarnings("Duplicates")
    private static void sort(Comparable[] a, Comparable[] aux, int low, int high) {

        if (high <= low) return;
        int middle = low + (high - low)/2;
        sort(a, aux, low, middle);
        sort(a, aux, middle + 1, high);
        merge(a, aux, low, middle, high);
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

        generateRandomArray(MergeSort.theArray, MergeSort.theArray.length);
        System.out.println("Before merge sort: ");
        printHorizontalArray(MergeSort.theArray, MergeSort.theArray.length, -1,-1);
        MergeSort.sort(MergeSort.theArray);
        System.out.println("\nAfter merge sort: ");
        printHorizontalArray(MergeSort.theArray, MergeSort.theArray.length, -1,-1);
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
