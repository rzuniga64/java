package java_lessons.lesson15_generic_programming.generic_class;

import sun.awt.image.ImageWatched;

/**
 * LinkedList class.
 */
public final class LinkedList {

    /** Constructor. */
    private LinkedList() { }

    /**
     * Unit tests for LinkedList class.
     * @param args the input arguments
     */
    public static void main(final String[] args) {

        Node<String> head = new Node("David");
        Node<String> node2 = new Node("Raymond");
        Node<String> node3 = new Node("Cynthia");
        head.next = node2;
        node2.next = node3;
        node3.next = new Node("Footer");

        Node<String> dummy = head;
        while (dummy.next != null) {
            System.out.println(dummy.getData());
            dummy = dummy.next;
        }
    }
}