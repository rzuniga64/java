package java_lessons.lesson20_exception_handling;

/**
 * The type TryCatch.
 * Exceptions are errors that occur in your program at run-time.
 */
public final class TryCatch {

    /** Constructor. */
    private TryCatch() { }

    /**
     * The unit tests for TryCatch class.
     * @param args the input arguments
     */
    public static void main(final String[] args) {

        int numer = 12;
        int denom = 0;

        try {
            System.out.print(numer / denom);
        } catch (ArithmeticException e) {
            System.out.println("Can't divide by zero.");
            denom = 2;
            System.out.print(numer / denom);
        }
    }
}
