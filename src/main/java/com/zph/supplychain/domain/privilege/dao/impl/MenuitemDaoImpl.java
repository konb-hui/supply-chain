package com.zph.supplychain.domain.privilege.dao.impl;

import org.springframework.stereotype.Repository;

import com.zph.supplychain.base.dao.impl.BaseDaoImpl;
import com.zph.supplychain.domain.privilege.Menuitem;
import com.zph.supplychain.domain.privilege.dao.MenuitemDao;

@Repository("menuitemDao")
public class MenuitemDaoImpl extends BaseDaoImpl<Menuitem> implements MenuitemDao{

}
