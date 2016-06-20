package sort;

/*
 * 	Selection Sort
 *	There is a pass for each position (0..size-1)
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
*	Total number of comparisons (in inner loop) is the sum of 1 to N-1 is N(N + 1) /2
*	Efficiency of algorith is O(N2)
*/

public class SelectionSort {

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


    /** On each pass, the smallest (minimum) element in the rest of the list is exchanged (swapped) with element at the
     *	current position. and then repeats searching through the entire array each time */

    private void selectionSort(){

        for(int x=0; x < arraySize; x++){
            int minimum = x;

            for(int y=x; y < arraySize; y++){
                // To change direction of sort just change this from > to <
                if(theArray[minimum]>theArray[y])
                    minimum = y;
            }

            swapValues(x, minimum);
            printHorizontalArray(x, -1);
        }
    }


    public static void main(String[] args){

        SelectionSort newArray = new SelectionSort();
        newArray.generateRandomArray();
        newArray.printHorizontalArray(-1,-1);
        newArray.selectionSort();
    }
}