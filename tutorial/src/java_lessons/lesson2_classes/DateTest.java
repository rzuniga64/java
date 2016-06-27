package java_lessons.lesson2_classes;

public class DateTest {
	public static void main(String[] args) {
		Date today = new Date(12,26,2013);
		Date tomorrow = new Date(1,2014);
		System.out.println("Today is " + today.toString());
		tomorrow.setDay(5);
		System.out.println("tomorrow is " + tomorrow.toString());
		System.out.println("today is again " + today.getMonth() + "/" + today.getDay() + "/" + today.getYear());
		
	}
}
