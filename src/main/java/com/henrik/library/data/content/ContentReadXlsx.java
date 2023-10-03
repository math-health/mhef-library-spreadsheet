package com.henrik.library.data.content;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ContentReadXlsx {
	private String fileXlsx;

	public ContentReadXlsx(String fileXlsx) {
		this.fileXlsx = fileXlsx;
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
					String cellValue = "";

					if (cell.getCellTypeEnum() == CellType.STRING) {
						cellValue = cell.getStringCellValue();
					} else if (cell.getCellTypeEnum() == CellType.NUMERIC) {
						cellValue = String.valueOf(cell.getNumericCellValue());
					} else if (cell.getCellTypeEnum() == CellType.BOOLEAN) {
						cellValue = String.valueOf(cell.getBooleanCellValue());
					}

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
						String cellValue = "";

						if (cell.getCellTypeEnum() == CellType.STRING) {
							cellValue = cell.getStringCellValue();
						} else if (cell.getCellTypeEnum() == CellType.NUMERIC) {
							cellValue = String.valueOf(cell.getNumericCellValue());
						} else if (cell.getCellTypeEnum() == CellType.BOOLEAN) {
							cellValue = String.valueOf(cell.getBooleanCellValue());
						}

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