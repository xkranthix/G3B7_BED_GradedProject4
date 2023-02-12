package com.glearning.employee.repository.model;

import java.util.List;

import com.glearning.employee.entity.Role;

public interface RoleDAO {

	public List<Role> getRoles();

	public String addRole(Role role);

}
