package java_lessons.lesson13_flow_control;

/**
 * DoWhile class.
 *  do {
 *      set of statements;
 *      } while(relational expression);
*/
public final class DoWhile {

    /** Constructor. */
    private DoWhile() { }

    /**
    * Unit tests.
    * @param args the arguments
    */
   public static void main(final String[] args) {

      int number = 1;
      do {
         System.out.println(number);
         ++number;
      } while (number < 11); // (number <= 10)

       double balance, rate;
       int years = 0;
       balance = 400000;
       rate = 1.10;
       do {
           balance *= rate;
           ++years;
       } while (balance < 1000000);
       System.out.println("It will take " + years
               + " years to reach $1,000,000.");
   }
}