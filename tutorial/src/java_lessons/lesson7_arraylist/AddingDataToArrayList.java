package java_lessons.lesson7_arraylist;

import java.util.ArrayList;

/**
 * AddingDataToArrayList class.
 */
public final class AddingDataToArrayList {
    /**
     * Constructor.
     */
    private AddingDataToArrayList() {
    }

    /**
     * Unit tests.
     *
     * @param args the arguments.
     */
    public static void main(final String[] args) {

        ArrayList<Integer> numbers = new ArrayList<>();

        System.out.println("The size of numbers: " + numbers.size());
        numbers.add(0);
        System.out.println("The size of numbers: " + numbers.size());

        for (int i = 1; i <= 10; ++i) {
            numbers.add(i);
        }
        System.out.println("The size of numbers: " + numbers.size());
    }
}
