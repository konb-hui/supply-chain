package com.zph.supplychain.base.service.impl;

import java.io.Serializable;

import org.springframework.transaction.annotation.Transactional;

import com.zph.supplychain.base.dao.BaseDao;
import com.zph.supplychain.base.service.BaseService;
import com.zph.supplychain.query.BaseQuery;
import com.zph.supplychain.query.PageResult;

public abstract class BaseServiceImpl<T> implements BaseService<T>{
	
	public abstract BaseDao getbaseDao();
	
	@Transactional
	public PageResult<T> findPageResult(BaseQuery baseQuery) {
		// TODO Auto-generated method stub
		return this.getbaseDao().findPageResult(baseQuery);
	}
	
	@Transactional
	public void saveEntry(T t) {
		// TODO Auto-generated method stub
		this.getbaseDao().saveEntry(t);
	}
	
	@Transactional
	public void updateEntry(T t) {
		// TODO Auto-generated method stub
		this.getbaseDao().updateEntry(t);
	}
	
	@Transactional
	public void deleteEntryById(Serializable id) {
		// TODO Auto-generated method stub
		this.getbaseDao().deleteEntry(id);
	}
	
	@Transactional
	public void deleteEntriesByids(Serializable[] ids) {
		// TODO Auto-generated method stub
		this.getbaseDao().deleteEntriesByIds(ids);
	}
	
	public T getEntry(Serializable id) {
		return (T) this.getbaseDao().getEntry(id);
	}
	
}
