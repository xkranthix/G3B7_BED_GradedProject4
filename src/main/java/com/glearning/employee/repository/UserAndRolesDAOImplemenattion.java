package com.glearning.employee.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.glearning.employee.entity.User;
import com.glearning.employee.repository.model.UserAndRolesDAO;

@Repository
public class UserAndRolesDAOImplemenattion implements UserAndRolesDAO {

	@Autowired
	private EntityManager entityManager;

	@Override
	@Transactional
	public String saveUser(User user) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(user);
		return "User Added Successfully - Id: " + user.getId();
	}

	@Override
	@Transactional
	public List<User> getUsers() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<User> query = currentSession.createQuery("from User", User.class);
		return query.getResultList();
	}

}
