package java_lessons.lesson10_inheritance;

public class ProtectedMembers
{
   public static void main(String[] args) 
   {
      Employee e1 = new Employee("Jones", 20000);
      Manager m1 = new Manager("Smith", 40000, "IT");
      System.out.println(e1.displayEmpInfo());
      m1.setSalary(e1, 25000);
      System.out.println(e1.displayEmpInfo());
   }
}