package com.atguigu.book;

import org.springframework.stereotype.Repository;


public class Book {
	private String bookName;
	private String author;
	private Double price;
	private Integer stock;
	private Integer sales;
	private Address address;
	// 一定有无参构造器

	public void setAddress(Address address) {
		this.address = address;
	}
	public String getBookName() {
		return bookName;
	}
	@Override
	public String toString() {
		return "Book [bookName=" + bookName + ", author=" + author + ", price="
				+ price + ", stock=" + stock + ", sales=" + sales
				+ ", address=" + address + "]";
	}
	public Address getAddress() {
		return address;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public Integer getSales() {
		return sales;
	}
	public void setSales(Integer sales) {
		this.sales = sales;
	}


}
