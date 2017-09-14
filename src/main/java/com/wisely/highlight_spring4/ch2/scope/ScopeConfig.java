package com.wisely.highlight_spring4.ch2.scope;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration	//用@Configuration注解该类，等价 与XML中配置beans；用@Bean标注方法等价于XML中配置bean。
@ComponentScan("com.wisely.highlight_spring4.ch2.scope")
public class ScopeConfig {

}
