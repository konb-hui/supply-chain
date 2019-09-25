package com.zph.supplychain.privilege.service.impl;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zph.supplychain.base.dao.BaseDao;
import com.zph.supplychain.base.service.impl.BaseServiceImpl;
import com.zph.supplychain.domain.privilege.Role;
import com.zph.supplychain.privilege.dao.RoleDao;
import com.zph.supplychain.privilege.service.RoleService;

@Service("roleService")
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService{
	
	@Resource(name="roleDao")
	private RoleDao roleDao;
	
	@Override
	public BaseDao getbaseDao() {
		// TODO Auto-generated method stub
		return this.roleDao;
	}

	public Role getRoleByName(String name) {
		// TODO Auto-generated method stub
		return this.roleDao.getRoleByName(name);
	}

	public Collection<Role> getRoleByUid(Long uid) {
		// TODO Auto-generated method stub
		return this.roleDao.getRoleByUid(uid);
	}

}
