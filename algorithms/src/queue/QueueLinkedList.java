package queue;

import sort.StdOut;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 *  queue: a data structure that holds a collection of elements of the same type.
 *  - The elements are accessed according to FIFO order: first in, first out
 *  - No random access to other elements
 *
 *  Examples:
 *  - people in line at a theatre box office
 *  - restocking perishable inventory
 *
 *  OPERATIONS
 *  - QueueLinkedList: constructor
 *  - isEmpty: returns true if queue is empty.
 *  - size: returns the number of items in the queue.
 *  - peek: returns the item least recently added to the queue.
 *  - enqueue: add a value onto the rear of the queue (the end of the line). Make sure it is not full first.
 *  - dequeue: remove a value from the front of the queue(the front of the line) Next! Make sure it is not empty first.
 *  - isEmpty: true if the queue currently contains no elements.
 *  - makeEmpty: removes all the elements his is allowed to take longer than constant time.
 *  - toString:
 *
 *  How do we define isFull and isEmpty?  use a counter variable to keep track of the total number of items in the queue.
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
 *  For example, imagine the print queue for a computer lab. Any computer can add a new print job to the queue
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
 *  - Use a counter variable, numItems, to keep track of the total number of items in the queue.
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

public class QueueLinkedList<Item> implements Iterable<Item> {

    private Node<Item> first;   // beginning of queue
    private Node<Item> last;    // end of queue
    private int n;              // number of elements in queue

    /**
     *  16 bytes (object overhead)
     *   8 bytes (inner class extra overhead)
     *   8 bytes (reference to String)
     *   8 bytes (reference to Node)
     *   -----------------------------------
     *   40 bytes per stack node
     */
    private class Node<Item> {

        Item item;
        Node<Item> next;

        Node() {}
        Node(Item item){ this.item = item; }

        public Item getItem() { return item; }
        public Node<Item> getNext() { return next; }
    }

    /**
     *  Initializes an empty queue.
     */
    public QueueLinkedList() {

        first = null;
        last = null;
        n = 0;
    }

    /**
     *  Returns true if queue is empty.
     *  Average time complexity: O(1)
     */
    public boolean isEmpty(){
        return(first == null);
    }

    /**
     *  Returns the number of items in the queue.
     *  @return true if this queue is empty; false otherwise.
     */
    public int size() {
        return n;
    }

    /**
     *  Returns the item least recently added to the queue.
     *  @return the item least recently added to the queue.
     *  @throws NoSuchElementException if this queue is empty
     */
    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        return first.item;
    }

    /**
     *  Add an item to the queue.
     *  @param item
     *  Average time complexity: O(1)
     */
    public void enqueue(Item item) {

        Node<Item> oldLast = last;
        last = new Node<Item>();
        last.item = item;
        last.next =  null;
        if (isEmpty()) first = last;
        else           oldLast.next = last;
        n++;
    }

    /**
     *  Removes and returns the item from the queue that was least recently added (FIFO).
     *  @return the item on this queue that was least recently added.
     * @throws NoSuchElementException if this queue is empty.
     */
    public Item dequeue() {

        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item item = first.item;
        first = first.next;
        n--;
        if (isEmpty()) last = null; // to avoid loitering
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
     *  Returns a string representation of this queue.
     *  @return the sequence of items in FIFO order, separated by a new line.
     */
    public String toString() {

        StringBuilder s = new StringBuilder();
        for (Item item: this) {
            s.append(item);
            s.append('\n');
        }
        return s.toString();
    }

    /**
     *  Returns an iterator that iterates over the items in this queue in FIFO order.
     *  @return an iterator that iterates over the items in this queue in FIFO order.
     */
    public Iterator<Item> iterator() {

        return new ListIterator<>(first);
    }

    private class ListIterator<Item> implements Iterator<Item> {

        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext() {

            return current != null;
        }

        /**
         *  an iterator doesn't implement remove() since it's optional.
         */
        public void remove() {

            throw new UnsupportedOperationException();
        }

        public Item next() {

            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    /**
     *  Unit tests the Queue data type.
     * @param args the command-line arguments.
     */
    public static void main(String[] args) {

        QueueLinkedList<String> queue = new QueueLinkedList<>();

        // Insert Link and add a reference to the book Link added just prior to the field next
        queue.enqueue("Don Quixote");
        queue.enqueue("A Tale of Two Cities");
        queue.enqueue("The Lord of the Rings");
        queue.enqueue("Harry Potter and the Sorcerer's Stone");

        if (!queue.isEmpty())
            StdOut.println(queue.toString());

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        if (!queue.isEmpty())
            StdOut.println(queue.toString());

        queue.makeEmpty();
        if (!queue.isEmpty())
            StdOut.print(queue.dequeue() + " ");
    }
}
