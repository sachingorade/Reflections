package com.sach.reflections.domain;

import java.util.List;

import com.sach.reflections.annotations.Ignore;

public class User {

	private long userId;
	private String email;
	private String role;
	private List<String> features;
	private String password; // just for example :)
	
	public User() {
	}

	public User(long userId, String email, String role, List<String> features, String password) {
		super();
		this.userId = userId;
		this.email = email;
		this.role = role;
		this.features = features;
		this.password = password;
	}
	
	protected User(long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (userId ^ (userId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (userId != other.userId)
			return false;
		return true;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<String> getFeatures() {
		return features;
	}

	public void setFeatures(List<String> features) {
		this.features = features;
	}

	@Ignore
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
