package java_lessons.lesson20_exception_handling;

public class ListEmptyException extends RuntimeException {
    public ListEmptyException() {
        super("List is empty");
    }
}
