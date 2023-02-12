package com.glearning.employee.rest;

import java.time.Duration;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session.Cookie;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.glearning.employee.entity.Employee;
import com.glearning.employee.entity.Role;
import com.glearning.employee.entity.User;
import com.glearning.employee.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employees")
	public List<Employee> findAll() {
		return employeeService.findAll();
	}

	@GetMapping("/employees/{employeeId}")
	public Employee getEmployeeById(@PathVariable int employeeId) {
		Employee employee = employeeService.findById(employeeId);
		if (employee == null) {
			throw new RuntimeException(" Employee Not Found - " + employeeId);
		}
		return employee;
	}

	@PostMapping("/employee")
	public Employee addEmployee(@RequestBody Employee employee) {
		employee.setId(0);
		employeeService.save(employee);
		return employee;
	}

	@PutMapping("/employee")
	public Employee updateEmployee(@RequestBody Employee employee) {
		employeeService.save(employee);
		return employee;
	}

	@DeleteMapping("/employee/{employeeId}")
	public String deleteEmployeeById(@PathVariable int employeeId) {
		Employee employee = employeeService.findById(employeeId);
		if (employee == null) {
			throw new RuntimeException(" Employee Not Found - " + employeeId);
		} else {
			employeeService.delete(employeeId);
		}
		return "Employee Deleted - ID: " + employeeId;
	}

	@GetMapping("/employees/search/{employeeFirstName}")
	public List<Employee> getEmployeeByFirstName(@PathVariable String employeeFirstName) {
		return employeeService.findByFirstName(employeeFirstName);
	}

	@GetMapping("/employees/sort")
	public List<Employee> sortEmployeeByFirstName(@RequestParam(name = "order") String order) {
		if ("asc".matches(order.toLowerCase()) || "desc".matches(order.toLowerCase())) {
			return employeeService.sortByFirstName(order.toUpperCase());
		} else {
			return null;
		}
	}

	@PostMapping("/add/role")
	public Role addRole(@RequestBody Role role) {
		role.setId(0);
		employeeService.addRole(role);
		return role;
	}

	@PostMapping("/add/user")
	public User saveuser(@RequestBody User user) {
		user.setId(0);
		String password = user.getPassword();
		System.out.println("Orginal Password: " + password);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		password = encoder.encode(password).toString();
		System.out.println("Encode Password: " + password);
		user.setPassword(password);
		employeeService.saveUser(user);
		return user;
	}

	@GetMapping("/roles")
	public List<Role> getRoles() {
		return employeeService.getRoles();
	}

	@GetMapping("/users")
	public List<User> getUsers() {
		return employeeService.getUsers();
	}
}
