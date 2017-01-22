package java_lessons.lesson16_sequential_collections;

import java.util.PriorityQueue;
import java.io.*;

/**
 * The priorityQueueSquareDance class.
 */
public final class priorityQueueSquareDance {

    /** Constructor. */
    private priorityQueueSquareDance() { }

    /**
     * The unit tests for priorityQueueSquareDance class.
     * @param args the input arguments
     */
    public static void main(final String[] args) {

        final String file = "tutorial\\src\\java_lessons" +
                "\\lesson16_sequential_collections\\dance.txt";

        PriorityQueue<String> men = new PriorityQueue<>();
        PriorityQueue<String> women = new PriorityQueue<>();
        String line;
        String sex;
        BufferedReader input;

        try {
            input = new BufferedReader(new FileReader(file));
            while ((line = input.readLine()) != null ) {
                sex = line.substring(0,1);
                if (sex.equals("M"))
                    men.add(line.substring(2));
                else
                    women.add(line.substring(2));
            }
            input.close();
        } catch (IOException except) {
            System.out.println("Error opening file");
        }

        while (!men.isEmpty() && !women.isEmpty()) {
            System.out.print("The dance partners will be: ");
            System.out.println(men.poll() + " and " + women.poll());
        }
        if (men.isEmpty()) {
            System.out.print("There are " + women.size());
            System.out.print(" women waiting to dance. ");
            System.out.println(women.peek() + " is the next female dancer.");
        }
        if (women.isEmpty()) {
            System.out.print("there are " + men.size());
            System.out.print(" men waiting to dance. ");
            System.out.println(men.peek() + " is the next male dancer.");
        }
    }
}
