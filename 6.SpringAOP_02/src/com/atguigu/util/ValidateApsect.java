package com.atguigu.util;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ValidateApsect {
	
	@Before("com.atguigu.util.LogUtils.hahaMyPoint()")
	public void logStart(JoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();
		Signature signature = joinPoint.getSignature();// 方法签名
		String name = signature.getName();
		System.out.println("【VA:" + name + "方法开始运行了】" + "参数列表为："
				+ Arrays.asList(args));
	}

	@AfterReturning(value="com.atguigu.util.LogUtils.hahaMyPoint()",returning="result")
	public void logReturn(JoinPoint joinPoint, Object result) {
		Signature signature = joinPoint.getSignature();// 方法签名
		String name = signature.getName();
		System.out.println("【VA:" + name + "】运行结束了，结果为：" + result);
	}

	@AfterThrowing(value="com.atguigu.util.LogUtils.hahaMyPoint()",throwing="e")
	public void logException(JoinPoint joinPoint, Exception e) {
		Signature signature = joinPoint.getSignature();// 方法签名
		String name = signature.getName();
		System.out.println("【VA:" + name + "】运行出现异常了，异常信息为：" + e);
	}

	@After(value="com.atguigu.util.LogUtils.hahaMyPoint()")
	public static void logEnd(JoinPoint joinPoint) {

		Signature signature = joinPoint.getSignature();// 方法签名
		String name = signature.getName();
		System.out.println("【VA:" + name + "】最终结束了");

	}
}
