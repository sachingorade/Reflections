package com.sach.reflections.intercept;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.sach.reflections.service.DataService;
import com.sach.reflections.service.DiFactory;

public class MethodInterceptor {

	public static void main(String[] args) throws Exception {
		DiFactory diFactory = new DiFactory(MethodInterceptor.class.getResource("/di.txt"));
		DataService dataService = getInterceptor(diFactory.getBean("dataService"));
		dataService.loadData();
	}
	
	
	@SuppressWarnings("unchecked")
	private static <T> T getInterceptor(final T type) {
		InvocationHandler handler = new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println(">> Before executing target method : " + method.getName());
				Object result = method.invoke(type, args);
				System.out.println("\n\t Data from target : " + result);
				System.out.println("\n>> After executing target method : " + method.getName());
				return result;
			}
		};
		
		Object proxyInstance = Proxy.newProxyInstance(MethodInterceptor.class.getClassLoader(), 
				type.getClass().getInterfaces(), handler);
		return (T) proxyInstance;
	}
	
}
