package com.server.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/*
 * 作者：张海波
 * 描述：User映射
 * */
/*
 * 创建一个Entity Bean对象
 * @Entity 表明该类 (UserEntity) 为一个实体类，它默认对应数据库中的表名是user_entity也可以写成
 * @Entity
 * @Table(name = "xwj_user", schema = "test")
 */
@Entity
@Table(name="admin")
public class Admin {
	private int adminId;
    private String adminName;
    private String adminPassword;
    private String adminSepassword;
    private int categoryId;//权限
    private String adminSex;
    private String adminPhone;
    private String adminMail;
    private String adminImage;
    //无参构造
    public Admin() {
    	
    }
    //有参构造
    public Admin(String adminName,String adminPassword,String adminSepassword,int categoryId,
    		String adminSex,String adminPhone,String adminMail,String adminImage,int adminId) {
    	super();
    	this.adminName=adminName;
    	this.adminPassword=adminPassword;
    	this.adminSepassword=adminSepassword;
    	this.categoryId=categoryId;
    	this.adminSex=adminSex;
    	this.adminPhone=adminPhone;
    	this.adminMail=adminMail;
    	this.adminImage=adminImage;
    	this.adminId=adminId;
    }
    public Admin(String adminPhone,String adminPassword) {
    	super();
    	this.adminPhone=adminPhone;
    	this.adminPassword=adminPassword;
    }
    public Admin(String adminPhone) {
    	super();
    	this.adminPhone=adminPhone;
    }
    /*
     * @Column注释定义了将成员属性映射到关系表中的哪一列和该列的结构信息
     * @Id注释指定表的主键
     * @GeneratorValue注解----JPA通用策略生成器
     * @GenericGenerator注解----自定义主键生成策略
     */
    @Id
    @Column(name="admin_id")
    @GeneratedValue(generator="admin_gen")
	@GenericGenerator(name="admin_gen",strategy="native")
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	
	@Column(name="admin_name")
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	
	@Column(name="admin_password")
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	
	@Column(name="admin_sepassword")
	public String getAdminSepassword() {
		return adminSepassword;
	}
	public void setAdminSepassword(String adminSepassword) {
		this.adminSepassword = adminSepassword;
	}
	
	@Column(name="category_id")
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
	@Column(name="admin_sex")
	public String getAdminSex() {
		return adminSex;
	}
	public void setAdminSex(String adminSex) {
		this.adminSex = adminSex;
	}
	
	@Column(name="admin_phone")
	public String getAdminPhone() {
		return adminPhone;
	}
	public void setAdminPhone(String adminPhone) {
		this.adminPhone = adminPhone;
	}
	
	@Column(name="admin_mail")
	public String getAdminMail() {
		return adminMail;
	}
	public void setAdminMail(String adminMail) {
		this.adminMail = adminMail;
	}
	
	@Column(name="admin_image")
	public String getAdminImage() {
		return adminImage;
	}
	public void setAdminImage(String adminImage) {
		this.adminImage = adminImage;
	}
    
}
