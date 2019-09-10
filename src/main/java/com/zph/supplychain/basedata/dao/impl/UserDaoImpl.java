package com.zph.supplychain.basedata.dao.impl;

import org.springframework.stereotype.Repository;

import com.zph.supplychain.base.dao.impl.BaseDaoImpl;
import com.zph.supplychain.basedata.dao.UserDao;
import com.zph.supplychain.domain.basedata.User;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{

}
