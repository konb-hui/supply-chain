package com.zph.supplychain.basedata.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zph.supplychain.base.dao.BaseDao;
import com.zph.supplychain.base.service.impl.BaseServiceImpl;
import com.zph.supplychain.basedata.dao.UserDao;
import com.zph.supplychain.basedata.service.UserService;
import com.zph.supplychain.domain.basedata.User;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService{
	
	@Resource(name = "userDao")
	private UserDao userDao;
	
	@Override
	public BaseDao getbaseDao() {
		// TODO Auto-generated method stub
		return this.userDao;
	}

}
