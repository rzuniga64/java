package java_lessons.lesson16_sequential_collections;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * priorityQueueUsingComparator class.
 */
public final class priorityQueueUsingComparator implements
        Comparator<String> {

    /** Constructor. */
    private priorityQueueUsingComparator() { }

    /**
     *  Compares the length of two Strings.
     *  Assume neither string is null. Real code should probably be more
     *  robust. You could also just return x.length() - y.length(), which
     *  would be more efficient.
     *  @param x a string
     *  @param y a string
     *  @return comparison of two strings
     */
    public int compare(final String x, final String y) {

        if (x.length() < y.length()) {
            return -1;
        } else if (x.length() > y.length()) {
            return 1;
        }
        return 0;
    }

    /**
     * Unit tests for priorityQueueUsingComparator.
     * @param args the default arguments
     */
    public static void main(final String[] args) {

        Comparator<String> comparator = new priorityQueueUsingComparator();
        PriorityQueue<String> queue = new PriorityQueue<>(10, comparator);
        queue.add("short");
        queue.add("very long indeed");
        queue.add("medium");
        while (queue.size() != 0) {
            System.out.println(queue.remove());
        }
    }
}

