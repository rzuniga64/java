package java_lessons.lesson18_data_structures;

/**
 * The type Node.
 * @param <T>
 */
public class Node<T> {

    /** The data. */
    protected T data;
    /** The reference to the next and previous Node. */
    protected Node left, right;

    /**
     * Instantiates a new Node.
     * @param newData the data
     */
    public Node(final T newData) {
        this.data = newData;
        left = null;
        right = null;
    }

    /** Instantiates a new Node. */
    public Node() {
        left = null;
        right = null;
    }

    /**
     * Get the data of the Node.
     * @return the data of the Node
     */
    T getData() {
        return data;
    }
}
