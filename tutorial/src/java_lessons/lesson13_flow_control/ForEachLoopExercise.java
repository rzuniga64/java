package java_lessons.lesson13_flow_control;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * ForEachLoopExercise class.
 */
public final class ForEachLoopExercise {

    /** Constructor. */
    private ForEachLoopExercise() { }

    /**
     * Unit tests.
     * @param args the arguments.
     */
    public static void main(final String[] args) {

        ArrayList<Integer> numbers = new ArrayList<>();

        for (int i = 1; i < 11; ++i) {
            numbers.add(i);
        }

        for (Iterator<Integer> n = numbers.iterator(); n.hasNext();) {
            int num = n.next();
            System.out.println(num);
        }

        for (int n : numbers) {
            System.out.println(n);
        }
    }
}
