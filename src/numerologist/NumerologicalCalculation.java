package numerologist;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import data.Data;

public class NumerologicalCalculation {
	
	private LocalDate dateOfBirth;
	private Data data;
	private Codes codes;
	private Markers markers;
	private Chakras chakras;
	private ChakrasAnalyze chakrasAnalyze;
	private LifeCode lifeCode;
	private boolean dataHasYear;
	private long age;
	
	public NumerologicalCalculation(LocalDate dateOfBirth, Data data) {
		this.dateOfBirth = dateOfBirth;
		this.data = data;
		this.dataHasYear = dateOfBirth.getYear() >= 1900 && dateOfBirth.getYear() <= 2151;
		setCodes();
		setMarkers();
		setChakras();
		setChakrasAnalyze();
		setLifeCode();
		setAge();
	}
	
	private void setCodes() {
		if (dataHasYear) {
			this.codes = new Codes(dateOfBirth, data);
		}
	}

	private void setMarkers() {
		if (codes != null) {
			this.markers = new Markers(codes);
		}
	}

	private void setChakras() {
		if (markers != null) {
			this.chakras = new Chakras(markers, data);
		}
	}

	private void setChakrasAnalyze() {
		if (chakras != null) {
			this.chakrasAnalyze = new ChakrasAnalyze(chakras);
		}
	}
	
	private void setLifeCode() {
		if(dateOfBirth != null) {
			this.lifeCode = new LifeCode(dateOfBirth);
		}
	}

	private void setAge() {
		LocalDate currentDate = LocalDate.now();
		this.age = ChronoUnit.YEARS.between(dateOfBirth, currentDate);
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("Нумерологический расчёт для даты: ").append(dateOfBirth.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))).append("\n")
				.append("Возраст ").append(age)
				.append(chakras.toString())
				.append(chakrasAnalyze.toString())
				.append(lifeCode.toString());
		return result.toString();
	}

	public Codes getCodes() {
		return codes;
	}

	public Markers getMarkers() {
		return markers;
	}

	public Chakras getChakras() {
		return chakras;
	}

	public ChakrasAnalyze getChakrasAnalyze() {
		return chakrasAnalyze;
	}

	public LifeCode getLifeCode() {
		return lifeCode;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	
	

}
