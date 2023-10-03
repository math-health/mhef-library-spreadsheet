package com.henrik.library.data.validation;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ValidationFile {
	public static boolean fileExists(String filePath) {
		return new java.io.File(filePath).exists();
	}

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