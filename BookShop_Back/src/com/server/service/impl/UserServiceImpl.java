package com.server.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.server.dao.UserDao;
import com.server.model.User;
import com.server.service.UserService;

@Repository("userDao")
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	public UserDao userDao;
	
	
	public User addUser(User user) {
		return userDao.addUser(user);
	}

	public int deleteUser(int userId) {
		return userDao.deleteUser(userId);
	}

	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	public User checkUser(User user) {
		return userDao.checkUser(user);
	}

	public int updateUser(User user) {
		return userDao.updateUser(user);
	}

}
