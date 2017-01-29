package Trees;

import static java.lang.Integer.max;
import java.util.ListIterator;

/***********************************************************************************************************************
 *  Represents a node in a binary tree with a left and right child. Therefore this class also represents the root of
 *  subtree.
 *
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
 **********************************************************************************************************************/
class Node<T> {

    private T element;
    private Node leftChild, rightChild;

    /**
     * Instantiates a new Node.
     *
     * @param element  the element
     */
    Node(T element) {
        this.element = element;
        this.leftChild = null;
        this.rightChild = null;
    }

    /**
     * Gets element.
     *
     * @return the element
     */
    T getElement() { return element; }

    /**
     * Sets element.
     *
     * @param element the element
     */
    void setElement(T element) { this.element = element; }

    /**
     * Gets left child.
     *
     * @return the left child
     */
    Node<T> getLeftChild() { return leftChild; }

    /**
     * Sets left child.
     *
     * @param leftChild the left child
     */
    void setLeftChild(Node<T> leftChild) { this.leftChild = leftChild; }

    /**
     * Gets right child.
     *
     * @return the right child
     */
    Node<T> getRightChild() { return rightChild; }

    /**
     * Sets right child.
     *
     * @param rightChild the right child
     */
    void setRightChild(Node<T> rightChild) { this.rightChild = rightChild; }

    /**
     * Return each data value of node in a string.
     */
    public String toString() {
        //return element.getKey() + " has the key " + element.getName() + "\nLeft Child: " + leftChild + "\nRight Child: " + rightChild + "\n";
        return null;
    }

    public Node<T> find (T target) {

        Node<T> result = null;
        if (element.equals(target))
            result = this;
        else
            if (this.getLeftChild() != null)
                result = this.getLeftChild().find(target);
            if (result == null && this.getRightChild() != null)
                result = this.getRightChild().find(target);

        return result;
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
    void printPreOrder(ListIterator<T> iter) {

        System.out.println(this.toString());
        if (this.getLeftChild() != null)
            this.getLeftChild().printPreOrder(iter);
        if (this.getRightChild() != null)
            this.getRightChild().printPreOrder(iter);
    }

    /**
     * Print a post order tree traversal
     */
    void printPostOrder(ListIterator<T> iter) {

        System.out.println(this.toString());
        if (this.getLeftChild() != null)
            this.getLeftChild().printPostOrder(iter);
        if (this.getRightChild() != null)
            this.getRightChild().printPostOrder(iter);
    }

    /**
     * Print a in order tree traversal.
     */
    void printInOrder(ListIterator<T> iter) {

        if (this.getLeftChild() != null)
            this.getLeftChild().printInOrder(iter);
        System.out.println(this.toString());
        if (this.getRightChild() != null)
            this.getRightChild().printInOrder(iter);
    }
}
