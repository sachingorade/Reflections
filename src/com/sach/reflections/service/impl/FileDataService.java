package com.sach.reflections.service.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.sach.reflections.service.DataService;

public class FileDataService implements DataService {

	@Override
	public String loadData() throws Exception {
		StringBuilder builder = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/data.txt")))) {
			String line = null;
			while ((line = br.readLine()) != null) {
				builder.append(line);
			}
		}
		return builder.toString();
	}
	
	public String loadDataFromSomeOtherMeans() {
		return "asasas";
	}

}
