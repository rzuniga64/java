package java_lessons.lesson9_oop;

public class ExerciseTime
{
   public static void main(String[] args) 
   {
      Time theTime = new Time(9,0,0);
      Time aTime = new Time(9,0,0);
      if (theTime.equals(aTime))
         System.out.println("The same time");
      else
         System.out.println("Different time");
   }
}