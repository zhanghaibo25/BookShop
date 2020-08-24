package com.server.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.server.dao.AdminDao;
import com.server.model.Admin;

/*
 *作者：张海波
 *描述： 
 */
//使用@Repository注解在Spring容器中注册实例
@Repository
@Transactional
public class AdminDaoImpl implements AdminDao {

	// 通过@Autowired注解注入Spring容器中的SessionFactory实例
	@Autowired
    private SessionFactory sessionFactory;
    
	@SuppressWarnings("unchecked")
	public List<Admin> getAllAdmins(){
		//开始查询
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Admin";
		Query query = session.createQuery(hql);
		List<Admin> adminlist = query.list();
		//返回查询值
		return adminlist;
	}
	
	
//    @SuppressWarnings("unchecked")
//	@Override
//    public List<Admin> search(Admin cond) {
//    	// 使用HQL查询，优点：
//    	// 1. 直接针对实体类和属性进行查询，不用写繁琐的SQL语句
//    	// 2. 查询结果直接保存在List对象中，不用再次封装
//    	// 3. 可以通过配置dialect属性，对不同数据库自动生成不同的用于执行的SQL语句。
//        // 获得session
//        Session session = sessionFactory.getCurrentSession();
//        String hql = "from Admin as ui where ui.adminName=:adminName and ui.adminPassword=:adminPassword";
//        Query query = session.createQuery(hql);
//        query.setString("adminName", cond.getAdminName());
//        query.setString("adminPassword", cond.getAdminPassword());
//        List<Admin> adminList = query.list();
//        System.out.println(hql);
//        return adminList;
//    }
//	public int reviseAdmin(Admin admin) {
//		// 开始更新
//		Session session = sessionFactory.getCurrentSession();
//		Transaction tx = session.beginTransaction();
//		//hql语句要和Admin中顺序一致
//		String hql = "update Admin set adminName =?,adminPassword=?,adminSepassword=?,categoryId=?,adminSex=?,adminPhone=?,adminMail=?,adminImage=? where adminId = ?";
//		Query query = session.createQuery(hql);
//		query.setParameter(0, admin.getAdminName());
//		query.setParameter(1, admin.getAdminPassword());
//		query.setParameter(2, admin.getAdminSepassword());
//		query.setParameter(3, admin.getCategoryId());
//		query.setParameter(4, admin.getAdminSex());
//		query.setParameter(5, admin.getAdminPhone());
//		query.setParameter(6, admin.getAdminMail());
//		query.setParameter(7, admin.getAdminImage());		
//		query.setParameter(8, admin.getAdminId());
//		int ret = query.executeUpdate();
//		tx.commit();
//		return ret;
//	}
}
