package numerologist;

import java.util.Calendar;

public class DateInInt {
	
	private int dayOfBirth;
	private int monthOfBirth;
	private int yearOfBirth;
	
	private static Calendar calendarBirthDay = new Input().getDateOfBirth();
		
	public int getDayOfBirth() {
		dayOfBirth = calendarBirthDay.get(Calendar.DAY_OF_MONTH);
		return dayOfBirth;
	}
	public int getMonthOfBirth() {
		monthOfBirth = calendarBirthDay.get(Calendar.MONTH) + 1;
		return monthOfBirth;
	}
	public int getYearOfBirth() {
		yearOfBirth = calendarBirthDay.get(Calendar.YEAR);
		return yearOfBirth;
	}
	public void setDayOfBirth(int dayOfBirth) {
		this.dayOfBirth = dayOfBirth;
	}
	public void setMonthOfBirth(int monthOfBirth) {
		this.monthOfBirth = monthOfBirth;
	}
	public void setYearOfBirth(int yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}
	public static Calendar getCalendarBirthDay() { 
		return calendarBirthDay;
	}
	

	public static void main(String[] args) {
		DateInInt number = new DateInInt();
		System.out.println(number.getDayOfBirth());
		System.out.println(number.getMonthOfBirth());
		System.out.println(number.getYearOfBirth());
	}
	
}
