package com.web.controller;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.server.model.Admin;
import com.server.service.AdminService;

//Spring+Springmvc+hibernate开发时，@Controller只能出现在Controller中
@Controller
@RequestMapping("/adminController")
public class AdminController {

	// 使用@Autowired注解注入AdminServiceImpl实例
	@Autowired
	private AdminService adminService;

	@RequestMapping("/login")
	@ResponseBody
	public void logIn(ModelMap map, HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter writer = response.getWriter();
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");
		JSONObject json3 = new JSONObject();
		JSONObject json4 = new JSONObject();
		JSONObject json5 = new JSONObject();
		JSONArray array = new JSONArray();
		List<Admin> adminList =adminService.getAllAdmins();
//		System.out.println(adminList);
		Admin admin=new Admin();
		if(adminList != null) {
			for(Admin thisAdmin:adminList) {
				if(thisAdmin.getAdminPhone().equals(phone)) {
					admin=thisAdmin;
				}
			}
		}

		if (admin.getAdminPhone() == null) {
			json3.put("error", "用户不存在");
			json3.put("success", "success");
			json3.put("adminId", admin.getAdminId());
			json3.put("adminName", admin.getAdminName());
			json3.put("adminPassword", admin.getAdminPassword());
			json3.put("adminSepassword", admin.getAdminSepassword());
			json3.put("adminPhone", admin.getAdminPhone());
			json3.put("adminCategoryid", admin.getCategoryId());
			json3.put("adminImage", admin.getAdminImage());
			json3.put("adminMail", admin.getAdminMail());
			json3.put("adminSex", admin.getAdminSex());
			array.put(json3);
		} else {
			if (!admin.getAdminPassword().equals(password)) {
				json4.put("success", "success");
				json4.put("error", "密码错误");
				json4.put("adminId", admin.getAdminId());
				json4.put("adminName", admin.getAdminName());
				json4.put("adminPassword", admin.getAdminPassword());
				json4.put("adminSepassword", admin.getAdminSepassword());
				json4.put("adminPhone", admin.getAdminPhone());
				json3.put("adminCategoryid", admin.getCategoryId());
				json4.put("adminImage", admin.getAdminImage());
				json4.put("adminMail", admin.getAdminMail());
				json4.put("adminSex", admin.getAdminSex());
				array.put(json4);
			} else {
				json5.put("success", "登录成功");
				json5.put("error", "error");
				json5.put("adminId", admin.getAdminId());
				json5.put("adminName", admin.getAdminName());
				json5.put("adminPassword", admin.getAdminPassword());
				json5.put("adminSepassword", admin.getAdminSepassword());
				json5.put("adminPhone", admin.getAdminPhone());
				json5.put("adminCategoryid", admin.getCategoryId());
				json5.put("adminImage", admin.getAdminImage());
				json5.put("adminMail", admin.getAdminMail());
				json5.put("adminSex", admin.getAdminSex());
				array.put(json5);
			}
		}
		writer.println(array.toString());
		writer.flush();
		writer.close();
	}

	
//	@RequestMapping
//  public String login(Admin admin) {
//      List<Admin> adminList=adminService.login(admin);
//      if (adminList.size() > 0) {
//          // 登录成功，转发到到index.jsp
//          return "index.jsp";
//      } else {
//          // 登录失败，重定向到login.jsp
//          return "redirect:/login.jsp";
//      }
//  }

}
