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

import com.server.model.User;
import com.server.service.UserService;

@Controller
@RequestMapping("/userController")
public class UserController {

	// 使用@Autowired注解注入AdminServiceImpl实例
		@Autowired
		private UserService userService;

		
		@RequestMapping("/updateuser")
		@ResponseBody
		public void update(ModelMap map,HttpServletRequest request,HttpServletResponse response) throws Exception {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			PrintWriter writer = response.getWriter();
			int id=Integer.parseInt(request.getParameter("id"));
			System.err.println(id);
			String name=request.getParameter("name");
			String password=request.getParameter("password");
			String sex=request.getParameter("sex");
			String phone=request.getParameter("phone");
			String mail=request.getParameter("mail");
			String address=request.getParameter("address");
			JSONObject json7 = new JSONObject();
			JSONObject json9 = new JSONObject();
			JSONArray array = new JSONArray();
			User user=new User();
			int flag=0;
			List<User> userList = userService.getAllUsers(); 
			for(User thisUser:userList) {
				if(thisUser.getUserPhone().equals(phone)) {
					if(thisUser.getUserId()==id) {
						user=thisUser;
						flag=1;
					}else {
						json9.put("success", "success");
						json9.put("error", "该手机号已被注册");
						json9.put("id", "id");
						json9.put("mail", "mali");
						json9.put("address", "address");
						json9.put("password", "password");
						json9.put("phone", "phone");
						json9.put("name", "name");
						json9.put("sex", "sex");
						array.put(json9);
						flag=0;
						break;
					}
				}else {
					if(thisUser.getUserId()==id) {
						user=thisUser;
						flag=1;
					}
				}
			}
			if(flag==1) {
				user.setUserName(name);
				user.setUserPhone(phone);
				user.setUserSex(sex);
				user.setUserPassword(password);
				user.setUserMail(mail);
				user.setUserAddress(address);
				try {
					userService.checkUser(user);
					json7.put("success", "修改成功");
					json7.put("error", "error");
					json7.put("phone", user.getUserPhone());
					json7.put("id", user.getUserId());
					json7.put("password", user.getUserPassword());
					json7.put("mail", user.getUserMail());
					json7.put("address", user.getUserAddress());
					json7.put("name", user.getUserName());
					json7.put("sex", user.getUserSex());
					array.put(json7);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			writer.println(array.toString());
			writer.flush();
			writer.close();
		}
		@RequestMapping("/finduser")
		@ResponseBody
		public void Check(ModelMap map, HttpServletRequest request, HttpServletResponse response) throws Exception {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			PrintWriter writer = response.getWriter();
			String username = request.getParameter("name");
			List<User> userList = userService.getAllUsers();
			User user = new User(); 
			if(userList != null) {
				for (User thisUser : userList) {
					if (thisUser.getUserName().equals(username)) {
						user = thisUser;
					}
				}
			}		
			JSONObject json = new JSONObject();
			JSONObject json2 = new JSONObject();
			JSONArray array = new JSONArray();
			if (user.getUserName() != null) {
				json.put("error", "error");
				json.put("success", "success");
				json.put("id", user.getUserId());
				json.put("name", user.getUserName());
				json.put("password", user.getUserPassword());
				json.put("sex", user.getUserSex());
				json.put("phone", user.getUserPhone());
				json.put("mail", user.getUserMail());
				json.put("address", user.getUserAddress());
				json.put("logintime", user.getUserLogintime());
				json.put("purrecord", user.getUserPurrecord());
				json.put("img", user.getUserImg());
				array.put(json);
			}else {
				json2.put("error", "该书不存在");
				json2.put("success", "success");
				json2.put("id", user.getUserId());
				json2.put("name", user.getUserName());
				json2.put("password", user.getUserPassword());
				json2.put("sex", user.getUserSex());
				json2.put("phone", user.getUserPhone());
				json2.put("mail", user.getUserMail());
				json2.put("address", user.getUserAddress());
				json2.put("logintime", user.getUserLogintime());
				json2.put("purrecord", user.getUserPurrecord());
				json2.put("img", user.getUserImg());
				array.put(json2);
			}
			writer.println(array.toString());
			writer.flush();
			writer.close();
		}

		@RequestMapping("/userlist")
		@ResponseBody
		public void UserList(ModelMap map, HttpServletRequest request, HttpServletResponse response) throws Exception {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			PrintWriter writer = response.getWriter();
			List<User> userList = userService.getAllUsers();
			JSONArray jsonArray = new JSONArray();
			if(userList != null) {
				for(int i=0;i<userList.size();i++) {	
					JSONObject json = new JSONObject();
					JSONArray array = new JSONArray();
					json.put("error", "error");
					json.put("success", "success");
					json.put("id", userList.get(i).getUserId());
					json.put("name", userList.get(i).getUserName());
					json.put("password", userList.get(i).getUserPassword());
					json.put("sex", userList.get(i).getUserSex());
					json.put("phone", userList.get(i).getUserPhone());
					json.put("mail", userList.get(i).getUserMail());
					json.put("address", userList.get(i).getUserAddress());
					json.put("logintime", userList.get(i).getUserLogintime());
					json.put("purrecord", userList.get(i).getUserPurrecord());
					json.put("img", userList.get(i).getUserImg());
					array.put(json);
					jsonArray.put(array);
				}
			}
			writer.println(jsonArray.toString());
			System.out.println(jsonArray);
			writer.flush();
			writer.close();
		}
}
