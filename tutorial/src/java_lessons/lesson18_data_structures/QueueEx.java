package java_lessons.lesson18_data_structures;

import java.util.LinkedList;

/**
 * The type QueueEx.
 * Methods used:
 * - addLast()
 * - removeFirst()
 * - size()
 * - isEmpty()
 */
public class QueueEx {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        LinkedList<String> names = new LinkedList<>();

        names.addLast("Cynthia");
        names.addLast("Raymond");
        names.addLast("David");

        for (String name : names)
            System.out.println(name);
        System.out.println();

        names.removeFirst();
        for (String name : names)
            System.out.println(name);
        System.out.println();

        names.addLast("Clayton");
        for (String name : names)
            System.out.println(name);
        System.out.println();
        System.out.println("Size of queue: " + names.size());

        if (!names.isEmpty())
            names.removeFirst();
        System.out.println("Size of queue: " + names.size());

        System.out.println();
        for (String name : names)
            System.out.println(name);
    }
}
