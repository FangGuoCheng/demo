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
@PropertySource("classpath:com/wisely/highlight_spring4/ch2/el/test.properties")	//7ʹ��@Value(${}) $������������ļ�
public class ElConfig {
	@Value("I LOVE YOU")	//1 ע����ͨ�ַ���
	private String normal;
	@Value("#{systemProperties['os.name']}")//2	ע�����ϵͳ���� 
	private String osName;
	@Value("#{T(java.lang.Math).random()*100.0}")	//3ע����ʽ��� 
	private double randomNumber;
	@Value("#{demoService.another}") 	//4	ע������Bean���� 
	private String fromAnother;
	@Value("classpath:com/wisely/highlight_spring4/ch2/el/test.txt")	//	5ע���ļ���Դ��
	private Resource testFile;
	@Value("http://www.baidu.com")	//6ע����ַ��Դ
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
