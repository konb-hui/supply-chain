package com.zph.supplychain.basedata.action;

import javax.annotation.Resource;

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
	private int currentPage;
	
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public String showPageResult() {
		baseQuery.setCurrentPage(currentPage);
		PageResult<Department> departments = this.departmentService.findPageResult(baseQuery);
		ActionContext.getContext().put("departments", departments);
		return listAction;
	}
	
	public String deleteDepartement() {
		//String[] ids = this.getCheckedStr().split(",");
		this.departmentService.deleteEntriesByids(this.getIds());
		return action2action;
	}
	
}
