package com.henrik.library;

import com.henrik.library.data.content.ContentDisplayTable;
import com.henrik.library.data.file.write.FileWriteData;
import com.henrik.library.data.file.read.FileReadMain;

import java.util.List;

public class App {
	private static boolean isThereArguments(String[] args) {
		if (args.length == 0) {
			System.out.println("Please provide the filename as an argument.");
			return false;
		} else {
			return true;
		}
	}

	public static void main(String[] args) {
		String pathFileCsv;
		String pathFileXlsx;
		int[] columnsToRead = {1, 3, 5, 6};

		// Check if a filename is provided as an argument
		if (isThereArguments(args)) {
			pathFileCsv = args[0];
			pathFileXlsx = args[0];
		} else {
			pathFileCsv = "C:\\Users\\PC\\Workspaces\\interfusao\\library-sdms-file-data\\assets\\data\\cities.csv";
			pathFileXlsx = "C:\\Users\\PC\\Workspaces\\interfusao\\library-sdms-file-data\\assets\\data\\example_XLS_50.xls";
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

		String pathFileOutput = "C:\\Users\\PC\\Workspaces\\interfusao\\library-sdms-file-data\\assets\\data\\result.txt";
		FileWriteData.writeDataIntoFileCsv(listDataCsvFull, pathFileOutput);
	}
}