package com.infiniteskills.data.applications.entity_associations;

import java.util.Date;

import com.infiniteskills.data.entities.entity_associations.UserUnidirectionalOneToOne;
import com.infiniteskills.data.utilities.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.infiniteskills.data.entities.entity_associations.Credential;

public class AppOneToOneAssociation {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		try {
			Transaction transaction = session.beginTransaction();
			
			UserUnidirectionalOneToOne userUnidirectionalOneToOne = new UserUnidirectionalOneToOne();
			userUnidirectionalOneToOne.setFirstName("Kevin");
			userUnidirectionalOneToOne.setLastName("Bowersox");
			userUnidirectionalOneToOne.setAge(20);
			userUnidirectionalOneToOne.setBirthDate(new Date());
			userUnidirectionalOneToOne.setCreatedBy("Kevin Bowersox");
			userUnidirectionalOneToOne.setCreatedDate(new Date());
			userUnidirectionalOneToOne.setEmailAddress("kevin.bowersox@navy.mil");
			userUnidirectionalOneToOne.setLastUpdatedDate(new Date());
			userUnidirectionalOneToOne.setLastUpdatedBy("Kevin Bowersox");

			Credential credential = new Credential();
			credential.setPassword("kevinspassword");
			credential.setUsername("kmb385");
			
			credential.setUserUnidirectionalOneToOne(userUnidirectionalOneToOne);
			/** Only persist the credential. Because we have @OneToOne(cascade=CascadeType.ALL) in Credential class
			 *  both credential and user will both be persisted. */
			userUnidirectionalOneToOne.setCredential(credential);
			
			session.save(credential);
			transaction.commit();
			
			UserUnidirectionalOneToOne dbUserUnidirectionalOneToOne = (UserUnidirectionalOneToOne) session.get(UserUnidirectionalOneToOne.class, credential.getUserUnidirectionalOneToOne().getUserId());
			System.out.println(dbUserUnidirectionalOneToOne.getFirstName());
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			HibernateUtil.getSessionFactory().close();
		}
	}

	
}
