package com.mhef.library.spreadsheet.dao.content;

import java.io.IOException;
import java.util.*;
import java.io.FileInputStream;

import com.mhef.library.spreadsheet.utils.validation.ValidationData;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ContentReadXlsx {
	private String fileXlsx;

	public ContentReadXlsx(String fileXlsx) {
		this.fileXlsx = fileXlsx;
	}

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