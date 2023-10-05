package com.mhef.library.spreadsheet.dao.file.write;

import com.mhef.library.spreadsheet.AppTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author Henrik Beck
 * @version 1.0.0
 */
class FileWriteDataTest {
	@BeforeAll
	static void setupListLoadValues() {
		AppTest.listLoadValues();
	}

	@Test
	void writeDataToFileMain() {}

	@Test
	void writeDataIntoFileCsv() {
		List<List<String>> listDataCsvFull = AppTest.getListDataCsvFull();
		List<List<String>> listDataCsvShort = AppTest.getListDataCsvShort();
		List<List<String>> listDataXlsFull = AppTest.getListDataXlsFull();
		List<List<String>> listDataXlsShort = AppTest.getListDataXlsShort();
		List<List<String>> listDataXlsxFull = AppTest.getListDataXlsxFull();
		List<List<String>> listDataXlsxShort = AppTest.getListDataXlsxShort();

		FileWriteData.writeDataIntoFileCsv(listDataCsvFull, AppTest.getPathFileOutputTxt() + "FromCsvFull");
		FileWriteData.writeDataIntoFileCsv(listDataCsvShort, AppTest.getPathFileOutputTxt() + "FrolCsvShort");
		FileWriteData.writeDataIntoFileCsv(listDataXlsFull, AppTest.getPathFileOutputTxt() +  "FromXlsFull");
		FileWriteData.writeDataIntoFileCsv(listDataXlsShort, AppTest.getPathFileOutputTxt() + "FromXlsShort");
		FileWriteData.writeDataIntoFileCsv(listDataXlsxFull, AppTest.getPathFileOutputTxt() + "FromXlsxFull");
		FileWriteData.writeDataIntoFileCsv(listDataXlsxShort, AppTest.getPathFileOutputTxt() + "FromXlsxShort");
	}
}