package com.zph.supplychain.business.xsgl.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.zph.supplychain.business.xsgl.service.XsyddService;
import com.zph.supplychain.domain.business.xsgl.Xsyddzhib;
import com.zph.supplychain.domain.business.xsgl.Xsyddzhub;
import com.zph.supplychain.query.PageResult;
import com.zph.supplychain.query.business.xsgl.XsyddzhibQuery;
import com.zph.supplychain.query.business.xsgl.XsyddzhubQuery;

@Controller("xsyddAction")
@Scope("prototype")
public class XsyddAction {
	//主表的查询条件
	private XsyddzhubQuery baseQuery_zhu = new XsyddzhubQuery();
	//子表的查询条件
	private XsyddzhibQuery baseQuery_zhi = new XsyddzhibQuery();
	@Resource(name="xsyddService")
	private XsyddService xsyddService;
	/**
	 * 查询销售预订单 
	 */
	public String showXsydd() {
		PageResult<Xsyddzhub> pageResult_zhu = this.xsyddService.getEntries_zhu(baseQuery_zhu);
		PageResult<Xsyddzhib> pageResult_zhi = this.xsyddService.getEntries_zi(baseQuery_zhi);
		
		ActionContext.getContext().put("pageResult_zhub", pageResult_zhu);
		ActionContext.getContext().put("pageResult_zhib", pageResult_zhi);
		
		return "xsyddList";
	}
}
