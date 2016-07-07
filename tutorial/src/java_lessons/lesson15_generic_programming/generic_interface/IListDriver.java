package java_lessons.lesson15_generic_programming.generic_interface;

/**
 * Test class for List class.
 */
public class IListDriver {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main (String[] args) {
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
