package com.zph.supplychain.business.xsgl;

import org.junit.Test;

import com.zph.supplychain.business.xsgl.service.XsyddService;
import com.zph.supplychain.domain.business.xsgl.Xsyddzhib;
import com.zph.supplychain.domain.business.xsgl.Xsyddzhub;
import com.zph.supplychain.query.PageResult;
import com.zph.supplychain.query.business.xsgl.XsyddzhibQuery;
import com.zph.supplychain.query.business.xsgl.XsyddzhubQuery;
import com.zph.supplychain.test.utils.SpringUtils;

public class XsyddTest extends SpringUtils{
	@Test
	public void testQuery() {
		XsyddService xsyddService = (XsyddService)context.getBean("xsyddService");
//		XsyddzhubQuery xsyddzhubQuery = new XsyddzhubQuery();
//		xsyddzhubQuery.setCurrentPage(2);
//		PageResult<Xsyddzhub> pageResult_zhu = xsyddService.getEntries_zhu(xsyddzhubQuery);
//		System.out.println(pageResult_zhu.getRows().size());
		
		XsyddzhibQuery xsyddzhibQuery = new XsyddzhibQuery();
		xsyddzhibQuery.setXsyddzhubid(2L);
		xsyddzhibQuery.setCurrentPage(2);
		PageResult<Xsyddzhib> pageResult = xsyddService.getEntries_zi(xsyddzhibQuery);
		System.out.println(pageResult.getRows().size());
	}
	
}
