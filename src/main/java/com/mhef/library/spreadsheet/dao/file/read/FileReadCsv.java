package com.mhef.library.spreadsheet.dao.file.read;

import com.mhef.library.spreadsheet.dao.content.ContentDisplay;
import com.mhef.library.spreadsheet.dao.content.ContentReadCsv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Henrik Beck
 * @version 1.0.0
 */
public class FileReadCsv {
	/**
	 * @param pathFile The path to a spreadsheet file. In example, .csv, .xls or .xlsx files are able to be used.
	 * @return The spreadsheet matrix data with the full data content.
	 */
	public static List<List<String>> getData(String pathFile) {
		ContentReadCsv reader = new ContentReadCsv(pathFile);
		List<List<String>> data = reader.readData(pathFile);

		return data;
	}

	/**
	 * @param pathFile The path to a spreadsheet file. In example, .csv, .xls or .xlsx files are able to be used.
	 * @param columnsToRead The index of the specifics columns to be read.
	 * @return The spreadsheet matrix data with the full data content.
	 */
	public static List<List<String>> getData(String pathFile, int[] columnsToRead) {
		List<List<String>> data = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(pathFile))) {
			String line;

			while ((line = br.readLine()) != null) {
				String[] values = line.split(",");
				List<String> row = new ArrayList<>();

				for (int columnIndex : columnsToRead) {
					if (columnIndex < values.length) {
						row.add(values[columnIndex].trim());
					}
				}

				data.add(row);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return data;
	}

	/**
	 * @param pathFile The path to a spreadsheet file. In example, .csv, .xls or .xlsx files are able to be used.
	 * @param isFormatted A boolean value key to display the table with colored NULL values instead of the table as raw data.
	 */
	public static void print(String pathFile, boolean isFormatted) {
		ContentReadCsv reader = new ContentReadCsv(pathFile);
		List<List<String>> data = reader.readData(pathFile);

		ContentDisplay printer = new ContentDisplay();

		if (isFormatted == true) {
			printer.tableFormattedContentPrint(data);
		} else {
			printer.tableFormattedContentPrint(data);
		}
	}
}