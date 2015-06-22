package learn_java.ch14_polymorphism;

/* An abstract class that can be inherited from 
   but can not be instantiated directly.  Used as
   a basis to create other classes. For Example,
   we don't normally want to create a Shape we want
   to implement a type of Shape(Circle, Rectangle,etc).

   To make a class a superclass while not allowing a 
   user to instantaiate it is to make it abstract.
*/

public abstract class Shape
{
   private int x;
   private int y;

   Shape(int xcor, int ycor) {
      x = xcor;
      y = ycor;
   }

   public int getX() {
      return x;
   }
  
   public int getY() {
      return y;
   }

   public void setX(int xcor) {
      x = xcor;
   }

   public void setY(int ycor) {
      y = ycor;
   }

   public void set(int xcor, int ycor) {
      setX(xcor);
      setY(ycor);
   }

   public void move(int x1, int y1) {
      set(getX() + x1, getY() + y1);
   }

   // Abstract method. A class that inherits from Shape1
   // must implement a draw method but not necessarily 
   // inherit the Shape1's draw method.  It doesn't make
   // sense to have a draw method for shape because we 
   // haven't defined the shape.  So rather than have a 
   // body that does something meaningless it's better to 
   // make the method abstract and then implement in a 
   // subclass for a particular type of shape.
   public abstract void draw();
}

