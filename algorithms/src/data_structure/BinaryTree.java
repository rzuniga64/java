package data_structure;

/**
 * Random data normally isn't unbalanced.  Ordered data tends to create unbalanced trees.
 *
 * You can search, insert, and delete items quickly in a tree
 * Ordered Arrays are bad at insertions and deletions.
 * Finding items in a Linked List is slow.
 * Time needed to perform an operation on a tree is O(log N)
 * On average a tree is more ifficient if you need to perform many different types of operations.
 */

public class BinaryTree {

    private Node root;

    private void addNode(int key, String name) {

        // Create a new data_structure.Node and initialize it
        Node newNode = new Node(key, name);

        // If there is no root this becomes root
        if (root == null) {
            root = newNode;
        } else {
            // Set root as the data_structure.Node we will start with as we traverse the tree
            Node focusNode = root;

            // Future parent for our new data_structure.Node
            Node parent;

            while (true) {

                // root is the top parent so we start there
                parent = focusNode;

                // Check if the new node should go on  the left side of the parent node
                if (key < focusNode.key) {

                    // Switch focus to the left child
                    focusNode = focusNode.leftChild;

                    // If the left child has no children
                    if (focusNode == null) {
                        // then place the new node on the left of it
                        parent.leftChild = newNode;
                        return; // All Done
                    }
                } else { // If we get here put the node on the right
                    focusNode = focusNode.rightChild;

                    // If the right child has no children
                    if (focusNode == null) {

                        // then place the new node on the right of it
                        parent.rightChild = newNode;
                        return; // All Done
                    }
                }
            }
        }
    }

    // All nodes are visited in ascending order. recursion.Recursion is used to go to one node and then go to its child nodes and
    // so forth

    private void inOrderTraverseTree(Node focusNode) {

        if (focusNode != null) {
            // Traverse the left node
            inOrderTraverseTree(focusNode.leftChild);

            // Visit the currently focused on node
            System.out.println(focusNode);

            // Traverse the right node
            inOrderTraverseTree(focusNode.rightChild);
        }
    }

    private void preorderTraverseTree(Node focusNode) {

        if (focusNode != null) {
            System.out.println(focusNode);

            preorderTraverseTree(focusNode.leftChild);
            preorderTraverseTree(focusNode.rightChild);
        }

    }

    private void postOrderTraverseTree(Node focusNode) {

        if (focusNode != null) {

            postOrderTraverseTree(focusNode.leftChild);
            postOrderTraverseTree(focusNode.rightChild);

            System.out.println(focusNode);
        }
    }

    private Node findNode(int key) {

        // Start at the top of the tree
        Node focusNode = root;

        // While we haven't found the data_structure.Node keep looking
        while (focusNode.key != key) {

            // If we should search to the left
            if (key < focusNode.key) {

                // Shift the focus data_structure.Node to the left child
                focusNode = focusNode.leftChild;
            } else {
                // Shift the focus data_structure.Node to the right child
                focusNode = focusNode.rightChild;
            }

            // The node wasn't found
            if (focusNode == null)
                return null;
        }
        return focusNode;
    }

    public boolean remove(int key) {

        // Start at the top of the tree
        Node focusNode = root;
        Node parent = root;

        // When searching for a data_structure.Node this will tell us whether to search to the right or left
        boolean isItALeftChild = true;

        // While we haven't found the data_structure.Node keep looking
        while (focusNode.key != key) {

            parent = focusNode;

            // If we should search to the left
            if (key < focusNode.key) {
                isItALeftChild = true;

                // Shift the focus data_structure.Node to the left child
                focusNode = focusNode.leftChild;
            } else {

                // Greater than focus node so go to the right
                isItALeftChild = false;

                // Shift the focus data_structure.Node to the right child
                focusNode = focusNode.rightChild;
            }

            // The node wasn't found
            if (focusNode == null)
                return false;
        }

        // If data_structure.Node doesn't have children delete it
        if (focusNode.leftChild == null && focusNode.rightChild == null) {

            // If root delete it
            if (focusNode == root)
                root = null;
            // If it was marked as a left child of the parent delete it in its parent
            else if (isItALeftChild)
                parent.leftChild = null;
            // Vice versa for the right child
            else
                parent.rightChild = null;
        }

        // If no right child
        else if (focusNode.rightChild == null) {

            if (focusNode == root)
                root = focusNode.leftChild;

            // If focus data_structure.Node was on the left of parent move the focus Nodes left child up to the parent node
            else if (isItALeftChild)
                parent.leftChild = focusNode.leftChild;

            // Vice versa for the right child
            else
                parent.rightChild = focusNode.leftChild;
        }

        // If no left child
        else if (focusNode.leftChild == null) {

            if (focusNode == root)
                root = focusNode.rightChild;

            // If focus data_structure.Node was on the left of parent move the focus Nodes right child up to the parent node
            else if (isItALeftChild)
                parent.leftChild = focusNode.rightChild;

            // Vice versa for the left child
            else
                parent.rightChild = focusNode.rightChild;
        }

        // Two children so I need to find the deleted nodes replacement
        else {

            Node replacement = getReplacementNode(focusNode);

            // If the focusNode is root replace root with the replacement
            if (focusNode == root)
                root = replacement;

            // If the deleted node was a left child make the replacement the left child
            else if (isItALeftChild)
                parent.leftChild = replacement;

            // Vice versa if it was a right child
            else
                parent.rightChild = replacement;

            replacement.leftChild = focusNode.leftChild;
        }

        return true;
    }

    public Node getReplacementNode(Node replacedNode) {

        Node replacementParent = replacedNode;
        Node replacement = replacedNode;

        Node focusNode = replacedNode.rightChild;

        // While there are no more left children
        while (focusNode != null) {
            replacementParent = replacement;
            replacement = focusNode;
            focusNode = focusNode.leftChild;
        }

        // If the replacement isn't the right child move the replacement into the parents leftChild slot and move the
        // replaced nodes right child into the replacements rightChild
        if (replacement != replacedNode.rightChild) {

            replacementParent.leftChild = replacement.rightChild;
            replacement.rightChild = replacedNode.rightChild;
        }

        return replacement;
    }

    public static void main(String[] args) {

        BinaryTree theTree = new BinaryTree();
        theTree.addNode(50, "Boss");
        theTree.addNode(25, "Vice President");
        theTree.addNode(15, "Office Manager");
        theTree.addNode(30, "Secretary");
        theTree.addNode(75, "Sales Manager");
        theTree.addNode(85, "Salesman 1");

        // Different ways to traverse binary trees
        System.out.println("preOrderTraversal:");
        theTree.preorderTraverseTree(theTree.root);
        System.out.println();

        System.out.println("inOrderTraversal:");
        theTree.inOrderTraverseTree(theTree.root);
        System.out.println();


        System.out.println("postOrderTraversal:");
        theTree.postOrderTraverseTree(theTree.root);
        System.out.println();

        // Find the node with key 75

        System.out.println("\ndata_structure.Node with the key 75");
        System.out.println(theTree.findNode(75));
    }
}

class Node {
    int key;
    private String name;

    Node leftChild;
    Node rightChild;

    Node(int key, String name) {
        this.key = key;
        this.name = name;
    }

    public String toString() {
        return name + " has the key " + key;

		 // return name + " has the key " + key + "\nLeft Child: " + leftChild +
		 // "\nRight Child: " + rightChild + "\n";
    }
}