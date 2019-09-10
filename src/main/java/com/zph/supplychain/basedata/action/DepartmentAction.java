package com.zph.supplychain.basedata.action;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.zph.supplychain.base.action.BaseAction;
import com.zph.supplychain.basedata.service.DepartmentService;
import com.zph.supplychain.domain.basedata.Department;
import com.zph.supplychain.query.PageResult;
import com.zph.supplychain.query.basedata.DepartmentQuery;

@Controller("departmentAction")
@Scope("prototype")
public class DepartmentAction extends BaseAction<Department>{
	
	@Resource(name="departmentService")
	private DepartmentService departmentService;
	private DepartmentQuery baseQuery = new DepartmentQuery();

	public String showPageResult() {
		baseQuery.setCurrentPage(this.getCurrentPage());
		PageResult<Department> departments = this.departmentService.findPageResult(baseQuery);
		ActionContext.getContext().put("departments", departments);
		return listAction;
	}
	
	public String deleteDepartement() {
		//String[] ids = this.getCheckedStr().split(",");
		this.departmentService.deleteEntriesByids(this.getIds());
		return action2action;
	}
	
	public String addUI() {
		return addUI;
	}
	
	public String add() {
		Department department = new Department();
		BeanUtils.copyProperties(this.getModel(), department);
		this.departmentService.saveEntry(department);
		return action2action;
	}
	
	public String updateUI() {
		Department department = this.departmentService.getEntry(this.getModel().getDid());
		ActionContext.getContext().getValueStack().push(department);
		return updateUI;
	}
	public String update() {
		Department department = this.departmentService.getEntry(this.getModel().getDid());
		BeanUtils.copyProperties(this.getModel(), department);
		this.departmentService.updateEntry(department);
		return action2action;
	}
	
	public String deleteOne() {
		this.departmentService.deleteEntryById(this.getModel().getDid());
		return action2action;
	}
}
