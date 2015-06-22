package learn_java.ch10_methods;

public class PassByValue
{
   public static void main(String[] args)
   {
      int number = 12;
      System.out.println("number squared: " + square(number));
      System.out.println("original number: " + number);
   }

   static int square(int num) {
      num *= num;
      System.out.println("num in square method: " + num);
      return num;
   }

}