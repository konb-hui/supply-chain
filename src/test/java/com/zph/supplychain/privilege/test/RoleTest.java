package com.zph.supplychain.privilege.test;

import org.junit.Test;

import com.zph.supplychain.domain.privilege.Role;
import com.zph.supplychain.privilege.service.RoleService;
import com.zph.supplychain.test.utils.SpringUtils;

public class RoleTest extends SpringUtils{
	@Test
	public void testSaveRole() {
		RoleService roleService = (RoleService) this.context.getBean("roleService");
		Role role = new Role();
		role.setIsParent(true);
		role.setName("CEO");
		role.setPid(0L);
		roleService.saveEntry(role);
	}
}
