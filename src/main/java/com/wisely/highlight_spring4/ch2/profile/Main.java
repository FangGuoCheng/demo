package com.wisely.highlight_spring4.ch2.profile;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.getEnvironment().setActiveProfiles("prod");//先将活动的 Profile设置为prod
		context.register(ProfileConfig.class); //后置注册Bean 配置类，不然会报Bean未定义的错误
		context.refresh();//刷新容器
		
		DemoBean  demoBean = context.getBean(DemoBean.class);
		System.out.println(demoBean.getContent());
		context.getEnvironment().setActiveProfiles("dev");//先将活动的 Profile设置为prod
		context.register(ProfileConfig.class); //后置注册Bean 配置类，不然会报Bean未定义的错误
		context.refresh();//刷新容器
		demoBean = context.getBean(DemoBean.class);
		System.out.println(demoBean.getContent());
		context.close();
		
	}
}
