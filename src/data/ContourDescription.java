package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class ContourDescription {
	
	Map<String, String> description;
	
	void setDescription() {
		Data data = Data.createData();
		System.out.println(data);
		this.description = new LinkedHashMap<String, String>();
		
//		for (Integer x : data.getPhysicalCont().keySet()) {
//			String s = data.getPhysicalCont().get(x).get(1);
//			if ("".equals(s)) continue;
//			description.put(s, "");
//		}

//		for (Integer x : data.getEmotionCont().keySet()) {
//			String s = data.getEmotionCont().get(x).get(1);
//			if ("".equals(s)) continue;
//			description.put(s, "");
//		}
		
		for (Integer x : data.getIntellectCont().keySet()) {
			String s = data.getIntellectCont().get(x).get(1);
			if ("".equals(s)) continue;
			description.put(s, "");
		}
	}
	

	public static void main(String[] args) throws IOException {
//		ContourDescription cd = new ContourDescription();
//		cd.setDescription();
//		System.out.println(cd.description);
		InputStreamReader isr = new InputStreamReader(new FileInputStream(new File("resources\\ContourDescriptions1251.txt")));
		BufferedReader br = new BufferedReader(isr);
		
			br.readLine();

	}

}
