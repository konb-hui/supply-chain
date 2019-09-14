package com.zph.supplychain.privilege.dao.impl;

import org.springframework.stereotype.Repository;

import com.zph.supplychain.base.dao.impl.BaseDaoImpl;
import com.zph.supplychain.domain.privilege.Role;
import com.zph.supplychain.privilege.dao.RoleDao;

@Repository("roleDao")
public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao{

}
