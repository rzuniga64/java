package java_lessons.lesson10_inheritance;

/**
 * Employee class is the base or parent class from which the Manager class will
 * inherit.
 *
 * Inheritance is when a class inherits the features of another class.
 */
public class Employee {

    /** Name of a person. */
    private final String name;
   /** The salary of the person. */
    private double salary;

    /**
     * Constructor.
     * @param n the name
     * @param s the salary
     */
    private Employee(final String n, final double s) {
        name = n;
        salary = s;
    }

    /**
     * Get the name.
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Get the salary.
     * @return the salary
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Set salarty
     */
    public void setSalary(final double s) {
        this.salary = s;
    }

    /**
     * Display employee info.
     * @return employee info as a String
     */
    public String display() {
        return "Name: " + name + "\n" + "Salary: " + salary + "\n";
   }
}
