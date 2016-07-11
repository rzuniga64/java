package java_lessons.DataTypes;

// x / y - 3
// 1 / (x + y)
// the square root of x to the 6th plus y to the 5th
// absolute value of x + y

public class Formulas
{
   public static void main(String[] args)
   {
      double x,y,z;
      x = -13.0;
      y = 2.0;
      z = x/y-3;
      System.out.println(z);
      
      z = x/(y-3);
      System.out.println(z);
      
      z= Math.pow(x,6)+ Math.pow(y,5);
      System.out.println(z);    		 
      
      z = Math.abs(x + y);
      System.out.println(z);   
   }
}