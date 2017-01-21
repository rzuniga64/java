package java_lessons.lesson8_classes;

/**
 * Date class
 * - Use encapsulation and data hiding to limit access to data from outside
 * the class.
 * - Constructors are used to initialize data members to a value.
 * - Constructors have same name as the class. They don't have a return type.
 * - Overloading allows you to overload a definition with another definition.
 */
public final class  Date {
    /** Month variable. */
    private int month;
    /** Day variable. */
    private int day;
    /** Year variable. */
    private int year;

    /**
     * Fully parametized constructor.
     * @param m month
     * @param d day
     * @param y year
     */
    private Date(final int m, final int d, final int y) {

        month = (m < 0 || m > 24) ? 0 : m;
        day = (d < 0 || d > 31) ? 0 : d;
        year = (y < 0) ? 0 : y;
    }

    /**
     * Overloaded constructor.
     * @param m month
     * @param y year
     */
    private Date(final int m, final int y) {

        month = (m < 0 || m > 24) ? 0 : m;
        day = 0;
        year = (y < 0) ? 0 : y;
    }

    /** Default constructor. */
    private Date() {
        month = 0;
        day = 0;
        year = 0;
    }

    /**
     * Display the state of the object at any particular time.
     * @return the object as a string
     */
    public String toString() {
        return getMonth() + "/" + getDay() + "/" + getYear();
    }

    /**
     * Get the month.
     * @return the month.
     */
    public int getMonth() {
        return month;
    }

    /**
     * Get the day.
     * @return the day.
     */
    public int getDay() {
        return day;
    }

    /**
     * Get the year.
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * Set the month.
     * @param m the month
     */
    public void setMonth(final int m) {
        month = m;
    }

    /**
     * Set the day.
     * @param d the day
     */
    void setDay(final int d) {
        day = d;
     }

    /**
     * Set the year.
     * @param y the year.
     */
    public void setYear(final int y) {
        year = y;
    }

    /**
     * Are two object equal?
     * @param d the date
     * @return true if objects are equal; false otherwise
     */
    public boolean equals(final Date d) {

        return (getMonth() == d.getMonth() && getDay() == d.getDay()
                && getYear() == d.getYear());
    }

    /**
     * Unit tests.
     * @param args the arguments.
     */
    public static void main(final String[] args) {

        Date today = new Date(12, 26, 2013);
        Date tomorrow = new Date(1, 2014);
        System.out.println("Today is " + today.toString());
        tomorrow.setDay(5);
        System.out.println("tomorrow is " + tomorrow.toString());
        System.out.println("today is again " + today.getMonth() + "/"
                + today.getDay() + "/" + today.getYear());
        System.out.println("Do two dates equal? " + today.equals(tomorrow));
    }
}
