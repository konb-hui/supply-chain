package com.zph.supplychain.login.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zph.supplychain.domain.basedata.User;
import com.zph.supplychain.login.dao.LoginDao;
import com.zph.supplychain.login.service.LoginService;

@Service("loginService")
public class LoginServiceImpl implements LoginService{
	
	@Resource(name="loginDao")
	private LoginDao loginDao;
	
	public User authentication(String username, String password) {
		// TODO Auto-generated method stub
		return this.loginDao.authentication(username, password);
	}

}
