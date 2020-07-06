package com.atguigu.test;

import static org.junit.Assert.*;

import java.util.Map;
import java.util.Properties;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.bean.Person;


public class IocTest {
	//private ApplicationContext ioc = new  ClassPathXmlApplicationContext("ioc.xml");
	//private ApplicationContext ioc2 = new  ClassPathXmlApplicationContext("ioc2.xml");

	
	
	public void test() {
		/*从容器中获取组件*/
		//ApplicationContext代表IOC容器
		//当前应用的xml文件在ClassPath下
		//ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc.xml");//容器创建时 == 此时创建对象
		// 得到ioc容器对象
		//Person bean =(Person) ioc.getBean("person01");//不是此时
		//System.out.println(bean);
		//fail("Not yet implemented");
		//同一个组件在容器中是单实例的
	}
	
	// 通过类型会失败

/*	public void test02(){
		 没有唯一的bean 报错
		Person bean  = ioc.getBean(Person.class);
		// 修改
		//Person bean = (Person) ioc.getBean("person01");
		//System.out.print(bean);
		Person bean = (Person) ioc2.getBean("person03");
		//System.out.println(bean.getCar());
		//System.out.println(bean.getBooks());
		//Map<String, Object> maps = bean.getMaps();

		System.out.println(bean.getMaps());
		Map<String,Object> bean2 = (Map<String, Object>) ioc2.getBean("myMap");
		System.out.println(bean2);
	}   */  
	
	@Test
	public void testFactory(){
		ApplicationContext ioc3 = new ClassPathXmlApplicationContext("ioc3.xml");
		System.out.println(ioc3.getBean("myFactoryBeanImple"));
	}

}
