package com.atguigu.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.impl.MyMathCalculator;
import com.atguigu.inter.Calculator;
//import com.atguigu.proxy.CalculatorProxy;
//import com.atguigu.inter.Calculator;
import com.atguigu.util.LogUtils;

public class AOPTest {

	ApplicationContext ioc = new ClassPathXmlApplicationContext(
			"applicationContext.xml");

	/*
	 * 通知的执行顺序
	 * 
	 * try{
	 * 
	 * @Before method.invoke(obj,args);
	 * 
	 * @AfterReturning }catch(){
	 * 
	 * @AfterThrowing }finally{
	 * 
	 * @After }
	 * 
	 * 正常执行顺序： @Before(前置通知) ->@After(后置通知) -> AfterReturning 异常:@Before ->
	 * 
	 * @After -> AfterThrowing
	 */
	@Test
	public void test() {
		// fail("Not yet implemented");
		// 不要自己new
		// Calculator calculator = new MyMathCalculator();
		// 如果用类型，一定要用接口类型Calculator,不要用它本类
		// 实际创建代理对象+实现的接口，所以必须用接口获取
		Calculator cal = ioc.getBean(Calculator.class);
		/*
		 * 注意用接口类型接收 Calculator cal2 = (Calculator)
		 * ioc.getBean("myMathCalculator");
		 */
		cal.add(11, 123);
		// 使用@Order()指定切面顺序，数字越小越优先（在最外层）
		// System.out.println("==普通通知：====LogUtils - VA 栈先进后出 L在V前面，L在外层=====");
		// cal.div(1, 0);

	}

	public void Test02() {
		/*
		 * 切入点表达式 *： 任意一个参数（构成重载） 匹配一个或者多个字符 权限位置public不能写*，不写表示任意权限
		 * ==================================== ..: 匹配任意多个、任意类型参数
		 * 匹配任意多层路径（*只能匹配一层路径）com..atguigu.* 双点不能直接冒出来 =========================
		 * 最模糊：任意包任意类下的任意方法，不要写 execution(* *.*(..)) 最精确的:全写
		 * ============================== 也支持&& || !
		 * execution("**..")&&execution(".....")
		 */

	}

}
