package java_lessons.lesson0;

public class HelloOthers
{
   public static void main(String[] args) 
   {
      String name = "Bob"; 
      String greeting = "Hello";
      System.out.println(greeting + ", " + name);
      name = "Mary";
      System.out.println(greeting + ", " + name + "!");
      greeting = "Goodbye";
      System.out.println(greeting + ", " + name + "!");
   }
}