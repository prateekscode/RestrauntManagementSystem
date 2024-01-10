package com.prateeks.dao;

public interface UserDao {

	boolean isValidUser(String username, String password);

	boolean addUser(User user);
	
	String getUserType(String username , String password);

}
