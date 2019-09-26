package com.zph.supplychain.login.service;

import com.zph.supplychain.domain.basedata.User;

public interface LoginService {
	public User authentication(String username,String password);
}
