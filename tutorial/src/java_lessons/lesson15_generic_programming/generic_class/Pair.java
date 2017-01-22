package java_lessons.lesson15_generic_programming.generic_class;

/**
 *  The Pair class.
 *  @param <T1> the type parameter
 *  @param <T2> the type parameter
 */
public final class Pair<T1, T2> {

    /** First gneric item. */
    private T1 firstItem;
    /** Second generic item. */
    private T2 secondItem;

    /**
     *  Instantiate a new Pair.
     *  @param first  the first data type
     *  @param second the second data type
     */
    private Pair(final T1 first, final T2 second) {
        firstItem = first;
        secondItem = second;
    }

    /**
     * Method to return the first data type.
     * @return the first data type
     */
    public T1 first() {

        return firstItem;
    }

    /**
     * Method to return the second data type.
     * @return the second data type
     */
    public T2 second() {

        return secondItem;
    }

    /**
     * Unit tests for Pair class.
     * @param args the input arguments
     */
    public static void main(final String[] args) {

        Pair<String, Integer> grade1 = new Pair<>("Williams", 90);
        Pair<String, Integer> grade2 = new Pair<>("Brown", 44);

        System.out.println(grade1.first());
        System.out.println(grade1.second());
        System.out.println(grade2.first());
        System.out.println(grade2.second());
    }
}
