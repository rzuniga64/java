package learn_java.ch16_flow_control;

//import java.util.ArrayList;

/*
for(variable declaration : collection-name) {
    set of statements;
}
*/


public class ForEachLoop
{
   public static void main(String[] args)
   {
      /*ArrayList<Integer> numbers = new ArrayList<Integer>();
      for(int i = 1; i < 11; ++i)
         numbers.add(i);
      for(int num : numbers)
         System.out.print(num + " ");*/
      int[] numbers = new int[10];
      for(int i = 0; i < 10; ++i)
         numbers[i] = i+1;
      for(int num : numbers)
         System.out.print(num + " ");
   }
}
        