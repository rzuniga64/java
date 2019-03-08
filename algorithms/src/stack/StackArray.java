package stack;

/**
 *  StackArray
 *  1.  StackArray is a data structure that holds a collection of elements of the same type.
 *  2.  Allows only a single item to be added or removed at a time
 *  3.  Allows access to the last item inserted, first out (LIFO)
 *  4.  Problem: No random access to other elements
 *	5.  StackArray overflow: Trying to push an item onto a full stack
 *  6. 	StackArray underflow: Trying to pop an item from an empty stack
 *
 *  Underflow: throw exception if pop from an empty stack.
 *  Overflow: use resizing array for array implementation.
 *  Null items: we allow null items to be inserted.
 *  Loitering. Holding a reference to an object when it is no longer needed
 *  Ex:
 *      public String pop()
 *      ( return stackArray[--top]; }
 *
 *  STACK OPERATIONS
 *  Operations: These operations should take constant time O(1)
 *
 *  isEmpty:    true if the stack currently contains no elements
 *  isFull:     true if the stack is currently full, i.e.,has no more space to hold additional elements
 *  push:       add a value onto the top of the stack. Make sure it is not full first.
 *  pop:        remove (and return) the value from the top of the stack. Make sure it is not empty first.
 *  peek:
 *  pushMany(String multipleValues):
 *  popAll():
 *  popDisplayAll():
 *  displayTheStack():
 *
 *  This operation should take linear time O(n)
 *  makeEmpty: removes all the elements
 *
 *   8 bytes (reference to an array)
 *  24 bytes (array overhead)
 *   8 bytes * array size
 *   4 bytes (int)
 *   4 bytes padding
 *   -------------------------------
 *   40 + 8 bytes * array size
 */
import java.util.Arrays;

public class StackArray<Item> {

    private Item[] stackArray;
    private int top;

    private StackArray(){

        stackArray = (Item[]) new Object[1];
        top = -1;   // stack is empty

        // Assigns the value of -1 to every value in the array so I control what gets printed to screen
        Arrays.fill(stackArray, "-1");
    }

    private boolean isEmpty() {
        return (top == -1);
    }

    private boolean isFull() {
        return top == stackArray.length - 1;
    }

    private void makeEmpty() {
        top = -1;
    }

    /**
     *  Add a value to the top of the stack.
     */
    @SuppressWarnings("Duplicates")
    private void push(Item input){

        if (top + 1 == stackArray.length) {
            resize(2 * stackArray.length);
        }

        if(top + 1 < stackArray.length){
            top++;
            stackArray[top] = input;
        } else
            System.out.println("Sorry But the stack.StackArray is Full");

        displayTheStack();
        System.out.println("PUSH " + input + " Was Added to the stack.StackArray\n");
    }

    /**
     *  Remove a value from the top of the stack.
     *  @return item from the top of the stack
     *
     *  This version avoids loitering.
     *  Garbage collector can reclaim memory only if no outstanding references.
     *  Halve size of stack when stack is one-quarter full.
     *  Invariant: Stack is between 24% and 100% full.
     */
    @SuppressWarnings("Duplicates")
    private Item pop(){

        if(top >= 0){
            displayTheStack();
            System.out.println("POP " + stackArray[top] + " Was Removed From the stack.StackArray\n");

            Item item = stackArray[top];
            stackArray[top--] = (Item)"-1"; // release the reference to the object so no loitering.
//            if (top > 0 && top == stackArray.length/4) {
//                resize(stackArray.length/2);
//            }
            return item;
        } else {
            displayTheStack();
            System.out.println("Sorry But the stack.StackArray is Empty");
            return (Item) "-1";
        }
    }

    /**
     *  If stack is full, create a new stack of twice the size, and copy items.
     *  @param capacity the size of the stack
     *
     *  Consequence. Inserting First N items takes time proportional to N (not N*N).
     *  The reason is you only create a new array every time it doubles but by the time it doubles you've inserted that
     *  many items into the stack.
     *  Cost of inserting first N items. N + (2 + 4 + 8 + ... + N) ~ 3N.
     */
    private void resize(int capacity) {

        Item[] copy = (Item[]) new Object[capacity];
        Arrays.fill(copy, "-1");
        for (int i = 0; i < stackArray.length; i++) {
            copy[i] = stackArray[i];
        }
        //System.arraycopy(stackArray, 0, copy, 0, stackArray.length);
        stackArray = copy;
    }

    private Item peek(){

        displayTheStack();
        System.out.println("PEEK " + stackArray[top] + " Is at the Top of the stack.StackArray\n");
        return stackArray[top];
    }

    private void pushMany(Item multipleValues){

        String[] tempString = multipleValues.toString().split(" ");

        for (String s : tempString) push((Item) s);
        //Arrays.stream(tempString).forEach(this::push);
    }

    private void popAll(){

        for(int i = top; i >= 0; i--)
            pop();

        displayTheStack();
    }

    @SuppressWarnings("Duplicates")
    private void reverseString(){

        StringBuilder theReverse = new StringBuilder();

        for(int i = top; i >= 0; i--)
            theReverse.append(stackArray[i]);

        System.out.println("The Reverse: " + theReverse);
    }

    @SuppressWarnings("Duplicates")
    private void displayTheStack(){

        for(int n = 0; n < 61; n++)System.out.print("-");
        System.out.println();
        for(int n = 0; n < stackArray.length; n++)
            System.out.format("| %2s "+ " ", n);

        System.out.println("|");
        for(int n = 0; n < 61; n++)System.out.print("-");
        System.out.println();

        for (Item s : stackArray) {
            if (s.toString().equals("-1")) System.out.print("|     ");
            else System.out.print(String.format("| %2s " + " ", s.toString()));
        }
        System.out.println("|");
        for(int n = 0; n < 61; n++)System.out.print("-");
        System.out.println();
    }

    @SuppressWarnings("Duplicates")
    public static void main(String[] args){

        StackArray theStack = new StackArray();

        theStack.push("10");
        theStack.push("17");
        theStack.push("13");

        // Look at the top value on the stack
        theStack.peek();

        // Remove values from the stack (LIFO)
        theStack.pop();
        theStack.pop();
        theStack.pop();
        theStack.pop();

        // Add many to the stack
        theStack.pushMany("R E D R U M");

        // Reverse the string.
        theStack.reverseString();

        // Remove all from the stack
        theStack.popAll();
    }
}