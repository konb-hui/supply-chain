package com.zph.supplychain.privilege.action;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.zph.supplychain.base.action.BaseAction;
import com.zph.supplychain.domain.privilege.Privilege;
import com.zph.supplychain.privilege.service.PrivilegeService;

@Controller("privilegeAction")
@Scope("prototype")
public class PrivilegeAction extends BaseAction<Privilege>{
	
	@Resource(name="privilegeService")
	private PrivilegeService privilegeService;
	
	public String showPrivilegeTree() {
		Collection<Privilege> privileges = this.privilegeService.getEntries();
		ActionContext.getContext().getValueStack().push(privileges);
		return SUCCESS;
	}
	
}
