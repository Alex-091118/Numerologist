package numerologist;

public class ChakrasAnalyze {

	private Chakras chakras;
	private int yan;
	private int in;
	private int logic;
	private int intuition;
	private int sp;
	private int iCan;
	private int iWant;

	public ChakrasAnalyze(Chakras chakras) {
		this.chakras = chakras;
		setFields();
	}

	private int[] toIntArray(String chakra) {
		String[] array = chakra.split("-");
		int[] arrayInt = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			arrayInt[i] = Integer.valueOf(array[i]);
		}
		return arrayInt;
	}

	private void setFields() {
		int[] chakrArr = toIntArray(chakras.getChakras());
		yan = chakrArr[1] + chakrArr[2] + chakrArr[3];
		in = chakrArr[0] + chakrArr[4] + chakrArr[5];
		logic = chakrArr[3] + chakrArr[5];
		intuition = chakrArr[2] + chakrArr[4];
		if (yan == in) {
			sp = yan * chakrArr[1];
		} else {
			sp = Math.abs(yan - in) * chakrArr[1];
		}
		iCan = chakrArr[0];
		if (yan == in) {
			iWant = yan;
		} else {
			iWant = Math.abs(yan - in);
		}
	}
	
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("\nßÍÜ: ").append(yan).append("\n")
				.append("ÈÍÜ: ").append(in).append("\n")
				.append("Ëîãèêà: ").append(logic).append("\n")
				.append("Èíòóèöèÿ: ").append(intuition).append("\n")
				.append("ÑÏ: ").append(sp).append("\n")
				.append("Õî÷ó: ").append(iWant).append(" Ìîãó: ").append(iCan).append("\n");
		return result.toString();
	}

	public int getYan() {
		return yan;
	}

	public int getIn() {
		return in;
	}

	public int getLogic() {
		return logic;
	}

	public int getIntuition() {
		return intuition;
	}

	public int getSp() {
		return sp;
	}

	public int getiCan() {
		return iCan;
	}

	public int getiWant() {
		return iWant;
	}



}
