package com.app.bishwas.dao;

import java.util.List;

import com.app.bishwas.domain.User;

public interface IUserDAO {

	public void addUser(User u);

	public void updateUser(User u);

	public void removeUser(int id );

	public User getUserById(int id);

	public List<User> findAllUser();
}
