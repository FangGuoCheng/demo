package com.wisely.highlight_spring4.ch2.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class DemoListener implements ApplicationListener<DemoEvent> {	//1��ʾApplicationListener�ӿڲ�ָ���������¼�����

	DemoListener () {
		
	}
	public void onApplicationEvent(DemoEvent event) {	//2ʹ�ø÷�������Ϣ���н��ܴ��� 
		String msg = event.getMsg();
		System.out.println("�ң�bean-demoListener���ܵ���Bean-demoPublisher��������Ϣ����" + msg);
	}

}
