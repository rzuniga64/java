package java_lessons.lesson2_classes;
class Date {
	private int month;
	private int day;
	private int year;
	
	Date(int m, int d, int y) {
		month = m;
		day = d;
		year = y;
	}
	
	Date(int m, int y) {
		month = m;
		day = 0;
		year = y;
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
	
	public void setMonth(int m) {
		month = m;
	}
	
	void setDay(int d) {
		day = d;
	}
	
	public void setYear(int y) {
		year = y;
	}
}