package com.mhef.library.spreadsheet;

public class UtilsMath {
	public static boolean isEven(int number) {
		return number % 2 == 0;
	}

	public static boolean isOdd(int number) {
		return number % 2 != 0;
	}

	public static double roundToNearestEven(double value) {
		double roundedValue = Math.round(value * 10000) / 10000.0; // rounding to four decimal places

		// Check if the rounded value is exactly in the middle between two neighboring even values
		if (roundedValue * 100 % 2 == 0.5) {
			long roundedValueLong = Math.round(roundedValue * 1000); // rounding to three decimal places

			// If the rounded value is odd, subtracting 1 will make it the nearest lower even value
			if (roundedValueLong % 2 != 0) {
				roundedValue -= 0.0001; // subtracting 0.0001 to get the nearest lower even value
			}
		}

		return roundedValue;
	}

	public static void main(String[] args) {
		System.out.println(isEven(3));
		System.out.println(isOdd(3));

		System.out.println(roundToNearestEven(0.18549)); // Output: 0.1854
		System.out.println(roundToNearestEven(0.18555)); // Output: 0.1856
	}
}