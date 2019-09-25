package com.zph.supplychain.privilege.dao;

import java.util.Collection;

import com.zph.supplychain.base.dao.BaseDao;
import com.zph.supplychain.domain.privilege.Role;

public interface RoleDao extends BaseDao<Role>{
	public Role getRoleByName(final String name);
	public Collection<Role> getRoleByUid(Long uid);
}
