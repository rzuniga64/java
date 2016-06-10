package data_structure;

public class Array {

    private int[] theArray = new int[50];   // Creates an array with 50 indexes
    private int arraySize = 10;             // Elements in theArray

    private int[] getTheArray(){ return theArray; }

    public int getArraySize(){ return arraySize; }

    // Fills the Array with random values
    private void generateRandomArray(){

        for(int i = 0; i < arraySize; i++)
            theArray[i] = (int)(Math.random()*9)+10;
    }

    // Used to slow down calculations
    private void pauseAndUpdate(){
        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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

    // Gets value at provided index
    private int getValueAtIndex(int index){
        if(index < arraySize) return theArray[index];
        return 0;
    }

    // Returns true or false if a value is in the Array
    private boolean doesArrayContainThisValue(int searchValue){

        boolean valueInArray = false;
        for(int i = 0; i < arraySize; i++){
            if(theArray[i] == searchValue)
                valueInArray = true;
        }
        return valueInArray;
    }


    // Delete Array row for the index and move elements up
    private void deleteIndex(int index){
        if(index < arraySize){
            // Overwrite the value for the supplied index
            // and then keep overwriting every index that follows
            // until you get to the last index in the array

            for(int i = index; i < (arraySize - 1); i++){
                pauseAndUpdate();
                theArray[i] = theArray[i+1];
            }
            arraySize--;
        }
    }

    private void insertValue(int value){
        if(arraySize < 50){
            pauseAndUpdate();
            theArray[arraySize] = value;
            arraySize++;
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
		
		Array newArray = new Array();
		
		newArray.generateRandomArray();
		
		newArray.printArray();
		
		System.out.println(newArray.getValueAtIndex(9));
		
		System.out.println(newArray.doesArrayContainThisValue(11));
		
		newArray.deleteIndex(3);

        newArray.printArray();
		
		newArray.insertValue(100);

		newArray.printArray();

    }
}