package com.zph.supplychain.privilege.action;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.zph.supplychain.base.action.BaseAction;
import com.zph.supplychain.domain.privilege.Role;
import com.zph.supplychain.privilege.service.RoleService;
import com.zph.supplychain.utils.SupplyChainKey;

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
	
	public String add() {
		Role role = new Role();
		BeanUtils.copyProperties(this.getModel(), role);
		this.roleService.saveEntry(role);
		/**
		 *把Role回调到客户端，因为客户端用使用rid 
		 */
		ActionContext.getContext().getValueStack().push(role);
		return SUCCESS;
	}
	
	public String showRoleByName() {
		Role role = this.roleService.getRoleByName(this.getModel().getName());
		if(role==null) {
			ActionContext.getContext().getValueStack().push(SupplyChainKey.ROLE_NAME_FLAG_ABLE);//名字可用，将标志传到客户端
		}else {
			ActionContext.getContext().getValueStack().push(SupplyChainKey.ROLE_NAME_FLAG_DISABLE);//名字不可用，将标志传到客户端
		}
		return SUCCESS;
	}
	
	public String deleteRole() {
		this.roleService.deleteEntryById(this.getModel().getRid());
		return SUCCESS;
	}
}
