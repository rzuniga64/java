package ch12_oop;

import ch12_oop.Time;

public class SetAndGetMethods
{
   public static void main(String[] args) 
   {
      Time theTime = new Time();
      theTime.setTime(13, 2, 0);
      System.out.println(theTime.display());
      theTime.setHours(15);
      System.out.println(theTime.display());
      System.out.println("The hour is: " + theTime.getHours());
   }
}