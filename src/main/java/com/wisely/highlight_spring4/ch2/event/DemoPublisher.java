package com.wisely.highlight_spring4.ch2.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class DemoPublisher {
	@Autowired
	ApplicationContext applicationContext; //1 注入Application用来发布事件
	public void publish(String msg) {
		applicationContext.publishEvent(new DemoEvent(this, msg));	//2使用Application的publishEvent方法发布
	}
}
