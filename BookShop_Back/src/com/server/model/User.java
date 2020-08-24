package com.server.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="user")
public class User {

	private int userId;
	private String userName;
	private String userPassword;
	private String userSex;
	private String userPhone;
	private String userMail;
	private String userAddress;
	private Date userLogintime;
	private String userPurrecord;
	private String userImg;
	
	public User() {
		
	}
	public User(int userId,String userName,String userPassword,String userSex,String userPhone,String userMail,
			String userAddress,Date userLogintime,String userPurrecord,String userImg) {
		this.userId = userId;
		this.userName = userName;
		this.userPassword= userPassword;
		this.userSex = userSex;
		this.userPhone= userPhone;
		this.userMail= userMail;
		this.userAddress = userAddress;
		this.userLogintime = userLogintime;
		this.userPurrecord = userPurrecord;
		this.userImg = userImg;
	}
	@Id
    @Column(name="user_id")
    @GeneratedValue(generator="user_gen")
	@GenericGenerator(name="user_gen",strategy="native")
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Column(name="user_name")
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Column(name="user_password")
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	@Column(name="user_sex")
	public String getUserSex() {
		return userSex;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	@Column(name="user_phone")
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	@Column(name="user_mail")
	public String getUserMail() {
		return userMail;
	}
	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}
	@Column(name="user_address")
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	@Column(name="user_login_time")
	public Date getUserLogintime() {
		return userLogintime;
	}
	public void setUserLogintime(Date userLogintime) {
		this.userLogintime = userLogintime;
	}
	@Column(name="user_pur_record")
	public String getUserPurrecord() {
		return userPurrecord;
	}
	public void setUserPurrecord(String userPurrecord) {
		this.userPurrecord = userPurrecord;
	}
	@Column(name="user_img")
	public String getUserImg() {
		return userImg;
	}
	public void setUserImg(String userImg) {
		this.userImg = userImg;
	}
	
}
