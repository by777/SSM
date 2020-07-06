package com.atguigu.dao;

import org.springframework.stereotype.Repository;

import com.atguigu.bean.Book;

@Repository
public class BookDao extends BaseDao<Book>{

	@Override
	public void save() {
		// TODO Auto-generated method stub
		System.out.println("BookDao保存图书了");
		
	}

}
