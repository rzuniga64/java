package java_lessons.lesson11_polymorphism;

public class Rectangle extends Shape
{
   private int width;
   private int height;

   Rectangle(int xcoor, int ycoor, int w, int h) {
      super(xcoor, ycoor);
      width = w;
      height = h;
   }

   public int getWidth()  { return width; }
   public int getHeight() { return height; }
   public void setWidth(int w) { width = w; }
   public void setHeight(int h) { height = h; }

   @Override
   public void draw() {
      System.out.println("Drawing a rectangle at x: " + getX() + ", y: " + getY() 
              + "width: " + getWidth() + ", height: " + getHeight());
   }
}