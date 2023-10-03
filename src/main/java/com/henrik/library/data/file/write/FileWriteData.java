package com.henrik.library.data.file.write;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileWriteData {
	protected void writeDataToFileMain(List<List<String>> data, String filePath) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
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

	public static void writeDataIntoFileCsv(List<List<String>> listData1, String pathFileOutput) {
		FileWriteData fileWriter = new FileWriteData();
		fileWriter.writeDataToFileMain(listData1, pathFileOutput);
	}
}