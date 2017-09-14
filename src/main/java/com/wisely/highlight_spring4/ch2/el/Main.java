package com.wisely.highlight_spring4.ch2.el;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ElConfig.class);
		ElConfig elConfig = context.getBean(ElConfig.class);
		PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = elConfig.PropertyConfigure();
		elConfig.outputResource();
		context.close();
		
	}
}
