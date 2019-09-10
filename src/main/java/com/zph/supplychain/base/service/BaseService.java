package com.zph.supplychain.base.service;

import java.io.Serializable;
import java.util.Collection;

import com.zph.supplychain.query.BaseQuery;
import com.zph.supplychain.query.PageResult;

public interface BaseService<T> {
	
	public PageResult<T> findPageResult(final BaseQuery baseQuery);
	
	public void saveEntry(T t);
	
	public void updateEntry(T t);
	
	public void deleteEntryById(Serializable id);
	
	public void deleteEntriesByids(Serializable[] ids);
	
	public T getEntry(Serializable id);
	
	public Collection<T> getEntries();
}
