package com.mhef.library.spreadsheet.dao.content;

import java.io.IOException;
import java.util.*;
import java.io.FileInputStream;

import com.mhef.library.spreadsheet.utils.validation.ValidationData;
import org.apache.poi.ss.usermodel.*;

/**
 * @author Henrik Beck
 * @version 1.0.0
 */
public class ContentReadXlsx {
	private String fileXlsx;

	/**
	 * Constructs a new instance of the ContentReadXlsx class with the specified file path to a .xlsx file.
	 *
	 * @param fileXlsx The path to the .xlsx file that will be read.
	 */
	public ContentReadXlsx(String fileXlsx) {
		this.fileXlsx = fileXlsx;
	}

	/**
	 * @todo Migrate this function to ValidationData class
	 * @todo Implement the a dynamic value to format the date syntax'. By now, it is static set to be 'M/d/yy hh:ss' format
	 * 
	 * @param cell The spreadsheet current cell value.
	 * @return The value of the cell in the spreadsheet, considering the original primitive type parser.
	 */
	private static String getCellValueAsStringAccordingToCellType(Cell cell) {
		if (cell.getCellTypeEnum() == CellType.STRING) {
			return cell.getStringCellValue();
		} else if (cell.getCellTypeEnum() == CellType.NUMERIC) {
			if (DateUtil.isCellDateFormatted(cell)) {
				return ValidationData.convertFromDateToString(cell.getDateCellValue(), "M/d/yy hh:ss");
			} else {
				return String.valueOf(cell.getNumericCellValue());
			}
		} else if (cell.getCellTypeEnum() == CellType.BOOLEAN) {
			return String.valueOf(cell.getBooleanCellValue());
		} else {
			return cell.getStringCellValue();
		}
	}

	/**
	 * @param fileXlsx The path to the .xlsx file.
	 * @return The spreadsheet matrix data with the full data content.
	 */
	public List<List<String>> readData(String fileXlsx) {
		List<List<String>> data = new ArrayList<>();

		try (FileInputStream fis = new FileInputStream(fileXlsx)) {
			Workbook workbook = WorkbookFactory.create(fis);
			Sheet sheet = workbook.getSheetAt(0);

			Iterator<Row> rowIterator = sheet.iterator();

			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				List<String> rowData = new ArrayList<>();

				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					String cellValue = getCellValueAsStringAccordingToCellType(cell);
					rowData.add(cellValue.trim());
				}

				data.add(rowData);
			}

			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return data;
	}

	/**
	 * @param fileXlsx The path to the .xlsx file.
	 * @param columnsToRead The index of the specifics columns to be read.
	 * @return The spreadsheet matrix data, only with the specifics columns content.
	 */
	public List<List<String>> readData(String fileXlsx, int[] columnsToRead) {
		List<List<String>> data = new ArrayList<>();

		try (FileInputStream fis = new FileInputStream(fileXlsx)) {
			Workbook workbook = WorkbookFactory.create(fis);
			Sheet sheet = workbook.getSheetAt(0);

			Iterator<Row> rowIterator = sheet.iterator();

			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				List<String> rowData = new ArrayList<>();

				int columnIndex = 0;

				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();

					if (Arrays.binarySearch(columnsToRead, columnIndex) >= 0) {
						String cellValue = getCellValueAsStringAccordingToCellType(cell);
						rowData.add(cellValue.trim());
					}

					columnIndex++;
				}

				data.add(rowData);
			}

			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return data;
	}
}