package sort;

public class BubbleSort {

    private int[] theArray = new int[50];   // Creates an array with 50 indexes
    private int arraySize = 10;             // Elements in theArray

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

    // This bubble sort will sort everything from largest to smallest
    private void bubbleSortDescending(){
        // i starts at the beginning of the array
        for(int i = 0; i < arraySize; i++){
            // The inner loop starts at the beginning of the array 1 index in more than i.
            for(int j = 1; j < (arraySize - i); j++){
                // Here we check if the 1st index is less than the next during the first run through.  Then we just
                // increase the indexes until they have all been checked
                if(theArray[j-1] < theArray[j])
                    swapValues(j-1, j);

            }
        }
    }

    private void swapValues(int indexOne, int indexTwo){
        int temp = theArray[indexOne];
        theArray[indexOne] = theArray[indexTwo];
        theArray[indexTwo] = temp;
    }

    public static void main(String[] args){
		
		BubbleSort newArray = new BubbleSort();
		
		newArray.generateRandomArray();
		
		newArray.printArray();
		
		newArray.bubbleSort();
		
		newArray.printArray();

        newArray.bubbleSortDescending();

        newArray.printArray();
    }
}