package com.atguigu.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.atguigu.bean.Employee;
import com.atguigu.dao.EmployeeDao;

public class TxTest {
	ApplicationContext ioc = new ClassPathXmlApplicationContext(
			"applicationContext.xml");
	JdbcTemplate jdbcTemplate = (JdbcTemplate) ioc.getBean("jdbcTemplate");
	NamedParameterJdbcTemplate namedJdbcTemplate = ioc.getBean(NamedParameterJdbcTemplate.class);

	public void test() throws SQLException {
		// fail("Not yet implemented");
		DataSource bean = (DataSource) ioc.getBean("dataSource");
		Connection connection = bean.getConnection();
		System.out.println(connection);
		connection.close();

	}

	public void test01() throws SQLException {
		// 使用JDBCTemplate导入Spring的包 、jdbc orm tx
		// DataSource bean =(DataSource) ioc.getBean("dataSource");
		// JdbcTemplate jdbcTemplate = new JdbcTemplate(bean);
		System.out.println(jdbcTemplate);

	}

	public void test02() {
		/*
		 * 1.id = 5 的salary更新为1300 UPDATE employ SET salary=? WHERE emp_id = ?
		 */
		System.out.println(jdbcTemplate);
		String sql = "UPDATE employee SET salary=? WHERE emp_id = ?";
		int update = jdbcTemplate.update(sql, 1300, 5);
		System.out.println(update);
	}

	public void test03() {
		/*
		 * 批量插入QueryRunner.batch(obj[][])
		 * 
		 * INSERT INTO employee(emp_name,salary) VALUES(?,?) INSERT INTO
		 * employee(emp_name,salary) VALUES(?,?) INSERT INTO
		 * employee(emp_name,salary) VALUES(?,?) INSERT INTO
		 * employee(emp_name,salary) VALUES(?,?)
		 */
		String sql = "INSERT INTO employee(emp_name,salary) VALUES(?,?)";
		List<Object[]> batchArgs = new ArrayList<Object[]>();
		// list的一维数组
		// list的长度就是sql语句要执行多少遍、Object[]就是每次执行要用的参数
		batchArgs.add(new Object[] { "张三", 99998.8 });
		batchArgs.add(new Object[] { "张4", 99.9988 });
		batchArgs.add(new Object[] { "张5", 9.99988 });

		int[] is = jdbcTemplate.batchUpdate(sql, batchArgs);
		for (int i : is) {
			System.out.println(i);
		}

	}

	public void test04() {
		/*
		 * 查询id=5的对象，并封装返回 SELECT javaBean需要与数据库中字段保持一致、如果不一致需要取别名 SELECT emp_id
		 * SELECT emp_id empId, emp_name empName,salary FROM employee WHERE
		 * emp_id = ? jdbcTemplate再方法级别进行了区分： 查询集合：jdbcTemplate.query()
		 * 查询单个对象：jdbcTemplate.queryForObject() --- 如果查询结果为空会报错
		 */
		String sql = "SELECT emp_id empId, emp_name empName,salary FROM employee WHERE emp_id = ?";
		/*
		 * RowMapper:每一行记录与JavaBean属性的映射 queryForObject(sql,RowMapper,arg)
		 */

		Employee employee = null;
		try {
			employee = jdbcTemplate.queryForObject(sql,
					new BeanPropertyRowMapper<>(Employee.class), 5);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// 有异常就异常 还是null就行
		}
		System.out.println(employee);

	}

	public void test05() {
		// 查询工资大于4000的
		/*
		 * SELECT emp_id empId, emp_name empName,salary FROM employee WHERE
		 * salary > ?
		 */
		String sql = "SELECT emp_id empId, emp_name empName,salary FROM employee WHERE salary > ?";
		// 封装List：集合里面元素的类型
		List<Employee> list = jdbcTemplate.query(sql,
				new BeanPropertyRowMapper<>(Employee.class), 4000);
		for (Employee employee : list) {
			System.out.println(employee);
		}

	}

	
	public void test06() {
		// 最大薪资
		String sql = "SELECT max(salary) FROM employee";// 返回单条数据
		// 无论是返回单个数据还是单个对象都是调用queryForObject
		Double object = jdbcTemplate.queryForObject(sql, Double.class);// 原生类型
		System.out.println(object);

	}
	// P91

	public void test07() {
		/*
		 * 使用具有具名参数的SQL语句插入一条员工记录，并以Map形式传入参数值
		 * 具名参数：具有名字的参数
		 * 占位符参数：问号顺序不能乱
		 * 
		 * */
		String sql = "INSERT INTO employee(emp_name,salary) VALUES(:empName,:salary)";
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("empName","Xiao Feifei");
		paramMap.put("salary",999.999);
		int rows = namedJdbcTemplate.update(sql, paramMap);
		System.out.println(rows);
		
		
	}

	public void test08() {
		/*
		 * 
		 * 以SqlParameterSource形式传入参数值
		 * */
		String sql = "INSERT INTO employee(emp_name,salary) VALUES(:empName,:salary)";
		Employee employee = new Employee();
		employee.setEmpName("转告5");
		//employee.setEmpId(111);
		employee.setSalary(1233.0);
		int rows = namedJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(employee));
		System.out.println(rows);
	}
	
	@Test
	public void test09() {
		// 创建Dao、自动装配
		EmployeeDao employeeDao =(EmployeeDao) ioc.getBean(EmployeeDao.class);
		Employee employee = new Employee();
		employee.setEmpName("召33");
		employee.setSalary(2144.0);
		employeeDao.saveEmployee(employee);
		
		
	}
}
