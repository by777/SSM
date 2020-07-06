package com.atguigu.factory;

import java.util.UUID;

import org.springframework.beans.factory.FactoryBean;

import com.atguigu.bean.Book;

public class MyFactoryBeanImple implements FactoryBean<Book>{
	
	/*getObject方法 Spring自动调用 --返回创建的对象
	 * 
	 * getObjectType：返回创建对象的类型
	 * Spring会自动调用这个方法来确认创建的对象是什么类型
	 * 
	 * isSingleton：是单例吗
	 * 
	 * 方法：
	 * 1-编写一个FactoryBean的实现类
	 * 2-在spring配置文件中进行注册
	 * */
	
	
	@Override
	public Book getObject() throws Exception {
		System.out.println("MyFactoryBeanImpleb被调用了");
		// TODO Auto-generated method stub
		Book book = new Book();
		book.setBookName(UUID.randomUUID().toString());
		book.setAuthorName("赵思");
		return book;
	}

	@Override
	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		return Book.class;
	}

	@Override
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
