package com.server.service;

import java.util.List;

import com.server.model.Book;

public interface BookService {

	// 增加
	public Book addBook(Book book);

	// 删除
	public int deleteBook(int bookId);

	// 列出所有
	public List<Book> getAllBooks();

	// 根据种类查
	public Book checkBook(Book book);
//	public String checkBook(Book book);

	// 修改
	public int updateBook(Book book);

}
