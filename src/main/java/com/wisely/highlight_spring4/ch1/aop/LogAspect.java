package com.wisely.highlight_spring4.ch1.aop;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
@Aspect	//ͨ��@Aspectע������һ������
@Component//ͨ��@Component�ô������ΪSpring���������Bean
public class LogAspect {
	@Pointcut("@annotation(com.wisely.highlight_spring4.ch1.aop.Action)")	//ͨ��@Pointcutע�������е�
	public void annotationPointCut(){};
	@After("annotationPointCut()")	//ͨ��@After ע������һ������,��ʹ��@Pointcut������е�
	public void after(JoinPoint joinPoint) {
		MethodSignature signature = (MethodSignature)joinPoint.getSignature();
		Method method = signature.getMethod();
		Action action = method.getAnnotation(Action.class);
		System.out.println("ע��ʽ����"+action.name());	//ͨ������ɻ��ע���ϵ����ԣ�Ȼ������־��¼��ص� �������������ͬ��
	}								 															  		
	@Before("execution(* com.wisely.highlight_spring4.ch1.aop.DemoMethodService.*(..))")	//ͨ��@Beforeע������һ������,�˽���ֱ��ʹ�����ع�����Ϊ������
	public void before(JoinPoint joinPoint) {
		MethodSignature signature = (MethodSignature)joinPoint.getSignature();
		Method method =  signature.getMethod();
	//	Action action = method.getAnnotation(Action.class);
		System.out.println("��������ʽ����"+method.getName());
	}
}
