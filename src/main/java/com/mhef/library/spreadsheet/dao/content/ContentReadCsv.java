package com.mhef.library.spreadsheet.dao.content;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Henrik Beck
 * @version 1.0.0
 */
public class ContentReadCsv {
	private String filePath;

	/**
	 * Constructs a new instance of the ContentReadXlsx class with the specified file path to a .csv file.
	 *
	 * @param filePath The path to the .csv file that will be read.
	 */
	public ContentReadCsv(String filePath) {
		this.filePath = filePath;
	}

	/**
	 * @param filePath The path to the .csv file.
	 * @return The spreadsheet matrix data with the full data content.
	 */
	public List<List<String>> readData(String filePath) {
		List<List<String>> data = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line;

			while ((line = br.readLine()) != null) {
				String[] values = line.split(",");
				List<String> row = new ArrayList<>();

				for (String value : values) {
					row.add(value.trim());
				}

				data.add(row);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return data;
	}

	/**
	 * @param filePath The path to the .csv file.
	 * @param columnsToRead The index of the specifics columns to be read.
	 * @return The spreadsheet matrix data, only with the specifics columns content.
	 */
	public List<List<String>> readData(String filePath, int[] columnsToRead) {
		List<List<String>> data = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line;

			while ((line = br.readLine()) != null) {
				String[] values = line.split(",");
				List<String> row = new ArrayList<>();

				for (int columnIndex : columnsToRead) {
					if (columnIndex >= 0 && columnIndex < values.length) {
						row.add(values[columnIndex].trim());
					} else {
						row.add(""); // Add empty string for non-existent columns
					}
				}

				data.add(row);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return data;
	}
}