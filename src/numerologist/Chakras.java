package numerologist;

import java.util.List;

public class Chakras {

	private String chakras;
	private Markers markers;
	private Data data;
	private List<String> chakraPhysCont;
	private List<String> chakraEmotCont;
	private List<String> chakraIntelCont;
	private List<String> table3;

	public Chakras(Markers markers, Data data) {
		this.markers = markers;
		this.data = data;
		setChakraPhysCont();
		setChakraEmotCont();
		setChakraIntelCont();
		setChakras();
		setTable3();

	}

	private void setChakraPhysCont() {
		this.chakraIntelCont = data.getIntellectCont().get(markers.getMarkerIntelCont());

	}

	private void setChakraEmotCont() {
		this.chakraEmotCont = data.getEmotionCont().get(markers.getMarkerEmotCont());

	}

	private void setTable3() {
		boolean stop = false;
		for (String key : data.getMapT3().keySet()) {
			for (String marker : key.split(",")) {
				if (marker.equals(Integer.toString(markers.getMarkerEmotCont()))) {
					this.table3 = data.getMapT3().get(key);
					stop = true;
					break;
				}
			}
			if (stop)
				break;
		}
	}

	private void setChakraIntelCont() {
		this.chakraPhysCont = data.getPhysicalCont().get(markers.getMarkerPhysCont());

	}

	private void setChakras() {
		this.chakras = chakraPhysCont.get(0) + "-" + chakraEmotCont.get(0) + "-" + chakraIntelCont.get(0);
	}

	public String getChakras() {
		return chakras;
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("\nЧакры: " + getChakras())
				.append("\nФизический контур: ").append(chakraPhysCont.get(0)).append(" ").append(chakraPhysCont.get(1))
				.append("\nЭмоциональный контур: ").append(chakraEmotCont.get(0)).append(" ").append(chakraEmotCont.get(1))
				.append("\nИнтеллектуальный контур: ").append(chakraIntelCont.get(0)).append(" ").append(chakraIntelCont.get(1))
				.append("\nЭмоциональный тип реактивности: ").append(table3.get(0))
				.append("\nЯ - ").append(table3.get(1)).append(" Мы - ").append(table3.get(2)).append("\n");
		return result.toString();
	}

}
