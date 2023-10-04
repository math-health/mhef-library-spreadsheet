package com.mhef.library.spreadsheet.utils.message;

import com.mhef.library.spreadsheet.dao.file.write.FileWriteData;

import java.io.IOException;

/**
 * @author Henrik Beck
 * @version 1.0.0
 */
public class MessageDisplay {
	/**
	 * <p>Display an error message in case of file conversion fails.</p>
	 *
	 * @todo This function might be migrated to another class to be reused also by the {@link FileWriteData} class.
	 * @param pathFileOrigin The path to the spreadsheet origin file to be based on.
	 * @param pathFileDestiny The path to the spreadsheet result file after exporting.
	 * @param error The IOExpection error value.
	 */
	public static void displayMessageFileConversionError(String pathFileOrigin, String pathFileDestiny, IOException error) {
		System.out.println("[Error]\tConversion from '" + pathFileOrigin + "' to '" + pathFileDestiny + "' file");
		System.err.println(error.getMessage());
	}

	/**
	 * <p>Display a success message in case of file conversion works.</p>
	 *
	 * @param pathFileOrigin The path to the spreadsheet origin file to be based on.
	 * @param pathFileDestiny The path to the spreadsheet result file after exporting.
	 */
	public static void displayMessageFileConversionSuccess(String pathFileOrigin, String pathFileDestiny) {
		System.out.println("[Success]\tConversion from '" + pathFileOrigin + "' to '" + pathFileDestiny + "' file");
	}

	/**
	 * <p>Display an error message in case of file write fails.</p>
	 *
	 * @todo This function might be migrated to another class to be reused also by the {@link FileWriteData} class.
	 * @param pathFile The path to the spreadsheet origin file to be based on.
	 * @param error The IOExpection error value.
	 */
	public static void displayMessageFileWriteError(String pathFile, IOException error) {
		System.out.println("[Error]\tData has not been written into '" + pathFile + "' file");
		System.err.println(error.getMessage());
	}

	/**
	 * <p>Display a success message in case of file write works.</p>
	 *
	 * @param pathFile The path to the spreadsheet origin file to be based on.
	 */
	public static void displayMessageFileWriteSuccess(String pathFile) {
		System.out.println("[Success]\tData has been written into '" + pathFile + "' file");
	}
}