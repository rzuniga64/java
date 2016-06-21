package sort;

import java.util.Arrays;

import static sort.SortUtility.generateRandomArray;
import static sort.SortUtility.printHorzArray;

public class ShellSort {

    private void shellsort() {
        int inner, outer, temp;
        int interval = 1;

        while (interval <= arraySize / 3) {

            interval = interval * 3 + 1;    // Define an interval sequence

            // Keep looping until the interval is 1. Then this becomes an insertion sort
            while (interval > 0) {
                // Continue incrementing outer until the end of the array is reached
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

                        // Make room for the smaller temp by moving values in the array
                        // up one space if they are greater than temp

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

                    // Now that everything has been moved into place put the value
                    // stored in temp into the index above the first value smaller
                    // than it is

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

    private int[] theArray;
    private int arraySize;

    private ShellSort(int arraySize) {
        this.arraySize = arraySize;
        theArray = new int[arraySize];
        generateRandomArray(this.theArray, this.arraySize);
    }
}
