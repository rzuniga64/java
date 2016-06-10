package aearch;

public class BinarySearch {

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


    // The Binary LinearSearch.LinearSearch is quicker than the linear search because all the values are sorted. Because everything is
    // sorted once you get to a number larger than what you are looking for you can stop the search. Also you be able
    // to start searching from the middle which speeds the search. It also works best when there are no duplicates
    private void binarySearchForValue(int value){

        int lowIndex = 0;
        int highIndex = arraySize - 1;

        while(lowIndex <= highIndex){
            int middleIndex = (highIndex + lowIndex) / 2;
            if(theArray[middleIndex] < value) lowIndex = middleIndex + 1;
            else if(theArray[middleIndex] > value) highIndex = middleIndex - 1;
            else {
                System.out.println("Found a Match for " + value + " at Index " + middleIndex);
                lowIndex = highIndex + 1;
            }
        }
    }

    // This bubble sort will sort everything from smallest to largest
    private void bubbleSort(){
        // i starts at the end of the Array
        // As it is decremented all indexes greater
        // then it are sorted
        for(int i = arraySize - 1; i > 1; i--){
            // The inner loop starts at the beginning of
            // the array and compares each value next to each
            // other. If the value is greater then they are
            // swapped
            for(int j = 0; j < i; j++){
                if(theArray[j] > theArray[j + 1])
                    swapValues(j, j+1);

            }
        }
    }

    private void swapValues(int indexOne, int indexTwo){
        int temp = theArray[indexOne];
        theArray[indexOne] = theArray[indexTwo];
        theArray[indexTwo] = temp;
    }

    public static void main(String[] args){
		
		BinarySearch newArray = new BinarySearch();
		
		newArray.generateRandomArray();
		
		newArray.printArray();

        newArray.bubbleSort();

        newArray.printArray();
		
		newArray.binarySearchForValue(12);
    }
}