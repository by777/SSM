package com.atguigu.test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.bean.Person;

public class IOCTest {
	
	ConfigurableApplicationContext ioc =new  ClassPathXmlApplicationContext("applicationContext03.xml");

	
	public void test() {
		System.out.println("启动");
		ioc.getBean("myBeanPostProcessor");
		ioc.close();
		//fail("Not yet implemented");
	}
	
	
	public void test02() throws SQLException{
		//1.从容器中拿到连接池
		//或者DataSource dataSource = (DataSource) ioc.getBean("dataSource");
		
//		DataSource bean = ioc.getBean(DataSource.class);
//		System.out.println(bean.getConnection());
		System.out.println("====");
		DataSource bean = (DataSource) ioc.getBean("dataSource");
		System.out.println(bean.getConnection());
	}

	@Test
	public void test03(){
		Person person = (Person) ioc.getBean("person04");
		System.out.println(person);
	}
}
