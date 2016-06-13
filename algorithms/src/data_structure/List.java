package data_structure;

/**
 * List: ordered set of objects
 *
 * Average Time Complexity
 * Indexing:    O(1)
 * Search:      O(n)
 * Insertion:   O(n)
 * Deletion:    O(n)
 *
 * constructor: creates an empty list
 * get(i):      returns the element at position i
 * set(i,v):    change the element at position i to v
 * isEmpty():   is the list empty
 * size():      returns the number of elements
 * doesArrayContainThisValue()
 * add(x, i):   inserts an element x at position i
 * remove(i):   removes the element at position i
 */

public class List {

    private int[] theArray;     // Creates an array with 50 indexes
    private int capacity;       // Elements in theArray

    // Constructor: create an empty list
    List(int size, int capacity) {
        this.theArray = new int[size];
        this.capacity = capacity;
    }

    private int[] getArray(){ return theArray; }
    public int size(){ return capacity; }

    // Fills the List with random values
    private void generateRandomArray(){
        for(int i = 0; i < size(); i++)
            theArray[i] = (int)(Math.random()*9)+10;
    }

    // Used to slow down calculations
    private void pauseAndUpdate(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Prints the List on the screen in a grid
    private void printArray(){

        System.out.println("----------");
        for(int i = 0; i < size(); i++){
            System.out.print("| " + i + " | ");
            System.out.println(theArray[i] + " |");
            System.out.println("----------");
        }
    }

    // Gets value at provided index
    // Average time complexity for indexing: O(1)
    private int get(int index){
        if(index < size()) return theArray[index];
        return 0;
    }

    // Sets value at provided index
    // Average time complexity for indexing: O(1)
    private int set(int index, int value){
        if(index < size()) theArray[index] = value;
            return theArray[index];
    }

    // Returns true or false if array is empty
    // Average time complexity: O(1)
    private boolean isEmpty() {
        if (size() != 0)
            return true;
        return false;
    }

    // Returns true or false if a value is in the List
    // Average time complexity for search: O(n)
    private boolean doesArrayContainThisValue(int searchValue){

        boolean valueInArray = false;
        for(int i = 0; i < size(); i++){
            if(theArray[i] == searchValue)
                valueInArray = true;
        }
        return valueInArray;
    }

    // Delete List row for the index and move elements up
    // Average time complexity for delete: O(n)
    private void delete(int index){
        if(index < size()){
            // Overwrite the value for the supplied index and then keep overwriting every index that follows until you
            // get to the last index in the array

            for(int i = index; i < (size() - 1); i++){
                pauseAndUpdate();
                theArray[i] = theArray[i+1];
            }
            capacity--;
        }
    }

    // Insert: move elements up and insert element at index
    // Average time complexity for insert: O(n)
    private void insert(int value){
        if(size() < 50){
            pauseAndUpdate();
            theArray[size()] = value;
            capacity++;
        }
    }

    public static void main(String[] args){
		
		List newArray = new List(50, 10);
        System.out.println(newArray.isEmpty());
		newArray.generateRandomArray();
		newArray.printArray();
		
		System.out.println(newArray.get(9));
        System.out.println(newArray.set(0, 10));
		
		System.out.println(newArray.doesArrayContainThisValue(11));
		
		newArray.delete(3);
        newArray.printArray();
		
		newArray.insert(100);
		newArray.printArray();
    }
}