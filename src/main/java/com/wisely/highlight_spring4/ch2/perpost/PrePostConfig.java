package com.wisely.highlight_spring4.ch2.perpost;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.wisely.highlight_spring4.ch2.perpost")
public class PrePostConfig {
	@Bean(initMethod="init",destroyMethod="destroy")	//分别为构造之后和销毁之前
	BeanWayService beanWayService() {
		return new BeanWayService();
	}
	@Bean
	JSR250WayService jsr250WayService() {
		return new JSR250WayService();
	}
}
