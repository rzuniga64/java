package java_lessons.lesson20_exception_handling;

/**
 * The type TryCatch.  Exceptions are errors that occur in your program at run-time.
 */
public class TryCatch {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

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
