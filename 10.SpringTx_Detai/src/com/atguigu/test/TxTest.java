package com.atguigu.test;

import java.io.FileNotFoundException;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.service.BookService;

public class TxTest {
	ApplicationContext ioc = new ClassPathXmlApplicationContext("tx.xml");

	@Test
	public void test() throws FileNotFoundException {
		/* fail("Not yet implemented"); */
		BookService bookService = (BookService) ioc.getBean(BookService.class);
		bookService.checkOut("Tom", "ISBN-001");
		System.out.println("结账完成");
	}

}
