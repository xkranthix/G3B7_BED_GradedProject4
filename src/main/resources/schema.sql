DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS role;
DROP TABLE IF EXISTS user_roles;
CREATE TABLE employee(
	id int auto_increment primary key,
	first_name varchar(45),
	last_name varchar(45),
	email varchar(45)
);
CREATE TABLE users(
	user_id int auto_increment primary key,
	user_name varchar(45),
	password varchar(85)
);
CREATE TABLE role(
	role_id int auto_increment primary key,
	name varchar(45)
);
CREATE TABLE user_roles(
	user_id int,
	role_id int,
	FOREIGN KEY (user_id) REFERENCES users(user_id),
	FOREIGN KEY (role_id) REFERENCES role(role_id)
);