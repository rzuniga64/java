package sort;

import java.util.Arrays;

import static sort.SortUtility.generateRandomArray;
import static sort.SortUtility.printHorzArray;

/**
 *  Shellsort is a subquadratic algorithm whose code is only slightly longer than the insertion sort, making it the
 *  simplest of the faster algorithms. It compares elements that are far apart and then by comparing elements that are
 *  less far apart, and so on, gradually shrinking toward the basic insertion sort.  Shellsort is known as a
 *  diminishing gap sort. When gap is 1 the loop is identical to an insertion sort.
 *
 *  The running time of Shellsort depends heavily on the choice of increment sequences.  A sequence which performs well
 *  in practice but has no theoretical basis, is to have a starting gap of N/2.2. This divisor appears to bring the
 *  average running time to below O(pow(N, 5/4)).  For 100, 000, to 1,000,000 items, it typically improves performance
 *  by about to 25 to 35 percent over Shell's Increments, although nobody knows why.  The performance of Shellsort is
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
 */

public class ShellSort {
    private static long startTime;
    private static long endTime;

    private int[] theArray;
    private int arraySize;

    private ShellSort(int arraySize) {
        this.arraySize = arraySize;
        theArray = new int[arraySize];
        generateRandomArray(this.theArray, this.arraySize);
    }

    private void shellsort() {
        startTime = System.currentTimeMillis();

        // Keep looping until the interval is 1. Then this becomes an insertion sort
        for (int gap = arraySize/2; gap > 0; gap = (gap == 2) ? 1 : (new Double(gap/2.2)).intValue()) {
            for (int i = gap; i < arraySize; i++) {
                int temp = theArray[i];
                int j;
                for (j = i; j >= gap && temp < theArray[j - gap]; j -= gap)
                    theArray[j] = theArray[j - gap];
                theArray[j] = temp;

                System.out.println("inner= " + (i-gap) + " outer= " + i + " temp= " + temp + " interval= " + gap);
                printHorzArray(theArray, arraySize, j, i, gap);
            }
        }

        endTime = System.currentTimeMillis();
        System.out.println("Shellsort took " + (endTime - startTime) + " milliseconds.");
    }

    private void sort() {
        int inner, outer, temp;
        int interval = 1;

        while (interval <= arraySize / 3) {

            interval = interval * 3 + 1;    // Define an interval sequence

            // Keep looping until the interval is 1. Then this becomes an insertion sort
            while (interval > 0) {
                for (outer = interval; outer < arraySize; outer++) {
                    // Store the value of the array in temp unless it has to be copied to a space occupied by a bigger
                    // number closer to the beginning of the array

                    temp = theArray[outer];
                    System.out.println("Copy " + theArray[outer] + " into temp");

                    // inner is assigned the value of the highest index to check against all values the proceed it.
                    // Along the way if a number is greater than temp it will be moved up in the array

                    inner = outer;
                    System.out.println("Checking if " + theArray[inner - interval]
                            + " in index " + (inner - interval)
                            + " is bigger than " + temp);

                    // While there is a number bigger than temp move it further up in the array
                    while (inner > interval - 1 && theArray[inner - interval] >= temp) {
                        System.out.println("In While Checking if "
                                + theArray[inner - interval] + " in index "
                                + (inner - interval) + " is bigger than " + temp);

                        printHorzArray(theArray, arraySize, inner, outer, interval);

                        // Make room for the smaller temp by moving values in array up one space if greater than temp
                        theArray[inner] = theArray[inner - interval];

                        System.out.println(theArray[inner - interval]
                                + " moved to index " + inner);
                        inner -= interval;
                        System.out.println("inner= " + inner);
                        printHorzArray(theArray, arraySize, inner, outer, interval);
                        System.out.println("outer= " + outer);
                        System.out.println("temp= " + temp);
                        System.out.println("interval= " + interval);
                    }

                    // Now that everything has been moved into place put the value stored in temp into the index above
                    // the first value smaller than it is

                    theArray[inner] = temp;
                    System.out.println(temp + " moved to index " + inner);
                    printHorzArray(theArray, arraySize, inner, outer, interval);
                }

                // Once we get here we have interval sorted our array so we decrement interval and go again
                interval = (interval - 1) / 3;
            }
        }
    }

    public static void main(String[] args) {
        ShellSort theSort = new ShellSort(10);
        System.out.println(Arrays.toString(theSort.theArray));
        theSort.shellsort();
        System.out.println(Arrays.toString(theSort.theArray));
    }
}
