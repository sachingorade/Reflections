package com.sach.reflections.loading;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class ExternalClassLoader extends URLClassLoader {

	public ExternalClassLoader(URL[] urls) throws MalformedURLException {
		super(urls);
	}
	
	@Override
	public Class<?> loadClass(String name) throws ClassNotFoundException {
		return super.loadClass(name);
	}
	
	@Override
	protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
		return super.loadClass(name, resolve);
	}

}
