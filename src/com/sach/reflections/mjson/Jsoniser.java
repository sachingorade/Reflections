package com.sach.reflections.mjson;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Map;

import com.sach.reflections.annotations.Ignore;

public class Jsoniser {

	public static String toJson(Object object) throws Exception {
		if (object == null) {
			return "null";
		}
		
		if (object.getClass().isArray()) {
			return convertArrayToJson(object);
		}
		
		if (object instanceof String) {
			return "\"" + object.toString() + "\"";
		}
		
		if (object instanceof Number || object instanceof Boolean) {
			return object.toString();
		}
		
		if (object instanceof Map) {
			// TODO
			return "";
		}
		
		if (object instanceof Collection) {
			return convertCollectionToJsonArray(object);
		}
		
		
		return convertObjectToJson(object);
	}

	private static String convertCollectionToJsonArray(Object object) throws Exception {
		StringBuilder builder = new StringBuilder("[");
		boolean firstObject = true;
		for (Object obj : (Collection<?>)object) {
			if (firstObject) {
				firstObject = false;
			} else {
				builder.append(",");
			}
			builder.append(toJson(obj));
		}
		return builder.append("]").toString();
	}

	private static String convertObjectToJson(Object object) throws Exception {
		StringBuilder builder = new StringBuilder("{\n");
		Method[] methods = object.getClass().getMethods();
		boolean firstObject = true;
		for (Method method : methods) {
			String propertyName = method.getName();

			Ignore ignore = method.getAnnotation(Ignore.class);
			if (ignore != null) {
				/*
				 * This method is to be ignored...
				 */
				continue;
			}
			
			if (isClassMethod(propertyName)) {
				continue;
			}
			
			if (propertyName.startsWith("get")) {
				propertyName = propertyName.substring(3, 4).toLowerCase() + propertyName.substring(4);
			} else if (propertyName.startsWith("is")) {
				propertyName = propertyName.substring(2, 3).toLowerCase() + propertyName.substring(3);
			} else {
				continue;
			}
			if (firstObject) {
				firstObject = false;
			} else {
				builder.append(",").append("\n");
			}
			builder.append("\t")
			.append("\"")
			.append(propertyName)
			.append(" : ")
			.append(toJson(method.invoke(object)));
		}
		return builder.append("\n}").toString();
	}
	
	private static boolean isClassMethod(String propertyName) {
		switch (propertyName) {
		case "getClass":
			return true;
		default:
			break;
		}
		return false;
	}

	private static String convertArrayToJson(Object arrayObject) throws Exception {
		StringBuilder builder = new StringBuilder("[");
		Object[] arr = (Object[]) arrayObject;
		boolean firstObject = true;
		for (Object obj : arr) {
			if (firstObject) {
				firstObject = false;
			} else {
				builder.append(",");
			}
			builder.append(toJson(obj));
		}
		return builder.append("]").toString();
	}
	
}
