package com.sach.reflections.loading;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;

public class MyClassLoader {

	public static void main(String[] args) throws Exception {
		// build an external class loader
		System.out.println("Using resource:" + MyClassLoader.class.getResource("/external.jar"));
		ClassLoader classLoader = new ExternalClassLoader(new URL[]{MyClassLoader.class.getResource("/external.jar")});

		try {
			System.out.println("\nLoading external driver:");
			Class<?> driver = Class.forName("com.external.Driver", true, classLoader);
			
			System.out.println("\nInitializing external driver:");
			Object obj = driver.newInstance();
			
			Method[] methods = driver.getMethods();
			for (Method method : methods) {
				if (method.getName().equals("getConnection")) {
					System.out.println("Connection from outside class: " + method.invoke(obj));
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

}
