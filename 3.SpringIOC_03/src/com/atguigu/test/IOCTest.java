package com.atguigu.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.atguigu.dao.BookDao;
import com.atguigu.servlet.BookServlet;


	/*Spring的单元测试
	 * 1\导包test
	 * 2、ApplicationContext ioc = null;
	 * 3\@Autowired
		BookServlet bookServlet;
		4\@ContextConfiguration(locations="")指定spring配置文件的位置
		5\RunWith(SpringJUnit4ClassRunner.class)指定用哪种驱动单元测试\默认就是Junit
	 * */

@ContextConfiguration(locations="classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class IOCTest {
	//private ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
	ApplicationContext ioc = null;
	
	@Autowired
	BookServlet bookServlet;
	
	@Test
	public void springTest(){
		System.out.println("Spring单元测试启动了");
	}
	
	
	public void test() {
		BookDao bean = (BookDao) ioc.getBean("bookDao");
		BookDao bean2 = (BookDao) ioc.getBean("bookDao");
		// 默认是单实例
		System.out.println(bean==bean2);
		
		
		//fail("Not yet implemented");
	}
	
	//@Test
	public void test01(){
		/*BookServlet bookServlet = ioc.getBean(BookServlet.class);
		bookServlet.doGet();*/
	}

}
