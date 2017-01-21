package java_lessons.lesson10_inheritance;

/**
 * Employee class is the base or parent class from which the Manager class will
 * inherit.
 *
 * Inheritance is when a class inherits the features of another class.
 * Protected means any inheriting class also has access to the member.
 * Protected is defined as allowing access to the superclass and subclass
 * inheriting from the superclass.
 * Use protected for salary since we want to set salary from Manager class.
 */
public class Employee {

    /** Name of a person. */
    private final String name;
   /** The salary of the person. */
    protected double salary;

    /**
     * Constructor.
     * @param n the name
     * @param s the salary
     */
    Employee(final String n, final double s) {
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
     * Display employee info.
     * @return employee info as a String
     */
    public String display() {
        return "Name: " + name + "\n" + "Salary: " + salary + "\n";
   }
}
