package java_lessons.lesson18_data_structures;

import java.util.LinkedList;

/**
 *  The type QueueEx uses a linked list to implement a queue.
 *  Doubly-linked list implementation of the List and Deque interfaces.
 *  Implements all optional list operations, and permits all elements
 *  (including null). All of the operations perform as could be expected for a
 *  doubly-linked list. Operations that index into the list will traverse the
 *  list from the beginning or the end, whichever is closer to the specified
 *  index.
 *
 *  Methods used:
 *  - addLast()
 *  - removeFirst()
 *  - size()
 *  - isEmpty()
 */
public final class QueueEx {

    /** Constructor. */
    private QueueEx() { }

    /**
     * Unit tests for QueueEx class.
     * @param args the input arguments
     */
    public static void main(final String[] args) {

        LinkedList<String> names = new LinkedList<>();

        names.addLast("Cynthia");
        names.addLast("Raymond");
        names.addLast("David");

        for (String name : names) {
            System.out.println(name);
        }
        System.out.println();

        names.removeFirst();
        for (String name : names) {
            System.out.println(name);
        }
        System.out.println();

        names.addLast("Clayton");
        for (String name : names) {
            System.out.println(name);
        }
        System.out.println();
        System.out.println("Size of queue: " + names.size());

        if (!names.isEmpty()) {
            names.removeFirst();
        }
        System.out.println("Size of queue: " + names.size());

        System.out.println();
        for (String name : names) {
            System.out.println(name);
        }
    }
}
