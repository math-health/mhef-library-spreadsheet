package com.mhef.library.spreadsheet.dao.file.write;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * @author Henrik Beck
 * @version 1.0.0
 */
public class FileWriteData {
	/**
	 * @param data The spreadsheet matrix data.
	 * @param pathFile The path to a document file to be written data content. In example, a .txt file is able to be used.
	 */
	protected void writeDataToFileMain(List<List<String>> data, String pathFile) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(pathFile))) {
			for (List<String> row : data) {
				String line = String.join(",", row); // Customize the delimiter as per your requirement
				writer.write(line);
				writer.newLine();
			}

			System.out.println("Data successfully written to file.");
		} catch (IOException e) {
			System.err.println("Error writing content to file: " + e.getMessage());
		}
	}

	/**
	 * @param data The spreadsheet matrix data.
	 * @param pathFile The path to a document file to be written data content. In example, a .txt file is able to be used.
	 */
	public static void writeDataIntoFileCsv(List<List<String>> data, String pathFile) {
		FileWriteData fileWriter = new FileWriteData();
		fileWriter.writeDataToFileMain( data, pathFile);
	}
}