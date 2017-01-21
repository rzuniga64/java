package java_lessons.lesson7_arraylist;

import java.util.ArrayList;

/**
 * AccessingArrayListElements class.
 */
public final class AccessingArrayListElements  {

    /**
     * Constructor.
     */
    private AccessingArrayListElements() {
    }

    /**
     * Display the array.
     * @param arr the array
     */
    static void display(final ArrayList arr) {

        for (Object item: arr) {
            System.out.print(item + " ");
        }
    }

    /**
     * Unit tests.
     *
     * @param args the arguments.
     */
   public static void main(final String[] args) {

       ArrayList<Integer> numbers = new ArrayList<>();
       for (int i = 1; i < 11; ++i) {
           numbers.add(i);
       }
       int total = 0;
       for (int number: numbers) {
           total += number;
       }
       System.out.println("The total is " + total);
       System.out.println("First element: " + numbers.get(0));
       System.out.println("Last element: " + numbers.get(numbers.size() - 1));
       display(numbers);
   }
}
