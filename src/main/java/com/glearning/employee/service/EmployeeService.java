package com.glearning.employee.service;

import java.util.List;

import com.glearning.employee.entity.Employee;
import com.glearning.employee.entity.Role;
import com.glearning.employee.entity.User;

public interface EmployeeService {
	public List<Employee> findAll();

	public Employee findById(int id);

	public void save(Employee employee);

	public void delete(int id);

	public List<Employee> findByFirstName(String firstName);

	public List<Employee> sortByFirstName(String order);

	public String addRole(Role role);

	public String saveUser(User user);

	public List<Role> getRoles();

	public List<User> getUsers();
}
