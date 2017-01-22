package java_lessons.lesson15_generic_programming.generic_interface;

/**
 *  NumberList class.
 *  @param <T>
 */
public final class NumberList<T> implements IList<T> {

    /** The data array. */
    private T[] data;
    /** The size of the array. */
    private int size;
    /** The capacity of the array. */
    private int capacity;

    /**
     * Constructor.
     * @param numItems the number of items
     */
    NumberList(final int numItems) {
        size = numItems;
        capacity = 0;
        data = (T[]) new Object[size];
    }

    /**
     * Add an item to the array.
     * @param item the item to add
     */
    public void add(final T item) {
        data[capacity] = item;
        ++capacity;
    }

    /**
     * Get the nth item of the array.
     * @param n the index of the item.
     * @return the nth item of the array
     */
    public T get(final int n) {

        return data[n];
    }

    /**
     * String representation of the data.
     * @return the data
     */
    public String toString() {
        String elements = "";
        for (int i = 0; i < capacity; ++i) {
            elements += data[i] + " ";
        }
        return elements;
    }
}
