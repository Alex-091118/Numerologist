package numerologist;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import data.Data;

public class Markers {
	
	private int markerPhysCont;
	private int markerEmotCont;
	private int markerIntelCont;
	private Codes codes;
	
	public Markers(Codes codes) {
		this.codes = codes;
		setMarkerPhysCont(getMarkersList().get(0));
		setMarkerEmotCont(getMarkersList().get(1));
		setMarkerIntelCont(getMarkersList().get(2));
	}
	
	private List<Integer> getMarkersList() {
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < codes.getYearCode().size(); i++) {
			Integer marker = codes.getYearCode().get(i) + codes.getMonthCode().get(i) + codes.getDayCode();
			result.add(marker);
		}
		return result;
	}
	
	public int getMarkerPhysCont() {
		return markerPhysCont;
	}

	public int getMarkerEmotCont() {
		return markerEmotCont;
	}

	public int getMarkerIntelCont() {
		return markerIntelCont;
	}
	

	private void setMarkerPhysCont(int markerPhysCont) {
		if (markerPhysCont == 0) {
			this.markerPhysCont = Codes.HOURS_23;
		} else {
			while (markerPhysCont > Codes.HOURS_23) {
				markerPhysCont -= Codes.HOURS_23;
			}
			this.markerPhysCont = markerPhysCont;
		}
	
	}

	private void setMarkerEmotCont(int markerEmotCont) {
		if (markerEmotCont == 0) {
			this.markerEmotCont = Codes.LUNAR_DAYS_28;
		} else {
			while (markerEmotCont > Codes.LUNAR_DAYS_28) {
				markerEmotCont -= Codes.LUNAR_DAYS_28;
			}
			this.markerEmotCont = markerEmotCont;
		}

	}

	private void setMarkerIntelCont(int markerIntelCont) {
		if (markerIntelCont == 0 ) {
			this.markerIntelCont = Codes.DAYS_33;
		} else {
			while (markerIntelCont > Codes.DAYS_33) {
				markerIntelCont -= Codes.DAYS_33;
			}
			this.markerIntelCont = markerIntelCont;
		}

	}

	public String toString() {
		return String.format("Маркеры \n%-25s%2d\n%-25s%2d\n%-25s%2d\n", "Физический контур:", markerPhysCont, 
				"Эмоциональный контур:", markerEmotCont, "Интеллектуальный контур:", markerIntelCont);
	}

	public static void main(String[] args) {
		System.out.println(new Markers(new Codes(LocalDate.of(1914, 06, 30), Data.createData())).toString());

	}

}
