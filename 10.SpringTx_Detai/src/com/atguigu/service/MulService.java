package com.atguigu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MulService {
	
	@Autowired
	private BookService bookService;
	// 多事务
	@Transactional
	public void mulTx(){
		/*传播行为设置这个事务方法是否与大事务共享一个事务（使用同一条链接）*/
		
		/*如果去checkout和updatePrice方法上添加propagation=Propagation=REQUIRED
		 * 因为当前事务外面已经有大事务，所以会在同一个事务里，如果有一个完蛋，大家一起完蛋
		 * propagation=Propagation=REQUIRED_NEW事务出错，只有这一个子事务回滚，大事务不会滚
		 * （p111：但是大事务的方法可能感知到子方法抛出的异常，所以REQUIRED_NEW要放在第一个方法checkout上，
		 * 这样代码才会执行到下一行）
		 * */
		bookService.checkOut("Tom", "ISBN-001");
		bookService.updatePrice("ISBN-002", 998);
		
		// int i = 10 / 0;
	}
}
