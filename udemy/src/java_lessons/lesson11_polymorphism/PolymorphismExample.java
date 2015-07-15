package java_lessons.lesson11_polymorphism;

// Test program where we aren't even sure what type of 
// object it is but we are going to call the Draw method 
// for it and see if it picks the right type of method for
// that object.

import java.util.ArrayList;

public class PolymorphismExample
{
   public static void main(String[] args)
   {
      ArrayList<Shape> shapes = new ArrayList<Shape>();
      Circle c1 = new Circle(10,20,5);
      Rectangle r1 = new Rectangle(50,50,10,20);
      shapes.add(c1);
      shapes.add(r1);
      for(int i = 0; i < shapes.size(); ++i)
         shapes.get(i).draw();
   }
}      