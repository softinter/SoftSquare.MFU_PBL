package com.softsquare.application.dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;

import com.softsquare.application.common.util.BeanUtils;
import com.softsquare.application.domain.ManageRoleMapping;
import com.softsquare.application.entity.Role;

public class RoleDaolmp extends AbstractDao<Integer, Role> implements RoleDao{
	
	@Override
	public ArrayList<Role> getRole() {
		 Criteria criteria = getSession().createCriteria(Role.class, "role");
		 ProjectionList projections = Projections.projectionList()
		            .add(Projections.property("role.roleId").as("roleId"))
		            .add(Projections.property("role.roleCode").as("roleCode"))
		            .add(Projections.property("role.roleName").as("roleName"));
		 criteria.setProjection(projections);
		 criteria.setResultTransformer(Transformers.aliasToBean(Role.class));
		 ArrayList<Role> roleList = (ArrayList<Role>) criteria.list();
		return roleList;
	}

	@Override
	public Role getRoleForUpdate(ManageRoleMapping mapping) {
		 Criteria criteria = getSession().createCriteria(Role.class, "role");
		 ProjectionList projections = Projections.projectionList()
		            .add(Projections.property("role.roleId").as("roleId"))
		            .add(Projections.property("role.roleCode").as("roleCode"))
		            .add(Projections.property("role.roleName").as("roleName"));
		 criteria.setProjection(projections);
		 if(BeanUtils.isNotEmpty(mapping.getRoleCode())){
			 criteria.add(Restrictions.eq("role.roleId", mapping.getRoleId()));			 
		 }
		 criteria.setResultTransformer(Transformers.aliasToBean(Role.class));
		 Role roleList = (Role) criteria.uniqueResult();
		return roleList;
	}
	
	@Override
	public void saveRole(Role role) throws Exception {
		save(role);
	}

	@Override
	public void removeRole(Role role) throws Exception {
		delete(role);
	}

	@Override
	public void updateRole(Role role) throws Exception {
		merge(role);
	}

}
