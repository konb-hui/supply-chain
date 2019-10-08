package com.zph.supplychain.business.xsgl.service.impl;

import com.zph.supplychain.base.dao.BaseDao;
import com.zph.supplychain.business.base.service.impl.BaseBusinessServiceImpl;
import com.zph.supplychain.business.xsgl.dao.XsyddzhibDao;
import com.zph.supplychain.business.xsgl.dao.XsyddzhubDao;
import com.zph.supplychain.business.xsgl.service.XsyddService;
import com.zph.supplychain.domain.business.xsgl.Xsyddzhib;
import com.zph.supplychain.domain.business.xsgl.Xsyddzhub;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
@Service("xsyddService")
public class XsyddServiceImpl extends BaseBusinessServiceImpl<Xsyddzhub,Xsyddzhib> implements XsyddService{
	@Resource(name="xsyddzhubDao")
	private XsyddzhubDao xsyddzhubDao;
	@Resource(name="xsyddzhibDao")
	private XsyddzhibDao xsyddzhibDao;
	@Override
	public BaseDao<Xsyddzhub> getBaseDao_zhu() {
		// TODO Auto-generated method stub
		return this.xsyddzhubDao;
	}

	@Override
	public BaseDao<Xsyddzhib> getBaseDao_zhi() {
		// TODO Auto-generated method stub
		return this.xsyddzhibDao;
	}

}
