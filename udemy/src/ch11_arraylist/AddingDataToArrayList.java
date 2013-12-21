package ch11_arraylist;

import java.util.ArrayList;

public class AddingDataToArrayList
{
   public static void main(String[] args) 
   {
      ArrayList<Integer> numbers = new ArrayList<Integer>();
      System.out.println("The size of numbers: " + numbers.size());
      numbers.add(0);
      System.out.println("The size of numbers: " + numbers.size());
      for(int i = 1; i <= 10; ++i)
         numbers.add(i);
      System.out.println("The size of numbers: " + numbers.size());
   }
}