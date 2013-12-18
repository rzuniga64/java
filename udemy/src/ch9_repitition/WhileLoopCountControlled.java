package ch9_repitition;

public class WhileLoopCountControlled
{
   public static void main(String[] args)
   {
      // balance, rate, number of years
      double balance = 5000;
      double rate = 1.02;
      // create a loop control variable
      int year = 1;
      while (year <= 10) {  		//test loop control variable
         balance = balance * rate; 	// balance *= rate;
         System.out.printf("After year " + year + ", the balance is %.2f\n", balance);
         ++year;					// modify loop control variable 
      }
      System.out.printf("After 10 years the balance is %.2f.\n", balance);
    
   }
}