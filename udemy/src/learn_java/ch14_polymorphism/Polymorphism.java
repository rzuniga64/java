package learn_java.ch14_polymorphism;
 
// Test program to show how draw differs for 
// a Circle object and a Rectangle object
// using polymorphism.

public class Polymorphism
{
   public static void main(String[] args) 
   {
      Circle c1 = new Circle(10,20,5);
      Rectangle r1 = new Rectangle(50,100,10,20);
      c1.draw();
      System.out.println();
      r1.draw();
   }
}