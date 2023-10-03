package com.henrik.library.data.file.read;

import com.henrik.library.data.content.ContentDisplayTable;
import com.henrik.library.data.content.ContentReadXlsx;

import java.util.List;

public class FileReadXlsx {
	public static List<List<String>> getData(String pathFile) {
		ContentReadXlsx reader = new ContentReadXlsx(pathFile);
		List<List<String>> data = reader.readData(pathFile);

		return data;
	}

	public static List<List<String>> getData(String pathFile, int arrayColumns[]) {
		ContentReadXlsx reader = new ContentReadXlsx(pathFile);
		List<List<String>> data = reader.readData(pathFile, arrayColumns);

		return data;
	}

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
