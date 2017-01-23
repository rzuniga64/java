package java_lessons.lesson20_exception_handling;

import java_lessons.lesson15_generic_programming.generic_class.List;

/**
 * The ListEmptyException class.
 */
public class ListEmptyException extends RuntimeException {

    /**
     * Instantiates a new ListEmptyException.
     */
    public ListEmptyException() {
        super("List is empty.");
    }

    /**
     * The unit tests for ListEmptyException class.
     * @param args the input arguments
     */
    public static void main(final String[] args) {
        try {

            List<String> names = new List<>(10);
            System.out.println(names.toString());
        } catch (ListEmptyException e) {
            e.printStackTrace();
        }
    }
}
