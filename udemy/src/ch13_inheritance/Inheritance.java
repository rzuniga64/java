package ch13_inheritance;

public class Inheritance
{
   public static void main(String[] args) 
   {
      Employee e1 = new Employee("Brown", 30000);
      System.out.println(e1.getName() + ": " + e1.getSalary());
      Manager m1 = new Manager("Smith", 50000, "Sales");
      System.out.println(m1.getName());
      System.out.println(m1.getSalary());
      System.out.println(m1.getDepartment());
      //m1.raise(.2);
      System.out.println(m1.getSalary());
   }
}