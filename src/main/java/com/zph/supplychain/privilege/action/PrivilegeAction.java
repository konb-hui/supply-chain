package com.zph.supplychain.privilege.action;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.zph.supplychain.base.action.BaseAction;
import com.zph.supplychain.domain.basedata.User;
import com.zph.supplychain.domain.privilege.Privilege;
import com.zph.supplychain.domain.privilege.Role;
import com.zph.supplychain.privilege.service.PrivilegeService;
import com.zph.supplychain.privilege.service.RoleService;

@Controller("privilegeAction")
@Scope("prototype")
public class PrivilegeAction extends BaseAction<Privilege>{
	
	@Resource(name="privilegeService")
	private PrivilegeService privilegeService;
	
	@Resource(name="roleService")
	private RoleService roleService;
	
	private Long rid;//角色id
	private String checkedStr;//被选中的权限节点的id的字符串
	
	public Long getRid() {
		return rid;
	}

	public void setRid(Long rid) {
		this.rid = rid;
	}

	public String getCheckedStr() {
		return checkedStr;
	}

	public void setCheckedStr(String checkedStr) {
		this.checkedStr = checkedStr;
	}

	public String showPrivilegeTree() {
		Collection<Privilege> privileges = this.privilegeService.getPrivilegeByRoleId(getRid());
		ActionContext.getContext().getValueStack().push(privileges);
		return SUCCESS;
	}
	
	public String savePrivilege() {
		//根据rid获取Role
		Role role = this.roleService.getEntry(rid);
		//获取被选中的角色的集合
		if("".equals(this.checkedStr)) {//页面上没有权限
			role.setPrivileges(null);
		}else {
			Set<Privilege> privileges = this.privilegeService.getEntriesByIds(this.checkedStr.split(","));
			//建立角色与权限的关系
			role.setPrivileges(privileges);
		}
		this.roleService.updateEntry(role);
		return SUCCESS;
	}
	
	/**
	 * 加载登录以后左侧的菜单
	 */
	 public String showMenuitemTreeByUid() {
		 User user = (User)this.getSession().getAttribute("user");
		 Collection<Privilege> privileges = this.privilegeService.getMenuitemByUid(user.getUid());
		 ActionContext.getContext().getValueStack().push(new HashSet<Privilege>(privileges));
		 return SUCCESS;
	 }
}
