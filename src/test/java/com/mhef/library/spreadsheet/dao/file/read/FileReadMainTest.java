package com.mhef.library.spreadsheet.dao.file.read;

import com.mhef.library.spreadsheet.AppTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * @author Henrik Beck
 * @version 1.0.0
 */
class FileReadMainTest {
	@BeforeAll
	static void setupListLoadValues() {
		AppTest.listLoadValues();
	}

	/**
	 * @todo This method must be tested
	 */
	@Test
	void displayTableData() {
		FileReadMain.displayTableData(AppTest.getPathFileInputCsv());
		FileReadMain.displayTableData(AppTest.getPathFileInputTxt());
		FileReadMain.displayTableData(AppTest.getPathFileInputXls());
		FileReadMain.displayTableData(AppTest.getPathFileInputXlsx());
	}

	@Test
	void getTableData() {}
}