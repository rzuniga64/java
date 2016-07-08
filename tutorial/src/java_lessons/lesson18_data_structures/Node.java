package java_lessons.lesson18_data_structures;

/**
 * The type Node.
 */
public class Node {

    public int data;
    public Node left;
    public Node right;

    /**
     * Instantiates a new Node.
     *
     * @param data the data
     */
    public Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }

    /**
     * Instantiates a new Node.
     */
    public Node() {
        left = null;
        right = null;
    }

    /**
     * This method returns the data of the Node.
     *
     * @return the data
     */
    int getData() {
        return data;
    }
}
