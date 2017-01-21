package java_lessons.lesson7_arraylist;

import java.util.Random;
import java.util.ArrayList;

/**
 * SearchArrayList class. The following methods help us search an ArrayList:
 * - indexOf
 * - contains
 */
public final class SearchAnArrayList {

    /**
     * Constructor.
     */
    private SearchAnArrayList() { }

    /**
     * Unit tests.
     * @param args the arguments.
     */
    public static void main(final String[] args) {

        Random rand = new Random(System.currentTimeMillis());
        ArrayList<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < 100; ++i) {
            numbers.add(rand.nextInt(101));
        }

        if (numbers.contains(99)) {
            System.out.println("99 was found at position "
                    + numbers.indexOf(99));
        } else {
            System.out.println("100 was not found in numbers.");
        }

        int min = 0;
        for (int i = 1; i < numbers.size(); ++i) {
            if (numbers.get(i) < numbers.get(min)) {
                min = i;
            }
        }
        System.out.println("The min value in numbers is " + numbers.get(min));
    }
}
