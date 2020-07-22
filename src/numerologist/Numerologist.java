package numerologist;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Numerologist {
	static Data data = Data.createData();
	
	static void calculationFromInput() {
		while(true) {
			LocalDate dateOfBirth = new Input().getDateOfBirth();
			if (dateOfBirth != null) {
				NumerologicalCalculation nc = new NumerologicalCalculation(dateOfBirth, data);
				System.out.println(nc.toString());
			}
		}
	}

	static void findMaxSP() {
		LocalDate dateOfBirth = LocalDate.of(1900, 01, 01);
		List<NumerologicalCalculation> listCalc = new ArrayList<>();
		int maxSP = 0;
		try {
			while (!dateOfBirth.equals(LocalDate.of(2151, 12, 31))) {
				NumerologicalCalculation nc = new NumerologicalCalculation(dateOfBirth, data);
				listCalc.add(nc);
				int sp = nc.getChakrasAnalyze().getSp();
				if (sp > maxSP) {
					maxSP = sp;
				}
				dateOfBirth = dateOfBirth.plusDays(1);
			}
		} catch (NullPointerException e) {
			System.out.println(dateOfBirth);
			e.printStackTrace();
		}
		System.out.println(maxSP);
		for (NumerologicalCalculation numc : listCalc) {
			if (numc.getChakrasAnalyze().getSp() == maxSP) {
				System.out.println(numc.toString());
				//System.out.println(numc.getDateOfBirth());
			}
		}
	}

	public static void main(String[] args) {
		Numerologist.calculationFromInput();
		//Numerologist.findMaxSP();

	}

}
