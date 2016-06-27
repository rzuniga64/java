package java_lessons.lesson5_decision_making;

public class LogicalOperators
{
   public static void main(String[] args)
   {
      // && - And logical operator
      // || - Or logical operator

      int hoursWorked = 39;
      int salary = 47000;
      System.out.println((hoursWorked > 40) && (salary <= 50000));
      String password = "GUEST";
      System.out.println((password.equals("guest")) || (password.equals("GUEST")));
   }
}