package sort;

import edu.princeton.cs.algs4.StdRandom;

import static sort.SortUtility.printHorizontalArray;

/**
 *  Goal. Partition array into 3 parts so that:
 *  - Entries between lt and gt equal to partition item v.
 *  - No larger entries to left of lt.
 *  - No smaller entries to right of gt.
 *
 *  lt 	i												gt
 *  P 	A	B	X	W	P	P	V	P	D	P	C	Y	Z
 *
 *  lt 	i											gt
 *  A 	P	B	X	W	P	P	V	P	D	P	C	Y	Z
 *
 *  lt 	i										gt
 *  A 	B	P	X	W	P	P	V	P	D	P	C	Y	Z
 *
 *  lt 	i									gt
 *  A 	B	P	Z	W	P	P	V	P	D	P	C	Y	X
 *
 *  lt 	i								gt
 *  A 	B	P	Y	W	P	P	V	P	D	P	C	Z	X
 *
 *  lt 	i							gt
 *  A 	B	P	C	W	P	P	V	P	D	P	Y	Z	X
 *
 *  lt 	i						gt
 *  A 	B	C	P	W	P	P	V	P	D	P	Y	Z	X
 *
 *  lt 	i					gt
 *  A 	B	C	P	P	P	P	V	P	D	W	Y	Z	X
 *
 *  lt 		i				gt
 *  A 	B	C	P	P	P	P	V	P	D	W	Y	Z	X
 *
 *  lt 			i			gt
 *  A 	B	C	P	P	P	P	V	P	D	W	Y	Z	X
 *
 *  lt 				i		gt
 *  A 	B	C	P	P	P	P	V	P	D	W	Y	Z	X
 *
 *  lt 				i	gt
 *  A 	B	C	P	P	P	P	D	P	V	W	Y	Z	X
 *
 *  lt 				i gt
 *  A 	B	C	D	P	P	P	P	P	V	W	Y	Z	X
 *
 *  lt 				gt
 *  A 	B	C	D	P	P	P	P	P	V	W	Y	Z	X
 *  lo													hi
 *
 *  Duplicate keys: lower bound
 *
 *  Sorting lower bound: If there are n distinct keys and the ith one occurs xi  times, any compare-based sorting
 *  algorithm must use at least
 *  - N lg N when all distinct
 *  - linear when only a constant number of distinct keys
 *  compares in the worst case.
 *
 *  Bottom line. Randomized quick sort with 3-way partitioning reduces running time from linearithmic to linear in
 *  broad case of applications.
 */
public class Quick3WaySort {

    private static Comparable[] theArray = new Comparable[13];

    // this class should not be instantiated
    private Quick3WaySort() {}

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
     *  Quick sort the array using 3-way partitioning
     *  @param a the array to be sorted
     *  @param low index of the array
     *  @param high index of the array
     */
    private static void sort(Comparable a[], int low, int high) {

        if (high <= low) return;
        int lt = low;
        int gt = high;
        Comparable v = a[low];
        int i = low + 1;

        while(i <= gt) {

            int cmp = a[i].compareTo(v);
            if      (cmp < 0) exch(a, lt++, i++);
            else if (cmp > 0) exch(a, i, gt--);
            else              i++;
        }

        // a[low..lt-1] < v = a[lt..gt] < a[gt+1..high]
        sort(a, low, lt -1 );
        sort(a, gt + 1, high);
        assert isSorted(a, low, high);
    }

    public static void main(String[] args) {

        Quick3WaySort.theArray[0] = "P";
        Quick3WaySort.theArray[1] = "A";
        Quick3WaySort.theArray[2] = "B";
        Quick3WaySort.theArray[3] = "X";
        Quick3WaySort.theArray[4] = "W";
        Quick3WaySort.theArray[5] = "P";
        Quick3WaySort.theArray[6] = "P";
        Quick3WaySort.theArray[7] = "V";
        Quick3WaySort.theArray[8] = "P";
        Quick3WaySort.theArray[9] = "D";
        Quick3WaySort.theArray[10] = "P";
        Quick3WaySort.theArray[11] = "Y";
        Quick3WaySort.theArray[12] = "Z";

        System.out.println("Before 3-way quick sort: ");
        printHorizontalArray(Quick3WaySort.theArray, Quick3WaySort.theArray.length, -1,-1);
        Quick3WaySort.sort(Quick3WaySort.theArray);
        System.out.println("\nAfter 3-way quick sort: ");
        printHorizontalArray(Quick3WaySort.theArray, Quick3WaySort.theArray.length, -1,-1);
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
