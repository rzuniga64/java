package com.infiniteskills.data.applications;

import com.infiniteskills.data.utilities.HibernateUtil_UseXML;
import org.hibernate.Session;

public class App_HibernateUtilUseXML {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.close();
	}
}