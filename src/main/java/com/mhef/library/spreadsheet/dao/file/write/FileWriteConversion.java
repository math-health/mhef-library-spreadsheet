package com.mhef.library.spreadsheet.dao.file.write;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileWriteConversion {
	// Not working
	public static void convertXlsxToCsv(String xlsxFilePath, String csvFilePath) throws IOException {
		try (Workbook workbook = new XSSFWorkbook(new FileInputStream(xlsxFilePath));
			 FileOutputStream csvWriter = new FileOutputStream(csvFilePath)) {
			Sheet sheet = workbook.getSheetAt(0);

			for (Row row : sheet) {
				for (Cell cell : row) {
					csvWriter.write(cell.getStringCellValue().getBytes());
					if (cell.getColumnIndex() != row.getLastCellNum() - 1) {
						csvWriter.write(',');
					}
				}
				csvWriter.write('\n');
			}
		}
	}

	public static void convertXlsxToXls(String xlsFilePath, String xlsxFilePath) throws IOException {
		try (Workbook xlsWorkbook = new HSSFWorkbook(new FileInputStream(xlsFilePath));
			 Workbook xlsxWorkbook = new XSSFWorkbook()) {

			for (Sheet sheet : xlsWorkbook) {
				Sheet xlsxSheet = xlsxWorkbook.createSheet(sheet.getSheetName());
				for (Row row : sheet) {
					Row xlsxRow = xlsxSheet.createRow(row.getRowNum());
					for (Cell cell : row) {
						Cell xlsxCell = xlsxRow.createCell(cell.getColumnIndex(), cell.getCellType());
						switch (cell.getCellType()) {
							case STRING:
								xlsxCell.setCellValue(cell.getStringCellValue());
								break;
							case NUMERIC:
								xlsxCell.setCellValue(cell.getNumericCellValue());
								break;
							case BOOLEAN:
								xlsxCell.setCellValue(cell.getBooleanCellValue());
								break;
							case FORMULA:
								xlsxCell.setCellFormula(cell.getCellFormula());
								break;
							default:
								xlsxCell.setCellValue("");
								break;
						}
					}
				}
			}

			try (FileOutputStream xlsxOutputStream = new FileOutputStream(xlsxFilePath)) {
				xlsxWorkbook.write(xlsxOutputStream);
			}
		}
	}
}