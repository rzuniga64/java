package ch16_flow_control;

public class DoWhile2
{
   public static void main(String[] args) 
   {
      double balance, rate;
      int years = 0;
      balance = 400000;
      rate = 1.10;
      /*while (balance < 100000) {
         balance *= rate;
         ++years;
      }*/
      do {
         balance *= rate;
         ++years;
      } while (balance < 1000000);
      System.out.println("It will take " + years + " years to reach $1,000,000.");
   }
}