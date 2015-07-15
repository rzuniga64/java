package java_lessons.lesson11_polymorphism;

public class InheritFromAbstractClass
{
   public static void main(String[] args)
   {
        //Shape is abstract so cannot be instantiated
        //Shape1 s1 = new Shape1(3,3);
        Circle c1 = new Circle(5,10,5);
        c1.draw();
        Rectangle r1 = new Rectangle(5,10, 10, 10);
        r1.draw();
   }
}