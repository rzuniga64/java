package java_lessons.lesson18_data_structures;

/**
 * The type Node.
 * @param <T>
 */
public class Node {

    /** The data. */
    protected int data;
    /** The reference to the next and previous Node. */
    protected Node left, right;

    /**
     * Instantiates a new Node.
     * @param newData the data
     */
    public Node(final int newData) {
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
    int getData() {
        return data;
    }
}
