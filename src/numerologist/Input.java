package numerologist;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Input {
	private Scanner scanner = new Scanner(System.in);
	private static String dateOfBirthString;
	private Calendar dateOfBirth;
	public static int count;
	
	public Input() {
		readDate();
	}
	void readDate() {
		
		System.out.println("Введите дату рождения в формате (дд.мм.гггг) ");
		String input = null;
		boolean checkInput = false;
		while (!checkInput) {
			input = scanner.nextLine();
			checkInput = input.matches("\\d{2}\\.\\d{2}\\.\\d{4}");
			if (!checkInput) {
				System.out.println("Wrong input! Try again");
			}
		}
		scanner.close();
		dateOfBirthString = input;
		setDateOfBirth();
		}

	public static String getDateOfBirthString() {
		return dateOfBirthString;
	}
	private void setDateOfBirth() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		try {
		Date date = sdf.parse(dateOfBirthString);
		dateOfBirth = Calendar.getInstance();
		dateOfBirth.setTime(date);
		} catch(ParseException e) {
			System.out.println("Некорректная дата");
		}	
	}
	
	public Calendar getDateOfBirth() {
		return dateOfBirth;

	}
	public static void main(String[] args) {
		Input in = new Input();
		in.readDate();
		System.out.println(Input.getDateOfBirthString());
		System.out.println(in.getDateOfBirth().getTime());
		
	}

}
