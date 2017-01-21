package java_lessons.lesson11_polymorphism;

/**
 *  Manager class.
 */
public class Manager extends Employee {

   /** Department. */
   private String department;

   /**
    * Constructor.
    * @param n name
    * @param s salary
    * @param d department
    */
   Manager(final String n, final int s, final String d) {
      super(n, s);  // call the constructor of the superclass.
      department = d;
   }

    /**
     * Get department.
     * @return department
     */
    public String getDepartment() {

        return department;
    }


    /**
     * Set the salary.
     * @param e employee
     * @param amount amount of salary
     */
    public void setSalary(final Employee e, final double amount) {

        e.salary = amount;
    }

   @Override
   /**
    * Display the manager information.
    */
   public String display() {

       String empinfo = super.display();
       return empinfo + "Department: " + department + "\n";
   }
}
