package com.zph.supplychain.login.dao;

import com.zph.supplychain.domain.basedata.User;

public interface LoginDao {
	public User authentication(String username,String password);
}
