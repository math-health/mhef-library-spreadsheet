package com.mhef.library.spreadsheet;

import com.mhef.library.spreadsheet.dao.content.ContentDisplayTable;
import com.mhef.library.spreadsheet.dao.file.read.FileReadMain;
import com.mhef.library.spreadsheet.dao.file.write.FileWriteConversion;
import com.mhef.library.spreadsheet.dao.file.write.FileWriteData;
import com.mhef.library.spreadsheet.utils.validation.ValidationData;
import org.apache.poi.ss.usermodel.DataFormatter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class App {
	final static String pathFileInputCsv = "C:\\Users\\PC\\Workspaces\\math-health\\mhef-library-spreadsheet\\assets\\data\\cities.csv";
	final static String pathFileInputXlsx = "C:\\Users\\PC\\Workspaces\\math-health\\mhef-library-spreadsheet\\assets\\data\\example_XLS_50.xls";
	final static String pathFileOutputCsv = "C:\\Users\\PC\\Workspaces\\math-health\\mhef-library-spreadsheet\\assets\\dist\\result.csv";
	final static String pathFileOutputTxt = "C:\\Users\\PC\\Workspaces\\math-health\\mhef-library-spreadsheet\\assets\\dist\\result.txt";
	final static String pathFileOutputXls = "C:\\Users\\PC\\Workspaces\\math-health\\mhef-library-spreadsheet\\assets\\dist\\result.xls";

	public static void main(String[] args) {
		int[] columnsToRead = {1, 3, 5, 6};

		// Create the lists according to the data files
		List<List<String>> listDataCsvFull = FileReadMain.getTableData(pathFileInputCsv, new int[]{});
		List<List<String>> listDataCsvShort = FileReadMain.getTableData(pathFileInputCsv, columnsToRead);
		List<List<String>> listDataXlsxFull = FileReadMain.getTableData(pathFileInputXlsx, new int[]{});
		List<List<String>> listDataXlsxShort = FileReadMain.getTableData(pathFileInputXlsx, columnsToRead);

		// Display the data content
//		dataListContentPrintAsList(listDataCsvFull);
//		dataListContentPrintAsTable(listDataCsvFull);

		// Display values from the first line
		// Syntax: listData.get(row).get(column)
//		System.out.println(listDataXlsxShort.get(0)); // [First Name, Gender, Age, Date]
//		System.out.println(listDataXlsxShort.get(0).get(2)); // Cell C1 // Age
//		System.out.println(listDataXlsxShort.get(1).get(2)); // Cell C2 // 32.0
		System.out.println(listDataXlsxShort.get(2).get(3)); // Cell D2 // Output: 16/08/2016 || 42598.0
//		System.out.println(listDataXlsxShort.get(2).get(3).getClass().getSimpleName());

		// Display values from the first column
		/*
		for (int i = 0; i < listDataXlsxShort.size(); i++) {
			System.out.println(listDataXlsxShort.get(i).get(0));
		}
		*/
	}

	public static void dataListContentPrintAsList(List<List<String>> listData) {
		System.out.println(listData);
	}

	public static void dataListContentPrintAsTable(List<List<String>> listData) {
		ContentDisplayTable.tableFormattedContentPrint(listData);
	}

	public static void dataObjectContentPrintAsTable(String pathFileInput) {
		FileReadMain.displayTableData(pathFileInput);
	}

	public static void dataFileWriteExternal(List<List<String>> listData) {
		FileWriteData.writeDataIntoFileCsv(listData, pathFileOutputTxt);
	}

	public static void dataFileConversion() {
		FileWriteConversion.convertFile(pathFileInputXlsx, pathFileOutputCsv);
		FileWriteConversion.convertFile(pathFileInputXlsx, pathFileOutputXls);
	}
}