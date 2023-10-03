package com.mhef.library.spreadsheet.dao.file.read;

import com.mhef.library.spreadsheet.dao.content.ContentDisplayTable;
import com.mhef.library.spreadsheet.dao.content.ContentReadCsv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReadCsv {
	public static List<List<String>> getData(String pathFile) {
		ContentReadCsv reader = new ContentReadCsv(pathFile);
		List<List<String>> data = reader.readData(pathFile);

		return data;
	}

	public static List<List<String>> getData(String csvFile, int[] columnsToRead) {
		List<List<String>> data = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
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

	public static void print(String pathFile, boolean isFormatted) {
		ContentReadCsv reader = new ContentReadCsv(pathFile);
		List<List<String>> data = reader.readData(pathFile);

		ContentDisplayTable printer = new ContentDisplayTable();

		if (isFormatted == true) {
			printer.tableFormattedContentPrint(data);
		} else {
			printer.tableFormattedContentPrint(data);
		}
	}
}