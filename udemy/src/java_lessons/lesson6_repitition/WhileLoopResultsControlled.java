package java_lessons.lesson6_repitition;

public class WhileLoopResultsControlled
{
   public static void main(String[] args)
   {
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