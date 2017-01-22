package java_lessons.lesson15_generic_programming.generic_class;

/**
 * The Node class.
 * @param <T> the type parameter
 */
class Node<T> {

    /** The data. */
    private T data;
    /** The reference to the next Node. */
    private Node next;

    /**
     * Instantiates a new Node.
     * @param newData the data
     */
    Node(T newData) {
        this.data = newData;
        next = null;
    }

    /**
     * Get the data of the Node.
     * @return the data of the Node
     */
    T getData() {
        return data;
    }
}
