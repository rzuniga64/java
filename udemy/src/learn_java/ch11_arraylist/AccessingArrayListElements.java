package learn_java.ch11_arraylist;

import java.util.ArrayList;

public class AccessingArrayListElements
{
   public static void main(String[] args) 
   {
      ArrayList<Integer> numbers = new ArrayList<Integer>();
      for(int i = 1; i < 11; ++i)
         numbers.add(i);
      int total = 0;
      for(int number: numbers)
         total += number;
      System.out.println("The total is " + total);
      System.out.println("First element: " + numbers.get(0));
      System.out.println("Last element: " + numbers.get(numbers.size()-1));
      display(numbers);
   }

   static void display(ArrayList arr) {
      for(int i = 0; i < arr.size(); ++i)
         System.out.print(arr.get(i) + " ");
   }
}