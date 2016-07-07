package java_lessons.lesson15_generic_programming.generic_class;

/**
 * The type Pair.
 *
 * @param <T1> the type parameter
 * @param <T2> the type parameter
 */
class Pair<T1, T2> {
    private T1 firstItem;
    private T2 secondItem;

    /**
     * Instantiates a new Pair.
     *
     * @param first  the first data type
     * @param second the second data type
     */
    Pair(T1 first, T2 second) {
        firstItem = first;
        secondItem = second;
    }

    /**
     * Method to return the first data type
     *
     * @return the first data type
     */
    public T1 first() {
        return firstItem;
    }

    /**
     * Method to return the second data type
     *
     * @return the second data type
     */
    public T2 second() {
        return secondItem;
    }
}
