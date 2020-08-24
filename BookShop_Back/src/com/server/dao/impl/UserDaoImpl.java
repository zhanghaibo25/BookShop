package com.server.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.server.dao.UserDao;
import com.server.model.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao{
	@Autowired
    private SessionFactory sessionFactory1;
	
	public User addUser(User user) {
		Session session = sessionFactory1.getCurrentSession();
		Transaction tx = session.beginTransaction();
		String hql = "add from User where userId = ?";
		Query query = session.createQuery(hql);
		User ret = (User) query.uniqueResult();
		tx.commit();
		return ret;	
		
	}
	public int deleteUser(int userId) {
		Session session = sessionFactory1.getCurrentSession();
		Transaction tx = session.beginTransaction();
		String hql = "delete from User where userId = ?";
		Query query = session.createQuery(hql);
		int ret = query.executeUpdate();
		tx.commit();
		return ret;	
	}
	@SuppressWarnings("unchecked")
	public List<User> getAllUsers(){
		//开始查询
		Session session = sessionFactory1.getCurrentSession();
		String hql = "from User";
		Query query = session.createQuery(hql);
		List<User> userlist = query.list();
		//返回查询值
		return userlist;
	}
	public User checkUser(User user) {
		//开始查询
		Session session = sessionFactory1.getCurrentSession();
		String hql = "from User where userName = ?";
		Query query = session.createQuery(hql);
		query.setParameter(0,user);
		User user2 = (User)query.uniqueResult();
		//返回查询值
		return user2;		
	}
	public int updateUser(User user) {
		// 开始更新
		Session session = sessionFactory1.getCurrentSession();
		Transaction tx = session.beginTransaction();
		//hql语句要和Admin中顺序一致
		String hql = "update User set userName =?,userPassword=?,userSex=?,userPhone=?,userMail=?,userAddress=?,userLogintime=?,userPurrecord=?,userImg=? where userId = ?";
		Query query = session.createQuery(hql);
		query.setParameter(0, user.getUserName());
		query.setParameter(1, user.getUserPassword());
		query.setParameter(2, user.getUserSex());
		query.setParameter(3, user.getUserPhone());
		query.setParameter(4, user.getUserMail());
		query.setParameter(5, user.getUserAddress());
		query.setParameter(6, user.getUserLogintime());
		query.setParameter(7, user.getUserPurrecord());		
		query.setParameter(8, user.getUserImg());
		query.setParameter(9, user.getUserId());
		int ret = query.executeUpdate();
		tx.commit();
		return ret;
	}	

}
