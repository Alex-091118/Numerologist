package numerologist;

import java.io.IOException;
import java.util.ArrayList;

public class Markers {

	Codes codes = new Codes();
	ArrayList<Integer> codeOfYear = codes.getYearCode();
	ArrayList<Integer> codeOfMonth = codes.getMonthCode();
	int codeOfDay = codes.getDayCode();

	public Markers() throws IOException {
	}

	public int getMarkerFK() {
		int marker = codeOfYear.get(0) + codeOfMonth.get(0) + codeOfDay;
		if (marker > Codes.HOURS_23) {
			while(marker > Codes.HOURS_23) {
				marker -= Codes.HOURS_23;
			}
			return marker;
		}
		return marker;
	}

	public int getMarkerEK() {
		int marker = codeOfYear.get(1) + codeOfMonth.get(1) + codeOfDay;
		if (marker > Codes.LUNAR_DAYS_28) {
			while(marker > Codes.LUNAR_DAYS_28) {
				marker -= Codes.LUNAR_DAYS_28;
			}
			return marker;
		}
		return marker;
	}

	public int getMarkerIK() {
		int marker = codeOfYear.get(2) + codeOfMonth.get(2) + codeOfDay;
		if (marker > Codes.DAYS_33) {
			while (marker > Codes.DAYS_33) {
				marker -= Codes.DAYS_33;
			}
			return marker;
		}
		return marker;
	}

	public static void main(String[] args) throws IOException {
		Markers m = new Markers();
		System.out.println(m.getMarkerFK());
		System.out.println(m.getMarkerEK());
		System.out.println(m.getMarkerIK());
		System.out.println("Расчёт произведён для даты " + DateInInt.getCalendarBirthDay().getTime());

	}

}
