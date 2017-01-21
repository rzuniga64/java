package java_lessons.lesson5_repitition;

/**
 * ForLoop class.
 *
 * for(initialize lcv; rel test lcv; modify lcv) {
 *    statements;
 * }
 *
 */
public final class ForLoop {

    /** Constructor. */
    private ForLoop() { }

    /**
     * Unit tests.
     * @param args the arguments.
     */
   public static void main(final String[] args) {

      int sum = 0;
      double balance = 5000;
      double rate = 1.02;

      for (int i = 1; i <= 10; ++i) {
         sum += i;
      }
      System.out.println("The sum of 1 to 10 is " + sum);

      for (int i = 1; i <= 10; ++i) {
          balance *= rate;
       }
       System.out.printf("The balance after 10 years is %.2f", balance);
   }
}
