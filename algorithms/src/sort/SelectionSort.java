package sort;

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


    /** Selection sort search for the smallest number in the array saves it in the minimum spot and then repeats
     * searching through the entire array each time */

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