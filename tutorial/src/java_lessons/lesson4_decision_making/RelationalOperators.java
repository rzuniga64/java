package java_lessons.lesson4_decision_making;

/**
 *  RelationalOperators class.
 *  ==  equality
 *  >   greater than
 *  >=  greater than or equal to
 *  <   less than
 *  <=  less than or equal to
 *  !=  not equal to
 */
public final class RelationalOperators {

    /** Constructor. */
    private RelationalOperators() { }

    /**
     * Unit tests.
     * @param args the arguments.
     */
   public static void main(final String[] args) {

      System.out.println(!("hello".equals("Hello")));
      System.out.println(2 <= 3);
      String password = "password";
      String mypassword = "passwrd";
      System.out.println(!(password.equals(mypassword)));
   }
}
