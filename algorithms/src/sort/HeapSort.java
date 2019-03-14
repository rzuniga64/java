package sort;

import sort.utility.StdIn;
import sort.utility.StdOut;

/******************************************************************************
 *  Compilation:  javac HeapSort.java
 *  Execution:    java HeapSort < input.txt
 *  Dependencies: StdOut.java StdIn.java
 *  Data files:   https://algs4.cs.princeton.edu/24pq/tiny.txt
 *                https://algs4.cs.princeton.edu/24pq/words3.txt
 *
 *  Sorts a sequence of strings from standard input using heapsort.
 *
 *  % more tiny.txt
 *  S O R T E X A M P L E
 *
 *  % java Heap < tiny.txt
 *  A E E L M O P R S T X                 [ one string per line ]
 *
 *  % more words3.txt
 *  bed bug dad yes zoo ... all bad yet
 *
 *  % java Heap < words3.txt
 *  all bad bed bug dad ... yes yet zoo   [ one string per line ]
 *
 ******************************************************************************/
public class HeapSort {

    /**
     *  This class should not be instantiated.
     */
    private HeapSort() { }

    /**
     *  Rearranges the array in ascending order, using the natural order.
     *  @param pq the array to be sorted.
     */
    public static void heapSort(Comparable[] pq) {

        int N = pq.length;
        for (int k = N/2; k >= 1; k--) {

            sink(pq, k, N);
        }
        while (N > 1) {
            exch(pq, 1, N--);
            sink(pq, 1, N);
        }
    }

    public static void main(String[] args) {

        String[] a = StdIn.readAllStrings();
        HeapSort.heapSort(a);
        show(a);
    }

    /*******************************************************************************************************************
     *  Helper functions to restore the heap invariant.
     ******************************************************************************************************************/

    private static void sink(Comparable[] pq, int k, int N) {
        while (2*k < N) {

            int j = 2 * k;
            if (j < N && less(pq, j, j + 1)) j++;
            if (!less(pq, k, j)) break;
            exch(pq, k, j);
            k = j;
        }
    }

    /*******************************************************************************************************************
     *  Helper functions for comparisons and swaps.
     *  Indices are "off-by-one" to support 1-based indexing.
     ******************************************************************************************************************/

    private static boolean less(Comparable[] pq, int i , int j) {
        return pq[i-1].compareTo(pq[j-1]) < 0;
    }

    private static void exch(Object[] pq, int i, int j) {

        Object swap = pq[i-1];
        pq[i-1] = pq[j-1];
        pq[j-1] = swap;
    }

    private static void show(Comparable[] a) {

        for (Comparable comparable : a) {
            StdOut.println(comparable);
        }
    }
}
