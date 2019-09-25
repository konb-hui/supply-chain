package com.zph.supplychain.privilege.dao.impl;

import java.sql.SQLException;
import java.util.Collection;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.zph.supplychain.base.dao.impl.BaseDaoImpl;
import com.zph.supplychain.domain.privilege.Role;
import com.zph.supplychain.privilege.dao.RoleDao;

@Repository("roleDao")
public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao{

	public Role getRoleByName(final String name) {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.execute(new HibernateCallback<Role>() {

			public Role doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery("from Role where name=:name");
				query.setParameter("name", name);
				return (Role)query.uniqueResult();
			}
			
		});
	}

	public Collection<Role> getRoleByUid(Long uid) {
		//加载所有的角色
		Collection<Role> allRoles = this.hibernateTemplate.find("from Role");
		//加载用户能够访问到的角色
		Collection<Role> userRoles = this.hibernateTemplate.find("from Role r inner join fetch r.users u where u.uid=?",uid);
		for (Role role : allRoles) {
			for (Role role2 : userRoles) {
				if(role.getRid().longValue()==role2.getRid().longValue()) {
					role.setChecked(true);
				}
			}
		}
		return allRoles;
	}

}
