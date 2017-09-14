package com.wisely.highlight_spring4.ch2.perpost;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PrePostConfig.class);
		PrePostConfig prePostConfig = context.getBean(PrePostConfig.class);
		BeanWayService beanWayService = prePostConfig.beanWayService();
		JSR250WayService jsrWayService = prePostConfig.jsr250WayService();
		beanWayService = null;
		jsrWayService = null;
		context.close();
	}
}
