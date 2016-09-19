package com.app.bishwas.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.app.bishwas.dao.IUserDAO;
import com.app.bishwas.domain.User;

public class UserDAOImpl implements IUserDAO {
	
	private static final Logger Logger = LoggerFactory.getLogger(UserDAOImpl.class);
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addUser(User u) {
		// TODO Auto-generated method stub
		Session session= this.sessionFactory.getCurrentSession();
		session.save(u);
		Logger.info("User saved successfully, User Details:" + u);

	}

	@Override
	public void updateUser(User u) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.update(u);
		Logger.info("User updated successfully, User Details:" + u);
	}

	@Override
	public void removeUser(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		User u= (User) session.load(User.class, new Integer(id));
		if(u!= null)
			session.delete(u);
		Logger.info("User removed successfully, User Details:" + u);

	}

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		User u= (User) session.load(User.class, new Integer(id));
		Logger.info("User loaded successfully, User Details:" + u);
		return u;
		
	}

	@Override
	public List<User> findAllUser() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<User> users =session.createQuery("From User").list();
		for(User u :users){
			Logger.info("Users list:" + u);	
		}
		return users;
	}

}
