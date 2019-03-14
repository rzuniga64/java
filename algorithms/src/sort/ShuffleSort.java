package sort;

import edu.princeton.cs.algs4.StdRandom;

import static sort.SortUtility.generateRandomArray;
import static sort.SortUtility.printHorizontalArray;

/**
 *  The class provides a client for reading in a sequence of strings and shuffling them using the Knuth (or Fisher-Yates)
 *  shuffling algorithm. This algorithm guarantees to rearrange the elements in uniformly random order, under
 *  the assumption that Math.random() generates independent and uniformly distributed numbers between 0 and 1.
 *
 *  For additional documentation,
 *  see <a href="https://algs4.cs.princeton.edu/11model">Section 1.1</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *  See {@link StdRandom} for versions that shuffle arrays and
 *  subarrays of objects, doubles, and ints.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
public class ShuffleSort {

    private static Integer[] theArray = new Integer[10];

    public static void shuffle(Object[] a) {

        int N = a.length;

        for (int i = 0; i < N; i++) {
            int r = StdRandom.uniform(i + 1);
            exch(a, i, r);
        }
    }

    public static void main(String[] args){

        generateRandomArray(ShuffleSort.theArray, ShuffleSort.theArray.length);
        printHorizontalArray(ShuffleSort.theArray,  ShuffleSort.theArray.length, -1,-1);
        ShuffleSort.shuffle(ShuffleSort.theArray);
        printHorizontalArray(ShuffleSort.theArray,  ShuffleSort.theArray.length, -1,-1);
    }

    /*******************************************************************************************************************
     *  Helper sorting functions
     ******************************************************************************************************************/

    private static void exch(Object[] a, int i, int j){

        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
}
