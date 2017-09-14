package com.wisely.highlight_spring4.ch2.el;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
@Configuration
@ComponentScan("com.wisely.highlight_spring4.ch2.el")
@PropertySource("classpath:com/wisely/highlight_spring4/ch2/el/test.properties")	//7使用@Value(${}) $必须加载配置文件
public class ElConfig {
	@Value("I LOVE YOU")	//1 注入普通字符串
	private String normal;
	@Value("#{systemProperties['os.name']}")//2	注入操作系统属性 
	private String osName;
	@Value("#{T(java.lang.Math).random()*100.0}")	//3注入表达式结果 
	private double randomNumber;
	@Value("#{demoService.another}") 	//4	注入其他Bean属性 
	private String fromAnother;
	@Value("classpath:com/wisely/highlight_spring4/ch2/el/test.txt")	//	5注入文件资源。
	private Resource testFile;
	@Value("http://www.baidu.com")	//6注入网址资源
	private Resource testUrl;
	@Value("${book.name}")
	private String bookName;	//7
	@Autowired
	private Environment  environment;	//7
	@Bean 
	public static PropertySourcesPlaceholderConfigurer PropertyConfigure() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	public void outputResource() {
		try {
			System.out.println("normal :: " + normal);
			System.out.println("osName :: " +  osName);
			System.out.println("randomNumber :: " + randomNumber);
			System.out.println("fromAnother :: " + fromAnother);
			System.out.println("testFile :: " + IOUtils.toString(testFile.getInputStream()));
			
			System.out.println("testUrl :: " + IOUtils.toString(testUrl.getInputStream()));
			System.out.println("bookName :: " + bookName);
			System.out.println("environment :: " + environment.getProperty("book.author"));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
