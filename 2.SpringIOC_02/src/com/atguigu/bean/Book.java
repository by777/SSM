package com.atguigu.bean;

public class Book {
	private String bookName;
	private String authorName;
	
	public void myInit(){
		System.out.println("图书初始化----》");
	}
	
	public void myDestory(){
		System.out.println("图书对象已销毁");
	}
	
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	@Override
	public String toString() {
		return "Book [bookName=" + bookName + ", authorName=" + authorName
				+ "]";
	}
	
}
