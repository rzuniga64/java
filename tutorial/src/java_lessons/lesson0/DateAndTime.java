package java_lessons.lesson0;

import java.util.*;

/**
 *  The Calendar class is an abstract class that provides methods for converting
 *  between a specific instant in time and a set of calendar fields such as
 *  YEAR, MONTH, DAY_OF_MONTH, HOUR, and so on, and for manipulating the
 *  calendar fields, such as getting the date of the next week.
 *
 *  You are given a date. Your task is to find what the day is on that date.
 *
 *  Input Format
 *  A single line of input containing the space separated month, day and year,
 *  respectively, in M M D D Y Y Y Y  format.
 *
 *  Constraints
 *  2000 < year < 3000
 *
 *  Output Format
 *  Output the correct day in capital letters.
 *
 *  Sample Input
 *  08 05 2015
 *
 *  Sample Output
 *  WEDNESDAY
 *
 *  Explanation
 *  The day on August 5th 2015  was WEDNESDAY.
 */
public final class DateAndTime {

    /** Constructor. */
    private DateAndTime() { }

    /**
     * Unit tests.
     * @param args args
     */
    public static void main(final String[] args) {
        Scanner in = new Scanner(System.in);
        String month = in.next();
        String day = in.next();
        String year = in.next();

        int y = Integer.parseInt(year);
        if (2000 <= y && y <= 3000) {
            Calendar rightNow = Calendar.getInstance();
            rightNow.set(Integer.parseInt(year)  , Integer.parseInt(month)-1 , Integer.parseInt(day));
            String dayOfWeek = rightNow.getDisplayName(Calendar.DAY_OF_WEEK , Calendar.LONG, Locale.getDefault());
            System.out.println(dayOfWeek.toUpperCase());
        }
    }
}
