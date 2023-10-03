package com.mhef.library.spreadsheet;

import com.mhef.library.spreadsheet.dao.content.ContentDisplayTable;
import com.mhef.library.spreadsheet.dao.file.read.FileReadMain;
import com.mhef.library.spreadsheet.dao.file.write.FileWriteConversion;
import com.mhef.library.spreadsheet.dao.file.write.FileWriteData;
import com.mhef.library.spreadsheet.utils.validation.ValidationData;

import java.io.IOException;
import java.util.List;

public class App {
	public static void main(String[] args) {
		String pathFileCsvInput;
		String pathFileXlsxInput;
		int[] columnsToRead = {1, 3, 5, 6};

		// Check if a filename is provided as an argument
		if (ValidationData.isThereArguments(args)) {
			pathFileCsvInput = args[0];
			pathFileXlsxInput = args[0];
		} else {
			pathFileCsvInput = "C:\\Users\\PC\\Workspaces\\math-health\\mhef-library-spreadsheet\\assets\\data\\cities.csv";
			pathFileXlsxInput = "C:\\Users\\PC\\Workspaces\\math-health\\mhef-library-spreadsheet\\assets\\data\\example_XLS_50.xls";
		}

		// Create the lists according to the data files
		List<List<String>> listDataCsvFull = FileReadMain.getTableData(pathFileCsvInput, new int[]{});
		List<List<String>> listDataCsvShort = FileReadMain.getTableData(pathFileCsvInput, columnsToRead);
		List<List<String>> listDataXlsxFull = FileReadMain.getTableData(pathFileXlsxInput, new int[]{});
		List<List<String>> listDataXlsxShort = FileReadMain.getTableData(pathFileXlsxInput, columnsToRead);

		// Display the data content
		FileReadMain.displayTableData(pathFileCsvInput);
		FileReadMain.displayTableData(pathFileXlsxInput);

		ContentDisplayTable.tableFormattedContentPrint(listDataCsvFull);
		System.out.println(listDataCsvFull);

		// Write data into an external file
		String pathFileOutput = "C:\\Users\\PC\\Workspaces\\math-health\\mhef-library-spreadsheet\\assets\\dist\\result.txt";
		FileWriteData.writeDataIntoFileCsv(listDataCsvFull, pathFileOutput);

		// Convert data files
		String pathFileCsvOutput = "C:\\Users\\PC\\Workspaces\\math-health\\mhef-library-spreadsheet\\assets\\dist\\result.csv";
		String pathFileXlsOutput = "C:\\Users\\PC\\Workspaces\\math-health\\mhef-library-spreadsheet\\assets\\dist\\result.xls";

		/*
		// Not working
		try {
			FileWriteConversion.convertXlsxToCsv(pathFileXlsxInput, pathFileCsvOutput);
			System.out.println("Conversion completed successfully.");
		} catch (IOException e) {
			System.out.println("Error converting XLSX to CSV: " + e.getMessage());
			throw new RuntimeException(e);
		}
		 */

		try {
			FileWriteConversion.convertXlsxToXls(pathFileXlsxInput, pathFileXlsOutput);
			System.out.println("Conversion completed successfully.");
		} catch (IOException e) {
			System.out.println("Error converting XLSX to XLS: " + e.getMessage());
			throw new RuntimeException(e);
		}
	}
}