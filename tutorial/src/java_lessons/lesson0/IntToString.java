package java_lessons.lesson0;

import java.security.Permission;
import java.util.Scanner;

/**
 *  You are given an integer , you have to convert it into a string.
 *  Please complete the partially completed code in the editor. If your code
 *  successfully converts  into a string  the code will print "Good job".
 *  Otherwise it will print "Wrong answer". n can range between  to  inclusive.
 */
public final class IntToString {

    /** Constructor. */
    private IntToString() { }

    /**
     * Unit tests.
     * @param args args
     */
    public static void main(final String[] args) {

        String s = "";

        DoNotTerminate.forbidExit();

        try {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            in.close();

            if (-100 <= n && n <= 100) {
                s = Integer.toString(n);
            }
            if (n == Integer.parseInt(s)) {
                System.out.println("Good job");
            } else {
                System.out.println("Wrong answer.");
            }
        } catch (DoNotTerminate.ExitTrappedException e) {
            System.out.println("Unsuccessful Termination!!");
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}

/**
 *  The following class will prevent you from terminating the code using
 *  exit(0)!
 */
final class DoNotTerminate {

    /** Constructor. */
    private DoNotTerminate() { }

    /** ExitTrappedException class. */
    static class ExitTrappedException extends SecurityException {

        private static final long serialVersionUID = 1;
    }

    /** forbidExit class. */
    static void forbidExit() {
        final SecurityManager securityManager = new SecurityManager() {
            @Override
            public void checkPermission(final Permission permission) {
                if (permission.getName().contains("exitVM")) {
                    throw new ExitTrappedException();
                }
            }
        };
        System.setSecurityManager(securityManager);
    }
}
