package java_lessons.lesson11_polymorphism;

// An interface is a class that has method names
// only but no method definitions.  When you inherit
// from an interface the class will have these features
// and in the inherited class you will define how those
// features work.  An interface is a contract that you
// are going to define a list of methods in the interface
// and any class that implements the interface must define
// those methods listed in the interface definition.
public interface Shape1
{
   public int getX();
   public int getY();
   public void setX(int xcor);
   public void setY(int ycor);
   public void draw();
}