package Queue;

/**
 *  Queue: a data structure that holds a collection of elements of the same type.
 *  - The elements are accessed according to FIFO order: first in, first out
 *  - No random access to other elements
 *
 *  Examples:
 *  - people in line at a theatre box office
 *  - restocking perishable inventory
 *
 *  OPERATIONS
 *  - enqueue: add a value onto the rear of the Queue (the end of the line). Make sure it is not full first.
 *  - dequeue: remove a value from the front of the Queue(the front of the line) Next! Make sure it is not empty first.
 *  - isEmpty: true if the Queue currently contains no elements.
 *  - makeEmpty: removes all the elements his is allowed to take longer than constant time.
 *  - How do we define isFull and isEmpty?  use a counter variable to keep track of the total number of items in the Queue.
 *
 *  These operations should take constant time: O(1)
 *
 *  Note: front and rear are variables used by the implementation to carry out the operations
 *  int item;
 *  q.enqueue(2);
 *  q.enqueue(3);
 *  q.enqueue(5);
 *  item = q.dequeue();	// item is 2
 *  item = q.dequeue();	// item is 3
 *
 *  QUEUE APPLICATIONS
 *
 *  The best examples of applications of queues involve managing multiple processes.
 *  For example, imagine the print Queue for a computer lab. Any computer can add a new print job to the Queue
 *  (enqueue). The printer performs the dequeue operation and starts printing that job. While it is printing, more jobs
 *  are added to the Q. When the printer finishes, it pulls the next job from the Q, continuing until the Q is empty
 *
 *  IMPLEMENTING A QUEUE CLASS
 *  - Just like stacks, queues can be implemented using arrays (fixed size, or resizing dynamic arrays) or linked
 *    lists (dynamic queues), and may be implemented using templates.
 *
 *  PROBLEM: END OF THE ARRAY
 *  - When front and rear indices move in the array:
 *  - problem: rear hits end of array quickly
 *  - solution: wrap index around to front of array
 *  - To 'wrap' the rear index back to the front of the array, you can use this code to increment rear during enqueue:
 *
 *  if (rear == queueSize - 1)
 *      rear = 0;
 *  else
 *      rear = rear+1;
 *  - the fllowing code is equivalent, but shorter (assuming 0 <= rear < queueSize):
 *    rear = (rear + 1) % queueSize;
 *  - Do the same for advancing the front index.
 *
 *  _	_	_	_	_	7	9	6		3	_	_	_	_	7	9	6		3	4	_	_	_	7	9	6
 *  f		r		r					f					r				f
 *
 *  - When is it full? (rear+1)%queueSize==front
 *  3	4	_	_	_	7	9	6
 *  r				f
 *  q.enqueue(5);
 *  q.enqueue(2);
 *  q.enqueue(1);
 *
 *  3	4	5	2	1	7	9	6
 *  r	f
 *
 *  - When is it empty? (rear+1)%queueSize==front
 *      int x;
 *      for (int i=0; i < queueSize; i++)
 *      x = q.dequeue();	// dequeue decrements the front
 *
 *  after the first one:				one element left:					no elements left, front passes rear:
 *  3	4	5	2	1	_	9	6		_	_	_	_	1	_	_	_		_	_	_	_	_	_	_	_
 *  r		f						   rf									r	f
 *
 *  - How do we define isFull and isEmpty?
 *  - Use a counter variable, numItems, to keep track of the total number of items in the Queue.
 *  - enqueue: numItems++
 *  - dequeue: numItems--
 *  - isEmpty is true when numItems == 0
 *  - isFull is true when numItems == queueSize
 *
 *  ARRAY VS LINKED LIST IMPLEMENTATIONS
 *
 *  - Both are very fast (O(1)).
 *  - Array may be faster (no dynamic allocation)
 *
 *  STATIC ARRAYS:
 *  - must anticipate maximum size
 *  - wasted space: entire array is allocated, even if using small portion
 *
 *  DYNAMIC ARRAYS (resize when full):
 *  - resizing takes time (copying all the elements)
 *  - resizing requires memory that is three times what is needed to store the elements at that time
 *
 *  LINKED LIST
 *  - code is actually simpler than array with resizing, especially for queues.
 *  - space used by elements is always proportional to number of elements (only wasted space is for the pointers)
 *
 *  SUMMARY:
 *  - array implementation is probably better for small objects.
 *  - linked list is probably better for large objects if space is scarce or copying is expensive (resizing)
 */

public class QueueLinkedList {

    private Node first, last;

    /**
     *  16 bytes (object overhead)
     *   8 bytes (inner class extra overhead)
     *   8 bytes (reference to String)
     *   8 bytes (reference to Node)
     *   -----------------------------------
     *   40 bytes per stack node
     */
    private class Node {

        Object item;
        Node next = null;

        Node() {}
        Node(Object value){ this.item = value; }

        public String toString(){return item.toString(); }
        public void display(){ System.out.println(item); }
        public Object getValue() { return item; }
        public Node getNext() { return next; }
    }

    /**
     *  Test if queue is empty.
     *  Average time complexity: O(1)
     */
    private boolean isEmpty(){
        return(first == null);
    }

    /**
     *  Add an item to the queue.
     *  @param item
     *  Average time complexity: O(1)
     */
    public void enqueue(Object item) {

        Node oldLast = last;
        last = new Node(0);
        last.item = item;
        last.next =  null;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
    }

    /**
     * Remove an item from the queue (FIFO).
     * @return item which is the value removed from the queue.
     */
    public Object dequeue() {

        Object item = first.item;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        return item;
    }

    /**
     *  Empty the stack.
     *  Average time complexity: O(N)
     */
    private void makeEmpty() {
        while (!isEmpty()) {
            dequeue();
        }
    }

    /**
     *  Display the linked list
     *  Average time complexity for traversing list: O(n)
     *  Start at the reference stored in firstLink and keep getting the references stored in next for every Link until
     *  next returns null
     */
    private void display(){

        QueueLinkedList.Node theLink = first;

        while(theLink != null){
            System.out.println(theLink.toString());
            theLink = theLink.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        QueueLinkedList theLinkedList = new QueueLinkedList();

        // Insert Link and add a reference to the book Link added just prior to the field next
        theLinkedList.enqueue("Don Quixote");
        theLinkedList.enqueue("A Tale of Two Cities");
        theLinkedList.enqueue("The Lord of the Rings");
        theLinkedList.enqueue("Harry Potter and the Sorcerer's Stone");

        theLinkedList.display();
        System.out.println("Value of first item in the stack is " + theLinkedList.first + "\n");

        theLinkedList.dequeue();
        theLinkedList.dequeue();
        theLinkedList.dequeue();
        theLinkedList.display();
        System.out.println("Value of first item in the stack is " + theLinkedList.first + "\n");

        theLinkedList.makeEmpty();
        theLinkedList.display();
    }
}
