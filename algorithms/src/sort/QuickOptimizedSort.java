package sort;

import edu.princeton.cs.algs4.StdRandom;

import static sort.SortUtility.generateRandomArray;
import static sort.SortUtility.printHorizontalArray;

/**
 *  In most situations the sort.QuickSort is the fastest sorting algorithm. The sort.QuickSort works by partitioning
 *  arrays that the smaller numbers are on the left and the larger are on the right.  It then recursively sends small
 *  parts of larger arrays to itself and partitions again. This method performs a Quick sort. It’s a recursive method
 *  but the basic idea behind Quick sort is that it does the recursion after it does the the work.
 *
 *  Basic Plan
 *  - Shuffle the array.
 *  - Partition, so that, for some j
 *    - entry a[j] is in place in the array
 *    - no larger entry to the left of j
 *    - no smaller entry to the right of j
 *  - Sort each piece recursively
 *
 *  Phase 1. repeat until i and j pointers cross.
 *  - Pick a partitioning element as a[0]
 *  - Scan i from left to right so long as (a[i] < a[l0]).
 *  - Scan j from right to left so long as (a[j] > a[0]).
 *  - Exchange a[i] with a[j]
 *
 *  K    R    A    T    E   L    E    P    U    I    M    Q    C    X    O    S	    stop i scan because a[i] > a=[0]
 *  lo   i                                                                    j
 *  K    R    A    T    E   L    E    P    U    I    M    Q    C    X    O    S	    stop j scan and exchange a[i] with a[j]
 *  lo   i                                                     j
 *  K    C    A    T    E   L    E    P    U    I    M    Q    R    X    O    S
 *       i                                                     j
 *  K    C    A    T    E   L    E    P    U    I    M    Q    R    X    O    S	    stop i scan because a[i] >= a [lo]
 *                 i                                           j
 *  K    C    A    T    E   L    E    P    U    I    M    Q    R    X    O    S	    decrement j as long as it points to
 *                 i                            j                                   something that's bigger than K
 *
 *  K    C    A    T    E   L    E    P    U    I    M    Q    R    X    O    S	    stop j scan and exchange a[i] with a[j]
 *                 i                            j
 *  K    C    A    I    E   L    E    P    U    T    M    Q    R    X    O    S
 *                 i                            j
 *  K    C    A    I    E   L    E    P    U    T    M    Q    R    X    O    S	    stop i scan because a[i] >= a [lo]
 *                          i                   j
 *  K    C    A    I    E   L    E    P    U    T    M    Q    R    X    O    S	    stop j scan and exchange a[i] with a[j]
 *                          i    j
 *  K    C    A    I    E   E    L    P    U    T    M    Q    R    X    O    S
 *                          i    j
 *  K    C    A    I    E   E    L    P    U    T    M    Q    R    X    O    S	    i stops at L > K, j stops at E < K,
 *                          j    i                                                  j stop at E < K, Now at this point
 *                                                                                  the partitioning process complete
 *  Phase 2. When pointers cross
 *  - Exchange a[lo] with a[j]
 *
 *  E    C    A    I    E   K    L    P    U    T    M    Q    R    X    O    S
 *  lo                      j                                            hi
 *
 *  Runtime analysis
 *  Best        Average     Worst
 *  O(n log n)  O(1/3 n log n)  O(1/2 N * N)
 *
 *  Random shuffle.
 *  - Probabilistic guarantee against worst case. Basis for math model that can be validated with experiments
 *
 *  Caveat emptor. Many textbooks implementations go quadratic if array
 *  - Is sorted or reverse sorted.
 *  - Has many duplicates (even if randomized!)
 *
 *  Quick sort properties
 *
 *  Proposition. Quick sort is an in-place sorting algorithm.
 *  Pf.
 *  - Partitioning: constant extra space
 *  - Depth of recursion: logarithmic extra space (with high probability).<-can guarantee logarithmic depth by recurring
 *                                                                          on smaller sub-array before large sub-array
 *  Proposition. Quick sort is not stable.
 *  Partitioning does one of those long range exchanges that might but a key with equal value over another key of the
 *  same value. it’s a little more work to make quick sort stable with a little extra space.
 */
public class QuickOptimizedSort {

    // cutoff to insertion sort, must be >=1
    private static final int CUTOFF = 10;
    private static Integer[] theArray = new Integer[10];

    // this class should not be instantiated
    private QuickOptimizedSort() {}

    /**
     *  Rearranges the array in ascending order, using the natural order.
     *  @param a the array to be sorted.
     */
    public static void sort(Comparable a[]) {

        StdRandom.shuffle(a); // shuffle needed for performance guarantee
        sort(a, 0, a.length - 1);
        assert isSorted(a);
    }

    /**
     *  Quick sort the array from a[low] to a[high].
     *  @param a the array to be sorted
     *  @param low index of the array
     *  @param high index of the array
     */
    @SuppressWarnings("Duplicates")
    private static void sort(Comparable a[], int low, int high) {

        if (high <= low) return;

        // Optimization: use insertion sort for small subarrays. Quick sort has too much overhead for tiny sub arrays.
        // Cutoff to insertion sort of for ~10 items.
        int n = high - low + 1;
        if (n <= CUTOFF) {
            insertionSort(a, low, high);
            return;
        }

        int j = partition(a, low, high);
        sort(a, low, j - 1);
        sort(a, j + 1, high);
        assert isSorted(a);
    }

    /**
     *  Partition the sub-array a[low..high] to that a[low..j-1] <= a[j+1..high] and return the array index j.
     *  @param a the array to be sorted
     *  @param low index of the array
     *  @param high index of the array
     *  @return the array index j
     */
    @SuppressWarnings("Duplicates")
    private static int partition(Comparable[] a, int low, int high) {

        // Optimization. Median of sample. Best choice of pivot = median. Estimate true median by taking median of sample.
        int n = high - low + 1;
        int median = median3(a, low, low + n/2, high);
        exch(a, median, low);

        int i = low; int j = high + 1;

        while (true) {

            while (less(a[++i], a[low])) // find item on left to swap
                if (i == high) break;

            while (less(a[low], a[--j])) // find item on right to swap, redundant since a[low] acts as a sentinel
                if (j == low) break;

            if (i >= j) break;           // check if pointers cross

            exch(a, i, j);               // swap
        }

        exch(a, low, j);                 // swap a[j] with partitioning item
        return j;                        // return index of item now known to be in place, now a[low..j-1] <= a[j+1..hi]
    }

    private static void insertionSort(Comparable[] a, int low, int high) {

        for (int i = low; i <= high; i++){

            for (int j = i; j > low && less(a[j], a[j-1]); j-- ){
                exch(a, j, j - 1);
            }
        }
    }

    /**
     *  Return the index of the median element among a[i], a[j], and a[k]
     *  @param a the array to be sorted
     *  @param i index of array
     *  @param j index of array
     *  @param k index of array
     *  @return Return the index of the median element among a[i], a[j], and a[k]
     */
    private static int median3(Comparable[] a, int i, int j, int k) {
        return (less(a[i], a[j]) ?
                (less(a[j], a[k]) ? j : less(a[i], a[k]) ? k : i) :
                (less(a[k], a[j]) ? j : less(a[k], a[i]) ? k : i));
    }

    public static void main(String[] args) {

        generateRandomArray(QuickOptimizedSort.theArray, QuickOptimizedSort.theArray.length);
        System.out.println("Before quick sort: ");
        printHorizontalArray(QuickOptimizedSort.theArray, QuickOptimizedSort.theArray.length, -1,-1);
        QuickOptimizedSort.sort(QuickOptimizedSort.theArray);
        System.out.println("\nAfter quick sort: ");
        printHorizontalArray(QuickOptimizedSort.theArray, QuickOptimizedSort.theArray.length, -1,-1);
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
