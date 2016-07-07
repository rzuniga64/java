package java_lessons.lesson15_generic_programming.generic_interface;

/**
 * The interface List provides us with a means to build upon a hierarchy of objects. We can do this generically
 * by creating a generic interface.
 *
 * @param <T> the type parameter
 */
interface IList<T> {
    /**
     * This method adds and element of type <T>
     *
     * @param element the element
     */
    void add(T element);

    /**
     * Get t.
     *
     * @param n the index of the element.
     * @return T the desired element.
     */
    T get(int n);
}
