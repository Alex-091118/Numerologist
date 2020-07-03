package numerologist;

import java.io.IOException;

public class LifeCode {
	String date = Input.getDateOfBirthString();
	
	int[] toIntArray(String st) {
		char[] array = st.replace(".", "").toCharArray();
		int [] arrayInt = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			arrayInt[i] = array[i] - '0';
		}
		return arrayInt;
	}
	
	int calcTypology() {
		int [] dateArray = toIntArray(date);
		int result = 0;
		for (int i = 0; i < dateArray.length; i++) {
			result += dateArray[i];
		}
		while (result > 9) {
			result = result / 10 + result % 10;
			}
		return result;
	}
	
	String calcTopPartLifeCode() {
		int [] dateArray = toIntArray(date);
		int firstNum = dateArray[0] + dateArray[1] + dateArray[2] + dateArray[3];
		while (firstNum > 9) {
			firstNum = firstNum / 10 + firstNum % 10;
		}
		int topPart = Integer.valueOf(date.replace(".", "").substring(0, 4)) * 
				Integer.valueOf(date.replace(".", "").substring(4, 8));
		String[] topPartArray = Integer.toString(topPart).split("");
		
		StringBuilder result = new StringBuilder();
		result.append(firstNum).append("/").append(topPartArray[0]).append("/");
		for(int i = 1; i < topPartArray.length; i++) {
			result.append(topPartArray[i]);
		}
		return result.toString();
	}
	
	String calcBottomPartLifeCode() {
		String topPart = calcTopPartLifeCode();
		int typo = calcTypology();
		char[] topPartArray = topPart.replace("/", "").toCharArray();
		int[] topArray = new int[topPartArray.length];
		for (int i = 0; i < topPartArray.length; i++) {
			topArray[i] = topPartArray[i] - '0';
		}
		int[] botPartArray = new int[topArray.length];
		for(int i = 0; i < topArray.length; i++) {
			botPartArray[i] = topArray[i] + typo;
			while (botPartArray[i] > 9) {
				botPartArray[i] = botPartArray[i] / 10 + botPartArray[i] % 10;
			}
		}
		StringBuilder result = new StringBuilder();
		result.append(botPartArray[0]).append("/").append(botPartArray[1]).append("/");
		for(int i = 2; i < botPartArray.length; i++) {
			result.append(botPartArray[i]);
		}
		return result.toString();
		
	}
	
	void printLifeCode() {
		System.out.println();
		System.out.println("Код жизни:");
		System.out.println(calcTopPartLifeCode());
		System.out.println(" " + calcTypology());
		System.out.println(calcBottomPartLifeCode());
		System.out.println();
	}

	public static void main(String[] args) throws IOException {
		Chakras chakras = new Chakras();
		
		System.out.println("Чакры: " + chakras.getChakrasToString());
		System.out.println(chakras.descriptionChak());
	
		
		LifeCode lf = new LifeCode();
				
		System.out.println(lf.calcTopPartLifeCode());
		System.out.println(" " + lf.calcTypology());
		System.out.println(lf.calcBottomPartLifeCode());
		lf.printLifeCode();
		System.out.println("Расчёт произведён для даты " + DateInInt.getCalendarBirthDay().getTime());
	}

}
