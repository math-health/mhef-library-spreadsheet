package com.mhef.library.spreadsheet.dao.file.write;

import java.io.*;

import com.mhef.library.spreadsheet.utils.validation.ValidationFile;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author Henrik Beck
 * @version 1.0.0
 */
public class FileWriteConversion {
	/**
	 * <p>Display an error message in case of file conversion fail.</p>
	 *
	 * @todo This function might be migrated to another class to be reused also by the {@link FileWriteData} class.
	 * @param pathFileOrigin The path to the spreadsheet origin file to be based on.
	 * @param pathFileDestiny The path to the spreadsheet result file after exporting.
	 * @param error The IOExpection error value.
	 */
	private static void displayMessageError(String pathFileOrigin, String pathFileDestiny, IOException error) {
		System.out.println("[Error]\tConversion from '" + pathFileOrigin + "' to '" + pathFileDestiny + "' file");
		System.out.println(error.getMessage());
	}

	/**
	 * <p>Display a success message in case of file conversion works.</p>
	 *
	 * @param pathFileOrigin The path to the spreadsheet origin file to be based on.
	 * @param pathFileDestiny The path to the spreadsheet result file after exporting.
	 */
	private static void displayMessageSuccess(String pathFileOrigin, String pathFileDestiny) {
		System.out.println("[Success]\tConversion from '" + pathFileOrigin + "' to '" + pathFileDestiny + "' file");
	}

	/**
	 * @param pathFileXlsx The path to the spreadsheet origin file to be based on.
	 * @param pathFileCsv The path to the spreadsheet result file after exporting.
	 */
	private static void convertFromXlsxToCsv(String pathFileXlsx, String pathFileCsv) throws IOException {
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

	/**
	 * @param pathFileXlsx The path to the spreadsheet origin file to be based on.
	 * @param pathFileXls The path to the spreadsheet result file after exporting.
	 */
	private static void convertFromXlsxToXls(String pathFileXlsx, String pathFileXls) throws IOException {
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

	/**
	 * @param pathFileOrigin The path to the spreadsheet origin file to be based on.
	 * @param pathFileDestiny The path to the spreadsheet result file after exporting.
	 */
	public static void convertFile(String pathFileOrigin, String pathFileDestiny) {
		String fileExtensionOrigin = ValidationFile.getFileExtension(pathFileOrigin);
		String fileExtensionDestiny = ValidationFile.getFileExtension(pathFileDestiny);

		System.out.println("[Trying]\tFrom '" + fileExtensionOrigin + "' to '" + fileExtensionDestiny + "'");

		if (fileExtensionOrigin.equals(fileExtensionDestiny)) {
			System.out.println("[Error]\tCannot convert to identical files extensions");
		} else if ((fileExtensionOrigin.equals(".xlsx") || fileExtensionOrigin.equals(".xls")) && fileExtensionDestiny.equals(".csv")) {
			try {
				FileWriteConversion.convertFromXlsxToCsv(pathFileOrigin, pathFileDestiny);
				displayMessageSuccess(pathFileOrigin, pathFileDestiny);
			} catch (IOException e) {
				displayMessageError(pathFileOrigin, pathFileDestiny, e);
				throw new RuntimeException(e);
			}
		} else if (fileExtensionOrigin.equals(".xlsx") && fileExtensionDestiny.equals(".xls")) {
			try {
				FileWriteConversion.convertFromXlsxToXls(pathFileOrigin, pathFileDestiny);
				displayMessageSuccess(pathFileOrigin, pathFileDestiny);
			} catch (IOException e) {
				displayMessageError(pathFileOrigin, pathFileDestiny, e);
				throw new RuntimeException(e);
			}
		}
	}
}