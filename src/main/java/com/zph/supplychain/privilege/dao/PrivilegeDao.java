package com.zph.supplychain.privilege.dao;

import java.util.Collection;

import com.zph.supplychain.base.dao.BaseDao;
import com.zph.supplychain.domain.privilege.Privilege;

public interface PrivilegeDao extends BaseDao<Privilege>{
	public Collection<Privilege> getPrivilegeByRoleId(Long id);
}
