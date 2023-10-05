package com.mhef.library.spreadsheet.dao.content;

import com.mhef.library.spreadsheet.AppTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

class ContentDisplayTableTest {
	@BeforeAll
	static void setupListLoadValues() {
		AppTest.listLoadValues();
	}

	@Test
	void tableFormattedContentPrint() {
		List<List<String>> listDataCsvFull = AppTest.getListDataCsvFull();
		List<List<String>> listDataCsvShort = AppTest.getListDataCsvShort();
		List<List<String>> listDataXlsFull = AppTest.getListDataXlsFull();
		List<List<String>> listDataXlsShort = AppTest.getListDataXlsShort();
		List<List<String>> listDataXlsxFull = AppTest.getListDataXlsxFull();
		List<List<String>> listDataXlsxShort = AppTest.getListDataXlsxShort();

		ContentDisplayTable.tableFormattedContentPrint(listDataCsvFull);
		ContentDisplayTable.tableFormattedContentPrint(listDataCsvShort);
		ContentDisplayTable.tableFormattedContentPrint(listDataXlsFull);
		ContentDisplayTable.tableFormattedContentPrint(listDataXlsShort);
		ContentDisplayTable.tableFormattedContentPrint(listDataXlsxFull);
		ContentDisplayTable.tableFormattedContentPrint(listDataXlsxShort);
	}

	@Test
	void tableNotFormattedContentPrint() {
		List<List<String>> listDataCsvFull = AppTest.getListDataCsvFull();
		List<List<String>> listDataCsvShort = AppTest.getListDataCsvShort();
		List<List<String>> listDataXlsFull = AppTest.getListDataXlsFull();
		List<List<String>> listDataXlsShort = AppTest.getListDataXlsShort();
		List<List<String>> listDataXlsxFull = AppTest.getListDataXlsxFull();
		List<List<String>> listDataXlsxShort = AppTest.getListDataXlsxShort();

		ContentDisplayTable.tableNotFormattedContentPrint(listDataCsvFull);
		ContentDisplayTable.tableNotFormattedContentPrint(listDataCsvShort);
		ContentDisplayTable.tableNotFormattedContentPrint(listDataXlsFull);
		ContentDisplayTable.tableNotFormattedContentPrint(listDataXlsShort);
		ContentDisplayTable.tableNotFormattedContentPrint(listDataXlsxFull);
		ContentDisplayTable.tableNotFormattedContentPrint(listDataXlsxShort);
	}
}