package com.atguigu.util;

import java.lang.reflect.Method;
import java.util.Arrays;

public class LogUtils {
	public static void logStart(Method method, Object...objects){
		System.out.println("【" + method.getName() + "】方法开始了：" + Arrays.asList(objects)  );
	}
	
	public static void logReturn(Method method,Object result) {
		System.out.println("【" + method.getName() + "】方法执行结束了，结果为为：" + result);
	}
	
	public static void logException(Method method, Exception e){
		System.out.println("【" + method.getName() + "方法】出现异常了，异常原因是是:" + e.getCause());
	}

	public static void logEnd(Method method) {
		// TODO Auto-generated method stub
		System.out.println("【" + method.getName() +"】方法最终结束了");
		
	}
}
