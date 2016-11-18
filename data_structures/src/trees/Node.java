package trees;

import static java.lang.Integer.max;

/***********************************************************************************************************************
 *  Public Operations
 *
 *  int getKey()
 *  void setKey(int)
 *  String getName()
 *  void setName(String)
 *  Node getLeftChild()
 *  void setLeftChild(Node)
 *  Node getRightChild()
 *  void setRightChild(Node)
 *
 *  int size( Node ):       Return size of subtree at node
 *  int height( Node ):     Return height of subtree at node
 *  void printPreOrder()    Print a preorder tree traversal
 *  void printPostOrder()   Print a postorder tree traversal
 *  void printInOrder()     Print a inorder tree traversal
 *  Node duplicate()        Return a duplicate tree
 */
class Node {
    private String name;
    private int key;

    private Node leftChild;
    private Node rightChild;

    /**
     * Instantiates a new Node.
     *
     * @param key  the key
     * @param name the name
     */
    Node(int key, String name) {
        this.key = key;
        this.name = name;
        this.leftChild = null;
        this.rightChild = null;
    }

    /**
     * Gets key.
     *
     * @return the key
     */
    int getKey() { return key; }

    /**
     * Sets key.
     *
     * @param key the key
     */
    public void setKey(int key) { this.key = key; }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() { return name; }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) { this.name = name; }

    /**
     * Gets left child.
     *
     * @return the left child
     */
    Node getLeftChild() { return leftChild; }

    /**
     * Sets left child.
     *
     * @param leftChild the left child
     */
    void setLeftChild(Node leftChild) { this.leftChild = leftChild; }

    /**
     * Gets right child.
     *
     * @return the right child
     */
    Node getRightChild() { return rightChild; }

    /**
     * Sets right child.
     *
     * @param rightChild the right child
     */
    void setRightChild(Node rightChild) { this.rightChild = rightChild; }

    /**
     * Return each data value of node in a string.
     */
    public String toString() {
        return name + " has the key " + key + "\nLeft Child: " + leftChild + "\nRight Child: " + rightChild + "\n";
    }

    /**
     * Return size of subtree at node.
     *
     * @param node the node
     * @return size of the node
     */
    int size( Node node) {

        if ( node == null)
            return 0;
        else
            return 1 + size(node.getLeftChild()) +  size(node.getRightChild());
    }

    /**
     * Return height of subtree at node
     *
     * @param node the node
     * @return height of the node
     */
    int height(Node node) {

        if ( node == null)
            return -1;
        else
            return 1 + max(height( node.getLeftChild()), height(node.getRightChild()));
    }

    /**
     * Print a pre order tree traversal
     */
    void printPreOrder() {

        System.out.println(this.toString());
        if (this.getLeftChild() != null)
            this.getLeftChild().printPreOrder();
        if (this.getRightChild() != null)
            this.getRightChild().printPreOrder();
    }

    /**
     * Print a post order tree traversal
     */
    void printPostOrder() {

        System.out.println(this.toString());
        if (this.getLeftChild() != null)
            this.getLeftChild().printPostOrder();
        if (this.getRightChild() != null)
            this.getRightChild().printPostOrder();
    }

    /**
     * Print a in order tree traversal.
     */
    void printInOrder() {
        if (this.getLeftChild() != null)
            this.getLeftChild().printInOrder();
        System.out.println(this.toString());
        if (this.getRightChild() != null)
            this.getRightChild().printInOrder();
    }

    /**
     * Return a duplicate tree
     *
     * @return the node
     */
    Node duplicate() {
        Node root = new Node(key, name);

        if (this.getLeftChild() != null)
            root.setLeftChild(getLeftChild().duplicate());
        if (this.getRightChild() != null)
            root.setRightChild(getRightChild().duplicate());
        return root;
    }
}
