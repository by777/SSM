package com.atguigu.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atguigu.dao.BookDao;

@Service
public class BookService {
	@Autowired
	BookDao bookDao;

	/*
	 * 事务的细节 P100
	 * 
	 * 异常分类： 运行时异常（非检查异常）：、可以不用处理、默认都回滚 编译时异常（检查异常）：要么try-catch要么throw
	 * 事务回滚：默认运行异常时都回滚，编译异常时不会回滚
	 * 
	 * isolation - Isolation： 事务的隔离级别 propagation -Propagation： 事务的传播行为
	 * 
	 * noRollbackFor -Class[]： 哪些异常事务可以不回滚-原来默认回滚的异常不回滚 noRollbackForClassName
	 * -String[]： String全类名
	 * 
	 * rollbackFor -Class[]： 哪些异常回滚的 rollbackForClassName -String[]： String全类名
	 * 
	 * readOnly -boolean：设置事务为只读事务 可以进行事务优化（当多个事务都是读，加快查询速度，默认false,说瞎话会报异常）
	 * timeout -int：超时指定时间（s）(sleep()是毫秒)自动终止并回滚
	 * 
	 * value -就是默认不写的 * ************************ propagation
	 * ：如果有多个事务进行嵌套，子事务是否要和大事务公共用一个事务 √REQUIRED：如果有事务A在运行，就在A内运行，如果没有A，就自己新建一个
	 * √REQUIRED_NEW:必须启动新事务，并在新事务内运行，如果有事务在运行，就把之前事务挂起
	 * SUPPORTS：如果有事务在运行，就在事务内运行。如果没有，就拉倒了，不在事务中运行
	 * NOT_SUPPORTED:当前方法不应该运行在事务内，如果有事务，将它挂起
	 * MANDATORY（翻译：强制）:当前方法必须运行在事务里，如果没有事务，就抛异常 NEVER：当前方法不应该运行在事务里，如果有事务、抛异常
	 * NESTED：如果有事务在运行，就内嵌子事务运行，否则就启动自己的新事务
	 */
	@Transactional
	public void checkOut(String userName, String isbn) {
		bookDao.updateStock(isbn);
		int price = bookDao.getPrice(isbn);
		bookDao.updateBalance(userName, price);

		/*
		 * 数学异常 运行时异常 默认回滚的 int a = 1 / 0; 测试事务
		 */
		// 编译时异常
		// new FileInputStream("111.txt");
	}

	@Transactional
	public void updatePrice(String isbn, int price) {
		bookDao.updatePrice(isbn, price);

	}
}
