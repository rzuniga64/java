package heap;

import java.util.Arrays;

public class Heap {

    private Data3[] theHeap;
    private int itemsInArray = 0;
    private int maxSize;

    private Heap(int maxSize) {

        this.maxSize = maxSize;
        theHeap = new Data3[maxSize];
    }

    private void insert(int index, Data3 newData) {
        theHeap[index] = newData;
    }

    private void incrementTheArray() {
        itemsInArray++;
    }

    private Data3 pop() {

         if (itemsInArray != 0) {
            int tempItemsInArray = itemsInArray - 1;

            // Used to show how data is moved during sorting
            System.out.println("Store " + theHeap[0] + " in root. Store " + theHeap[tempItemsInArray] + " in index 0");
            System.out.println(Arrays.toString(theHeap) + "\n");
            Data3 root = theHeap[0];
            theHeap[0] = theHeap[--itemsInArray];

            // Send to the array heap method starting with index 0
            heapTheArray(0);
            return root;
         }
         return null;
    }

    /**
     * 4 ROW TREE
     * _______1
     * ___1_______1
     * _1___1___1___1
     * 1_1_1_1_1_1_1_1
     * 1st Row Indent 7 Spaces 0
     * 2nd Row Indent 3 Spaces 7
     * 3rd Row Indent 1 Spaces 3
     * 4th Row Indent 0 Spaces 1
     *
     * http://www.wolframalpah.com
     * Indent : 1/2 * (-2+2^n) start with 1
     * Note: need an iterator that starts at 1. Go until no more rows.
     * Spaces : 0 and then whatever Indent was
     *
     * First Index Per Row
     *
     * 0
     * 1 2
     * 3 4 5 6
     * 7 8 9 10 11 12 13 14
     * .5 * (-2 + (Math.pow(2, iteration)))
     *
     * Items Per Row
     * 1, 2, 4, 8
     * Math.pow(2, iteration - 1)
     *
     * Max Index Per Row
     * indexToPrint + itemsPerRow
     *
     * Indent Number
     * Indent Number Space Number
     * Indent Number Space Number Space...
     *
     * I need 1 index followed by multiple numbers & spaces every time
     */
    private void printTree(int rows) {

        // Number of spaces between items in tree
        int spaces = 0;
        int iteration = 1;

        // Generate all of the indents that are needed depending on the number of rows to print
        int[] indent = getIndentArray(rows);

        while (iteration <= rows) {

            // Find first Index : .5 * (-2 + 2^n)
            int indexToPrint = (int) (.5 * (-2 + (Math.pow(2, iteration))));

            // Number of Items per Row : 2^(n - 1)
            int itemsPerRow = (int) (Math.pow(2, iteration - 1));
            int maxIndexToPrint = indexToPrint + itemsPerRow;

            // Print the indents needed
            for (int j = 0; j < indent[iteration - 1]; j++)
                System.out.print(" ");

            // Print all of the index values for each row. indexToPrint represents the first index in the
            // row, while maxIndexToPrint equals the last
            for (int l = indexToPrint; l < maxIndexToPrint; l++) {

                // If the array isn't full don't try to print indexes that don't exist
                if (l < itemsInArray) {
                    System.out.print(String.format("%02d", theHeap[l].key));

                    for (int k = 0; k < spaces; k++)
                        System.out.print(" ");
                }
            }

            // In a tree the spaces get bigger in the same way that indents get smaller
            spaces = indent[iteration - 1];
            iteration++;
            System.out.println();
        }
    }

    /**
     *  Fix the following problems:
     *  1. Make calculation of the indent more dynamic by depending up the array data
     *  2. Print indexes that don't exist (i.e. when less items in array than can accommodate the rows
     *  3. Ability to print single and double digit numbers
     *  Calculate each indent per row for the tree then reverse their order to go from biggest to smallest
    */

    private int[] getIndentArray(int rows) {

        int[] indentArray = new int[rows];

        for (int i = 0; i < rows; i++)
            //Indent : 1/2 * (-2+2^n) start with 1
            indentArray[i] = (int) Math.abs((-2 + (Math.pow(2, i + 1))));

        Arrays.sort(indentArray);
        indentArray = reverseArray(indentArray);
        return indentArray;
    }

    // Reverse the indent values in the array so that they go from biggest to smallest
    private int[] reverseArray(int[] theArray) {

        // Index of the first element
        int leftIndex = 0;

        // Index of last element
        int rightIndex = theArray.length - 1;

        while (leftIndex < rightIndex) {
            // Exchange the left and right elements
            int temp = theArray[leftIndex];
            theArray[leftIndex] = theArray[rightIndex];
            theArray[rightIndex] = temp;

            // Move the indexes to check towards the middle
            leftIndex++;
            rightIndex--;
        }

        return theArray;
    }

    // Fill the heap with random numbers based on the number that is passed in
    private void generateFilledArray(int randNum) {

        Data3 randomData1;

        for (int i = 0; i < this.maxSize; i++) {

            randomData1 = new Data3((int) (Math.random() * randNum) + 1);
            this.insert(i, randomData1);

            // Need to do this in a separate function because later when I sort the array I need to use insert
            // without incrementing the array
            incrementTheArray();
        }
    }

    private void heapTheArray(int index) {

        int largestChild;
        Data3 root = theHeap[index];

        while (index < itemsInArray / 2) {

            // Get the index for the leftChild
            int leftChild = 2 * index + 1;

            // Get the index for the rightChild
            int rightChild = leftChild + 1;

            // If leftChild is less then rightChild save rightChild in largestChild
            if (rightChild < itemsInArray && theHeap[leftChild].key < theHeap[rightChild].key) {
                System.out.println("Put Value " + theHeap[rightChild] + " in largestChild");
                largestChild = rightChild;
            } else {
                System.out.println("Put Value " + theHeap[leftChild] + " in largestChild");

                // Otherwise save leftChild in largestChild
                largestChild = leftChild;
            }

            // If root is greater then the largestChild jump out of while
            if (root.key >= theHeap[largestChild].key)
                break;

            System.out.println("Put Index Value " + theHeap[largestChild] + " in Index " + index);

            // Save the value in largest child into the top index
            theHeap[index] = theHeap[largestChild];
            index = largestChild;
            System.out.println();
            printTree(4);
            System.out.println();
        }

        theHeap[index] = root;
    }

    // Cycle through the array and pop off each so the array goes from smallest to largest
    private void heapSort() {

        for (int k = maxSize - 1; k >= 0; k--) {
            Data3 largestNode = pop();
            insert(k, largestNode);

            System.out.println(Arrays.toString(theHeap));
        }
    }

    public static void main(String args[]) {

        Heap newHeap = new Heap(63);
        newHeap.generateFilledArray(90);

        // Print out the array before it is sorted
        System.out.println("Original Array");
        System.out.println(Arrays.toString(newHeap.theHeap));

        System.out.println();

        newHeap.printTree(6);
        System.out.println();

        for (int j = newHeap.maxSize / 2 - 1; j >= 0; j--)
            newHeap.heapTheArray(j);


        System.out.println("Heaped Array");
        System.out.println(Arrays.toString(newHeap.theHeap) + "\n");
        newHeap.printTree(4);
        System.out.println("HEAPED SORTED");
        newHeap.heapSort();

        // Print the sorted array
        System.out.println("\nSorted Array");
        System.out.println(Arrays.toString(newHeap.theHeap));
    }
}

class Data3 {
    protected int key;

    protected Data3(int key) {
        this.key = key;
    }

    public String toString() {
        return Integer.toString(key);
    }
}