package com.mhef.library.spreadsheet.dao.content;

import com.mhef.library.spreadsheet.utils.validation.ValidationData;

import java.util.List;

public class ContentDisplayTable {
	private static int[] tableFormattedCalculateColumnWidths(List<List<String>> data) {
		int[] columnWidths = new int[data.get(0).size()];

		for (List<String> row : data) {
			for (int i = 0; i < row.size(); i++) {
				columnWidths[i] = Math.max(columnWidths[i], row.get(i).length());
			}
		}

		return columnWidths;
	}

	private static void tableFormattedColumnsPrint(int[] columnWidths, List<String> row) {
		String formattedValue;

		for (int i = 0; i < row.size(); i++) {
			String value = row.get(i).trim();

			// Check if cell content content is nullable
			if (value.isEmpty() || value.equals("NULL") || value.matches("^\\s*$")) {
				// Display 'NULL' in red color
				formattedValue = String.format("\033[0;31m%-" + columnWidths[i] + "s\033[0m ", "NULL");
			} else {
				formattedValue = String.format("%-" + columnWidths[i] + "s ", value);
			}

			System.out.print("|" + formattedValue + "\t");
		}
	}

	private static void tableFormattedSeparatorHeaderPrint(int[] columnWidths) {
		for (int i = 0; i < columnWidths.length; i++) {
			System.out.print("|");
			System.out.print("-".repeat(columnWidths[i] + 0) + " ");
			System.out.print("\t");

			if (i == columnWidths.length - 1) {
				tableFormattedSeparatorRowPrint(columnWidths);
			}
		}
	}

	private static void tableFormattedSeparatorRowPrint(int[] columnWidths) {
		System.out.println();
	}

	public static void tableFormattedContentPrint(List<List<String>> data) {
		int[] columnWidths = tableFormattedCalculateColumnWidths(data);

		// Print the rows values
		for (int i = 0; i < data.size(); i++) {
			List<String> row = data.get(i);

			// Ignore empty lines
			if (ValidationData.isRowContentDataEmptyOrNullable(row)) {
				continue;
			}

			if (i == 1) {
				tableFormattedSeparatorHeaderPrint(columnWidths);
			}

			tableFormattedColumnsPrint(columnWidths, row);
			tableFormattedSeparatorRowPrint(columnWidths);
		}
	}

	public static void tableNotFormattedContentPrint(List<List<String>> data) {
		for (List<String> row : data) {
			for (String value : row) {
				System.out.print(value + "\t");
			}

			System.out.println();
		}
	}
}