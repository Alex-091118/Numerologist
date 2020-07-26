package numerologist;

import java.time.LocalDate;
import java.util.List;

import data.Data;

public class Codes {
	public static final int HOURS_23 = 23;
	public static final int LUNAR_DAYS_28 = 28;
	public static final int DAYS_33 = 33;
	private List<Integer> yearCode;
	private List<Integer> monthCode;
	private Integer dayCode;
	private LocalDate dateOfBirth;
	private Data data;
	

	public Codes(LocalDate dateOfBirth, Data data) {
		this.dateOfBirth = dateOfBirth;
		this.data = data;
		setYearCode();
		setMonthCode();
		setDayCode();
	}

	private void setYearCode() {
		this.yearCode = data.getCodesYears().get(dateOfBirth.getYear());
	}

	private void setMonthCode() {
		if (dateOfBirth.lengthOfMonth() == 29) {
			this.monthCode = data.getCodesMonths().get(229);
		} else {
			this.monthCode = data.getCodesMonths().get(dateOfBirth.getMonthValue());
		}
	}

	private void setDayCode() {
		this.dayCode = dateOfBirth.lengthOfMonth() - dateOfBirth.getDayOfMonth();

	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(String.format("%15s = ", "Константы"))
				.append(String.format("|%2d|%2d|%2d|\n", HOURS_23, LUNAR_DAYS_28, DAYS_33))
				.append(String.format("%15s = ", "Код года (" + dateOfBirth.getYear() + ")"));
		for (Integer x : yearCode) {
			result.append(String.format("|%2d", x));
		}
		result.append("|\n").append(String.format("%15s = ", "Код месяца (" + dateOfBirth.getMonthValue() + ")"));
		for (Integer x : monthCode) {
			result.append(String.format("|%2d", x));
		}
		result.append("|\n").append(String.format("%15s = ", "Код дня (" + dateOfBirth.getDayOfMonth() + ")"))
				.append(String.format("|%2d|%2d|%2d|\n", dayCode, dayCode, dayCode));
		return result.toString();

	}

	public List<Integer> getYearCode() {
		return yearCode;
	}

	public List<Integer> getMonthCode() {
		return monthCode;
	}

	public Integer getDayCode() {
		return dayCode;
	}

	public static void main(String[] args) {
		Data data = Data.createData();
		Codes codes = new Codes(LocalDate.of(1914, 12, 31), data);
		System.out.println(codes.toString());
		System.out.println("program continue");

	}

}
