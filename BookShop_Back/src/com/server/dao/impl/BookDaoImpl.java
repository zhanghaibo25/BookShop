package com.server.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.server.dao.BookDao;
import com.server.model.Book;

@Repository
@Transactional
public class BookDaoImpl implements BookDao{

	@Autowired
    private SessionFactory sessionFactory1;
	
	public Book addBook(Book book) {
		Session session = sessionFactory1.getCurrentSession();
		Transaction tx = session.beginTransaction();
		String hql = "add from Book where bookId = ?";
		Query query = session.createQuery(hql);
		Book ret = (Book) query.uniqueResult();
		tx.commit();
		return ret;	
		
	}
	public int deleteBook(int bookId) {
		Session session = sessionFactory1.getCurrentSession();
		Transaction tx = session.beginTransaction();
		String hql = "delete from Book where bookId = ?";
		Query query = session.createQuery(hql);
		int ret = query.executeUpdate();
		tx.commit();
		return ret;	
	}
	@SuppressWarnings("unchecked")
	public List<Book> getAllBooks(){
		//开始查询
		Session session = sessionFactory1.getCurrentSession();
		String hql = "from Book";
		Query query = session.createQuery(hql);
		List<Book> booklist = query.list();
		//返回查询值
		return booklist;
	}
	public Book checkBook(Book book) {
		//开始查询
		Session session = sessionFactory1.getCurrentSession();
		String hql = "from Book where bookName = ?";
		Query query = session.createQuery(hql);
		query.setParameter(0,book);
		Book book2 = (Book)query.uniqueResult();
		//返回查询值
		return book2;		
	}
//	public String checkBook(Book book) {
//		//开始查询
//		Session session = sessionFactory1.getCurrentSession();
//		String hql = "from Book where bookName = ?";
//		Query query = session.createQuery(hql);
//		query.setParameter(0,book);
//		String book2 = query.toString();
//		//返回查询值
//		return book2;		
//	}
	public int updateBook(Book book) {
		// 开始更新
		Session session = sessionFactory1.getCurrentSession();
		Transaction tx = session.beginTransaction();
		//hql语句要和Admin中顺序一致
		String hql = "update Book set bookName =?,bookAuthor=?,bookPublisher=?,bookPrice=?,bookImg=?,bookFirstCategory=?,bookSecondCategory=?,bookTransaction=?,bookStock=? where bookId = ?";
		Query query = session.createQuery(hql);
		query.setParameter(0, book.getBookName());
		query.setParameter(1, book.getBookAuthor());
		query.setParameter(2, book.getBookPublisher());
		query.setParameter(3, book.getBookPrice());
		query.setParameter(4, book.getBookImg());
		query.setParameter(5, book.getBookFirstCategory());
		query.setParameter(6, book.getBookSecondCategory());
		query.setParameter(7, book.getBookTransactiontime());		
		query.setParameter(8, book.getBookStock());
		query.setParameter(9, book.getBookId());
		int ret = query.executeUpdate();
		tx.commit();
		return ret;
	}	
}
