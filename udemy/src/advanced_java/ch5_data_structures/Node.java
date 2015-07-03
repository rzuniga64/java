package advanced_java.ch5_data_structures;

public class Node {
    public int data;
    public Node left;
    public Node right;

    public Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }

    public Node() {
        left = null;
        right = null;
    }

    int getData() {
        return data;
    }
}
