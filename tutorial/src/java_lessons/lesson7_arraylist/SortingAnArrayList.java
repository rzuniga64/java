package java_lessons.lesson7_arraylist;

import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

/**
 * SortingAnArrayList class.
 */
public final class SortingAnArrayList {

    /**
     * Constructor.
     */
    private SortingAnArrayList() {
    }

    /**
     * Display the array.
     * @param arr the array
     */
    static void display(final ArrayList arr) {
        for (Object item : arr) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    /**
     * Unit tests.
     *
     * @param args the arguments.
     */
    public static void main(final String[] args) {

        Random rand = new Random(System.currentTimeMillis());
        ArrayList<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < 10; ++i) {
            numbers.add(rand.nextInt(101));
        }
        display(numbers);
        Collections.sort(numbers);
        display(numbers);
    }
}

