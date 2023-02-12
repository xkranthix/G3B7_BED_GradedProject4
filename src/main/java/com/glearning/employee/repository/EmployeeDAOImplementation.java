package com.glearning.employee.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.glearning.employee.entity.Employee;
import com.glearning.employee.repository.model.EmployeeDAO;

@Repository
public class EmployeeDAOImplementation implements EmployeeDAO {

	@Autowired
	private EntityManager entityManager;

	@Override
	@Transactional
	public List<Employee> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Employee> query = currentSession.createQuery("from Employee", Employee.class);
		return query.getResultList();
	}

	@Override
	@Transactional
	public Employee findById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Employee employee = currentSession.get(Employee.class, id);
		return employee;
	}

	@Override
	@Transactional
	public void save(Employee employee) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(employee);
	}

	@Override
	@Transactional
	public void delete(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Employee> query = currentSession.createQuery("delete from Employee where id=:empId");
		query.setParameter("empId", id);
		query.executeUpdate();
	}

	@Override
	public List<Employee> findByFirstName(String firstName) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Employee> query = currentSession.createQuery("from Employee where firstName=:name");
		query.setParameter("name", firstName);
		return query.getResultList();
	}

	@Override
	public List<Employee> sortByFirstName(String order) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Employee> query = currentSession.createQuery("from Employee ORDER BY firstName " + order);
		return query.getResultList();
	}

}
