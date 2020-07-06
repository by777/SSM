package com.atguigu.util;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;

public class ValidateApsect {

	public void logStart(JoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();
		Signature signature = joinPoint.getSignature();// 方法签名
		String name = signature.getName();
		System.out.println("【VA:" + name + "方法开始运行了】" + "参数列表为："
				+ Arrays.asList(args));
	}

	public void logReturn(JoinPoint joinPoint, Object result) {
		Signature signature = joinPoint.getSignature();// 方法签名
		String name = signature.getName();
		System.out.println("【VA:" + name + "】运行结束了，结果为：" + result);
	}

	public void logException(JoinPoint joinPoint, Exception e) {
		Signature signature = joinPoint.getSignature();// 方法签名
		String name = signature.getName();
		System.out.println("【VA:" + name + "】运行出现异常了，异常信息为：" + e);
	}

	public static void logEnd(JoinPoint joinPoint) {

		Signature signature = joinPoint.getSignature();// 方法签名
		String name = signature.getName();
		System.out.println("【VA:" + name + "】最终结束了");

	}
}
