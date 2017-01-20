package java_lessons.lesson1;

/**
 *  A variable is a name for a memory location.
 *  Always has a type.
 *  Data stored in a variable is called a value.
 *  Variable name must start with a letter.
 *  May contain letters, numbers, and the underscore character.
 *  Variables should begin with lowercase letters.
 */
public final class Variables {

    /** Constructor. */
    private Variables() { }

    /**
     * Unit tests.
     * @param args the arguments
     */
    public static void main(final String[] args) {
        // Integral types
        int int1       = 1;    // -2**31 - 2**31
        long long1     = 1L;   // -2**63 - 2**63
        float float1   = 0.2f; // 127 digits after decimal point
        double double1 = 1.2d; // 1023 digits after decimal
        byte byte1     = 1;    // -128 - 127
        short short1   = 1;    // -2**15 - 2**15
        char letter     = 'a';  // alphabetic chars stored as ASCII

        int value = int1 + (int) long1 + (int) float1 + (int) double1 + byte1
                + short1;

        // Non-numeric data types
        String string1 = "Hello"; // String is a class
        Boolean bool   = false;    // built-in data type

        System.out.println("letter = " + letter);
        System.out.println("value = " + value);
        System.out.println("string1 = " + string1);
    }
}

