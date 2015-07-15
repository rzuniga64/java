package java_lessons.lesson21_exception_handling;

// We want to specify a generic data type using generic programming
// by using a type place holder <T>.
public class List<T> {
    private T[] data;
    private int size;
    private int capacity;

    public List(int numElements) {
        size = numElements;
        capacity = 0;

        /* Generic classes and methods only work with Object
           data types. Data types must be Object instead
           of primitive data types.

           create a new Object array and cast it to the data
           type that will be provided when we instantiate a list
        */
        data = (T[]) new Object[size];
    }

    public void add(T element) {
        data[capacity] = element;
        capacity++;
    }

    public String toString() throws ListEmptyException {
        if (data[0] == null)
            throw new ListEmptyException();

        String elements = "";
        for (int i = 0; i < capacity; ++i) {
            elements += data[i] + " ";
        }
        return elements;
    }
}