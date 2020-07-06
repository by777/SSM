package com.atguigu.dao;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


/*id默认就是类名首字母小写、改写方法1("bookDao")\调整作用域2*/
@Repository
//@Scope(value="prototype")
public class BookDao {
	
	private String bookName="noName";
	
	public void saveBook(){
		System.out.println("Book已经保存！");
	}
	
}
