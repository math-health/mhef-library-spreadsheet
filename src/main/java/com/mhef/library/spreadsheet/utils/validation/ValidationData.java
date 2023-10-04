package com.mhef.library.spreadsheet.utils.validation;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author Henrik Beck
 * @version 1.0.0
 */
public class ValidationData {
	/**
	 * @param row The spreadsheet matrix data from a single row.
	 * @return The verification about if all the values from a single row is empty (null) or not.
	 */
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

	/**
	 * @param args The arguments informed from the command line interface(CLI).
	 * @return The verification about if there is or there is not arguments.
	 */
    public static boolean isThereArguments(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide the filename as an argument.");
            return false;
        } else {
            return true;
        }
    }

	/**
	 * @param dateDouble The date as double format. In example, the 42598.0 value.
	 * @param syntaxFormat The date format syntax. In example, the "M/d/yy hh:ss" value
	 * @return The converted value based on the date format syntax. In example, "8/16/16 12:00" value
	 */
	public static String convertFromDateToString(Date dateDouble, String syntaxFormat) {
		return new SimpleDateFormat(syntaxFormat).format(dateDouble);
	}
}