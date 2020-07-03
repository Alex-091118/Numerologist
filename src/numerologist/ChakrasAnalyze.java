package numerologist;

import java.io.IOException;

public class ChakrasAnalyze {

	String chakrasToString;
	
	public ChakrasAnalyze(Chakras chakras) {
		chakrasToString = chakras.getChakrasToString();
	}
	int[] toIntArray(String chakra) {
		String[] array = chakra.split("-");
		int[] arrayInt = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			arrayInt[i] = Integer.valueOf(array[i]);
		}
		return arrayInt;
	}
	
	void printChakrAnalyze() {
		int [] chakrArr = toIntArray(chakrasToString);
		int yan = chakrArr[1] + chakrArr[2] + chakrArr[3];
		int in = chakrArr[0] + chakrArr[4] + chakrArr[5];
		int logic = chakrArr[3] + chakrArr[5];
		int intuition = chakrArr[2] + chakrArr[4];
		int sp;
		if (yan > in) {
			sp = (yan - in) * chakrArr[1]; 
		} else if (yan < in) {
			sp = (in - yan) * chakrArr[1];
		} else {
			sp = yan * chakrArr[1]; 
		}
		int iCan = chakrArr[0];
		int iWant;
		if (yan > in) {
			iWant = yan - in; 
		} else if (yan < in) {
			iWant = in - yan;
		} else {
			iWant = yan; 
		}
		System.out.println();
		System.out.println("���: " + yan);
		System.out.println("���: " + in);
		System.out.println("������: " + logic);
		System.out.println("��������: " + intuition);
		System.out.println("��: " + sp);
		System.out.println("����: " + iWant + " ����: " + iCan);
	}
	
	
	
	public static void main(String[] args) throws IOException {

		Chakras chakras = new Chakras();
		System.out.println("�����: " + chakras.getChakrasToString());
		System.out.println(chakras.descriptionChak());
		
		LifeCode lf = new LifeCode();
		System.out.println(lf.calcTopPartLifeCode());
		System.out.println(" " + lf.calcTypology());
		System.out.println(lf.calcBottomPartLifeCode());
		
		ChakrasAnalyze ca = new ChakrasAnalyze(chakras);
		ca.printChakrAnalyze();
		System.out.println("������ ��������� ��� ���� " + DateInInt.getCalendarBirthDay().getTime());
	}

}
