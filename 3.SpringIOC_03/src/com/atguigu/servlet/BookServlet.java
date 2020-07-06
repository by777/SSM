package com.atguigu.servlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.atguigu.dao.BookDao;
import com.atguigu.service.BookService;


/*@Autowired属性的自动注入:spring去容器中找到对应的组件
 * 
 * 
 * 
 * 
 * */

@Controller
public class BookServlet {
	
	private BookDao bd;
	
	//自动装配赋值
	@Autowired
	private BookService bookService;
	
	public void doGet(){
		bookService.save();
	}
	
	
	/*方法上autowired，
	 * 1、这个方法也会在bean创建的时候自动运行
	 * 2、方法内每一个参数都会自动注入值
	 * 3、同样可以在参数上加@Qualifier("指定id")
	 * */
	@Autowired
	public void hahaha(BookDao bookDao){
		System.out.println("Spring运行了这个方法hahaha");
		bd=bookDao;
		bookDao.saveBook();
	}
	
}
