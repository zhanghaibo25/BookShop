package com.server.service;

import java.util.List;

import com.server.model.User;

public interface UserService {
	public User addUser(User user);
	//删除
	public int deleteUser(int userId);
	//列出所有
	public List<User> getAllUsers();
	//根据种类查
	public User checkUser(User user);
	//更新
	public int updateUser(User user);
}
