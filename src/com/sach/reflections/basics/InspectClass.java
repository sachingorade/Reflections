package com.sach.reflections.basics;

import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;
import java.util.Arrays;

import com.sach.reflections.domain.User;

public class InspectClass {

	public static void main(String[] args) {
		Constructor<?>[] constructors = User.class.getConstructors();
		System.out.println("Total constructors : " + constructors.length);
		for (Constructor<?> con : constructors) {
			System.out.println("\tName : " + con.getName());
			Parameter[] parameters = con.getParameters();
			System.out.println("\tParameters:");
			if (parameters.length > 0) {
				for (Parameter param : parameters) {
					System.out.println("\t\tParam : " + param.getDeclaringExecutable());
					System.out.println("\t\tType : " + param.getClass());
				}
			}
		}
	}
	
}
