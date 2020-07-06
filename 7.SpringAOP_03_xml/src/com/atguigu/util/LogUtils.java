package com.atguigu.util;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;

public class LogUtils {

	public Object myAround(ProceedingJoinPoint pjp) throws Throwable {

		Object[] args = pjp.getArgs();
		Object result = null;
		try {
			System.out.println("这里是环绕前置通知");
			result = pjp.proceed(args);
			System.out.println("环绕返回通知");
		} catch (Exception e) {

			System.out.println("环绕异常通知");

			throw new RuntimeException(e);
		} finally {
			System.out.println("环绕后置通知");
		}

		return result;
	}

	public static void logStart(JoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();
		Signature signature = joinPoint.getSignature();// 方法签名
		String name = signature.getName();
		System.out.println("【logUtils：前置" + name + "方法开始运行了】" + "参数列表为："
				+ Arrays.asList(args));
	}

	public static void logReturn(JoinPoint joinPoint, Object result) {
		Signature signature = joinPoint.getSignature();// 方法签名
		String name = signature.getName();
		System.out.println("【logUtils；" + name + "】运行结束了，结果为：" + result);
	}

	public static void logException(JoinPoint joinPoint, Exception e) {
		Signature signature = joinPoint.getSignature();// 方法签名
		String name = signature.getName();
		System.out.println("【logUtils：" + name + "】运行出现异常了，异常信息为：" + e);
	}

	public static void logEnd(JoinPoint joinPoint) {

		Signature signature = joinPoint.getSignature();// 方法签名
		String name = signature.getName();
		System.out.println("【logUtils：" + name + "】最终结束了");

	}
}
