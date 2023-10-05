package com.mhef.library.spreadsheet.dao.file.read;

import com.mhef.library.spreadsheet.utils.validation.ValidationFile;

import java.util.List;

/**
 * @author Henrik Beck
 * @version 1.0.0
 */
public class FileReadMain {
	/**
	 * @param pathFile The path to a spreadsheet file. In example, .csv, .xls or .xlsx files are able to be used.
	 */
	public static void displayTableData(String pathFile) {
		// Check if the file exists
		if (!ValidationFile.fileExists(pathFile)) {
			System.out.println("File " + pathFile + " does not exist.");
			System.exit(0);
		}

		// Declaring the variables
		String formatFile = ValidationFile.getFileExtension(pathFile);

		// Insert content into list
		if (formatFile.equals(".csv")) {
			FileReadCsv.print(pathFile, true);
		} else if (formatFile.equals(".xls") || formatFile.equals(".xlsx")) {
			FileReadXlsx.print(pathFile, true);
		}
	}

	/**
	 * @param pathFile The path to a spreadsheet file. In example, .csv, .xls or .xlsx files are able to be used.
	 * @param columnsToRead The index of the specifics columns to be read.
	 * @return The spreadsheet matrix data with the full data content. Usage syntax: listData.get(row).get(column).
	 */
	public static List<List<String>> getTableData(String pathFile, int columnsToRead[]) {
		// Check if the file exists
		if (!ValidationFile.fileExists(pathFile)) {
			System.out.println("File " + pathFile + " does not exist.");
			System.exit(1);
		}

		// Declaring the variables
		String formatFile = ValidationFile.getFileExtension(pathFile);
		List<List<String>> listData = null;

		// Insert content into list
		if (formatFile.equals(".csv")) {
			if (columnsToRead.length > 0) {
				listData = FileReadCsv.getData(pathFile, columnsToRead);
			} else {
				listData = FileReadCsv.getData(pathFile);
			}
		} else if (formatFile.equals(".xls") || formatFile.equals(".xlsx")) {
			if (columnsToRead.length > 0) {
				listData = FileReadXlsx.getData(pathFile, columnsToRead);
			} else {
				listData = FileReadXlsx.getData(pathFile);
			}
		}

		return listData;
	}
}