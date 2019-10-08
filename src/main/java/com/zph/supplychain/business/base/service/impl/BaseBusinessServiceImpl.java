package com.zph.supplychain.business.base.service.impl;

import java.io.Serializable;

import com.zph.supplychain.base.dao.BaseDao;
import com.zph.supplychain.business.base.service.BaseBusinessService;
import com.zph.supplychain.query.BaseQuery;
import com.zph.supplychain.query.PageResult;

public abstract class BaseBusinessServiceImpl<T, E extends Serializable> implements BaseBusinessService<T, E>{
	
	public abstract BaseDao<T> getBaseDao_zhu();
	public abstract BaseDao<E> getBaseDao_zhi();
	
	public PageResult<T> getEntries_zhu(BaseQuery baseQuery) {
		// TODO Auto-generated method stub
		return this.getBaseDao_zhu().findPageResult(baseQuery);
	}

	public PageResult<E> getEntries_zi(BaseQuery baseQuery) {
		// TODO Auto-generated method stub
		return this.getBaseDao_zhi().findPageResult(baseQuery);
	}

}
