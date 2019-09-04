package com.zph.supplychain.base.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.zph.supplychain.base.dao.BaseDao;
import com.zph.supplychain.query.BaseQuery;
import com.zph.supplychain.query.PageResult;

@Repository("baseDao")
public class BaseDaoImpl<T> implements BaseDao<T>{
	
	@Resource(name="hibernateTemplate")
	public HibernateTemplate hibernateTemplate;

	public PageResult<T> findPageResult(BaseQuery baseQuery) {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection<T> findEntry() {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveEntry(T t) {
		// TODO Auto-generated method stub
		
	}

	public void updateEntry(T t) {
		// TODO Auto-generated method stub
		
	}

	public void deleteEntriesByIds(Serializable[] ids) {
		// TODO Auto-generated method stub
		
	}

	public void deleteEntry(Serializable id) {
		// TODO Auto-generated method stub
		
	}

	public T getEntry(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<T> getEntriesByIds(Serializable[] ids) {
		// TODO Auto-generated method stub
		return null;
	}

	public int getCount(final BaseQuery baseQuery) {
		return this.hibernateTemplate.execute(new HibernateCallback<Integer>() {

			public Integer doInHibernate(Session session) throws HibernateException, SQLException {
				StringBuffer stringBuffer = new StringBuffer();
				stringBuffer.append("select count(*) from Department");
				stringBuffer.append(" where 1=1 ");
				//获取所有的查询条件
				Map<String, Object> keyValues = baseQuery.buildWhere();
				//拼接where条件的过程
				for(Entry<String, Object> entry : keyValues.entrySet()) {
					stringBuffer.append("and " + entry.getKey() + "=:" + entry.getKey());
				}
				System.out.println(stringBuffer.toString());
				Query query = session.createQuery(stringBuffer.toString());
				//把where条件中的参数传递值的过程
				for(Entry<String, Object> entry : keyValues.entrySet()) {
					query.setParameter(entry.getKey(), entry.getValue());
				}
				Long count = (Long) query.uniqueResult();
				return count.intValue();
			}
			
		});
	}

}
