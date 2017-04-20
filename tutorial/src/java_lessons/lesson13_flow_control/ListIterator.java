package java_lessons.lesson13_flow_control;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * ListIterator class.
 */
public final class ListIterator {

    /** Constructor. */
    private ListIterator() { }

    /**
     * Unit tests.
     * @param args the arguments.
     */
    public static void main(final String[] args) {

        ArrayList<Integer> numbers = new ArrayList<>();

        for (int i = 1; i < 11; ++i) {
            numbers.add(i);
        }

        // Demonstrate how the foreach loop works internally.
        for (Iterator<Integer> n = numbers.iterator(); n.hasNext();) {
            int num = n.next();
            System.out.println(num);
        }

        for (int n : numbers) {
            System.out.println(n);
        }
    }
}
