package com.glearning.employee.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.glearning.employee.entity.Role;
import com.glearning.employee.repository.model.RoleDAO;

@Repository
public class RoleImplementation implements RoleDAO {

	@Autowired
	private EntityManager entityManager;

	@Override
	@Transactional
	public String addRole(Role role) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(role);
		return "Role Added Successfully - Id: " + role.getId();
	}

	@Override
	@Transactional
	public List<Role> getRoles() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Role> query = currentSession.createQuery("from Role", Role.class);
		return query.getResultList();
	}
}
