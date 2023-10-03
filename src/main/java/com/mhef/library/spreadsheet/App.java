package com.mhef.library.spreadsheet;

import com.mhef.library.spreadsheet.dao.content.ContentDisplayTable;
import com.mhef.library.spreadsheet.dao.file.write.FileWriteData;
import com.mhef.library.spreadsheet.dao.file.read.FileReadMain;
import com.mhef.library.spreadsheet.utils.validation.ValidationData;

import java.util.List;

public class App {
	public static void main(String[] args) {
		String pathFileCsv;
		String pathFileXlsx;
		int[] columnsToRead = {1, 3, 5, 6};

		// Check if a filename is provided as an argument
		if (ValidationData.isThereArguments(args)) {
			pathFileCsv = args[0];
			pathFileXlsx = args[0];
		} else {
			pathFileCsv = "C:\\Users\\PC\\Workspaces\\math-health\\mhef-library-spreadsheet\\assets\\data\\cities.csv";
			pathFileXlsx = "C:\\Users\\PC\\Workspaces\\math-health\\mhef-library-spreadsheet\\assets\\data\\example_XLS_50.xls";
		}

		// Call the functions
		FileReadMain.displayTableData(pathFileCsv);
		FileReadMain.displayTableData(pathFileXlsx);

		List<List<String>> listDataCsvFull = FileReadMain.getTableData(pathFileCsv, new int[]{});
		List<List<String>> listDataCsvShort = FileReadMain.getTableData(pathFileCsv, columnsToRead);
		List<List<String>> listDataXlsxFull = FileReadMain.getTableData(pathFileXlsx, new int[]{});
		List<List<String>> listDataXlsxShort = FileReadMain.getTableData(pathFileXlsx, columnsToRead);

		ContentDisplayTable.tableFormattedContentPrint(listDataCsvFull);
		System.out.println(listDataCsvFull);

		String pathFileOutput = "C:\\Users\\PC\\Workspaces\\math-health\\mhef-library-spreadsheet\\assets\\dist\\result.txt";
		FileWriteData.writeDataIntoFileCsv(listDataCsvFull, pathFileOutput);
	}
}