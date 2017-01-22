package java_lessons.lesson15_generic_programming.generic_class;

import java_lessons.lesson20_exception_handling.ListEmptyException;

/**
 *  List class. We want to specify a generic data type using generic programming
 *  by using a type place holder <T>.
 *  @param <T> the type parameter
 */
public class List<T> {
    /** An array to hold the data. */
    private T[] data;
    /** The size of the array. */
    private int size;
    /** The capacity of the array. */
    private int capacity;

    /**
     * Constructor.
     * Generic classes and methods only work with Object data types. Data
     * types must be Object instead of primitive data types. Create a new
     * Object array and cast it to the data type that will be provided when
     * we instantiate a list.
     * @param numElements the num elements
     */
    public List(final int numElements) {

        size = numElements;
        capacity = 0;
        data = (T[]) new Object[size];
    }

    /**
     * This method will add a generic data type to a data list.
     * @param element the element to add
     */
    public void add(final T element) {
        data[capacity] = element;
        capacity++;
    }

    /**
     * String representation of the data.
     * @return the data as a string
     * @throws ListEmptyException ListEmptyException
     */
    public String toString() throws ListEmptyException {

        if (data[0] == null) {
            throw new ListEmptyException();
        }
        String elements = "";
        for (int i = 0; i < capacity; ++i) {
            elements += data[i] + " ";
        }
        return elements;
    }
}