package com.mhef.library.spreadsheet.utils.validation;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Henrik Beck
 * @version 1.0.0
 */
public class ValidationFile {
	/**
	 * @param filePath The path to the informed file.
	 * @return The verification is the file exists or not
	 */
	public static boolean fileExists(String filePath) {
		return new java.io.File(filePath).exists();
	}

	/**
	 * @param filePath The path to the informed file.
	 * @return The file extension value. In example, ".csv", ".xls" and "xlsx" values.
	 */
	public static String getFileExtension(String filePath) {
		Path path = Paths.get(filePath);
		String fileName = path.getFileName().toString();
		int dotIndex = fileName.lastIndexOf(".");

		if (dotIndex == -1) {
			return ""; // No file extension found
		}

		return fileName.substring(dotIndex);
	}
}