package com.atguigu.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.atguigu.bean.Employee;

@Repository
public class EmployeeDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void saveEmployee(Employee employee){
		String sql = "INSERT INTO employee(emp_name,salary) VALUES(?,?)";
		jdbcTemplate.update(sql,employee.getEmpName(),employee.getSalary());
	}
}
