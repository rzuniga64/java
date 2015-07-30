package com.infiniteskills.data.dao.interfaces;

import java.util.List;

import com.infiniteskills.data.entities._07_hibernate_api.UserHibernateAPI;

public interface UserDao extends Dao<UserHibernateAPI,Long>{

	public List<UserHibernateAPI> findByFirstName(String firstName);
}
