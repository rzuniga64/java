package structural.adapter.StringSort;

import java.util.Comparator;

/**
 *  TestAdapterPattern class.
 *  The target.
 */
public final class TestAdapterPattern {

    /** Constructor. */
    private TestAdapterPattern() { }

    /**
     * Unit tests.
     * @param args args
     */
    public static void main(final String[] args) {

        MyString[] x = {new MyString("B"), new MyString("A") };
        Comparator c = new MyStringComparator();
        Array.sort(x, c);
    }
}
