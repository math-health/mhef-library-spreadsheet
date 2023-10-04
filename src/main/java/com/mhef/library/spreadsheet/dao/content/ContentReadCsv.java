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
	private String fileCsv;

	/**
	 * Constructs a new instance of the ContentReadXlsx class with the specified file path to a .csv file.
	 *
	 * @param fileCsv The path to the .csv file that will be read.
	 */
	public ContentReadCsv(String fileCsv) {
		this.fileCsv = fileCsv;
	}

	/**
	 * @param fileCsv The path to the .csv file.
	 * @return The spreadsheet matrix data with the full data content.
	 */
	public List<List<String>> readData(String fileCsv) {
		List<List<String>> data = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(fileCsv))) {
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
	 * @todo This method should be created.
	 * @param fileCsv The path to the .csv file.
	 * @param columnsToRead The index of the specifics columns to be read.
	 * @return The spreadsheet matrix data, only with the specifics columns content.
	 */
	//public List<List<String>> readData(String fileCsv, int[] columnsToRead){}
}