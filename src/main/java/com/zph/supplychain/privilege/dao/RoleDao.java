package com.zph.supplychain.privilege.dao;

import com.zph.supplychain.base.dao.BaseDao;
import com.zph.supplychain.domain.privilege.Role;

public interface RoleDao extends BaseDao<Role>{
	public Role getRoleByName(final String name);
}
