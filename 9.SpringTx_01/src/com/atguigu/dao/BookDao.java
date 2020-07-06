package com.atguigu.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookDao {
	/* 减去余额 */
	@Autowired
	JdbcTemplate jdbcTemplate;

	public void updateBalance(String userName, int price) {
		/* UPDATE account SET balance=balance-? WHERE username=? */
		String sql = "UPDATE account SET balance=balance-? WHERE username=?";
		jdbcTemplate.update(sql, price, userName);
	}

	/* 获取某本图书的价格 */
	public int getPrice(String isbn) {
		String sql = "SELECT price FROM book WHERE isbn=?";
		int price = jdbcTemplate.queryForObject(sql, Integer.class, isbn);
		return price;

	}
	/*减去库存，简单起见每次减一*/
	public void updateStock(String isbn){
		String sql = "UPDATE book_stock SET stock=stock-1 WHERE isbn=?";
		jdbcTemplate.update(sql,isbn);
	}
}
