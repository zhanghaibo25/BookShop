package com.server.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.server.dao.BookDao;
import com.server.model.Book;
import com.server.service.BookService;

@Repository("bookDao")
@Service
public class BookServiceImpl implements BookService{

	@Autowired
	public BookDao bookDao;
	
	//添加
	public Book addBook(Book book) {
		return bookDao.addBook(book);
	}
	//删除
	public int deleteBook(int bookId) {
		return bookDao.deleteBook(bookId);
	}
	//列出所有
	public List<Book> getAllBooks(){
		return bookDao.getAllBooks();
	}
	//修改
	public int updateBook(Book book) {
		return bookDao.updateBook(book);
	}
	//根据种类查
	public Book checkBook(Book book) {
		return bookDao.checkBook(book);
	}
//	public String checkBook(Book book) {
//		return bookDao.checkBook(book);
//	}
		
}
