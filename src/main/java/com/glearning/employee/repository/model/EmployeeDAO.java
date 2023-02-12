package com.glearning.employee.repository.model;

import java.util.List;

import com.glearning.employee.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> findAll();

	public Employee findById(int id);

	public void save(Employee employee);

	public void delete(int id);

	public List<Employee> findByFirstName(String firstName);

	public List<Employee> sortByFirstName(String order);
}
