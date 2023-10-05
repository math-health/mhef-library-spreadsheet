package com.mhef.library.spreadsheet.dao.file.write;

import com.mhef.library.spreadsheet.AppTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Henrik Beck
 * @version 1.0.0
 */
class FileWriteConversionTest {
	@BeforeAll
	static void setupListLoadValues() {
		AppTest.listLoadValues();
	}

	@Test
	void convertFile() {
		FileWriteConversion.convertFile(AppTest.getPathFileInputXls(), AppTest.getPathFileOutputCsv());
		FileWriteConversion.convertFile(AppTest.getPathFileInputXls(), AppTest.getPathFileOutputXls());
	}
}