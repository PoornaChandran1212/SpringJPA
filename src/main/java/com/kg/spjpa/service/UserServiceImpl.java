package com.kg.spjpa.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import com.kg.spjpa.entity.User;
import com.kg.spjpa.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// import com.javaspringclub.entity.User;
// import com.javaspringclub.userRepository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired

	// Implementing Constructor based DI
	private UserRepository userRepository;

	// public UserServiceImpl() {

	// }

	// @Autowired
	// public UserServiceImpl(UserRepository userRepository) {
	// super();
	// this.userRepository = userRepository;
	// }

	// @Override
	public List getAllUsers() {
		List list = new ArrayList<>();
		userRepository.findAll().forEach(e -> list.add(e));
		return list;
	}

	// @Override
	public User getUserById(Long id) {
		User user = userRepository.findById(id).get();
		return user;
	}

	// @Override
	public boolean saveUser(User user) {
		try {
			userRepository.save(user);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	// @Override
	public boolean deleteUserById(Long id) {
		try {
			userRepository.deleteById(id);
			return true;
		} catch (Exception ex) {
			return false;
		}

	}

}