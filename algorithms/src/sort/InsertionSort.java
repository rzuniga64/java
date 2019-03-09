package sort;

import static sort.SortUtility.generateRandomArray;
import static sort.SortUtility.printHorizontalArray;

/**
 *  The Insertion sort.
 *  Unlike the other sorts that had a group sorted at any given time, groups are only partially sorted here.
 *
 *  Runtime analysis
 *  Best    Average     Worst
 *  O(n)    O(n*n)      O(n*n)
 *
 *  Insertion sort is a simple sorting algorithm that is appropriate for small inputs
 *  The basic action of insertion sort is to sort the elements in positions 0 through p (where p ranges from 1 through
 *  N-1). In each state p increases by 1. That is what the outer loop is controlling.
 *
 *  When the body of the for loop is entered we are guaranteed that the elements in array positions 0 through p-1 have
 *  already been sorted and that we need to extend this to positions 0 to p.
 *
 *  At each step the underlined element needs to be added to the previously sorted part of the array. We can easily
 *  do that by placing it in a temporary variable and sliding all the elements that ARE LARGER THAN IT on position
 *  to the right. We then copy the temporary variable into the former position of the leftmost relocated
 *  element. We keep a counter j, which is the position in which the temporary variable should be written back.
 *  Every time an element is slid, j decreases by 1.
 *
 *  Array Position           0   1   2   3   4   5
 *  ----------------------------------------------
 *  Initial state            8|  5   9   2   6   3   temp = 5
 *                              -
 *  After a[0..1] is sorted  5   8|  9   2   6   3   temp = 9
 *                                  -
 *  After a[0..2] is sorted  5   8   9|  2   6   3   temp = 2
 *                                      -
 *  After a[0..3] is sorted  2   5   8   9|  6   3   temp = 6
 *                                          -
 *  After a[0..4] is sorted  2   5   6   8   9|  3   temp = 3
 *                                              -
 *  After a[0..5] is sorted  2   3   5   6   8   9|
 *
 *  Insertion sort uses ~1/4 N*N compares and ~1/4 N*N exchanges on average.
 *  Since N*N/4 versus N*N/2 insertion sort is going to be twice as fast as selection sort.
 **/
public class InsertionSort {

    private static Integer[] theArray = new Integer[10];

    private static void insertionSort(Comparable[] a){

        int N = a.length;

        for (int i = 0; i < N; i++){

            for (int j = i; j > 0; j-- ){
                if (less(a[j], a[j-1])) {
                    exch(a, j, j - 1);
                } else {
                    break;
                }
            }

            printHorizontalArray((Integer[]) a, N, i, -1);
        }
    }

    /** The Binary LinearSearch is quicker than the linear search because all the values are sorted. Because everything is
     * sorted once you get to a number larger than what you are looking for you can stop the search. Also you be able
     * to start searching from the middle which speeds the search. It also works best when there are no duplicates */

    private void binarySearchForValue(int value){

        int N = theArray.length;
        int lowIndex = 0;
        int highIndex = N - 1;

        while(lowIndex <= highIndex){

            int middleIndex = (highIndex + lowIndex) / 2;
            if(theArray[middleIndex] < value) lowIndex = middleIndex + 1;
            else if(theArray[middleIndex] > value) highIndex = middleIndex - 1;
            else {
                System.out.println("\nFound a Match for " + value + " at Index " + middleIndex);
                lowIndex = highIndex + 1;
            }
            printHorizontalArray(theArray, N, middleIndex, -1);
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

    @SuppressWarnings("Duplicates")
    private static boolean isSorted(Comparable[] a, int lo, int hi) {

        for (int i = lo + 1; i <= hi; i++) {
            if (less(a[i], a[i-1])) return false;
        }
        return true;
    }

    public static void main(String[] args){

        generateRandomArray(InsertionSort.theArray, InsertionSort.theArray.length);
        printHorizontalArray(InsertionSort.theArray,  InsertionSort.theArray.length, -1,-1);

        InsertionSort.insertionSort(InsertionSort.theArray);
    }
}