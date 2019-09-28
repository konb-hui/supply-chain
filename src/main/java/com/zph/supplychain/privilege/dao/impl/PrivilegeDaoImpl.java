package com.zph.supplychain.privilege.dao.impl;

import java.util.Collection;
import java.util.Iterator;

import org.springframework.stereotype.Repository;

import com.zph.supplychain.base.dao.impl.BaseDaoImpl;
import com.zph.supplychain.domain.privilege.Privilege;
import com.zph.supplychain.privilege.dao.PrivilegeDao;

@Repository("privilegeDao")
public class PrivilegeDaoImpl extends BaseDaoImpl<Privilege> implements PrivilegeDao{

	public Collection<Privilege> getPrivilegeByRoleId(Long id) {
		/**
		 * 1.加载所有的权限 
		 * 2.加载该角色能够访问到的权限
		 * 3.两次遍历把所有的权限中用户能访问到的权限checked设为true
		 */
		Collection<Privilege> allPrivileges = this.hibernateTemplate.find("from Privilege");
		Collection<Privilege> rolePrivileges = this.hibernateTemplate.find("from Privilege p inner join fetch p.roles r where r.rid=?",id);
		for (Privilege privilege : allPrivileges) {//遍历所有的权限
			for (Privilege privilege2 : rolePrivileges) {//遍历角色的权限
				//如果当前正在遍历的所有权限中的该项是角色能够访问到的
				if(privilege.getId().longValue()==privilege2.getId().longValue()) {
					privilege.setChecked(true);
				}
			}
		}
		return allPrivileges;
	}

	public Collection<Privilege> getMenuitemTreeByUid(Long uid) {
		if(uid.longValue()==1) {//说明是管理员
			return this.hibernateTemplate.find("from Privilege where type='1'");	
		}else {//普通员工
			this.hibernateTemplate.find("from Privilege p inner join fetch p.roles r inner join fetch r.users u where u.uid=? and p.type='1'",uid);
		}
		return null;
	}

	public Collection<Privilege> getFunctionTreeByUid(Long uid) {
		if(uid.longValue()==1) {//说明是管理员
			return this.hibernateTemplate.find("from Privilege where type='2'");	
		}else {//普通员工
			this.hibernateTemplate.find("from Privilege p inner join fetch p.roles r inner join fetch r.users u where u.uid=? and p.type='2'",uid);
		}
		return null;
	}

}
