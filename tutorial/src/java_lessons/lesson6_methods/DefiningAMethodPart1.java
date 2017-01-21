package java_lessons.lesson6_methods;

/**
 * DefiningAMethodPart1 class.
 *
 * A method is a set of instructions that performs a named operation.
 * It takes data as input and may return data as output.
 */
public final class DefiningAMethodPart1 {

    /** Constructor. */
    private DefiningAMethodPart1() { }

    /**
     *  Static means an independent method.
     *  Parameters must match in data
     *  type and number.
     * @param number the number to square
     * @return the square of the number
     */
   static int square(final int number) {
      return number * number;
   }

    /**
     * Unit tests.
     * @param args the arguments.
     */
    public static void main(final String[] args) {
        int num = 12;
        System.out.println(num + " squared equals " + square(num));
    }
}
