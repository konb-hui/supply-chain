package com.zph.supplychain.test.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringUtils {
	public static ApplicationContext context;
	static {
		context = new ClassPathXmlApplicationContext("com/zph/supplychain/spring/applicationContext.xml");
	}
}
