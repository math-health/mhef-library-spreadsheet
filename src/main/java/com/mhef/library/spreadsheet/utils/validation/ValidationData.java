package com.mhef.library.spreadsheet.utils.validation;

import java.text.SimpleDateFormat;
import java.util.Date;
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

    public static boolean isThereArguments(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide the filename as an argument.");
            return false;
        } else {
            return true;
        }
    }

	public static String convertFromDateToString(Date dateDouble, String syntaxFormat) {
		return new SimpleDateFormat(syntaxFormat).format(dateDouble);
	}
}