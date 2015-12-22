package com.classcontent.model;

import java.io.File;

/**
 * 图书模型
 * @author guibs
 *
 */
public class Book {
	private int id;
	private String bookName;
	private double price;
	private String author;
	private int bookTypeId;
	private File context;
	private File pic;
	
	
	public File getPic() {
		return pic;
	}
	public void setPic(File pic) {
		this.pic = pic;
	}
	public File getContext() {
		return context;
	}
	public void setContext(File context) {
		this.context = context;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getBookTypeId() {
		return bookTypeId;
	}
	public void setBookTypeId(int bookTypeId) {
		this.bookTypeId = bookTypeId;
	}
	
	public Book(String bookName, double price, String author, int bookTypeId) {
		super();
		this.bookName = bookName;
		this.price = price;
		this.author = author;
		this.bookTypeId = bookTypeId;
	}
	public Book(int id, String bookName, double price, String author, int bookTypeId) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.price = price;
		this.author = author;
		this.bookTypeId = bookTypeId;
	}
	public Book(String bookName, double price, String author, int bookTypeId, File context) {
		super();
		this.bookName = bookName;
		this.price = price;
		this.author = author;
		this.bookTypeId = bookTypeId;
		this.context = context;
	}
	public Book(String bookName, double price, String author, int bookTypeId, File context, File pic) {
		super();
		this.bookName = bookName;
		this.price = price;
		this.author = author;
		this.bookTypeId = bookTypeId;
		this.context = context;
		this.pic = pic;
	}
	
	
	
}
