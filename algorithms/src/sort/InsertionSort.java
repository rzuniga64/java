package sort;

public class InsertionSort {

    private int[] theArray = new int[50];
    private int arraySize = 10;

    private void generateRandomArray(){
        for(int i = 0; i < arraySize; i++){
            theArray[i] = (int)(Math.random()*10)+10;
        }
    }

    private void printHorizontalArray(int i, int j){

        for(int n = 0; n < 51; n++)System.out.print("-");
        System.out.println();
        for(int n = 0; n < arraySize; n++)
            System.out.print("| " + n + "  ");

        System.out.println("|");
        for(int n = 0; n < 51; n++)System.out.print("-");
        System.out.println();
        for(int n = 0; n < arraySize; n++)
            System.out.print("| " + theArray[n] + " ");

        System.out.println("|");
        for(int n = 0; n < 51; n++)System.out.print("-");
        System.out.println();

        // END OF FIRST PART
        // ADDED FOR BUBBLE SORT
        if(j != -1){
            // ADD THE +2 TO FIX SPACING
            for(int k = 0; k < ((j*5)+2); k++)System.out.print(" ");
            System.out.print(j);
        }

        // THEN ADD THIS CODE
        if(i != -1){
            // ADD THE -1 TO FIX SPACING
            for(int l = 0; l < (5*(i - j)-1); l++)System.out.print(" ");
            System.out.print(i);
        }
        System.out.println();
    }

    private void swapValues(int indexOne, int indexTwo){

        int temp = theArray[indexOne];
        theArray[indexOne] = theArray[indexTwo];
        theArray[indexTwo] = temp;
    }

    /** The Binary LinearSearch.LinearSearch is quicker than the linear search because all the values are sorted. Because everything is
     * sorted once you get to a number larger than what you are looking for you can stop the search. Also you be able
     * to start searching from the middle which speeds the search. It also works best when there are no duplicates */

    private void binarySearchForValue(int value){
        int lowIndex = 0;
        int highIndex = arraySize - 1;

        while(lowIndex <= highIndex){

            int middleIndex = (highIndex + lowIndex) / 2;
            if(theArray[middleIndex] < value) lowIndex = middleIndex + 1;
            else if(theArray[middleIndex] > value) highIndex = middleIndex - 1;
            else {
                System.out.println("\nFound a Match for " + value + " at Index " + middleIndex);
                lowIndex = highIndex + 1;
            }
            printHorizontalArray(middleIndex, -1);
        }
    }

    /**
     *  The Insertion sort.SelectionSort is normally the best of the elementary sorts.
     *  Unlike the other sorts that had a group sorted at any given time, groups are only partially sorted here.
     *
     * Insertion sort is a simple sorting algorithm that is appropriate for small inputs
     * The basic action of insertion sort is to sort the elements in positions 0 through p (where p ranges from 1 through
     * N-1). In each state p increases by 1. That is what the outer loop is controlling.
     *
     * When the body of the for loop is entered we are guaranteed that the elements in array positions 0 through p-1 have
     * already been sorted and that we need to extend this to positions 0 to p.
     *
     * At each step the underlined element needs to be added to the previously sorted part of the array. We can easily
     * do that by placing it in a temporary variable and sliding all the elements that ARE LARGER THAN IT on position
     * to the right. We then copy the temporary variable into the former position of the leftmost relocated
     * element. We keep a counter j, which is the position in which the temporary variable should be written back.
     * Every time an element is slid, j decreases by 1.
     *
     * Array Position           0   1   2   3   4   5
     * ----------------------------------------------
     * Initial state            8|  5   9   2   6   3   temp = 5
     *                              -
     * After a[0..1] is sorted  5   8|  9   2   6   3   temp = 9
     *                                  -
     * After a[0..2] is sorted  5   8   9|  2   6   3   temp = 2
     *                                      -
     * After a[0..3] is sorted  2   5   8   9|  6   3   temp = 6
     *                                          -
     * After a[0..4] is sorted  2   5   6   8   9|  3   temp = 3
     *                                              -
     * After a[0..5] is sorted  2   3   5   6   8   9|
     **/

    private void insertionSort(){

        for (int i = 1; i < arraySize; i++){
            int temp = theArray[i];
            int j;
            for (j = i; j > 0 && theArray[j-1] > temp; j-- ){
                theArray[j] = theArray[j-1];
                printHorizontalArray(i, j);
            }

            theArray[j] = temp;
            printHorizontalArray(i, j);
            System.out.println("\nArray[i] = " + theArray[i] + " Array[j] = " + theArray[j] + " toInsert = " + temp + "\n");
        }
    }

    public static void main(String[] args){

        InsertionSort newArray = new InsertionSort();
        newArray.generateRandomArray();
        newArray.printHorizontalArray(-1,-1);

        newArray.insertionSort();
    }
}