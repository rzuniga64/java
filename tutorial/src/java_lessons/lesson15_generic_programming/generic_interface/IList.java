package java_lessons.lesson15_generic_programming.generic_interface;

/**
 * The interface List provides us with a means to build upon a hierarchy of
 * objects. We can do this generically by creating a generic interface.
 * @param <T> the type parameter
 */
interface IList<T> {

    /**
     * Adds an element of type <T>.
     * @param item the item
     */
    void add(T item);

    /**
     * Get the nth item from the list.
     * @param n the index of the item.
     * @return T the desired item.
     */
    T get(int n);

    /**
     * Unit tests for IList interface.
     * @param args the input arguments
     */
    static void main(final String[] args) {

        StringList groceryList = new StringList(10);
        groceryList.add("milk");
        groceryList.add("eggs");
        System.out.println("Grocery list: " + groceryList.toString());

        NumberList numbers = new NumberList(5);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        System.out.println("Numbers: " + numbers.toString());
    }
}
