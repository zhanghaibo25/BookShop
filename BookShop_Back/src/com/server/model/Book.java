package com.server.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/*
 * 作者：张海波
 * 描述：book映射
 */

@Entity
@Table(name="book")
public class Book {

	private int bookId;
    private String bookName;
    private String bookAuthor;
    private String bookPublisher;
    private double bookPrice;//权限
    private String bookImg;
    private String bookFirstCategory;//类别
    private String bookSecondCategory;
    private int bookTransactiontime;
    private int bookStock;//库存
    
    public Book() {
    	
    }
    public Book(String bookName,String bookAuthor,String bookPublisher,double bookPrice,
    		String bookImg,String bookFirstCategory,String bookSecondCategory,int bookTransactiontime,
    		int bookStock,int bookId) {
    	this.bookId = bookId;
    	this.bookName = bookName;
    	this.bookAuthor = bookAuthor;
    	this.bookPublisher = bookPublisher;
    	this.bookPrice = bookPrice;
    	this.bookImg = bookImg;
    	this.bookFirstCategory = bookFirstCategory;
    	this.bookSecondCategory = bookSecondCategory;
    	this.bookTransactiontime = bookTransactiontime;
    	this.bookStock = bookStock;
    }
    @Id
    @Column(name="book_id")
    @GeneratedValue(generator="book_gen")
	@GenericGenerator(name="book_gen",strategy="native")
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	@Column(name="book_name")
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	@Column(name="book_author")
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	@Column(name="book_publisher")
	public String getBookPublisher() {
		return bookPublisher;
	}
	public void setBookPublisher(String bookPublisher) {
		this.bookPublisher = bookPublisher;
	}
	@Column(name="book_price")
	public double getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}
	@Column(name="book_img")
	public String getBookImg() {
		return bookImg;
	}
	public void setBookImg(String bookImg) {
		this.bookImg = bookImg;
	}
	@Column(name="book_first_category")
	public String getBookFirstCategory() {
		return bookFirstCategory;
	}
	public void setBookFirstCategory(String bookFirstCategory) {
		this.bookFirstCategory = bookFirstCategory;
	}
	@Column(name="book_second_category")
	public String getBookSecondCategory() {
		return bookSecondCategory;
	}
	public void setBookSecondCategory(String bookSecondCategory) {
		this.bookSecondCategory = bookSecondCategory;
	}
	@Column(name="book_transaction_time")
	public int getBookTransactiontime() {
		return bookTransactiontime;
	}
	public void setBookTransactiontime(int bookTransactiontime) {
		this.bookTransactiontime = bookTransactiontime;
	}
	@Column(name="book_stock")
	public int getBookStock() {
		return bookStock;
	}
	public void setBookStock(int bookStock) {
		this.bookStock = bookStock;
	}
    
}
