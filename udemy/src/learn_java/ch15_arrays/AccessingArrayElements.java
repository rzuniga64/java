package learn_java.ch15_arrays;

// We will access array elements and initialize
// an array that has been declared but not initialized.
public class AccessingArrayElements
{
   public static void main(String[] args)
   {
      final int size = 10;
      // declare an array 
      int[] numbers = new int[size];  
      // initialize the array 
      for(int i = 0; i < size; ++i)
         numbers[i] = i+1;
      // access the array
      for(int number: numbers)
         System.out.print(number + " ");
      // let's total the array
      int total = 0;
      for(int i = 0; i < size; ++i)
         total += numbers[i];
      System.out.println("Total: " + total);
      // out of bounds exception (run-time error)
      // System.out.print("Out of bounds: " + numbers[10]);
   }
}