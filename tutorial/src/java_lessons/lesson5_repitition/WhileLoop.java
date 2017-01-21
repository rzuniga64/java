package java_lessons.lesson5_repitition;

/**
 * WhileLoop class.
 *
 * while (relational expression) {
 *    loop body
 * }
 *
 */
public final class WhileLoop  {

    /** Constructor. */
    private WhileLoop() { }

    /**
     * Unit tests.
     * @param args the arguments.
     */
   public static void main(final String[] args) {
      int number = 1;
      while (number <= 10) {
         System.out.println(number);
         ++number;
      }
   }
}
