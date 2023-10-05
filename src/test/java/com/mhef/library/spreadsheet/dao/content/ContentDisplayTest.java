package com.mhef.library.spreadsheet.dao.content;

import com.mhef.library.spreadsheet.AppTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

class ContentDisplayTest {
	@BeforeAll
	static void setupListLoadValues() {
		AppTest.listLoadValues();
	}

	@Test
	void listAsArray() {
		List<List<String>> listDataCsvFull = AppTest.getListDataCsvFull();
		List<List<String>> listDataCsvShort = AppTest.getListDataCsvShort();
		List<List<String>> listDataXlsFull = AppTest.getListDataXlsFull();
		List<List<String>> listDataXlsShort = AppTest.getListDataXlsShort();
		List<List<String>> listDataXlsxFull = AppTest.getListDataXlsxFull();
		List<List<String>> listDataXlsxShort = AppTest.getListDataXlsxShort();

		// Display the data content
		ContentDisplay.listAsArray(listDataCsvFull);
		ContentDisplay.listAsArray(listDataCsvShort);
		ContentDisplay.listAsArray(listDataXlsFull);
		ContentDisplay.listAsArray(listDataXlsShort);
		ContentDisplay.listAsArray(listDataXlsxFull);
		ContentDisplay.listAsArray(listDataXlsxShort);
	}

	@Test
	void tableFormattedContentPrint() {
		List<List<String>> listDataCsvFull = AppTest.getListDataCsvFull();
		List<List<String>> listDataCsvShort = AppTest.getListDataCsvShort();
		List<List<String>> listDataXlsFull = AppTest.getListDataXlsFull();
		List<List<String>> listDataXlsShort = AppTest.getListDataXlsShort();
		List<List<String>> listDataXlsxFull = AppTest.getListDataXlsxFull();
		List<List<String>> listDataXlsxShort = AppTest.getListDataXlsxShort();

		ContentDisplay.tableFormattedContentPrint(listDataCsvFull);
		ContentDisplay.tableFormattedContentPrint(listDataCsvShort);
		ContentDisplay.tableFormattedContentPrint(listDataXlsFull);
		ContentDisplay.tableFormattedContentPrint(listDataXlsShort);
		ContentDisplay.tableFormattedContentPrint(listDataXlsxFull);
		ContentDisplay.tableFormattedContentPrint(listDataXlsxShort);
	}

	@Test
	void tableNotFormattedContentPrint() {
		List<List<String>> listDataCsvFull = AppTest.getListDataCsvFull();
		List<List<String>> listDataCsvShort = AppTest.getListDataCsvShort();
		List<List<String>> listDataXlsFull = AppTest.getListDataXlsFull();
		List<List<String>> listDataXlsShort = AppTest.getListDataXlsShort();
		List<List<String>> listDataXlsxFull = AppTest.getListDataXlsxFull();
		List<List<String>> listDataXlsxShort = AppTest.getListDataXlsxShort();

		ContentDisplay.tableNotFormattedContentPrint(listDataCsvFull);
		ContentDisplay.tableNotFormattedContentPrint(listDataCsvShort);
		ContentDisplay.tableNotFormattedContentPrint(listDataXlsFull);
		ContentDisplay.tableNotFormattedContentPrint(listDataXlsShort);
		ContentDisplay.tableNotFormattedContentPrint(listDataXlsxFull);
		ContentDisplay.tableNotFormattedContentPrint(listDataXlsxShort);
	}
}