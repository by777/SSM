package com.atguigu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atguigu.dao.BookDao;

@Service
public class BookService {
	@Autowired
	BookDao bookDao;


	/* 事务的细节 P100
	 * 
	 * isolation - Isolation： 事务的隔离级别
	 * propagation -Propagation： 事务的传播行为
	 * 
	 * noRollbackFor -Class[]： 哪些异常事务可以不回滚
	 * noRollbackForClassName -String[]： String全类名
	 * 
	 * rollbackFor -Class[]： 哪些异常回滚的
	 * rollbackForClassName -String[]： String全类名
	 * 
	 * readOnly -boolean：设置事务为只读事务
	 * 	可以进行事务优化（当多个事务都是读，加快查询速度，默认false,说瞎话会报异常）
	 * timeout -int：超时指定时间（s）(sleep()是毫秒)自动终止并回滚
	 * value -就是默认不写的
	 * */
	@Transactional()
	public void checkOut(String userName, String isbn) {
		bookDao.updateStock(isbn);
		int price = bookDao.getPrice(isbn);
		bookDao.updateBalance(userName, price);
		/*
		 * int a = 1 / 0; 测试事务
		 */
	}
}
