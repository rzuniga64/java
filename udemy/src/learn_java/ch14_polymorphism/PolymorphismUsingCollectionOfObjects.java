package learn_java.ch14_polymorphism;

import java.util.ArrayList;

public class PolymorphismUsingCollectionOfObjects
{
   public static void main(String[] args)
   {
      Employee e1 = new Employee("Smith", 20000);
      Manager m1 = new Manager("Brown", 40000, "IT");
      Employee e2 = new Employee("Jones", 30000);
      Manager m2 = new Manager("Green", 50000, "Sales");
      ArrayList<Employee> emps = new ArrayList<Employee>();
      emps.add(e2);
      emps.add(m1);
      emps.add(e1);
      emps.add(m2);
      for(int i = 0; i < emps.size(); ++i)
         System.out.println(emps.get(i).displayEmpInfo());
   }
}