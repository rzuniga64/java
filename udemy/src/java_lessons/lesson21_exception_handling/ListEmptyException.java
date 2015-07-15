package java_lessons.lesson21_exception_handling;

public class ListEmptyException extends RuntimeException {
    public ListEmptyException() {
        super("List is empty");
    }
}
