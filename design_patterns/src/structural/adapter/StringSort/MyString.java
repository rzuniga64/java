package structural.adapter.StringSort;

/**
 *  MyString class.
 *  The Adaptee class (legacy).
 */
public class MyString {

    /** a String. */
    private String s;

    /**
     * Constructor.
     * @param x String
     */
    MyString(final String x) {
        s = x;
    }

    /**
     * Function to determine if two Objects are equal.
     * @param o Object
     * @return true if equal; false otherwise
     */
    @Override
    public boolean equals(final Object o) {
        return s.equals(o);
    }

    /**
     * hashcode function.
     * @return hashcode
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    /**
     * Function to determine if one Object is greater than another.
     * @param s1 Object
     * @return true if greater than; false otherwise
     */
    public boolean greaterThan(final MyString s1) {

        return  s.compareTo(s1.toString()) != 1;
    }
}


