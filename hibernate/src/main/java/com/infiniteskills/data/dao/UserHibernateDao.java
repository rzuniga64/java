package com.infiniteskills.data.dao;

import java.util.List;

import com.infiniteskills.data.dao.interfaces.UserDao;
import com.infiniteskills.data.entities._07_hibernate_api.UserHibernateAPI;

public class UserHibernateDao extends AbstractDao<UserHibernateAPI,Long> implements UserDao {

	public List<UserHibernateAPI> findByFirstName(String firstName) {
		//add implementation here...
		return null;
	}

}
