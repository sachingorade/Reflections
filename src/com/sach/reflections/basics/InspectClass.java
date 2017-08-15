package com.sach.reflections.basics;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

import com.sach.reflections.domain.User;

public class InspectClass {

	public static void main(String[] args) {
		inspectClass(User.class);
	}

	private static void inspectClass(Class<?> clazz) {
		listPublicConstructors(clazz);
		listPrivateConstructors(clazz);
		
		listPublicMethods(clazz);
		listPrivateMethods(clazz);
		
		listPublicFields(clazz);
		listPrivateFields(clazz);
	}
	
	private static void listPrivateFields(Class<?> clazz) {
		Field[] fields = clazz.getDeclaredFields();
		System.out.println("Private/Protected fields:");
		for (Field field : fields) {
			if ((field.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC) {
				continue;
			}
			System.out.println("\tName:" + field.getName());
			System.out.println("\tType:" + field.getType());
			System.out.println("\tPrimitive:" + field.getType().isPrimitive());
			System.out.println();
		}
	}

	private static void listPublicFields(Class<?> clazz) {
		Field[] fields = clazz.getFields();
		System.out.println("Public fields:");
		for (Field field : fields) {
			System.out.println("\tName:" + field.getName());
			System.out.println("\tType:" + field.getType());
			System.out.println();
		}
	}

	private static void listPrivateMethods(Class<?> clazz) {
		Method[] methods = clazz.getDeclaredMethods();
		System.out.println("Private/Protected Methods:");
		for (Method method : methods) {
			if ((method.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC) {
				continue;
			}
			System.out.println("\tName:" + method.getName());
			Class<?>[] parameterTypes = method.getParameterTypes();
			System.out.println("\tParameter count:" + parameterTypes.length);
			System.out.println("\tParameter types:" + Arrays.toString(parameterTypes));
			System.out.println();
		}
	}

	private static void listPublicMethods(Class<?> clazz) {
		Method[] methods = clazz.getMethods();
		System.out.println("Public Methods:");
		for (Method method : methods) {
			System.out.println("\tName:" + method.getName());
			Class<?>[] parameterTypes = method.getParameterTypes();
			System.out.println("\tParameter count:" + parameterTypes.length);
			System.out.println("\tParameter types:" + Arrays.toString(parameterTypes));
			System.out.println();
		}
	}

	private static void listPrivateConstructors(Class<?> clazz) {
		Constructor<?>[] constructors = clazz.getDeclaredConstructors();
		System.out.println("Private/Protected constructors: ");
		for (Constructor<?> con : constructors) {
			if ((con.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC) {
				continue;
			}
			System.out.println("\tName: " + con.getName());
			System.out.println("\tParameter types: " + Arrays.toString(con.getParameterTypes()));
			System.out.println();
		}		
	}
	
	private static void listPublicConstructors(Class<?> clazz) {
		Constructor<?>[] constructors = clazz.getConstructors();
		System.out.println("Public constructors: ");
		for (Constructor<?> con : constructors) {
			System.out.println("\tName: " + con.getName());
			System.out.println("\tParameter types: " + Arrays.toString(con.getParameterTypes()));
			System.out.println();
		}		
	}
	
}
