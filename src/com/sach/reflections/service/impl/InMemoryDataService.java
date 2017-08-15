package com.sach.reflections.service.impl;

import com.sach.reflections.service.DataService;

public class InMemoryDataService implements DataService {

	private static final String DATA = "1, sachin, 449";
	
	@Override
	public String loadData() {
		return DATA;
	}

}
