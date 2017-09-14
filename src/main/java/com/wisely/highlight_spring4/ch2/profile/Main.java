package com.wisely.highlight_spring4.ch2.profile;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.getEnvironment().setActiveProfiles("prod");//�Ƚ���� Profile����Ϊprod
		context.register(ProfileConfig.class); //����ע��Bean �����࣬��Ȼ�ᱨBeanδ����Ĵ���
		context.refresh();//ˢ������
		
		DemoBean  demoBean = context.getBean(DemoBean.class);
		System.out.println(demoBean.getContent());
		context.getEnvironment().setActiveProfiles("dev");//�Ƚ���� Profile����Ϊprod
		context.register(ProfileConfig.class); //����ע��Bean �����࣬��Ȼ�ᱨBeanδ����Ĵ���
		context.refresh();//ˢ������
		demoBean = context.getBean(DemoBean.class);
		System.out.println(demoBean.getContent());
		context.close();
		
	}
}
