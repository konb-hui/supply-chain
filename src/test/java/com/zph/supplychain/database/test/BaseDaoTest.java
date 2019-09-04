package com.zph.supplychain.database.test;

import org.junit.Test;

import com.zph.supplychain.base.dao.BaseDao;
import com.zph.supplychain.query.basedata.DepartmentQuery;
import com.zph.supplychain.test.utils.SpringUtils;

public class BaseDaoTest extends SpringUtils{
	@Test
	public void testBaseDao_Count() {
		BaseDao baseDao = (BaseDao) context.getBean("baseDao");
		DepartmentQuery departmentQuery = new DepartmentQuery();
		departmentQuery.setName("asdwe");
		int count = baseDao.getCount(departmentQuery);
		System.out.println(count);
	}
}
