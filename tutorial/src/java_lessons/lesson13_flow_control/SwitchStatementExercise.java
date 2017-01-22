package java_lessons.lesson13_flow_control;

/**
 * SwitchStatementExercise class.
 */
public final class SwitchStatementExercise {

    /** Constructor. */
    private SwitchStatementExercise() { }

    /**
     * Unit tests.
     * @param args the arguments.
     */
    public static void main(final String[] args) {

        double n1, n2;
        n1 = 23;
        n2 = 11;
        System.out.println(calc(n1, n2, '+'));
        System.out.println(calc(n1, n2, '-'));
        System.out.println(calc(n1, n2, '*'));
        System.out.println(calc(n1, n2, '/'));
    }

    /**
     *  Operation function.
     *  @param num1 number
     *  @param num2 number
     *  @param op operation
     *  @return the result of the calculation
     */
    private static double calc(final double num1, final double num2,
                               final char op) {
        /*if (op == '+')
            return num1 + num2;
        else if (op == '-')
            return num1 - num2;
        else if (op == '*')
            return num1 * num2;
        else if (op == '/')
            return num1 / num2;
        else
            return 0; */

        double result;
        switch (op) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            default:
                return 0;
        }
        return result;
   }
}
