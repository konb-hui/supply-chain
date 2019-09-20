package com.zph.supplychain.privilege.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zph.supplychain.base.dao.BaseDao;
import com.zph.supplychain.base.service.impl.BaseServiceImpl;
import com.zph.supplychain.domain.privilege.Privilege;
import com.zph.supplychain.privilege.dao.PrivilegeDao;
import com.zph.supplychain.privilege.service.PrivilegeService;

@Service("privilegeService")
public class PrivilegeServiceImpl extends BaseServiceImpl<Privilege> implements PrivilegeService{
	
	@Resource(name="privilegeDao")
	private PrivilegeDao privilegeDao;
	
	
	@Override
	public BaseDao getbaseDao() {
		// TODO Auto-generated method stub
		return this.privilegeDao;
	}

}
