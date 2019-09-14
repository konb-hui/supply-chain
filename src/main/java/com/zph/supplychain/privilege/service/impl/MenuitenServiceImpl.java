package com.zph.supplychain.privilege.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.zph.supplychain.base.dao.BaseDao;
import com.zph.supplychain.base.service.impl.BaseServiceImpl;
import com.zph.supplychain.domain.privilege.Menuitem;
import com.zph.supplychain.privilege.dao.MenuitemDao;
import com.zph.supplychain.privilege.service.MenuitemService;

@Service("menuitemService")
public class MenuitenServiceImpl extends BaseServiceImpl<Menuitem> implements MenuitemService{
	
	@Resource(name="menuitemDao")
	private MenuitemDao menuitemDao;
	
	@Override
	public BaseDao getbaseDao() {
		// TODO Auto-generated method stub
		return this.menuitemDao;
	}

}
