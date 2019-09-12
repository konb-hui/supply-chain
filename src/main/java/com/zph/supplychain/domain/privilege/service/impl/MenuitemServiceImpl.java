package com.zph.supplychain.domain.privilege.service.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.zph.supplychain.base.dao.BaseDao;
import com.zph.supplychain.base.service.impl.BaseServiceImpl;
import com.zph.supplychain.domain.privilege.Menuitem;
import com.zph.supplychain.domain.privilege.dao.MenuitemDao;
import com.zph.supplychain.domain.privilege.service.MenuitemService;

@Repository("menuitemService")
public class MenuitemServiceImpl extends BaseServiceImpl<Menuitem> implements MenuitemService{
	
	@Resource(name="menuitemDao")
	private MenuitemDao menuitemDao;
	
	@Override
	public BaseDao getbaseDao() {
		// TODO Auto-generated method stub
		return this.menuitemDao;
	}

}
