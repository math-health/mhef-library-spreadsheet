package com.henrik.library.data.content;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ContentReadCsv {
	private String fileCsv;

	public ContentReadCsv(String fileCsv) {
		this.fileCsv = fileCsv;
	}

	public List<List<String>> readData(String fileCsv) {
		List<List<String>> data = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(fileCsv))) {
			String line;

			while ((line = br.readLine()) != null) {
				String[] values = line.split(",");
				List<String> row = new ArrayList<>();

				for (String value : values) {
					row.add(value.trim());
				}

				data.add(row);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return data;
	}
}