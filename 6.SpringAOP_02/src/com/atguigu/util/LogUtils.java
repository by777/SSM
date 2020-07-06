package com.atguigu.util;

import java.lang.reflect.Method;
import java.util.Arrays;

import javax.management.RuntimeErrorException;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/*切面类
 * 中的通知方法
 * @Before:。。。
 * @After:。。。finally
 * @AfterReturning:在目标方法正常返回时运行 
 * @AfterThrowing:异常  catch
 * @Around:环绕
 * Aspect 切面类也加入IOC
 * */

@Aspect
@Component
public class LogUtils {
	/*
	 * 我们可以在方法运行的时候，拿到目标方法的详细信息 只需要JoinPoint,封装了当前目标方法的详细信息 Spring 对通知方法不要求返回值
	 * 、权限，唯一要求是参数 参数表上每一个参数，spring都要知道是什么 JoinPoint -- spring认识
	 * 不知道的参数一定告诉spring这是什么：所以用了returning \ throwing 异常要写大的，NullPointException
	 * e只接受空指针异常 返回值同理。Object result ====================== 抽取可重用的切入点表达式
	 * 1、随便声明一个没有实现的返回void的空方法 2、给方法标注@Pointcut 3、切入点@Before("hahaMyPoint()")
	 */


	 @Pointcut("execution(public int com.atguigu.impl.MyMathCalculator.*(..))")
	 public void hahaMyPoint(){
	 
	 }


	/*
	 * Around()环绕通知是最强大的通知 动态代理 try{ // 前置通知 method.invoke(obj,args); // 返回通知
	 * }catch(e){ // 异常通知
	 * 
	 * }finally{ //后置通知
	 * 
	 * }
	 * 
	 * 当两种通知同时使用时，新的通知顺序为：
	 * 【环绕前置】- 【普通前置】-【目标方法执行】-【环绕正常返回/出现异常】-【环绕后置】-【普通后置】-【普通】
	 */
	//@Around("execution(public int com.atguigu.impl.MyMathCalculator.*(..))")
	public Object myAround(ProceedingJoinPoint pjp) throws Throwable {
		// 环绕通知中
		// 利用反射推进目标方法,就是method.invoke(obj,args);
		Object[] args = pjp.getArgs();
		Object result = null;
		try {
			System.out.println("这里是前置通知");
			result = pjp.proceed(args);
			System.out.println("返回通知");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			System.out.println("异常通知");
			// 环绕通知先运行，会吃掉异常，导致其他其他通知接受不到异常，一定要把这个异常跑抛出去
			throw new RuntimeException(e);
		}finally{
			System.out.println("后置通知");
		}
		// 返回返回值,这个值写死，会导致原方法得到错误的答案
		return result;
	}

	// execution(访问权限符 返回值类型 方法签名)
	@Before("execution(public int com.atguigu.impl.MyMathCalculator.*(int, int))")
	public static void logStart(JoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();
		Signature signature = joinPoint.getSignature();// 方法签名
		String name = signature.getName();
		System.out.println("【logUtils：前置" + name + "方法开始运行了】" + "参数列表为："
				+ Arrays.asList(args));
	}

	/* 告诉Spring result用来接受返回值 */
	@AfterReturning(value = "execution(public int com.atguigu.impl.MyMathCalculator.*(int, int))", returning = "result")
	public static void logReturn(JoinPoint joinPoint, Object result) {
		Signature signature = joinPoint.getSignature();// 方法签名
		String name = signature.getName();
		System.out.println("【logUtils；" + name + "】运行结束了，结果为：" + result);
	}

	@AfterThrowing(value = "execution(public int com.atguigu.impl.MyMathCalculator.*(int, int))", throwing = "e")
	public static void logException(JoinPoint joinPoint, Exception e) {
		Signature signature = joinPoint.getSignature();// 方法签名
		String name = signature.getName();
		System.out.println("【logUtils：" + name + "】运行出现异常了，异常信息为：" + e);
	}

	@After("execution(public int com.atguigu.impl.MyMathCalculator.*(int, int))")
	public static void logEnd(JoinPoint joinPoint) {
		// TODO Auto-generated method stub
		Signature signature = joinPoint.getSignature();// 方法签名
		String name = signature.getName();
		System.out.println("【logUtils：" + name + "】最终结束了");

	}
}
