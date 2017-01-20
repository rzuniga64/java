package java_lessons.lesson4_decision_making;

/**
 * LogicalOperators class.
 * && And logical operator
 * || Or logical operator
 */
public final class LogicalOperators {

   /** Constructor. */
   private LogicalOperators() { }

   /**
    * Unit tests.
    * @param args the arguments.
    */
   public static void main(final String[] args) {
      int hoursWorked = 39;
      int salary = 47000;
      System.out.println((hoursWorked > 40) && (salary <= 50000));
      String passwd = "GUEST";
      System.out.println((passwd.equals("guest")) || (passwd.equals("GUEST")));
   }
}
