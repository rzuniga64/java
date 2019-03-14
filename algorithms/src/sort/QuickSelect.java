package sort;

import edu.princeton.cs.algs4.StdRandom;

import static sort.utility.SortUtility.generateRandomArray;
import static sort.utility.SortUtility.printHorizontalArray;

public class QuickSelect {

    private static Integer[] theArray = new Integer[10];

    // this class should not be instantiated
    private QuickSelect() {}

    public static Comparable select(Comparable[] a, int k) {

        StdRandom.shuffle(a);
        int low = 0;
        int high = a.length - 1;

        while (high > low)
        {
            int j = partition(a, low, high);
            if      (j < k) low = j + 1;
            else if (j > k) high = j - 1;
            else     return a[k];
        }

        return a[k];
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

    public static void main(String[] args) {

        generateRandomArray(QuickSelect.theArray, QuickSelect.theArray.length);
        printHorizontalArray(QuickSelect.theArray, QuickSelect.theArray.length, -1,-1);
        Comparable largest = QuickSelect.select(QuickSelect.theArray, QuickSelect.theArray.length/2);
        System.out.println("\nAfter quick select the kth largest is: " + largest.toString());

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
