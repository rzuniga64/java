package Bag;

import java.util.Arrays;
import java.util.Iterator;

/**
 *  BagArray: unordered collection of objects of the same type
 *  Implemented using a fixed size array.
 *  Solutions:
 *  - Use a dynamically allocated array.
 *  - When its capacity is reached, allocate a new, bigger array.
 *  - Can contain multiple values of the same type.
 *
 *
 *  Advantages of array over linked list:
 *  1. Arrays allow random access to element: array[i] while linked lists only allow sequential access to elements
 *  2. Arrays do no require extra storage for 'links'. Linked lists are impractical for lists of characters or
 *     booleans (pointer value is bigger than data value).
 *
 *  Operations:
 *  Traversing
 *  Searching
 *  Sorting
 *  Insertion
 *  Deletion
 *  Merging
 *
 *  Average Time Complexity
 *  Indexing:    O(1)
 *  Search:      O(n)
 *  Insertion:   O(n)
 *  Deletion:    O(n)
 *
 *  constructor:        creates an empty list
 *  iterator:           Iterator method must return an Iterator because the StackArray class implements Iterable
 *  isEmpty():          is the bag empty
 *  size()              returns the number of values
 *  add(value):         add a value to the bag
 *  remove(value:       removes an value from the bag (if it exists)
 *  occurrences(value): how many times is value in the bag
 *  display:            display the contents of the bag
 */
public class BagArray<Item> implements Iterable<Item> {

    private Item[] bagArray;
    private int count;

    private BagArray() {
        count = -1;
        bagArray = (Item[]) new Object[1];

        // Assigns the value of -1 to every value in the array so I control what gets printed to screen
        Arrays.fill(bagArray, "-1");
    }

    /**
     *  Iterator method must return an Iterator because the StackArray class implements Iterable.
     *  @return ListIterator
     */
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    /**
     *  An Iterator or class that implements hasNext() and next methods because the StackArray class
     *  implements Iterable.  The iterator() method returns a ListIterator.
     */
    private class ReverseArrayIterator implements Iterator<Item> {

        private int i = bagArray.length;

        public boolean hasNext() {
            return i > 0;
        }

        public Item next() {

            return bagArray[--i];
        }
    }

    private boolean isEmpty() {
        return (count == -1);
    }

    private int size() {
        return count;
    }

    private void add(Item item) {

        if (count + 1 == bagArray.length) {
            resize(2 * bagArray.length);
        }

        if (count + 1 < bagArray.length) {
            count++;
            bagArray[count] = item;
        } else
            System.out.println("Sorry But the BagArray is Full");

        display();
        System.out.println("ADD " + item + " Was Added to the BagArray\n");
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
    @SuppressWarnings("Duplicates")
    private void resize(int capacity) {

        Item[] copy = (Item[]) new Object[capacity];
        Arrays.fill(copy, "-1");
//        for (int i = 0; i < bagArray.length; i++) {
//            copy[i] = bagArray[i];
//        }
        System.arraycopy(bagArray, 0, copy, 0, bagArray.length);
        bagArray = copy;
    }

    private void remove(Item item) {

        int index = -1;

        for (int i = 0; i < count && index == -1; i++) {
            if (bagArray[i] == item)
                index = i;
            if (index != -1) {
                bagArray[index] = bagArray[count - 1];
                count--;
            }
        }
    }

   private int occurrences(Item item){

        int occurrences = 0;

        for (int i = 0; i < count; i++) {
            if (bagArray[i] == item)
                occurrences++;
        }
        return occurrences;
    }

    @SuppressWarnings("Duplicates")
    private void display(){

        for(int n = 0; n < 61; n++)System.out.print("-");
        System.out.println();
        for(int n = 0; n < bagArray.length; n++)
            System.out.format("| %2s "+ " ", n);

        System.out.println("|");
        for(int n = 0; n < 61; n++)System.out.print("-");
        System.out.println();

        for (Item s : bagArray) {
            if (s.toString().equals("-1")) System.out.print("|     ");
            else System.out.print(String.format("| %2s " + " ", s.toString()));
        }
        System.out.println("|");
        for(int n = 0; n < 61; n++)System.out.print("-");
        System.out.println();
    }

    public static void main(String[] args){

        BagArray b = new BagArray();
        System.out.println("Is bag empty? " + b.isEmpty());
        b.add(10);
        b.add(17);
        b.add(13);

        System.out.println("size " + b.size());
        System.out.println("how many 10's? " + b.occurrences(10));
        b.remove(10);
        System.out.println("removed a 10");
        System.out.println("size " + b.size());
        System.out.println("how many 10's? " + b.occurrences(4));
    }
}

