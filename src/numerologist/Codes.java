package numerologist;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;

public class Codes {

	public static final int HOURS_23 = 23;
	public static final int LUNAR_DAYS_28 = 28;
	public static final int DAYS_33 = 33;

	public Codes() throws IOException {
	}

	private Map<Integer, ArrayList<Integer>> years = Mapper.getMapInt("years.xls");
	private Map<Integer, ArrayList<Integer>> months = Mapper.getMapInt("months.xls");
	private DateInInt dateInInt = new DateInInt();

	public ArrayList<Integer> getYearCode() {
		return years.get(dateInInt.getYearOfBirth());
	}

	public ArrayList<Integer> getMonthCode() {
		boolean leap = DateInInt.getCalendarBirthDay().getActualMaximum(Calendar.DAY_OF_MONTH) == 29;
		if (leap) {
			return months.get(229);
		} else {
			return months.get(dateInInt.getMonthOfBirth());
		}

	}

	public int getDayCode() {
		return DateInInt.getCalendarBirthDay().getActualMaximum(Calendar.DAY_OF_MONTH) - dateInInt.getDayOfBirth();
	}

	public static void main(String[] args) throws IOException {
		Codes codes = new Codes();
		System.out.println(codes.getYearCode());
		System.out.println(codes.getMonthCode());
		System.out.println(codes.getDayCode());
		System.out.println("Расчёт произведён для даты " + DateInInt.getCalendarBirthDay().getTime());

	}

}
