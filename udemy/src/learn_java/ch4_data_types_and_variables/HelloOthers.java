package learn_java.ch4_data_types_and_variables;

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