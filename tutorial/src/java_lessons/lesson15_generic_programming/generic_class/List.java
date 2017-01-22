package java_lessons.lesson15_generic_programming.generic_class;

import java_lessons.lesson20_exception_handling.ListEmptyException;

/**
 *  List class. We want to specify a generic data type using generic programming
 *  by using a type place holder <T>. The letter T is a placeholder for the
 *  data type that will be provided later when we use the List class. You
 *  cannot use a primitive type for a generic data type. Instead you must use
 *  its wrapper class.
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
     * Java does not allow an array of Generic object. Generic classes and
     * methods only work with Object data types. Data types must be Object
     * instead of primitive data types. Create a new Object array and cast it
     * to the data type that will be provided when we instantiate a list.
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
        data[capacity++] = element;
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

    /**
     * Unit tests for List class.
     * @param args the input arguments
     */
    public static void main(final String[] args) {

        List<String> groceryList = new List<>(10);
        groceryList.add("milk");
        groceryList.add("eggs");
        System.out.println("Grocery list: " + groceryList.toString());

        List<Integer> numbers = new List<>(5);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        System.out.println("Numbers: " + numbers.toString());
    }
}