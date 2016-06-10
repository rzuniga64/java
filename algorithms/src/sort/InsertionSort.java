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
     *  The Insertion sort.SelectionSort is normally the best of the elementary sorts. Unlike the other sorts that had a group sorted
     *  at any given time, groups are only partially sorted here.
     *  */

    private void insertionSort(){

        for (int i = 1; i < arraySize; i++){
            int j = i;
            int toInsert = theArray[i];
            while ((j > 0) && (theArray[j-1] > toInsert)){
                theArray[j] = theArray[j-1];
                j--;
                printHorizontalArray(i, j);
            }

            theArray[j] = toInsert;
            printHorizontalArray(i, j);
            System.out.println("\nArray[i] = " + theArray[i] + " Array[j] = " + theArray[j] + " toInsert = " + toInsert + "\n");
        }
    }

    public static void main(String[] args){

        InsertionSort newArray = new InsertionSort();
        newArray.generateRandomArray();
        newArray.printHorizontalArray(-1,-1);

        newArray.insertionSort();
    }
}