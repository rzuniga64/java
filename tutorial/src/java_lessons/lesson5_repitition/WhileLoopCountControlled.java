package java_lessons.lesson5_repitition;

/**
 * WhileLoopCountControlled class.
 */
public final class WhileLoopCountControlled {

    /** Constructor. */
    private WhileLoopCountControlled() { }

    /**
     * Unit tests.
     * @param args the arguments.
     */
    public static void main(final String[] args) {

        // balance, rate, number of year
        double balance = 5000;
        double rate = 1.02;

        // create a loop control variable
        int year = 1;
        while (year <= 10) {   //test loop control variable
            balance = balance * rate; // balance *= rate;
            System.out.printf("After year " + year + ", the balance is %.2f\n",
                    balance);
            ++year; // modify loop control variable
        }
        System.out.printf("After 10 years the balance is %.2f.\n", balance);
    }
}
