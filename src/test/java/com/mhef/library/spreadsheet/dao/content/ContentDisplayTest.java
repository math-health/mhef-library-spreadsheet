package com.mhef.library.spreadsheet.dao.content;

import com.mhef.library.spreadsheet.AppTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Henrik Beck
 * @version 1.0.0
 */
class ContentDisplayTest {
	@BeforeAll
	static void setupListLoadValues() {
		AppTest.listLoadValues();
	}

	/**
	 * @todo Implement tests for listDataCsvFull.
	 * @todo Implement tests for listDataCsvShort.
	 * @todo Implement tests for listDataXlsFull.
	 * @todo Implement tests for listDataXlsShort.
	 * @todo Implement tests for listDataXlsxFull.
	 * @todo Implement tests for listDataXlsxShort.
	 */
	@Test
	void checkCellValueDataContent(){
		List<List<String>> listDataCsvFull = AppTest.getListDataCsvFull();
		List<List<String>> listDataCsvShort = AppTest.getListDataCsvShort();
		List<List<String>> listDataXlsFull = AppTest.getListDataXlsFull();
		List<List<String>> listDataXlsShort = AppTest.getListDataXlsShort();
		List<List<String>> listDataXlsxFull = AppTest.getListDataXlsxFull();
		List<List<String>> listDataXlsxShort = AppTest.getListDataXlsxShort();

		// Test spreadsheet cell values
		assertEquals(listDataCsvFull.get(0).get(0), "\"LatD\"");	// Cell A1
		assertEquals(listDataCsvFull.get(0).get(1), "\"LatM\"");	// Cell B1
		assertEquals(listDataCsvFull.get(0).get(2), "\"LatS\"");	// Cell C1
		assertEquals(listDataCsvFull.get(1).get(0), "41");		// Cell A2
		assertEquals(listDataCsvFull.get(1).get(1), "5");		// Cell B2
		assertEquals(listDataCsvFull.get(1).get(2), "59");		// Cell C2
		assertEquals(listDataCsvFull.get(2).get(0), "42");		// Cell A3
		assertEquals(listDataCsvFull.get(2).get(1), "52");		// Cell B3
		assertEquals(listDataCsvFull.get(2).get(2), "48");		// Cell C3

		assertEquals(listDataXlsShort.get(1).get(2), "32.0"); // Cell C2
		assertEquals(listDataXlsShort.get(2).get(3), "8/16/16 12:00"); // Cell D2 // Output: 8/16/16 12:00 || 16/08/2016 || 42598.0
		assertEquals(listDataXlsShort.get(2).get(3).getClass().getSimpleName(), "String");

//		assertEquals(listDataXlsShort.get(0), "[First Name, Gender, Age, Date]");
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