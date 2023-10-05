package com.mhef.library.spreadsheet.dao.content;

import com.mhef.library.spreadsheet.AppTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Henrik Beck
 * @version 1.0.0
 */
class ContentSearchTest {
	@BeforeAll
	static void setupListLoadValues() {
		AppTest.listLoadValues();
	}

	@Test
	void getIndexFromValue() {
		List<List<String>> listDataCsvFull = AppTest.getListDataCsvFull();

		assertEquals(ContentSearch.getIndexFromValue(listDataCsvFull, "\"Tyler\""), "I40");
		assertEquals(ContentSearch.getIndexFromValue(listDataCsvFull, "\"Twin Falls\""), "I41");
	}

	@Test
	void getValueFromIndex() {
		List<List<String>> listDataCsvFull = AppTest.getListDataCsvFull();

		assertEquals(ContentSearch.getValueFromIndex(listDataCsvFull, "A1"), "\"LatD\"");
		assertEquals(ContentSearch.getValueFromIndex(listDataCsvFull, "A2"), "41");
		assertEquals(ContentSearch.getValueFromIndex(listDataCsvFull, "B1"), "\"LatM\"");
		assertEquals(ContentSearch.getValueFromIndex(listDataCsvFull, "B2"), "5");
		assertEquals(ContentSearch.getValueFromIndex(listDataCsvFull, "H7"), "\"W\"");
		assertEquals(ContentSearch.getValueFromIndex(listDataCsvFull, "HB95"), null);
	}
}