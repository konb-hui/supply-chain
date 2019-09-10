package com.zph.supplychain.query.basedata;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.zph.supplychain.query.BaseQuery;

public class UserQuery extends BaseQuery{
	
	private String name;
	private String sex;
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	@Override
	public Map<String, Object> buildWhere() {
		if(StringUtils.isNotBlank(this.name)) {
			this.getKeyValues().put("name", this.name);
		}
		if(StringUtils.isNotBlank(this.sex)) {
			this.getKeyValues().put("sex", this.sex);
		}
		return this.getKeyValues();
	}

}
