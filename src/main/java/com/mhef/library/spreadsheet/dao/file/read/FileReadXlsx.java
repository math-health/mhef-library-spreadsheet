package com.mhef.library.spreadsheet.dao.file.read;

import com.mhef.library.spreadsheet.dao.content.ContentDisplayTable;
import com.mhef.library.spreadsheet.dao.content.ContentReadXlsx;

import java.util.List;

/**
 * @author Henrik Beck
 * @version 1.0.0
 */
public class FileReadXlsx {
	/**
	 * @param pathFile The path to a spreadsheet file. In example, .csv, .xls or .xlsx files are able to be used.
	 * @return The spreadsheet matrix data with the full data content.
	 */
	public static List<List<String>> getData(String pathFile) {
		ContentReadXlsx reader = new ContentReadXlsx(pathFile);
		List<List<String>> data = reader.readData(pathFile);

		return data;
	}

	/**
	 * @param pathFile The path to a spreadsheet file. In example, .csv, .xls or .xlsx files are able to be used.
	 * @param columnsToRead The index of the specifics columns to be read.
	 * @return The spreadsheet matrix data with the full data content.
	 */
	public static List<List<String>> getData(String pathFile, int columnsToRead[]) {
		ContentReadXlsx reader = new ContentReadXlsx(pathFile);
		List<List<String>> data = reader.readData(pathFile,  columnsToRead);

		return data;
	}

	/**
	 * @param pathFile The path to a spreadsheet file. In example, .csv, .xls or .xlsx files are able to be used.
	 * @param isFormatted A boolean value key to display the table with colored NULL values instead of the table as raw data.
	 */
	public static void print(String pathFile, boolean isFormatted) {
		ContentReadXlsx reader = new ContentReadXlsx(pathFile);
		List<List<String>> data = reader.readData(pathFile);

		ContentDisplayTable printer = new ContentDisplayTable();

		if (isFormatted == true) {
			printer.tableFormattedContentPrint(data);
		} else {
			printer.tableFormattedContentPrint(data);
		}
	}
}