package numerologist;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Data implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<Integer, ArrayList<Integer>> codesYears;
	private Map<Integer, ArrayList<Integer>> codesMonths;
	private Map<Integer, ArrayList<String>> physicalCont;
	private Map<Integer, ArrayList<String>> emotionCont;
	private Map<Integer, ArrayList<String>> intellectCont;
	private Map<String, ArrayList<String>> mapT3;

	private Data() {
		System.out.println("Data ERROR");
		System.exit(-1);
	}

	static Data createData() {
		try (FileInputStream fis = new FileInputStream(new File("objData.bin"));
				ObjectInputStream ois = new ObjectInputStream(fis)) {
			return (Data) ois.readObject();
		} catch (FileNotFoundException e) {
			System.out.println("File \"objData.bin\" not found");
			System.out.println(e.fillInStackTrace().getMessage());
		} catch (IOException e) {
			System.out.println("IO error.File \"objData.bin\" damaged");
			System.out.println(e.fillInStackTrace().getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException");
			System.out.println(e.fillInStackTrace().getMessage());
		}
		return new Data();
	}

	String printColumnMap(Map<?, ?> map, int column, int widthKey, int widthValue) {
		StringBuilder result = new StringBuilder();
		List<Object> keyList = Arrays.asList(map.keySet().toArray());
		for (int i = 0; i < keyList.size() / column; i++) {
			for (int j = i; j < keyList.size(); j += keyList.size() / column) {
				result.append(String.format("%" + widthKey + "s = ", keyList.get(j)))
						.append(String.format("|%" + widthValue + "s|    ", map.get(keyList.get(j))));
			}
			result.append("\n");
		}

		return result.toString();

	}

	@Override
	public String toString() {
		StringBuilder allInfo = new StringBuilder();
		allInfo.append("\nYear codes (коды года)\n").append(printColumnMap(codesYears, 6, 4, -12))
				.append("\nMonth codes (коды мес€ца)\n").append(printColumnMap(codesMonths, 1, 3, -15))
				.append("\nPhysical contour (физический контур)\n").append(printColumnMap(physicalCont, 1, 3, -40))
				.append("\nEmotional contour (эмоциональный контур)\n").append(printColumnMap(emotionCont, 1, 3, -40))
				.append("\nIntelligent contour (интеллектуальный контур)\n").append(printColumnMap(intellectCont, 1, 3, -40))
				.append("\nTable 3\n").append(printColumnMap(mapT3, 1, 25, -50));
		return allInfo.toString();
	}

	public Map<Integer, ArrayList<Integer>> getCodesYears() {
		return codesYears;
	}

	public Map<Integer, ArrayList<Integer>> getCodesMonths() {
		return codesMonths;
	}

	public Map<Integer, ArrayList<String>> getPhysicalCont() {
		return physicalCont;
	}

	public Map<Integer, ArrayList<String>> getEmotionCont() {
		return emotionCont;
	}

	public Map<Integer, ArrayList<String>> getIntellectCont() {
		return intellectCont;
	}

	public Map<String, ArrayList<String>> getMapT3() {
		return mapT3;
	}

	public static void main(String[] args) {
		Data data = Data.createData();
		System.out.println(data.toString());
		System.out.println("program continue");

	}

}
