package learn_java.ch4_data_types_and_variables;


/* *
 * Strings and booleans
 *
 * String - 0 or more characters surrounded by double quotes
 * String is a class, not a built-in type
 * Large collection of methods for manipulating strings
 * String length limited primarily by available memory
 * Strings can be combined with + concatenation
 * Empty string, "", is legal String object
 *
 * boolean - true/false values
 * Built-in data type
 * Comparisons - salary > 100000
 * Repetition - while balance < 10000
 *
 */
public class Variables {
    @SuppressWarnings("unused")
    public static void main(String[] args)
    {
        // Integral types
        int int1       = 1;    // -2**31 - 2**31
        long long1     = 1L;   // -2**63 - 2**63
        float float1   = 0.2f; // 127 digits after decimal point
        double double1 = 1.2d; // 1023 digits after decimal
        byte byte1     = 1;    // -128 - 127
        short short1   = 1;    // -2**15 - 2**15
        char char1     = 'a';  // alphabetic characters stored as numeric value (ASCII)

        // Non-numeric data types
        String string1 = "Hello"; // String is a class
        Boolean bool   = true;    // built-in data type

        int salary, hoursWorked;
        String middleName, lastName, initials;
    }
}

