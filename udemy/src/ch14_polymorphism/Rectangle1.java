package ch14_polymorphism;

// Develop a class from an interface
// An interface is another way to build complex
// hierchies in Java.
public class Rectangle1 implements Shape1
{
   private int x;
   private int y;
   private int width;
   private int height;

   Rectangle1(int xcor, int ycor, int w, int h) {
      x = xcor;
      y = ycor;
      width = w;
      height = h;
   }

   public int getWidth()  { return width; }
   public int getHeight() { return height; }
   public void setWidth(int w) { width = w; }
   public void setHeight(int h) { height = h; }  
   
   // Must implement the methods listed in the Shape1 interface
   @Override
   public int getX() {return x;}
   @Override
   public int getY() {return y;}
   @Override
   public void setX(int xcor) {x = xcor;}
   @Override
   public void setY(int ycor) {y = ycor;}
   @Override
   public void draw() {
      System.out.println("Drawing a rectangle at x: " + getX() + ", y: " + getY() 
              + "width: " + getWidth() + ", height: " + getHeight());
   }
}