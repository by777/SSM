package com.atguigu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atguigu.dao.BookDao;

@Service
public class BookService {
	@Autowired
	BookDao bookDao;

	@Transactional
	public void checkOut(String userName, String isbn) {
		bookDao.updateStock(isbn);
		int price = bookDao.getPrice(isbn);
		bookDao.updateBalance(userName, price);
	}
}
