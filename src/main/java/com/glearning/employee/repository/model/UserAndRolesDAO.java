package com.glearning.employee.repository.model;

import java.util.List;

import com.glearning.employee.entity.User;

public interface UserAndRolesDAO {

	public List<User> getUsers();

	public String saveUser(User user);

}
