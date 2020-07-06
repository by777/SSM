package com.atguigu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.bean.Book;
import com.atguigu.dao.BaseDao;
import com.atguigu.dao.BookDao;

@Service
public class BookService extends BaseService<Book> {
	//子类会自动复制粘贴进代码，注入正确的dao

}
