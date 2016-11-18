package stack;

/**
 *  Stacks are used to complete a task and are soon after discarded.
 *
 *  StackArray
 *  1.  StackArray is a data structure that holds a collection of elements of the same type.
 *  2.  Allowa only a single item to be added or removed at a time
 *  3.  Allows access to the last item inserted, first out (LIFO)
 *  4.  Problem: No random access to other elements
 *	5.  StackArray overflow: Trying to push an item onto a full stack
 *  6. 	StackArray underflow: Trying to pop an item from an empty stack
 *
 *  STACK OPERATIONS
 *  Operations: These operations should take constant time O(1)
 *
 *  isEmpty: true if the stack currently contains no elements
 *  isFull: true if the stack is currently full, i.e.,has no more space to hold additional elements
 *  push: add a value onto the top of the stack. Make sure it is not full first.
 *  pop: remove (and return) the value from the top of the stack. Make sure it is not empty first.
 *  peek:
 *  pushMany(String multipleValues):
 *  popAll():
 *  popDisplayAll():
 *  displayTheStack():
 *
 *  This oporation should take linear time O(n)
 *  makeEmpty: removes all the elements
 */

public class StackLinkedList {

    private class Link {
        Object value;
        Link next = null;

        Link() { }
        Link(Object value){ this.value = value; }

        public String toString(){return value.toString(); }
        public void display(){ System.out.println(value); }
        public Object getValue() { return value; }
        public Link getNext() { return next; }
    }

    private Link head;    // Reference to first Link in list
    private StackLinkedList(){ head = null; }

    // Display the linked list
    // Average time complexity for traversing list: O(n)
    //
    // Start at the reference stored in firstLink and keep getting the references stored in next for every Link until
    // next returns null
    public void display(){

        StackLinkedList.Link theLink = head;

        while(theLink != null){
            System.out.println(theLink.toString());
            theLink = theLink.next;
        }
        System.out.println();
    }

    // Returns true or false if linked list is empty
    // Average time complexity: O(1)
    public boolean isEmpty(){
        return(head == null);
    }

    public boolean isFull(){
        return false;
    }

    public void makeEmpty() {
        while (!isEmpty()) {
            //pop();
        }
    }

    public void push(Object value) {
        Link temp = new Link();
        temp.value = value;

        // insert at head of list
        temp.next = head;
        head = temp;
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
    }
}
