package sort;

class SortUtility {

    // Fills the Array with random values
    static public void generateRandomArray(int[] theArray, int arraySize){

        for(int i = 0; i < arraySize; i++)
            theArray[i] = (int)(Math.random()*10)+10;
    }

    // Prints the Array on the screen in a grid
    static public void printArray(int[] theArray, int arraySize){

        System.out.println("----------");
        for(int i = 0; i < arraySize; i++){
            System.out.print("| " + i + " | ");
            System.out.println(theArray[i] + " |");
            System.out.println("----------");
        }
    }

    static void printHorizontalArray(int[] theArray, int arraySize, int i, int j){

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
}
