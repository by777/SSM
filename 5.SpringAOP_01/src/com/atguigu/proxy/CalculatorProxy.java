package com.atguigu.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

import com.atguigu.inter.Calculator;
import com.atguigu.util.LogUtils;
import com.sun.istack.internal.FinalArrayList;
import com.atguigu.util.*;
/*帮calculator生成代理对象的类
 * 
 * 
 * */
public class CalculatorProxy {
	
	/*为传入的参数对象创建一个动态代理*/
	public static Calculator getProxy(final Calculator calculator){
		
		//被加载对象的类加载器
		ClassLoader loader = null;
		loader = calculator.getClass().getClassLoader();
		
		//这个对象所实现的所有接口
		Class<?>[] interfaces = null;
		interfaces = calculator.getClass().getInterfaces();
		
		//方法执行器，帮目标对象执行目标方法
		InvocationHandler h = null;
		h = new InvocationHandler() {
			
			//接口实现
			/*Object proxy：代理对象：给jdk使用，任何时候都不要动这个对象
			 * Method method, 当前将要执行目标对象的方法
			 * Object[] args：方法调用时，外界传入的值
			 * */
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				// TODO Auto-generated method stub
				System.out.println("====这是动态代理的运行====");
				Object result = null;
				try{
					//利用反射执行目标方法,返回值就是目标方法执行完毕的返回值
					LogUtils.logStart(method,args);
					//System.out.println("【" + method.getName() + "】方法开始执行了，参数列表为：" + Arrays.asList(args));
					result = method.invoke(calculator, args);
					LogUtils.logReturn(method, result);
					//System.out.println("【" + method.getName() + "】方法执行结束了，结果为为：" + result);
					//System.out.println("【" + method.getName() + "】方法执行结束了，结果为为：" +(String) result);
					}
				
				catch (Exception e){
					LogUtils.logException(method, e);
					//System.out.println("【" + method.getName() + "方法】出现异常了，异常原因是是:" + e.getCause());
					
				}
				finally{
					LogUtils.logEnd(method);
					//System.out.println("【" + method.getName() +"】方法最终结束了");
				}
				
				return result;
			}
		};
		
		Object proxy = Proxy.newProxyInstance(loader, interfaces, h);
		
		return (Calculator) proxy;
	}
	
	
	
	
}
