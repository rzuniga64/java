package java_lessons.lesson3_io;

/**
 * Print class.
 */
public final class Printf {

    /** Constructor. */
    private Printf() { }

    /**
     * Unit tests.
     * @param args the arguments
     */
   public static void main(final String[] args) {

       final double pi = 3.14159263;
       System.out.printf("pi = %.2f\n", pi);
       System.out.printf("pi = %10.5f", pi);
   }
}
