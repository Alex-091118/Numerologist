package data;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;

public class Data implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<Integer, ArrayList<Integer>> codesYears;
	private Map<Integer, ArrayList<Integer>> codesMonths;
	private Map<Integer, ArrayList<String>> physicalCont;
	private Map<Integer, ArrayList<String>> emotionCont;
	private Map<Integer, ArrayList<String>> intellectCont;
	@Override
	public String toString() {
		return "Data [codesYears=" + codesYears + ",\n\n\n codesMonths=" + codesMonths + ", \n\n\n physicalCont=" + physicalCont
				+ ",\n\n\n emotionCont=" + emotionCont + ",\n\n\n intellectCont=" + intellectCont + ",\n\n\n mapT3=" + mapT3 + "]";
	}

	private Map<String, ArrayList<String>> mapT3;

	void setData() throws EncryptedDocumentException, IOException {
		codesYears = Mapper.getMapInt("years.xls");
		codesMonths = Mapper.getMapInt("months.xls");
		physicalCont = Mapper.getMapString("fk.xls");
		emotionCont = Mapper.getMapString("ek.xls");
		intellectCont = Mapper.getMapString("ik.xls");
		mapT3 = Mapper.getMapT3("t3.xls");
	}

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		Data data = new Data();
		data.setData();
		System.out.println(data.toString());
		FileOutputStream fos = new FileOutputStream(new File("objData.bin"));
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(data);
		

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
	
	
}