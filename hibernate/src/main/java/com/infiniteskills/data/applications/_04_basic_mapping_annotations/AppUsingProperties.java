package com.infiniteskills.data.applications._04_basic_mapping_annotations;

import com.infiniteskills.data.utilities.HibernateUtilProperties;
import org.hibernate.Session;

public class AppUsingProperties {

	public static void main(String[] args) {
		
		Session session = HibernateUtilProperties.getSessionFactory().openSession();
		session.beginTransaction();
		session.close();
	}
}
