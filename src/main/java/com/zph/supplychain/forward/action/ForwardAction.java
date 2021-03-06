package com.zph.supplychain.forward.action;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller("forwardAction")
public class ForwardAction extends ActionSupport{
	
	private String method;

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}
	
	public String forward() {
		return this.method;
	}
	public String top() {
		return "top";
	}
	public String center() {
		return "center";
	}
	public String left() {
		return "left";
	}
	public String right() {
		return "right";
	}
}
