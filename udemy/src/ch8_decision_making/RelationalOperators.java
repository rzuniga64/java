package ch8_decision_making;

public class RelationalOperators
{
   public static void main(String[] args)
   {
      /*
         == - equality
         > - greater than
         >= - greater than or equal to
         < - less than
         <= - less than or equal to
         != - not equal to
      */
      System.out.println(!("hello".equals("Hello")));
      System.out.println(2 <= 3);
      String password = "password";
      String mypassword = "passwrd";
      System.out.println(!(password.equals(mypassword)));
   }
}