package com.app.bishwas.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.bishwas.dao.IUserDAO;
import com.app.bishwas.domain.User;
import com.app.bishwas.service.IUserService;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

	private IUserDAO userDAO;

	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public void addUser(User u) {
		// TODO Auto-generated method stub
		userDAO.addUser(u);
	}

	@Override
	public void updateUser(User u) {
		// TODO Auto-generated method stub
		userDAO.updateUser(u);
	}

	@Override
	public void removeUser(int id) {
		// TODO Auto-generated method stub
		userDAO.removeUser(id);
	}

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return userDAO.getUserById(id);
	}

	@Override
	public List<User> findAllUser() {
		// TODO Auto-generated method stub
		return userDAO.findAllUser();
	}

}
