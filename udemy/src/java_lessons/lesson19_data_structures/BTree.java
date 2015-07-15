package java_lessons.lesson19_data_structures;

public class BTree {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(8);
        bst.insert(7);
        bst.insert(13);
        bst.insert(3);
        bst.insert(10);
        bst.insert(6);
        bst.insert(4);
        bst.insert(1);
        bst.insert(14);
        bst.inOrder();
        System.out.println();
        bst.preOrder();
        System.out.println();
        bst.postOrder();
        System.out.println("The minimum value is: " + bst.min());
        System.out.println("the maximum value is: " + bst.max());
    }
}
