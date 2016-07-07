package java_lessons.lesson15_generic_programming.generic_class;

/**
 * The type Node.
 *
 * @param <T> the type parameter
 */
class Node<T> {
    private T data;
    public Node next;

    /**
     * Instantiates a new Node.
     *
     * @param data the data
     */
    Node(T data) {
        this.data = data;
        next = null;
    }

    /**
     * Gets data of the Node
     *
     * @return the data of the Node
     */
    T getData() { return data; }
}