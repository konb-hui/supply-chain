package com.zph.supplychain.database.test;

import org.junit.Test;

import com.zph.supplychain.basedata.dao.DepartmentDao;
import com.zph.supplychain.domain.basedata.Department;
import com.zph.supplychain.query.PageResult;
import com.zph.supplychain.query.basedata.DepartmentQuery;
import com.zph.supplychain.test.utils.SpringUtils;

public class DepartmentTest extends SpringUtils{
	@Test
	public void testGetCount() {
		DepartmentDao departmentDao = (DepartmentDao) context.getBean("departmentDao");
		DepartmentQuery baseQuery = new DepartmentQuery();
		int count = departmentDao.getCount(baseQuery);
		System.out.println(count);
	}
	@Test
	public void testPageResult() {
		DepartmentDao departmentDao = (DepartmentDao) context.getBean("departmentDao");
		DepartmentQuery baseQuery = new DepartmentQuery();
		PageResult<Department> pageResult = departmentDao.findPageResult(baseQuery);
		for(Department department : pageResult.getRows()) {
			System.out.println(department.getDid());
		}
	}
}
