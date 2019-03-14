package sort;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *  The MaximumPriorityQueue class represents a priority queue of generic keys. It supports the usual insert and
 *  delete-the-maximum operations, along with methods for peeking at the maximum key, testing if the priority queue is
 *  empty, and iterating through the keys.
 *
 *  This implementation uses a binary heap.
 *  The insert and delete-the-maximum operations take logarithmic amortized time.
 *  The max, size, and is-empty operations take constant time.
 *  Construction takes time proportional to the specified capacity or the number of items used to initialize the data
 *  structure.
 *
 *  @param <Key> the generic type of key on this priority queue
 */
public class MaxPriorityQueue<Key> implements Iterable<Key> {

    private static Integer[] theArray = new Integer[10];
    private Key[] pq;                   // store items at indices 1 to n
    private int N;                      // number of items on priority queue
    private Comparator<Key> comparator; //optional comparator

    /**
     *  Initializes an empty priority queue.
     */
    public MaxPriorityQueue() {

        this(1);
    }

    /**
     *  Initializes an empty priority queue with the given initial capacity.
     * @param initCapacity the initial capacity of this priority queue
     */
    public MaxPriorityQueue(int initCapacity) {

        pq = (Key[]) new Object[initCapacity + 1];
        N = 0;
    }

    /**
     *  Initializes a empty priority queue with the given initial capacity, using the given comparator.
     *  @param initCapacity the initial capacity of this priority queue.
     *  @param comparator the order in which to compare the keys.
     */
    public MaxPriorityQueue(int initCapacity, Comparator<Key> comparator) {

        this.comparator = comparator;
        pq = (Key[]) new Object[initCapacity + 1];
        N = 0;
    }

    /**
     *  Initializes an empty priority queue using the given comparator.
     * @param comparator the order in which to compare keys.
     */
    public MaxPriorityQueue(Comparator<Key> comparator) {

        this(1, comparator);
    }

    /**
     *  Initializes a priority queue from the array of keys. Takes time proportional to the number of keys, using
     *  sink-based heap construction.
     *  @param keys the array of keys.
     */
    public MaxPriorityQueue(Key[] keys) {

        N = keys.length;
        pq = (Key[]) new Object[keys.length + 1];
        for (int i = 0; i < N; i++) {
            pq[i + 1] = keys[i];
        }
        for (int k = N/2; k >= 1; k--) {
            sink(k);
        }
        assert isMaxHeap();
    }

    /**
     *  Returns true if this priority queue is empty.
     *  @return true if this priority queue is empty; false otherwise.
     */
    public boolean isEmpty() {

        return N ==0;
    }

    /**
     *  Return the number of keys on this priority queue.
     *  @return the number of keys on this priority queue.
     */
    public int size() {
        return N;
    }

    /**
     *  Returns a largest key on this priority queue.
     *  @return a largest key on this priority queue.
     *  @throws NoSuchElementException if this priority queue is empty.
     */
    public Key max() {
        if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        return pq[1];
    }

    /**
     *  Helper functiont o double the size of the heap array
     *  @param capacity the new size of the heap array
     */
    private void resize(int capacity) {

        assert capacity > N;
        Key[] temp = (Key[]) new Object[capacity];
        for (int i = 1; i <= N; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }

    /**
     * Adds a new key to this priority queue.
     * @param key the new key to add to this priority queue
     */
    public void insert(Key key) {

        // double the size of array if necessary
        if (N == pq.length - 1) resize (2 * pq.length);

        // add key, and percolate it up to maintain heap invariant
        pq[++N] = key;
        swim(N);
        assert isMaxHeap();
    }

    /**
     *  Removes and returns a largest key on this priority queue.
     *  @return a largest key on this priority queue
     *  @throws NoSuchElementException if this priority queue is empty
     */
    public Key delMax() {

        if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        Key max = pq[1];
        exch(1, N--);
        sink(1);
        pq[N + 1] = null;    //to avoid loitering and help with garbage collection
        if ((N > 0) && (N == (pq.length -1 /4))) resize(pq.length / 2);
        assert isMaxHeap();
        return max;
    }

    public static void main(String[] args) {

        MaxPriorityQueue<String> pq = new MaxPriorityQueue<>();
        // T P R N H O A E I G S-
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) pq.insert(item);
            else if (!pq.isEmpty()) StdOut.print(pq.max() + " ");
        }
        StdOut.println("(" + pq.size() + " left on pq)");
    }

    /*******************************************************************************************************************
     *  Helper functions to restore the heap invariant.
     ******************************************************************************************************************/

    private void swim(int k) {
        while (k > 1 && less(k/2, k)) {

            exch(k, k/2);
            k = k/2;
        }
    }

    private void sink(int k) {
        while (2*k <= N) {
            int j = 2 * k;
            if (j < N && less(j, j + 1)) j++;
            if (!less(k,j)) break;
            exch(k, j);
            k = j;
        }
    }

    /*******************************************************************************************************************
     *  Helper sorting functions
     ******************************************************************************************************************/

    /**
     *  Is pq[i] < pq[j]?
     *  @param i index of pq
     *  @param j index of pq
     *  @return true if p[i] < p[j]
     */
    private boolean less(int i, int j) {

        if (comparator == null) {
            return ((Comparable<Key>) pq[i]).compareTo(pq[j]) < 0;
        } else {
            return comparator.compare(pq[i], pq[j]) < 0;
        }
    }

    /**
     *  Exchange a[i] and a[j]
     *  @param i index into array
     *  @param j index into array
     */
    private void exch(int i, int j){

        Key swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }

    /**
     *  is pq[1..N] a max heap?
     * @return true if pq[1..N] is max heap; false otherwise.
     */
    private boolean isMaxHeap() {

        return isMaxHeap(1);
    }

    private boolean isMaxHeap(int k) {

        if (k > N) return true;
        int left = 2 * k;
        int right = 2 * k + 1;
        if (left <= N && less(k, left)) return false;
        if (right <= N && less(k, right)) return false;
        return isMaxHeap(left) && isMaxHeap(right);
    }

    /*******************************************************************************************************************
     *  Iterator
     ******************************************************************************************************************/

    /**
     *  Returns an iterator that iterates over the keys on this priority queue in descending order.
     *  The iterator doesn't implement remove() since it's optional.
     *  @return an iterator that iterates over the keys in descending order.
     */
    public Iterator<Key> iterator() {

        return new HeapIterator();
    }

    private class HeapIterator implements Iterator<Key> {

        private MaxPriorityQueue<Key> copy;     // creaet a new priority queue

        public HeapIterator() {
            if (comparator == null) copy = new MaxPriorityQueue<>(size());
            else                    copy = new MaxPriorityQueue<>(size(), comparator);
            for (int i = 1; i <= N; i++)
                copy.insert(pq[i]);
        }

        public boolean hasNext() {

            return !copy.isEmpty();
        }

        public void remove () {

            throw new UnsupportedOperationException();
        }

        public Key next() {

            if (!hasNext()) throw new NoSuchElementException();
            return copy.delMax();
        }
    }
}

