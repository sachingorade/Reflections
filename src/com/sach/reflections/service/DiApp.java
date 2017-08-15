package com.sach.reflections.service;

public class DiApp {

	public static void main(String[] args) throws Exception {
		DiFactory diFactory = new DiFactory(DiApp.class.getResource("/di.txt"));
		DataService dataService = diFactory.getBean("dataService");
		System.out.println(dataService.loadData());
	}
	
}
