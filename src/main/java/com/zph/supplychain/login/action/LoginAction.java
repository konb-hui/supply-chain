package com.zph.supplychain.login.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.zph.supplychain.base.action.BaseAction;
import com.zph.supplychain.domain.basedata.User;
import com.zph.supplychain.login.service.LoginService;

@Controller("loginAction")
@Scope("prototype")
public class LoginAction extends BaseAction<User>{
	@Resource(name="loginService")
	private LoginService loginService;
	
	public String authentication() {
		User user = this.loginService.authentication(this.getModel().getUsername(), this.getModel().getPassword());
		if(user == null) {//用户名或者密码错误
			this.addActionError("用户名或密码错误");
			return "login";
		}else {
			this.getSession().setAttribute("user", user);
			return "index";
		}
	}
}
