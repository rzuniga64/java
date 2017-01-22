package java_lessons.lesson12_arrays;

/**
 * The AccessingArrayElementsClass.
  */
public final class AccessingArrayElements {

    /** Constructor. */
    private AccessingArrayElements() { }

    /**
     * Unit tests.
     * @param args the arguments
     */
    public static void main(final String[] args) {

      final int size = 10;
      int[] numbers = new int[size];
      int total = 0;

      for (int i = 0; i < size; ++i) {
          numbers[i] = i + 1;
      }
      // access the array
      for (int number: numbers) {
          System.out.print(number + " ");
          total += number;
      }

      System.out.println("The total is " + total);
   }
}