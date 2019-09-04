package com.zph.supplychain.query.basedata;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.zph.supplychain.query.BaseQuery;

public class DepartmentQuery extends BaseQuery{
	private String name;
	private String description;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public Map<String, Object> buildWhere() {
		if(StringUtils.isNotBlank(this.name)) {//name的属性值部位空
			this.getKeyValues().put("name", this.name);
		}
		if(StringUtils.isNotBlank(this.description)) {//description的实行值部位空
			this.getKeyValues().put("description", description);
		}
		return this.getKeyValues();
	}

}
