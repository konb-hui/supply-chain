package com.zph.supplychain.query;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseQuery {
	//把页面上的表单元素封装成map
	Map<String, Object> keyValues = new HashMap<String, Object>();
	//把页面上的查询条件封装成一个Map<String, Object>，并且返回
	public abstract Map<String, Object> buildWhere();
	public Map<String, Object> getKeyValues() {
		return keyValues;
	}
	public void setKeyValues(Map<String, Object> keyValues) {
		this.keyValues = keyValues;
	}
	
}
