package numerologist;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Input {

	private LocalDate dateOfBirth;
	
	public Input() {
		setDateOfBirth();
	}

	private void setDateOfBirth() {
		System.out.println("Введите дату рождения в формате (дд.мм.гггг):");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		try {
			this.dateOfBirth = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
		} catch (Exception e) {
			System.out.println("Wrong input!");
			System.out.println(e.fillInStackTrace().getMessage());
		}
	}

	LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

}
