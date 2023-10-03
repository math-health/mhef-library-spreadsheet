package com.henrik.library.data.validation;

import java.util.List;

public class ValidationData {
	public static boolean isRowContentDataEmpty(String[] values) {
		for (String value : values) {
			if (!value.trim().isEmpty()) {
				return false;
			}
		}

		return true;
	}

	public static boolean isRowContentDataEmptyOrNullable(List<String> row) {
		boolean isEmptyRow = true;

		for (String value : row) {
			if (!value.trim().isEmpty() && !value.equals("NULL") && !value.matches("^\\s*$")) {
				isEmptyRow = false;
				break;
			}
		}

		if (isEmptyRow) {
			return true;
		}

		return false;
	}
}