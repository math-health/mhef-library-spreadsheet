package com.mhef.library.spreadsheet.dao.content;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Henrik Beck
 * @version 1.0.0
 */
public class ContentSearch {
	/**
	 * @param data The spreadsheet matrix data.
	 * @param cellValue the element to search for.
	 * @return The index of the first occurrence of the specified element using the format of column letter + row number, or null if not found,
	 */
	public static String getIndexFromValue(List<List<String>> data, String cellValue) {
		// Iterate over each row
		for (int row = 0; row < data.size(); row++) {
			List<String> rowData = data.get(row);

			// Iterate over each column
			for (int column = 0; column < rowData.size(); column++) {
				String currentElement = rowData.get(column);

				// Check if the current element matches the search element
				if (currentElement.equals(cellValue)) {
					// Convert the column index to a character
					char columnChar = (char) ('A' + column);

					// Convert the row index to a number
					int rowNumber = row + 1;

					// Return the position in the format of column + row
					return columnChar + Integer.toString(rowNumber);
				}
			}
		}

		// If the element is not found, return null
		return null;
	}

	/**
	 * @param data The spreadsheet matrix data.
	 * @param cellIndex the cell address in the format of column letter + row number
	 * @return The value at the specified cell address, or null if the cell address is invalid
	 */
	public static String getValueFromIndex(List<List<String>> data, String cellIndex) {
		// Convert the cell address to uppercase for consistency
		cellIndex = cellIndex.toUpperCase();

		// Extract the column letters and row number from the cell address
		String columnLetters = cellIndex.replaceAll("[0-9]", "");
		int rowNumber = Integer.parseInt(cellIndex.replaceAll("[A-Z]", ""));

		// Convert the column letters to a zero-based index
		int columnIndex = 0;
		for (int i = 0; i < columnLetters.length(); i++) {
			columnIndex = columnIndex * 26 + (columnLetters.charAt(i) - 'A' + 1);
		}
		columnIndex--;

		// Check if the row number is within the valid range
		if (rowNumber <= 0 || rowNumber > data.size()) {
			return null;
		}

		// Check if the column index is within the valid range
		if (columnIndex < 0 || columnIndex >= data.get(0).size()) {
			return null;
		}

		// Retrieve the cell value from the matrix
		return data.get(rowNumber - 1).get(columnIndex);
	}
}