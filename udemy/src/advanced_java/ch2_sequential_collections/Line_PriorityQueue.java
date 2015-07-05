package advanced_java.ch2_sequential_collections;

import java.util.PriorityQueue;

public class Line_PriorityQueue {
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