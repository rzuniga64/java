package java_lessons.lesson20_exception_handling;

class ListEmptyException extends RuntimeException {
    ListEmptyException() {
        super("List is empty");
    }
}
