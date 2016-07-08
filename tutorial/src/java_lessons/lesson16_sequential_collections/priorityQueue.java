package java_lessons.lesson16_sequential_collections;

import java.util.PriorityQueue;

/**
 * The type Priority queue.
 */
public class priorityQueue {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        PriorityQueue<String> line = new PriorityQueue<>();

        line.add("David");
        line.add("Cynthia");
        line.add("Raymond");
        line.add("Bryan");
        line.add("Clayton");

        for (String name : line)
            System.out.println(name);

        // remove an item from the head
        line.poll();
        System.out.println("\n");
        for (String name : line)
            System.out.println(name);

        // remove a specific item
        line.remove("Raymond");
        System.out.println("\n");
        for (String name : line)
            System.out.println(name);

        // look at the head of the queue
        System.out.println("\nThe head: " + line.peek());
    }
}
