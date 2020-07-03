package numerologist;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class Chakras {

	private Map<Integer, ArrayList<String>> physicalCont = Mapper.getMapString("fk.xls");
	private Map<Integer, ArrayList<String>> emotionCont = Mapper.getMapString("ek.xls");
	private Map<Integer, ArrayList<String>> intellectCont = Mapper.getMapString("ik.xls");
	private Map<String, ArrayList<String>> mapT3 = Mapper.getMapT3("t3.xls");

	Markers markers = new Markers();

	public Chakras() throws IOException {
	}

	String t3() {
		String result = "";
		boolean stop = false;
		for (String x : mapT3.keySet()) {
			String[] arr = x.split(",");
			for (String s : arr) {
				if (s.equals(Integer.toString(markers.getMarkerEK()))) {
					result = "Эмоциональный тип реактивности: " + mapT3.get(x).get(0) + "\nЯ - " + mapT3.get(x).get(1)
							+ " Мы - " + mapT3.get(x).get(2);
					stop = true;
				}
			}
			if (stop) {
				break;
			}
		}

		return result;

	}

	String getChakrasToString() {
		return physicalCont.get(markers.getMarkerFK()).get(0) + "-" + emotionCont.get(markers.getMarkerEK()).get(0)
				+ "-" + intellectCont.get(markers.getMarkerIK()).get(0);
	}

	String descriptionChak() {
		String fkCh = physicalCont.get(markers.getMarkerFK()).get(0);
		String ekCh = emotionCont.get(markers.getMarkerEK()).get(0);
		String ikCh = intellectCont.get(markers.getMarkerIK()).get(0);
		String fk = physicalCont.get(markers.getMarkerFK()).get(1);
		String ek = emotionCont.get(markers.getMarkerEK()).get(1);
		String ik = intellectCont.get(markers.getMarkerIK()).get(1);
		return "Физический контур: " + fkCh + " " + fk + "\nЭмоциональный контур: " + ekCh + " " + ek
				+ "\nИнтеллектуальный контур: " + ikCh + " " + ik;
	}

	void printChakras() {
		System.out.println("Чакры: " + getChakrasToString());
		System.out.println(descriptionChak());
		System.out.println(t3());
	}

	public static void main(String[] args) throws IOException {

		Chakras chakras = new Chakras();
		System.out.println("Чакры: " + chakras.getChakrasToString());
		System.out.println(chakras.descriptionChak());
	
		System.out.println(chakras.t3());
		System.out.println("Расчёт произведён для даты " + DateInInt.getCalendarBirthDay().getTime());

	}

}
