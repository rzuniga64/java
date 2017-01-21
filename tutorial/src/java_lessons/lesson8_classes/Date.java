package java_lessons.lesson8_classes;

class Date {

    private int month;
    private int day;
    private int year;

    Date(final int m, final int d, final int y) {
        month = m;
        day = d;
        year = y;
    }

    Date(final int m, final int y) {
        month = m;
        day = 0;
        year = y;
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
