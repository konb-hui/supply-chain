package com.zph.supplychain.basedata.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.zph.supplychain.base.action.BaseAction;
import com.zph.supplychain.basedata.service.UserService;
import com.zph.supplychain.domain.basedata.User;
import com.zph.supplychain.query.PageResult;
import com.zph.supplychain.query.basedata.UserQuery;

@Controller("userAction")
@Scope("prototype")
public class UserAction extends BaseAction<User>{
	@Resource(name = "userService")
	private UserService userService;
	private UserQuery baseQuery = new UserQuery();
	
	public String showPageResult() {
		baseQuery.setCurrentPage(this.getCurrentPage());
		PageResult<User> users = userService.findPageResult(baseQuery);
		ActionContext.getContext().put("users",users);
		return listAction;
	}
}
