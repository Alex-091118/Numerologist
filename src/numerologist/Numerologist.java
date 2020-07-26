package numerologist;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import data.Data;

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
		List<Integer> listSP = new ArrayList<Integer>();
		int maxSP = 0;
		try {
			while (!dateOfBirth.equals(LocalDate.of(2151, 12, 31))) {
				NumerologicalCalculation nc = new NumerologicalCalculation(dateOfBirth, data);
				listCalc.add(nc);
				
				int sp = nc.getChakrasAnalyze().getSp();
				listSP.add(sp);
				if (sp > maxSP) {
					maxSP = sp;
				}
				dateOfBirth = dateOfBirth.plusDays(1);
			}
		} catch (NullPointerException e) {
			System.out.println(dateOfBirth);
			e.printStackTrace();
		}
		Collections.sort(listSP);
		System.out.println(maxSP);
		System.out.println(listCalc.size());
		System.out.println(listSP);
//		for (NumerologicalCalculation numc : listCalc) {
//			if (numc.getChakrasAnalyze().getSp() == maxSP) {
//				System.out.println(numc.toString());
//				//System.out.println(numc.getDateOfBirth());
//			}
//		}
	}

	public static void main(String[] args) {
		Numerologist.calculationFromInput();
		//Numerologist.findMaxSP();

	}

}
