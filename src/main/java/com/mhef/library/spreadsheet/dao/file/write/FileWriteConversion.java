package com.mhef.library.spreadsheet.dao.file.write;

import java.io.*;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileWriteConversion {
	public static void convertXlsxToCsv(String pathFileXlsx, String pathFileCsv) throws IOException {
		try (Workbook workbook = WorkbookFactory.create(new FileInputStream(pathFileXlsx));
			 BufferedWriter csvWriter = new BufferedWriter(new FileWriter(pathFileCsv))) {

			Sheet sheet = workbook.getSheetAt(0);
			for (Row row : sheet) {
				for (Cell cell : row) {
					String cellValue = "";
					switch (cell.getCellType()) {
						case STRING:
							cellValue = cell.getStringCellValue();
							break;
						case NUMERIC:
							cellValue = String.valueOf(cell.getNumericCellValue());
							break;
						case BOOLEAN:
							cellValue = String.valueOf(cell.getBooleanCellValue());
							break;
						case BLANK:
							cellValue = "";
							break;
						default:
							cellValue = "";
							break;
					}
					csvWriter.write(cellValue + ",");
				}
				csvWriter.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void convertXlsxToXls(String pathFileXlsx, String pathFileXls) throws IOException {
		try (Workbook xlsWorkbook = new HSSFWorkbook(new FileInputStream(pathFileXlsx));
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

			try (FileOutputStream xlsxOutputStream = new FileOutputStream(pathFileXls)) {
				xlsxWorkbook.write(xlsxOutputStream);
			}
		}
	}
}