package data;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Mapper {

	public static Map<Integer, ArrayList<Integer>> getMapInt(String nameFile)
			throws EncryptedDocumentException, IOException {
		Map<Integer, ArrayList<Integer>> linkedMap = new LinkedHashMap<Integer, ArrayList<Integer>>();
		try {
			Workbook readBook = WorkbookFactory.create(new File(nameFile));
			Sheet sheet = readBook.getSheetAt(0);
			for (Row row : sheet) {
				linkedMap.put((int) row.getCell(0).getNumericCellValue(),
						new ArrayList<Integer>(Arrays.asList((int) row.getCell(1).getNumericCellValue(),
								(int) row.getCell(2).getNumericCellValue(),
								(int) row.getCell(3).getNumericCellValue())));
			}
		} catch (EncryptedDocumentException e) {
			System.out.println("error excel");
		} catch (IOException e) {
			System.out.println("file not found");
		}

		return linkedMap;

	}

	public static Map<Integer, ArrayList<String>> getMapString(String nameFile)
			throws EncryptedDocumentException, IOException {
		Map<Integer, ArrayList<String>> linkedMap = new LinkedHashMap<Integer, ArrayList<String>>();
		try {
			Workbook readBook = WorkbookFactory.create(new File(nameFile));
			Sheet sheet = readBook.getSheetAt(0);
			for (Row row : sheet) {
				linkedMap.put(Integer.valueOf(row.getCell(0).getStringCellValue()), new ArrayList<String>(
						Arrays.asList(row.getCell(1).getStringCellValue(), row.getCell(2).getStringCellValue())));
			}
		} catch (EncryptedDocumentException e) {
			System.out.println("error excel");
		} catch (IOException e) {
			System.out.println("file not found");
		}

		return linkedMap;

	}

	public static Map<String, ArrayList<String>> getMapT3(String nameFile)
			throws EncryptedDocumentException, IOException {
		Map<String, ArrayList<String>> linkedMap = new LinkedHashMap<String, ArrayList<String>>();
		try {
			Workbook readBook = WorkbookFactory.create(new File(nameFile));
			Sheet sheet = readBook.getSheetAt(0);
			for (Row row : sheet) {
				linkedMap.put(row.getCell(0).getStringCellValue(),
						new ArrayList<String>(Arrays.asList(row.getCell(1).getStringCellValue(),
								row.getCell(2).getStringCellValue(), row.getCell(3).getStringCellValue())));
			}
		} catch (EncryptedDocumentException e) {
			System.out.println("error excel");
		} catch (IOException e) {
			System.out.println("file not found");
		}

		return linkedMap;

	}

	public static Map<String, String> readContourDescription(String fileName) throws IOException {
		Path path = Paths.get(fileName);
		List<String> allLines = Files.readAllLines(path);
		Map<String, String> hashMap = new LinkedHashMap<String, String>();
		for (String line : allLines) {
			Pattern pattern = Pattern.compile("(.+):(.*)");
			Matcher matcher = pattern.matcher(line);
			matcher.find();
			hashMap.put(matcher.group(1).toLowerCase(), matcher.group(2));
		}
		return hashMap;

	}

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		readContourDescription("resources\\ContourDescriptions.txt");
	}

}
