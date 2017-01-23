package java_lessons.lesson29_stringbuilder_class;

/**
 * The type String builder methods.
 * - toString
 * - insert
 * - indexOf(String)
 * - delete(int, int)
 * - deleteCharAt(int)
 * - reverse
 */
public final class StringBuilderMethods {

    /** Constructor. */
    private StringBuilderMethods() { }

    /**
     * The unit tests for StringBuilderMethods class.
     * @param args the input arguments
     */
    public static void main(final String[] args) {

        //StringBuilder sentence = new StringBuilder();
        StringBuilder sentence = new StringBuilder("Now the time");
        System.out.println(sentence.toString());

        sentence.insert(4, "is ");
        System.out.println(sentence.toString());

        System.out.println("the is found at pos: " + sentence.indexOf("the"));

        sentence.delete(4, 6);
        System.out.println(sentence.toString());

        sentence.deleteCharAt(3);
        System.out.println(sentence.toString());

        sentence.reverse();  // can  be used to check for palindromes
        System.out.println(sentence.toString());
    }
}
