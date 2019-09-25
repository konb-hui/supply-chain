package com.zph.supplychain.privilege.service;

import java.util.Collection;

import com.zph.supplychain.base.service.BaseService;
import com.zph.supplychain.domain.privilege.Role;

public interface RoleService extends BaseService<Role>{
	public Role getRoleByName(String name);
	public Collection<Role> getRoleByUid(Long uid);
}
