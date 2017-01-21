package java_lessons.lesson7_arraylist;

import java.util.ArrayList;

/**
 * PassArrayListAsMethodArgument class.
 * Reference objects are passed by reference not by value. We have access to the
 * underlying memory addresses where the reference object is stored.  So when
 * we modify the object not just a copy. ArrayList is a reference object.
 */
public final class PassArrayListAsMethodArgument {

    /**
     * Constructor.
     */
    private PassArrayListAsMethodArgument() { }

   /**
    * Display the contents of an array.
    * @param arr the array
    */
   static void display(final ArrayList arr) {
      for (Object item : arr) {
         System.out.print(item + " ");
      }
      System.out.println();
   }

   /**
    * Change the contents of an array list.
    * @param arr the array
    * @param amount the amount
    */
   static void change(final ArrayList<Integer> arr, final int amount) {
       int value;
       for (int i = 0; i < arr.size(); ++i) {
           value = arr.get(i);
           arr.set(i, value + amount);
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
        display(numbers);
        change(numbers, 5);
        display(numbers);
    }
}
