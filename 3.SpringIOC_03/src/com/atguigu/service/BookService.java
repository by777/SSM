package com.atguigu.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.atguigu.dao.BookDao;

@Service
public class BookService {
	
	/*使用Qualifier 找不到就报错
	 * 
	 * @Autowired	标注默认一定装配到。除非@Autowired(required=false)找不到装配null
	 * */
	
	
	@Qualifier("bookDao")//指定一个名作为id，让spring别使用变量名作为id
	//@Autowired
	@Resource //也可以在装配
	private BookDao bookDao;
	
	public void save(){
		System.out.println("BookService正在调用dao帮你保存图书");
		bookDao.saveBook();
	}
}
