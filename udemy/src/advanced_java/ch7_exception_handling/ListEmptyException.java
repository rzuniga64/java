package advanced_java.ch7_exception_handling;

public class ListEmptyException extends RuntimeException {
    public ListEmptyException() {
        super("List is empty");
    }
}
