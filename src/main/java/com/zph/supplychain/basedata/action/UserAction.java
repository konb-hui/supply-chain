package com.zph.supplychain.basedata.action;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.zph.supplychain.base.action.BaseAction;
import com.zph.supplychain.basedata.service.DepartmentService;
import com.zph.supplychain.basedata.service.UserService;
import com.zph.supplychain.domain.basedata.Department;
import com.zph.supplychain.domain.basedata.User;
import com.zph.supplychain.query.PageResult;
import com.zph.supplychain.query.basedata.UserQuery;

@Controller("userAction")
@Scope("prototype")
public class UserAction extends BaseAction<User>{
	@Resource(name = "userService")
	private UserService userService;
	@Resource(name = "departmentService")
	private DepartmentService departmentService;
	private UserQuery baseQuery = new UserQuery();
	private Long did;
	
	
	public Long getDid() {
		return did;
	}

	public void setDid(Long did) {
		this.did = did;
	}

	public String showPageResult() {
		baseQuery.setCurrentPage(this.getCurrentPage());
		PageResult<User> users = userService.findPageResult(baseQuery);
		ActionContext.getContext().put("users",users);
		return listAction;
	}
	
	public String addUI() {
		/**
		 * 列出所有department
		 */
		Collection<Department> departments = this.departmentService.getEntries();
		ActionContext.getContext().put("departments", departments);
		return addUI;
	}
	
	public String add() {
		/**
		 * 1.获取用户的一般属性
		 * 2.获取页面上did的值，根据did的值把department对象提取出来
		 * 3.建立用户与部门之间的关系
		 */
		User user = new User();
		BeanUtils.copyProperties(this.getModel(), user);
		
		Department department = this.departmentService.getEntry(this.did);
		//建立用户与部门之间的关系
		user.setDepartment(department);
		//用户和部门，用户负责维护关系
		this.userService.saveEntry(user);
		return action2action;
	}
	
	public String updateUI() {
		/**
		 * 回显用户的一般属性
		 */
		User user = this.userService.getEntry(this.getModel().getUid());
		ActionContext.getContext().getValueStack().push(user);
		
		/**
		 * 回显部门
		 * action中的属性did在对象栈中，所以只需要给did复制即可
		 */
		this.did = user.getDepartment().getDid();
		
		/**
		 * 把部门提取出来
		 */
		Collection<Department> departments = this.departmentService.getEntries();
		ActionContext.getContext().put("departments", departments);
		return updateUI;
	}
	
	public String update() {
		/**
		 * 用户的一般属性
		 */
		User user = this.userService.getEntry(this.getModel().getUid());
		BeanUtils.copyProperties(this.getModel(), user);//把用户属性的新的值获取到
		
		Department department = this.departmentService.getEntry(this.did);//该用户重新选择的部门
				
		user.setDepartment(department);
		
		this.userService.updateEntry(user);
		
		return action2action;
	}
}
