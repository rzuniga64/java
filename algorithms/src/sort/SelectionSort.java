package sort;

import static sort.SortUtility.generateRandomArray;
import static sort.SortUtility.printHorizontalArray;

/**
 * 	Selection Sort is normally the best of the elementary sorts. There is a pass for each position (0..size-1)
 *	On each pass, the smallest (minimum) element in the rest of the list is exchanged (swapped) with element at the
 *	current position. The first part of the list (already processed) is always sorted. Each pass increases the size
 *	of the sorted portion
 *
 * 	Runtime analysis
 * 	Best    Average     Worst
 * 	O(n*n)  O(n*n)      O(n*n)
 *
 *	Array Position	0 	1	2	3	4
 *	Initial State	36	24	10	6	12
 *	After 1st pass	6 	24	10	36	12	6 and 36 are swapped
 *	After 2nd pass	6 	10 	24	36	12	10 and 24 are swapped
 *	After 3rd pass	6	10	12	36	24	12 and 24 are swapped
 *	After 4th pass	6 	10	12	24	36	24 and 36 are swapped
 *
 *	N is the number of elements in the list
 *	Outer loop executes N-1 times
 *	Inner loop executes N-1, then N-2, then N-3, ... then once.
 *
 *	Total number of comparisons (in inner loop) is the sum of 1 to N-1 is N(N + 1) /2 ~ N*N/2 compares and N exchanges.
 *	Efficiency of algorithm is O(N2)
 *  Running time is insensitive to input. Quadratic time, even if input is sorted.
 *  Data movement is minimal. Linear number of exchanges.
 */

public class SelectionSort {

    private static Integer[] theArray = new Integer[10];

    // This class should not be instantiated.
    private SelectionSort() { }

    /** On each pass, the smallest (minimum) element in the rest of the list is exchanged (swapped) with element at the
     *	current position. and then repeats searching through the entire array each time */
    public static void sort(Comparable[] a){

        int N = a.length;

        for(int i = 0; i < a.length; i++){

            int min = i;

            for(int j = i + 1; j < N; j++) {
                if( less(a[j], a[min]))
                    min = j;
            }

            exch(a, i, min);
            printHorizontalArray((Integer[]) a, a.length, i, -1);
        }
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

    private static boolean isSorted(Comparable[] a, int lo, int hi) {

        for (int i = lo + 1; i <= hi; i++) {
            if (less(a[i], a[i-1])) return false;
        }
        return true;
    }

    public static void main(String[] args){

        generateRandomArray(SelectionSort.theArray, SelectionSort.theArray.length);
        printHorizontalArray(SelectionSort.theArray, SelectionSort.theArray.length, -1,-1);
        SelectionSort.sort(SelectionSort.theArray);
        System.out.println("The array is sorted: " + SelectionSort.isSorted(SelectionSort.theArray));
    }
}