package numerologist;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Numerologist {
	void start() throws IOException {
		Chakras chakras = new Chakras();
		LifeCode lf = new LifeCode();
		ChakrasAnalyze ca = new ChakrasAnalyze(chakras);
		System.out.println("Возраст: " + age());
		chakras.printChakras();
		ca.printChakrAnalyze();
		lf.printLifeCode();
	}
	
	// Branch Refactor
	// Branch Refactor
	// Branch Refactor
	// Branch Refactor
	// Branch Refactor
	
	long age() {
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		LocalDate birthDay = LocalDate.parse(Input.getDateOfBirthString(), dtf);
		return ChronoUnit.YEARS.between(birthDay, currentDate);
	}
public static void main(String[] args) throws IOException {
	Numerologist num = new Numerologist();
	num.start();
	}

}
