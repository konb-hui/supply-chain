package com.zph.supplychain.privilege.service;

import java.util.Collection;

import com.zph.supplychain.base.service.BaseService;
import com.zph.supplychain.domain.privilege.Privilege;

public interface PrivilegeService extends BaseService<Privilege>{
	public Collection<Privilege> getPrivilegeByRoleId(Long rid);
}
