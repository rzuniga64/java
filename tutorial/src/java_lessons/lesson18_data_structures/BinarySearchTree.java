package java_lessons.lesson18_data_structures;

/**
 * The type Binary search tree class.
 * Methods:
 * - insert(e)
 * - inorder()
 * - preorder()
 * - postorder()
 * - min()
 * - max()
 *
 */
class BinarySearchTree {
    private Node root;

    /**
     * Instantiates a new Binary search tree.
     */
    BinarySearchTree() {
        root = null;
    }

    /**
     * This methods inserts an element into the binary tree.
     *
     * @param data the data
     */
    void insert(int data) {

        Node newNode = new Node();
        newNode.data = data;

        if (root == null) {
            root = newNode;
        } else {
            Node current = root;
            Node parent;

            while (true) {
                parent = current;
                if (data < current.data) {
                    current = current.left;
                    if (current == null) {
                        parent.left = newNode;
                        break;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = newNode;
                        break;
                    }
                }
            }
        }
    }

    /**
     * This methods prints out a binary search tree in order.
     */
    void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node n) {
        if (n != null) {
            inOrder(n.left);
            System.out.println(n.getData());
            inOrder(n.right);
        }
    }

    /**
     * This methods prints out a binary search tree in pre-order.
     */
    void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node n) {
        if (n != null) {
            System.out.println(n.getData());
            preOrder(n.left);
            preOrder(n.right);
        }
    }

    /**
     * This methods prints out a binary search tree in post-order.
     */
    void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node n) {
        if (n != null) {
            postOrder(n.left);
            postOrder(n.right);
            System.out.println(n.getData());
        }
    }

    /**
     * This method finds the minimum element in the binary search tree.
     *
     * @return the int
     */
    int min() {
        Node current = root;

        while (current.left != null)
            current = current.left;

        return current.getData();
    }

    /**
     *  This method finds the maximum element in the binary search tree.
     *
     * @return the int
     */
    int max() {
        Node current = root;

        while (current.right != null)
            current = current.right;

        return current.getData();
    }
}
