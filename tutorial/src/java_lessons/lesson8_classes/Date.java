package java_lessons.lesson8_classes;

/**
 * Date class
 * - Use encapsulation and data hiding to limit access to data from outside
 * the class.
 * - Constructors are used to initialize data members to a value.
 * - Constructors have same name as the class. They don't have a return type.
 */
class Date {

    private int month;
    private int day;
    private int year;

    /**
     * Fully parametized constructor.
     * @param m month
     * @param d day
     * @param y year
     */
    Date(final int m, final int d, final int y) {

        month = (m < 0 || m > 24) ? 0 : m;
        day = (d < 0 || d > 31) ? 0 : d;
        year = (y < 0) ? 0 : y;
    }

    Date(final int m, final int y) {
        
        month = (m < 0 || m > 24) ? 0 : m;
        day = 0;
        year = (y < 0) ? 0 : y;
    }

    Date() {
        month = 0;
        day = 0;
        year = 0;
    }

    public String toString() {
        return month + "/" + day + "/" + year;
    }

    int getMonth() {
        return month;
    }

    int getDay() {
        return day;
    }

    int getYear() {
        return year;
    }

    public void setMonth(final int m) {
        month = m;
    }

    void setDay(final int d) {
        day = d;
     }

    public void setYear(final int y) {
        year = y;
    }

    public static void main(final String[] args) {

        Date today = new Date(12, 26, 2013);
        Date tomorrow = new Date(1, 2014);
        System.out.println("Today is " + today.toString());
        tomorrow.setDay(5);
        System.out.println("tomorrow is " + tomorrow.toString());
        System.out.println("today is again " + today.getMonth() + "/"
                + today.getDay() + "/" + today.getYear());
    }
}
