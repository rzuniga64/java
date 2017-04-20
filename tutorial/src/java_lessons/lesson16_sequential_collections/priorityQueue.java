package java_lessons.lesson16_sequential_collections;

import java.util.PriorityQueue;

/**
 *  The type Priority queue is a little bit different than a queue because it
 *  stores the data in its natural order (String data will be sorted
 *  alphabetically and numbers in ascending order). it does not orders the
 *  elements in FIFO manner.
 *
 *  The PriorityQueue class is an unbounded priority queue based on a priority
 *  heap.Following are the important points about PriorityQueue:The elements of
 *  the priority queue are ordered according to their natural ordering, or by a
 *  Comparator provided at queue construction time, depending on which
 *  constructor is used.
 *
 *  A priority queue does not permit null elements.
 *  A priority queue relying on natural ordering also does not permit
 *  insertion of non-comparable objects.
 *
 *  The head of this queue is the least element with respect to the specified
 *  ordering. If multiple elements are tied for least value, the head is one of
 *  those elements -- ties are broken arbitrarily. The queue retrieval
 *  operations poll, remove, peek, and element access the element at the head
 *  of the queue.
 *  A priority queue is unbounded, but has an internal capacity governing the
 *  size of an array used to store the elements on the queue. It is always at
 *  least as large as the queue size. As elements are added to a priority queue,
 *  its capacity grows automatically. The details of the growth policy are not
 *  specified.
 *
 *  This class and its behavorial.iterator implement all of the optional methods of the
 *  Collection and Iterator interfaces. The Iterator provided in method
 *  behavorial.iterator() is not guaranteed to traverse the elements of the priority queue
 *  in any particular order. If you need ordered traversal, consider using
 *  Arrays.sort(pq.toArray()).
 */
public final class priorityQueue {

    /** Constructor.*/
    private priorityQueue() { }

    /**
     * Unit tests.
     * @param args the input arguments
     */
    public static void main(final String[] args) {

        PriorityQueue<String> line = new PriorityQueue<>();

        line.add("Amit");
        line.add("Vijay");
        line.add("Karan");
        line.add("Jai");
        line.add("Rahul");

        for (String name : line) {
            System.out.println(name);
        }

        System.out.println("\nhead:" + line.element());

        // remove an item from the head
        System.out.println("Removing item using poll " + line.poll());
        System.out.println("\n");
        for (String name : line) {
            System.out.println(name);
        }
        // remove a specific item
        line.remove("Raymond");
        System.out.println("\n");
        for (String name : line) {
            System.out.println(name);
        }
        // look at the head of the queue
        System.out.println("\nThe head: " + line.peek());
    }
}
