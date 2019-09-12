package com.zph.supplychain.privilege.action;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.zph.supplychain.base.action.BaseAction;
import com.zph.supplychain.domain.privilege.Menuitem;
import com.zph.supplychain.privilege.service.MenuitemService;

@Controller("menuitemAction")
@Scope("prototype")
public class MenuitemAction extends BaseAction<Menuitem>{
	
	@Resource(name="menuitemService")
	private MenuitemService menuitemService;
	
	public String showMenuitemTree() {
		Collection<Menuitem> menuitems = this.menuitemService.getEntries();
		ActionContext.getContext().getValueStack().push(menuitems);
		return SUCCESS;
	}
	
}
