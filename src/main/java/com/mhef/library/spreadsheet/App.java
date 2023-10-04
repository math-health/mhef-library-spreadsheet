package com.mhef.library.spreadsheet;

import com.mhef.library.spreadsheet.dao.content.ContentDisplayTable;
import com.mhef.library.spreadsheet.dao.file.read.FileReadMain;
import com.mhef.library.spreadsheet.dao.file.write.FileWriteConversion;
import com.mhef.library.spreadsheet.dao.file.write.FileWriteData;

import java.util.List;

/**
 * @author Henrik Beck
 * @version 1.0.0
 *
 * @todo Document all the functions from the entire project using JavaDoc notation.
 * @todo Create unitary tests using JUnit5 library.
 *
 * <p>The absolute paths from the used files are referenced from my own local machine. Replace the values according to your needs</p>
 * <p>Before generating the Spreadsheet.jar file, please remove this class. This class is only used for running tests while developing before migrating to JUnit5 library format.</p>
 */
public class App {
	final static String pathFileInputCsv = "C:\\Users\\PC\\Workspaces\\math-health\\mhef-library-spreadsheet\\assets\\data\\cities.csv";
	final static String pathFileInputXls = "C:\\Users\\PC\\Workspaces\\math-health\\mhef-library-spreadsheet\\assets\\data\\example_XLS_50.xls";
	final static String pathFileInputXlsx = "C:\\Users\\PC\\Workspaces\\math-health\\mhef-library-spreadsheet\\organizing\\data\\20230529 - todos os metais (Teste Microondas) (2).xlsx";
	final static String pathFileOutputCsv = "C:\\Users\\PC\\Workspaces\\math-health\\mhef-library-spreadsheet\\assets\\dist\\result.csv";
	final static String pathFileOutputTxt = "C:\\Users\\PC\\Workspaces\\math-health\\mhef-library-spreadsheet\\assets\\dist\\result.txt";
	final static String pathFileOutputXls = "C:\\Users\\PC\\Workspaces\\math-health\\mhef-library-spreadsheet\\assets\\dist\\result.xls";

	public static void main(String[] args) {
		int[] columnsToRead = {1, 3, 5, 6};

		// Create the lists according to the data files
		List<List<String>> listDataCsvFull = FileReadMain.getTableData(pathFileInputCsv, new int[]{});
		List<List<String>> listDataCsvShort = FileReadMain.getTableData(pathFileInputCsv, columnsToRead);
		List<List<String>> listDataXlsFull = FileReadMain.getTableData(pathFileInputXls, new int[]{});
		List<List<String>> listDataXlsShort = FileReadMain.getTableData(pathFileInputXls, columnsToRead);
		List<List<String>> listDataXlsxFull = FileReadMain.getTableData(pathFileInputXlsx, new int[]{});
		List<List<String>> listDataXlsxShort = FileReadMain.getTableData(pathFileInputXlsx, columnsToRead);

		// Display the data content
//		dataListContentPrintAsList(listDataCsvFull);
		dataListContentPrintAsTable(listDataCsvFull);
		dataListContentPrintAsTable(listDataCsvShort);
//		dataListContentPrintAsList(listDataXlsFull);
//		dataListContentPrintAsTable(listDataXlsShort);
//		dataListContentPrintAsList(listDataXlsxFull);

//		dataListContentPrintAsTable(listDataXlsxFull);
//		dataListContentPrintAsList(listDataXlsxShort);
//		dataListContentPrintAsTable(listDataXlsxShort);

		// Display values from the first line
		// Syntax: listData.get(row).get(column)
//		System.out.println(listDataXlsxShort.get(0)); // [First Name, Gender, Age, Date]
//		System.out.println(listDataXlsxShort.get(0).get(2)); // Cell C1 // Age
//		System.out.println(listDataXlsxShort.get(1).get(2)); // Cell C2 // 32.0
//		System.out.println(listDataXlsxShort.get(2).get(3)); // Cell D2 // Output: 8/16/16 12:00 || 16/08/2016 || 42598.0
//		System.out.println(listDataXlsxShort.get(2).get(3).getClass().getSimpleName()); // String

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
		FileWriteConversion.convertFile(pathFileInputXls, pathFileOutputCsv);
		FileWriteConversion.convertFile(pathFileInputXls, pathFileOutputXls);
	}
}