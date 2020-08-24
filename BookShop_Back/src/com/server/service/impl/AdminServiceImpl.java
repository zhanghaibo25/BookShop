package com.server.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.server.dao.AdminDao;
import com.server.model.Admin;
import com.server.service.AdminService;


@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	public AdminDao adminDao;
	
	
	public List<Admin> getAllAdmins(){
		return adminDao.getAllAdmins();
	}

}
