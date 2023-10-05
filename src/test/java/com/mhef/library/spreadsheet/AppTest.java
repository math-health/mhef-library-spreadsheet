package com.mhef.library.spreadsheet;

import com.mhef.library.spreadsheet.dao.file.read.FileReadMain;

import java.util.List;

/**
 * @author Henrik Beck
 * @version 1.0.0
 */
public class AppTest {
	// Path file input

	private static final String pathFileInputCsv = "C:\\Users\\PC\\Workspaces\\math-health\\mhef-library-spreadsheet\\assets\\data\\cities.csv";
	private static final String pathFileInputXls = "C:\\Users\\PC\\Workspaces\\math-health\\mhef-library-spreadsheet\\assets\\data\\example_XLS_50.xls";
	private static final String pathFileInputXlsx = "C:\\Users\\PC\\Workspaces\\math-health\\mhef-library-spreadsheet\\organizing\\data\\20230529 - todos os metais (Teste Microondas) (2).xlsx";

	// Path file output

	private static final String pathFileOutputCsv = "C:\\Users\\PC\\Workspaces\\math-health\\mhef-library-spreadsheet\\assets\\dist\\result.csv";
	private static final String pathFileOutputTxt = "C:\\Users\\PC\\Workspaces\\math-health\\mhef-library-spreadsheet\\assets\\dist\\result.txt";
	private static final String pathFileOutputXls = "C:\\Users\\PC\\Workspaces\\math-health\\mhef-library-spreadsheet\\assets\\dist\\result.xls";
	private static final String pathFileOutputXlsx = "C:\\Users\\PC\\Workspaces\\math-health\\mhef-library-spreadsheet\\assets\\dist\\result.xls";

	// Arrays

	private static final int[] columnsToRead = {1, 3, 5, 6};

	// Lists

	private static List<List<String>> listDataCsvFull;
	private static List<List<String>> listDataCsvShort;
	private static List<List<String>> listDataXlsFull;
	private static List<List<String>> listDataXlsShort;
	private static List<List<String>> listDataXlsxFull;
	private static List<List<String>> listDataXlsxShort;

	public static void listLoadValues() {
		// Create the lists according to the data files - CSV
		listDataCsvFull = FileReadMain.getTableData(pathFileInputCsv, new int[]{});
		listDataCsvShort = FileReadMain.getTableData(pathFileInputCsv, columnsToRead);

		// Create the lists according to the data files - XLS
		listDataXlsFull = FileReadMain.getTableData(pathFileInputXls, new int[]{});
		listDataXlsShort = FileReadMain.getTableData(pathFileInputXls, columnsToRead);

		// Create the lists according to the data files - XLSX
		listDataXlsxFull = FileReadMain.getTableData(pathFileInputXlsx, new int[]{});
		listDataXlsxShort = FileReadMain.getTableData(pathFileInputXlsx, columnsToRead);
	}

	// Path file input

	public static String getPathFileInputCsv() {
		return pathFileInputCsv;
	}

	public static String getPathFileInputTxt() {
		// return pathFileInputTxt;
		return null;
	}

	public static String getPathFileInputXls() {
		return pathFileInputXls;
	}

	public static String getPathFileInputXlsx() {
		return pathFileOutputXlsx;
	}

	// Path file output

	public static String getPathFileOutputCsv() {
		return pathFileOutputCsv;
	}

	public static String getPathFileOutputTxt() {
		return pathFileOutputTxt;
	}

	public static String getPathFileOutputXls() {
		return pathFileOutputXls;
	}

	public static String getPathFileOutputXlsx() {
		return pathFileOutputXlsx;
	}

	// Arrays

	public static int[] getColumnsToRead() {
		return columnsToRead;
	}

	// Lists

	public static List<List<String>> getListDataCsvFull() {
		return listDataCsvFull;
	}

	public static List<List<String>> getListDataCsvShort() {
		return listDataCsvShort;
	}

	public static List<List<String>> getListDataXlsFull() {
		return listDataXlsFull;
	}

	public static List<List<String>> getListDataXlsShort() {
		return listDataXlsShort;
	}

	public static List<List<String>> getListDataXlsxFull() {
		return listDataXlsxFull;
	}

	public static List<List<String>> getListDataXlsxShort() {
		return listDataXlsxShort;
	}
}