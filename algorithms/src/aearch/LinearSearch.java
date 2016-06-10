package aearch;

public class LinearSearch {

    private int[] theArray = new int[50];   // Creates an array with 50 indexes
    private int arraySize = 10;             // Elements in theArray

    private int[] getTheArray(){ return theArray; }

    public int getArraySize(){ return arraySize; }

    // Fills the Array with random values
    private void generateRandomArray(){

        for(int i = 0; i < arraySize; i++)
            theArray[i] = (int)(Math.random()*9)+10;
    }

    // Prints the Array on the screen in a grid
    private void printArray(){

        System.out.println("----------");
        for(int i = 0; i < arraySize; i++){
            System.out.print("| " + i + " | ");
            System.out.println(theArray[i] + " |");
            System.out.println("----------");
        }
    }

    // Linear LinearSearch.LinearSearch : Every index must be looked at
    private String linearSearchForValue(int value){

        boolean valueInArray = false;
        String indexsWithValue = "";
        System.out.print("The Value was Found in the Following Indexes: ");
        for(int i = 0; i < arraySize; i++){
            if(theArray[i] == value) {
                valueInArray = true;
                System.out.print(i + " ");
                indexsWithValue+= i + " ";
            }
        }

        if(!valueInArray){
            indexsWithValue = "None";
            System.out.print(indexsWithValue);
        }

        System.out.println();
        return indexsWithValue;
    }

    public static void main(String[] args){
		
		LinearSearch newArray = new LinearSearch();
		
		newArray.generateRandomArray();
		
		newArray.printArray();

		newArray.linearSearchForValue(11);
    }
}