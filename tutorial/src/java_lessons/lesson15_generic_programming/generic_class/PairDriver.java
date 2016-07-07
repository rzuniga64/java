package java_lessons.lesson15_generic_programming.generic_class;

/**
 * The type Pair driver.
 */
public class PairDriver {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Pair<String, Integer> grade1 = new Pair<>("Williams", 90);
        Pair<String, Integer> grade2 = new Pair<>("Brown", 44);

        System.out.println(grade1.first());
        System.out.println(grade1.second());
        System.out.println(grade2.first());
        System.out.println(grade2.second());
    }
}