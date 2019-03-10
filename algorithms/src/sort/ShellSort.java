package sort;

import jdk.nashorn.tools.Shell;

import java.util.Arrays;

import static sort.SortUtility.generateRandomArray;
import static sort.SortUtility.generateRandomArray;
import static sort.SortUtility.printHorizontalArray;

import static sort.SortUtility.printHorzArray;

/**
 *  Shell sort is a sub quadratic algorithm whose code is only slightly longer than the insertion sort, making it the
 *  simplest of the faster algorithms. It compares elements that are far apart and then by comparing elements that are
 *  less far apart, and so on, gradually shrinking toward the basic insertion sort.  Shell sort is known as a
 *  diminishing gap sort. When gap is 1 the loop is identical to an insertion sort.
 *
 *  The running time of Shell sort depends heavily on the choice of increment sequences.  A sequence which performs well
 *  in practice but has no theoretical basis, is to have a starting gap of N/2.2. This divisor appears to bring the
 *  average running time to below O(pow(N, 5/4)).  For 100, 000, to 1,000,000 items, it typically improves performance
 *  by about to 25 to 35 percent over Shell's Increments, although nobody knows why.  The performance of Shell sort is
 *  quite acceptable in practice, even for N in the tens of thousands. The simplicity of the code makes it the algorithm
 *  of choice for sorting up to moderately large input.  it is also a fine example of a very simple algorithm with an
 *  extremely complex analysis.
 *
 *  Runtime analysis
 *  Best        Average         Worst
 *  O(n log n)  depends on gap  O(n log n * log n)
 *
 *  Original        81  94  11  96  12  35  17  95  28  58  41  75  15
 *  After 5-sort    35  17  11  28  12  41  75  15  96  58  81  94  95
 *                  --                  --                  --
 *  After 3-sort    28  12  11  35  15  41  58  17  94  75  81  96  95
 *                  --          --          --          --          --
 *  After 1-sort    11  12  15  17  28  35  41  58  75  81  94  95  96
 *
 *  The analysis of shell sort is still open.
 *  Proposition. The worst case number of compares used by shell sort with the 3x+1 increments is O(pow(N, 3/2).
 *
 *  Property. Actually in practice it's much less than that. Number of compares used by shell sort with the 3x + 1
 *  increments is at most by a small multiple of N times the # of increments used.  The problem is nobody knows an
 *  accurate model for describing the number of compares taken by shell sort for any interesting increment sequence.
 */

public class ShellSort {

    private static Integer[] theArray = new Integer[10];

    // this class should not be instantiated
    private ShellSort() {}

    private static void shellsort(Comparable[] a) {

        long startTime = System.currentTimeMillis();
        long endTime;

        int N = a.length;

        // 3x + 1 increment sequence: 1, 4, 13, 40, 121, 364, 1093, ...
        int h = 1;
        while (h < N/3) h = 3*h + 1;

        while ( h >= 1) { // h-sort the array

            // h-sort the array. Keep looping until h is 1. Then this becomes an insertion sort
            for (int i = h; i < N; i++) {

                for (int j = i; j >= h && less(a[j], a[j-h]); j -= h) {
                    exch(a, j, j-h);

                    //System.out.println("inner= " + (i-h) + " outer= " + i + " interval= " + h);
                    //printHorizontalArray((Integer[]) a, a.length, -1,-1);
                }
            }
            assert isHsorted(a, h);
            h /= 3;
        }

        assert(isSorted(a));
        endTime = System.currentTimeMillis();
        System.out.println("Shellsort took " + (endTime - startTime) + " milliseconds.");
    }

    /**
     *  Creates a sequene of integers; Shell sorts them;
     *  and prints them to standard output in ascending order.
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        generateRandomArray(ShellSort.theArray, ShellSort.theArray.length);
        //printHorizontalArray(ShellSort.theArray,  ShellSort.theArray.length, -1,-1);

        display(ShellSort.theArray);
        ShellSort.shellsort(ShellSort.theArray);
        display(ShellSort.theArray);
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

    /**
     *  Exchange a[i] and a[j]
     * @param a the array to sort
     * @param i index into array
     * @param j index into array
     */
    private static void exch(Object[] a, int i, int j){

        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    /**
     *  print array to standard output
     */
    private static void display(Comparable[] a) {
        System.out.println(Arrays.toString(a));
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

    /**
     *  Is the array a[] h-sorted?
     *  @param a the array
     *  @return true if h-sorted
     */
    private static boolean isHsorted(Comparable[] a, int h) {

        for (int i = h; i < a.length; i++) {
            if (less(a[i], a[i-h])) {
                return false;
            }
        }
        return true;
    }

    @SuppressWarnings("Duplicates")
    private static boolean isSorted(Comparable[] a, int lo, int hi) {

        for (int i = lo + 1; i <= hi; i++) {
            if (less(a[i], a[i-1])) return false;
        }
        return true;
    }
}
