package com.zph.supplychain.database.test;

import org.junit.Test;

import com.zph.supplychain.test.utils.SpringUtils;

public class SessionFactoryTest extends SpringUtils{
	@Test
	public void testSeessionFactory(){
		context.getBean("sessionFactory");
	}
}
