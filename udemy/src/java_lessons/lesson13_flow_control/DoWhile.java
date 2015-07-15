package java_lessons.lesson13_flow_control;

public class DoWhile
{
   /*
   do {
      set of statements;
   } while(relational expression);
 
   */
   public static void main(String[] args)
   {
      int number = 1;
      do {
         System.out.println(number);
         ++number;
      } while(number < 11); // (number <= 10)
   }
}