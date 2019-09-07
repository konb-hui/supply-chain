package com.zph.supplychain.basedata.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zph.supplychain.base.dao.BaseDao;
import com.zph.supplychain.base.service.impl.BaseServiceImpl;
import com.zph.supplychain.basedata.dao.DepartmentDao;
import com.zph.supplychain.basedata.service.DepartmentService;
import com.zph.supplychain.domain.basedata.Department;

@Service("departmentService")
public class DepartmentServiceImpl extends BaseServiceImpl<Department> implements DepartmentService{
	
	@Resource(name = "departmentDao")
	private DepartmentDao departmentDao;
	
	@Override
	public BaseDao getbaseDao() {
		// TODO Auto-generated method stub
		return this.departmentDao;
	}

}
