package learn_java.ch9_repitition;

public class ForLoop2
{
   public static void main(String[] args)
   {
      double balance = 5000;
      double rate = 1.02;
      
      for(int i = 1; i <= 10; ++i) {
         balance *= rate;
      }
      System.out.println("The balance after 10 years is " + balance);
   }
}