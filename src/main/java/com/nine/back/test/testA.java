package com.nine.back.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nine.back.strategy.LoginStrategy;

public class testA {
	public static void main(String[] args) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-mybatis.xml");
		//BaseStrategy bs = (BaseStrategy) context.getBean("bs");
		LoginStrategy ls=(LoginStrategy) context.getBean("login");
		String data="{'userid':100001,'password':'admin'} ";
		ls.doApply(data);
	}
}
