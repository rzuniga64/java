package learn_java.ch10_methods;

// A method is a set of instructions that performs a named operation.
// It takes data as input and may return data as output.

public class DefiningAMethodPart1
{
   public static void main(String[] args) 
   {
      int num = 12;
      System.out.println(num + " squared equals " + square(num));     
   }

    // Static means an independent method.
    // Parameters must match in data type and number.
   static int square(int number) {
      return number * number;
   }
}