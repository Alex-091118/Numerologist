package numerologist;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LifeCode {
	private String dateOfBirth;
	private List<String> dateOfBirthSplit;
	private Integer lifeCode;
	private Integer firstNum;
	private Integer typology;
	private List<Integer> topPart;
	private List<Integer> bottomPart;
	
	public LifeCode(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth.format(DateTimeFormatter.ofPattern("ddMMyyyy"));
		dateOfBirthSplit = Arrays.asList(this.dateOfBirth.split(""));
		setLifeCode();
		setFirstNum();
		setTypology();
		setTopPart();
		setBottomPart();
	}
		
	private void setLifeCode() {
		int onePart = Integer.parseInt(dateOfBirth.substring(0, 4));
		//System.out.println(onePart);
		int twoPart = Integer.parseInt(dateOfBirth.substring(4, 8));
		//System.out.println(twoPart);
		this.lifeCode = onePart * twoPart;
	}

	private void setFirstNum() {
		int firstNum = 0;
		for (int i = 0; i < 4; i++) {
			firstNum += Integer.parseInt(dateOfBirthSplit.get(i));
			//System.out.println(firstNum);
		}
		while (firstNum > 9)
			firstNum = firstNum / 10 + firstNum % 10;
		this.firstNum = firstNum;
	}

	private void setTypology() {
		int typology = 0;
		for (String x : dateOfBirthSplit) {
			typology += Integer.parseInt(x);
			//System.out.println(typology);
		}
		while (typology > 9)
			typology = typology / 10 + typology % 10;
		this.typology = typology;
	}

	private void setTopPart() {
		List<Integer> topPart = new ArrayList<Integer>();
		topPart.add(firstNum);
		for (String s : lifeCode.toString().split("")) {
			topPart.add(Integer.parseInt(s));
		}
		this.topPart = topPart;
	}

	private void setBottomPart() {
		List<Integer> bottomPart = new ArrayList<Integer>();
		for(Integer x : topPart) {
			int sum = x + typology;
			while(sum > 9) {
				sum = sum / 10 + sum % 10;
			}
			bottomPart.add(sum);
		}
		this.bottomPart = bottomPart;
	}
	
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("\nКод жизни:\n")
				.append(topPart.get(0)).append("/").append(topPart.get(1)).append("/");
		for (int i = 2; i < topPart.size(); i++) {
			result.append(topPart.get(i));
		}
		result.append("\n")
				.append(" ").append(typology).append("\n")
				.append(bottomPart.get(0)).append("/").append(bottomPart.get(1)).append("/");
		for (int i = 2; i < bottomPart.size(); i++) {
			result.append(bottomPart.get(i));
		}
		result.append("\n");
		return result.toString();
	}

	public static void main(String[] args) {
		LifeCode ld = new LifeCode(LocalDate.of(1986, 11, 27));
		System.out.println(ld.dateOfBirth);
		System.out.println(ld.dateOfBirthSplit);
		System.out.println(ld.lifeCode);
		System.out.println(ld.firstNum);
		System.out.println(ld.typology);
		System.out.println(ld.topPart);
		System.out.println(ld.bottomPart);
		System.out.println(ld.toString());
		
	}

}
