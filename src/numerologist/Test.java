package numerologist;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Test {
		
	public static void main(String[] args) {
//		Date date = new Date();
//		Date dateOfBirth = DateInInt.getCalendarBirthDay().getTime();
//		LocalDate currentDate = LocalDate.now();
//		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
//		LocalDate birthDay = LocalDate.parse(Input.getDateOfBirthString(), dtf);
//		
//		
//		
//		System.out.println(birthDay.get(ChronoField.YEAR));
//		System.out.println(ChronoUnit.YEARS.between(birthDay, currentDate));
//		System.out.println(date);
//		System.out.println(dateOfBirth);
//		System.out.println(currentDate);
//		System.out.println(birthDay);
		int result = 37;
		while(result > 9) {
		result = result / 10 + result % 10;
		}
		System.out.println(result);
	}
}
