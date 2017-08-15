package com.sach.reflections.mjson;

import java.util.Arrays;

import com.sach.reflections.domain.User;

public class JsonTest {

	public static void main(String[] args) throws Exception {
		User user = new User(2, "sachin.gorade@somemailprovider.com", "viewer", Arrays.asList("feature1", "feature2"), "passwd");
		String json = Jsoniser.toJson(user);
		System.out.println(json);
	}
	
}
