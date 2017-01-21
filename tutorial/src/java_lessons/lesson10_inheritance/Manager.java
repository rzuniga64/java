package java_lessons.lesson10_inheritance;

/**
 *  Manager class.
 *  When we write the constructor of the subclass we have to call the
 *  constructor of the superclass.
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
   private Manager(final String n, final int s, final String d) {
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

   @Override
   /**
    * Display the manager information.
    */
   public String display() {

      String empinfo = super.display();
      return empinfo + "Department: " + department + "\n";
   }

    /**
     * Set the salary.
     * @param e employee
     * @param amount amount of salary
     */
   public void setSalary(final Employee e, final double amount) {

       e.setSalary(amount);
   }
}
