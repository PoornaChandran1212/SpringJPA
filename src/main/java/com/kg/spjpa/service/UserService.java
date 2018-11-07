package com.kg.spjpa.service;

import java.util.List;
// import com.javaspringclub.entity.User;

import com.kg.spjpa.entity.User;

public interface UserService {

	public List getAllUsers();
	public User getUserById(Long id);
	public boolean saveUser(User user);
	public boolean deleteUserById(Long id);

}
