package java_lessons.lesson1;

/**
 * An enumerated data type is a programmer defined data type.
 * It consists of values known as enumerators. Example:
 * - Day is a data type, it’s values are:
 * - MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY
 * - Operations that work over enum values:
 * - =, ==, !=, <, <=, >, >=, can use as case labels in switch stmt
 *
 * When the enum is declared public inside a class, the typename and values must include the class name and scope
 * resolution operator outside the class
 */

public class EnumeratedTypes {

    private enum Day {
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
        THURSDAY, FRIDAY, SATURDAY
    }

    private Day day;

    private EnumeratedTypes(Day day) {
        this.day = day;
    }

    private void tellItLikeItIs() {
        switch (day) {
            case MONDAY:
                System.out.println("Mondays are bad.");
                break;

            case FRIDAY:
                System.out.println("Fridays are better.");
                break;

            case SATURDAY: case SUNDAY:
                System.out.println("Weekends are best.");
                break;

            default:
                System.out.println("Midweek days are so-so.");
                break;
        }
    }

    public static void main(String[] args) {
        EnumeratedTypes firstDay = new EnumeratedTypes(Day.MONDAY);
        firstDay.tellItLikeItIs();
        EnumeratedTypes thirdDay = new EnumeratedTypes(Day.WEDNESDAY);
        thirdDay.tellItLikeItIs();
        EnumeratedTypes fifthDay = new EnumeratedTypes(Day.FRIDAY);
        fifthDay.tellItLikeItIs();
        EnumeratedTypes sixthDay = new EnumeratedTypes(Day.SATURDAY);
        sixthDay.tellItLikeItIs();
        EnumeratedTypes seventhDay = new EnumeratedTypes(Day.SUNDAY);
        seventhDay.tellItLikeItIs();
    }
}

