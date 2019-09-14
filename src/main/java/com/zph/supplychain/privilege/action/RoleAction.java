package com.zph.supplychain.privilege.action;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.zph.supplychain.base.action.BaseAction;
import com.zph.supplychain.domain.privilege.Role;
import com.zph.supplychain.privilege.service.RoleService;

@Controller("roleAction")
@Scope("prototype")
public class RoleAction extends BaseAction<Role>{
	
	@Resource(name="roleService")
	private RoleService roleService;
	
	public String showRoleTree() {
		Collection<Role> roles = this.roleService.getEntries();
		ActionContext.getContext().getValueStack().push(roles);
		return SUCCESS;
	}
	
}
