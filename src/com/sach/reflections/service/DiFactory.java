package com.sach.reflections.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class DiFactory {

	private Map<String, Object> beans;
	
	public DiFactory(URL url) throws Exception {
		beans = new HashMap<>();
		loadBeans(url);
	}

	private void loadBeans(URL url) throws Exception {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()))) {
			String line = null;
			while ((line = br.readLine()) != null) {
				// skip the commented lines
				if (line.startsWith("#")) {
					continue;
				}
				String parts[] = line.split(",");
				Class<?> beanClass = Class.forName(parts[1]);
				beans.put(parts[0], beanClass.newInstance());
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getBean(String type) {
		return (T) beans.get(type);
	}
	
}
