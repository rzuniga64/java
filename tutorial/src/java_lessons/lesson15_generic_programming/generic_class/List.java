package java_lessons.lesson15_generic_programming.generic_class;

/**
 * We want to specify a generic data type using generic programming by using a type place holder <T>.
 *
 * @param <T> the type parameter
 */

public class List<T> {
    private T[] data;
    private int size;
    private int capacity;

    /**
     * Instantiates a new List.  Generic classes and methods only work with Object data types.
     * Data types must be Object instead of primitive data types. Create a new Object array and cast it to the data type
     * that will be provided when we instantiate a list.
     *
     * @param numElements the num elements
     */
    public List(int numElements) {
        size = numElements;
        capacity = 0;
        data = (T[]) new Object[size];
    }

    /**
     * This method will add a generic data type to a data list.
     *
     * @param element the element to add
     */
    public void add(T element) {
        data[capacity] = element;
        capacity++;
    }

    public String toString() {
        String elements = "";
        for (int i = 0; i < capacity; ++i) {
            elements += data[i] + " ";
        }
        return elements;
    }
}