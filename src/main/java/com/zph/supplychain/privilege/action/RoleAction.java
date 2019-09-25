package com.zph.supplychain.privilege.action;

import java.util.Collection;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.zph.supplychain.base.action.BaseAction;
import com.zph.supplychain.basedata.service.UserService;
import com.zph.supplychain.domain.basedata.User;
import com.zph.supplychain.domain.privilege.Role;
import com.zph.supplychain.privilege.service.RoleService;
import com.zph.supplychain.utils.SupplyChainKey;

@Controller("roleAction")
@Scope("prototype")
public class RoleAction extends BaseAction<Role>{
	
	@Resource(name="roleService")
	private RoleService roleService;
	
	@Resource(name="userService")
	private UserService userService;
	
	private Long uid;
	
	private String checkedStr;
	public String getCheckedStr() {
		return checkedStr;
	}

	public void setCheckedStr(String checkedStr) {
		this.checkedStr = checkedStr;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

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
	
	public String updateRole() {
		Role role = this.roleService.getEntry(this.getModel().getRid());
		role.setName(this.getModel().getName());
		this.roleService.updateEntry(role);
		return SUCCESS;
	}
	/**
	 * 在权限设置模块，显示角色的名称 
	 */
	public String showRoles() {
		Collection<Role> roles = this.roleService.getEntries();
		ActionContext.getContext().put("roles", roles);
		return listAction;
	}
	/**
	 *跳转到到用户设置角色的页面 
	 */
	public String showUserList() {
		Collection<User> users = this.userService.getEntries();
		ActionContext.getContext().put("users", users);
		return listAction;
	}
	/**
	 *在权限管理-->角色配置-->设置角色（超级链接）-->加载角色树，涉及到对角色树的回显 
	 */
	public String showRoleByUid() {
		Collection<Role> roles = this.roleService.getRoleByUid(uid);
		ActionContext.getContext().getValueStack().push(roles);
		return SUCCESS;
	}
	public String saveRole() {
		User user = this.userService.getEntry(uid);
		Set<Role> roles = this.roleService.getEntriesByIds(checkedStr.split(","));
		user.setRoles(roles);//建立用户与角色的关系
		this.userService.updateEntry(user);
		return SUCCESS;
	}
}
