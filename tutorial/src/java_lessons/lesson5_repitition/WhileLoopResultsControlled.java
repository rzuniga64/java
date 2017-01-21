package java_lessons.lesson5_repitition;

/**
 * WhileLoopResultsControlled class.
 */
public final class WhileLoopResultsControlled {

    /** Constructor. */
    private WhileLoopResultsControlled() { }

    /**
     * Unit tests.
     * @param args the arguments.
     */
    public static void main(final String[] args) {

        double balance = 300000;
        double rate = 1.10;
        int years = 0;

        while (balance <= 1000000) {
            balance *= rate;
            ++years;
        }
        System.out.println("It will take " + years + " years to reach 100000.");
   }
}
