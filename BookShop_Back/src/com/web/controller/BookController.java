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

import com.server.model.Book;
import com.server.service.BookService;

@Controller
@RequestMapping("/bookController")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@RequestMapping("/findbook")
	@ResponseBody
	public void Check(ModelMap map, HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter writer = response.getWriter();
		String bookname = request.getParameter("bookName");
		List<Book> bookList = bookService.getAllBooks();
//		System.out.println(bookList);
		Book book = new Book();
		if(bookList != null) {
			for (Book thisBook : bookList) {
				if (thisBook.getBookName().equals(bookname)) {
					book = thisBook;
				}
			}
		}		
		JSONObject json = new JSONObject();
		JSONObject json2 = new JSONObject();
		JSONArray array = new JSONArray();
		if (book.getBookName() != null) {
			json.put("error", "error");
			json.put("success", "success");
			json.put("bookId", book.getBookId());
			json.put("bookName", book.getBookName());
			json.put("bookAuthor", book.getBookAuthor());
			json.put("bookPublisher", book.getBookPublisher());
			json.put("bookPrice", book.getBookPrice());
			json.put("bookImg", book.getBookImg());
			json.put("bookFirstCategory", book.getBookFirstCategory());
			json.put("bookSecondCategory", book.getBookSecondCategory());
			json.put("bookTransaction", book.getBookTransactiontime());
			json.put("bookStock", book.getBookStock());
			array.put(json);
		}else {
			json2.put("error", "该书不存在");
			json2.put("success", "success");
			json2.put("bookId", book.getBookId());
			json2.put("bookName", book.getBookName());
			json2.put("bookAuthor", book.getBookAuthor());
			json2.put("bookPublisher", book.getBookPublisher());
			json2.put("bookPrice", book.getBookPrice());
			json2.put("bookImg", book.getBookImg());
			json2.put("bookFirstCategory", book.getBookFirstCategory());
			json2.put("bookSecondCategory", book.getBookSecondCategory());
			json2.put("bookTransaction", book.getBookTransactiontime());
			json2.put("bookStock", book.getBookStock());
			array.put(json2);
		}
		writer.println(array.toString());
		writer.flush();
		writer.close();
	}

	@RequestMapping("/booklist")
	@ResponseBody
	public void BookList(ModelMap map, HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter writer = response.getWriter();
//		String bookname = request.getParameter(" ");
		List<Book> bookList = bookService.getAllBooks();
		JSONArray jsonArray = new JSONArray();
		if(bookList != null) {
			for(int i=0;i<bookList.size();i++) {	
				JSONObject json = new JSONObject();
				JSONArray array = new JSONArray();
				json.put("error", "error");
				json.put("success", "success");
				json.put("bookId", bookList.get(i).getBookId());
				json.put("bookName", bookList.get(i).getBookName());
				json.put("bookAuthor", bookList.get(i).getBookAuthor());
				json.put("bookPublisher", bookList.get(i).getBookPublisher());
				json.put("bookPrice", bookList.get(i).getBookPrice());
				json.put("bookImg", bookList.get(i).getBookImg());
				json.put("bookFirstCategory", bookList.get(i).getBookFirstCategory());
				json.put("bookSecondCategory", bookList.get(i).getBookSecondCategory());
				json.put("bookTransaction", bookList.get(i).getBookTransactiontime());
				json.put("bookStock", bookList.get(i).getBookStock());
				array.put(json);
				jsonArray.put(array);
			}
		}
		writer.println(jsonArray.toString());
		System.out.println(jsonArray);
		writer.flush();
		writer.close();
	}
//	@RequestMapping("/update")
//	@ResponseBody
//	public void update(ModelMap map, HttpServletRequest request, HttpServletResponse response) throws Exception {
//		request.setCharacterEncoding("utf-8");
//		response.setCharacterEncoding("utf-8");
//		PrintWriter writer = response.getWriter();
//		List<Book> bookList = bookService.getAllBooks();
//		Book book = new Book();
//		if (request.getParameter("name") != null) {
//			String name = request.getParameter("name");
//			for (Book thisBook : bookList) {
//				if (thisBook.getBookName().equals(name)) {
//					book = thisBook;
//				}
//			}
//		}
//		JSONObject json = new JSONObject();
//		JSONArray array = new JSONArray();
//		if (book.getBookName() != null) {
//			json.put("bookId", book.getBookId());
//			json.put("bookName", book.getBookName());
//			json.put("bookAuthor", book.getBookAuthor());
//			json.put("bookPulisher", book.getBookPublisher());
//			json.put("bookPrice", book.getBookPrice());
//			json.put("bookImg", book.getBookImg());
//			json.put("bookFirstCategory", book.getBookFirstCategory());
//			json.put("bookSecondCategory", book.getBookSecondCategory());
//			json.put("bookTransaction", book.getBookTransactiontime());
//			json.put("bookStock", book.getBookStock());
//			array.put(json);
//		}
//		writer.println(array.toString());
//		writer.flush();
//		writer.close();
//	}

}
