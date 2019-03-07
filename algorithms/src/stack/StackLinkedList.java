package stack;

/**
 *  Stacks are used to complete a task and are soon after discarded.
 *
 *  StackArray
 *  1.  StackArray is a data structure that holds a collection of elements of the same type.
 *  2.  Allow a only a single item to be added or removed at a time
 *  3.  Allows access to the last item inserted, first out (LIFO)
 *	4.  StackArray overflow: Trying to push an item onto a full stack
 *  5. 	StackArray underflow: Trying to pop an item from an empty stack
 *
 *  STACK OPERATIONS
 *  Operations: These operations should take constant time O(1)
 *
 *  isEmpty: true if the stack currently contains no elements
 *  isFull:  true if the stack is currently full, i.e.,has no more space to hold additional elements
 *  push:    add a value onto the top of the stack. Make sure it is not full first.
 *  pop:     remove (and return) the value from the top of the stack. Make sure it is not empty first.
 *  peek:
 *  pushMany(String multipleValues):
 *  popAll():
 *  popDisplayAll():
 *  displayTheStack():
 *
 *  This operation should take linear time O(n)
 *  makeEmpty: removes all the elements
 *
 *  A stack with Nn items uses ~40 N bytes.
 *  Analysis includes memory for the stack but not the strings themselves, which the client owns.
 */

public class StackLinkedList {

    /**
     *  16 bytes (object overhead)
     *   8 bytes (inner class extra overhead)
     *   8 bytes (reference to String)
     *   8 bytes (reference to Node)
     *   -----------------------------------
     *   40 bytes per stack node
     */
    private class Link {

        Object value;
        Link next = null;

        Link() {}
        Link(Object value){ this.value = value; }

        public String toString(){return value.toString(); }
        public void display(){ System.out.println(value); }
        public Object getValue() { return value; }
        public Link getNext() { return next; }
    }

    private Link head;    // Reference to first Link in list
    private StackLinkedList(){ head = null; }

    /**
     *  Add a value to the top of the stack.
     *  Average time complexity: O(1)
     */
    private void push(Object value) {

        Link first = new Link();
        first.value = value;
        first.next = head; // insert at head of list

        head = first;
    }


    /**
     *  Remove a value from the top of the stack.
     *  Average time complexity: O(1)
     */
     private Object pop() {

        Object value = head.value;
        head = head.next;

        return value;
    }

    /**
     *  Test if stack is empty.
     *  Average time complexity: O(1)
     */
    private boolean isEmpty(){
        return(head == null);
    }

    /**
     *  Test if stack is full.
     *  Average time complexity: O(1)
     */
     public boolean isFull(){
        return false;
    }

    /**
     *  Empty the stack.
     *  Average time complexity: O(N)
     */
    private void makeEmpty() {
        while (!isEmpty()) {
            pop();
        }
    }

    /**
     *  Display the linked list
     *  Average time complexity for traversing list: O(n)
     *  Start at the reference stored in firstLink and keep getting the references stored in next for every Link until
     *  next returns null
     */
    private void display(){

        StackLinkedList.Link theLink = head;

        while(theLink != null){
            System.out.println(theLink.toString());
            theLink = theLink.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        StackLinkedList theLinkedList = new StackLinkedList();

        // Insert Link and add a reference to the book Link added just prior to the field next
        theLinkedList.push("Don Quixote");
        theLinkedList.push("A Tale of Two Cities");
        theLinkedList.push("The Lord of the Rings");
        theLinkedList.push("Harry Potter and the Sorcerer's Stone");

        theLinkedList.display();
        System.out.println("Value of first item in the stack is " + theLinkedList.head + "\n");

        theLinkedList.makeEmpty();
        theLinkedList.display();
    }
}
