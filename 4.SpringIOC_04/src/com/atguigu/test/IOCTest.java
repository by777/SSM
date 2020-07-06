package com.atguigu.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.service.BookService;
import com.atguigu.service.UserService;

public class IOCTest {
	
	
	ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	@Test
	public void test() {
		//fail("Not yet implemented");
		
		BookService bookService = ioc.getBean(BookService.class);
		UserService userService = ioc.getBean(UserService.class);
		bookService.save();
		userService.save();
		System.out.println(bookService.getClass()+"父类是======"+bookService.getClass().getSuperclass());
		System.out.println(bookService.getClass()+"带泛型的父类是======"+bookService.getClass().getGenericSuperclass());
		
		/*p=57*/
	}

}
