package com.infiniteskills.data.applications.entity_associations;

import java.util.Date;

import com.infiniteskills.data.entities.entity_associations.User3;
import com.infiniteskills.data.utilities.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.infiniteskills.data.entities.entity_associations.Credential;

public class AppOneToOneAssociation {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		try {
			Transaction transaction = session.beginTransaction();
			
			User3 user3 = new User3();
			user3.setFirstName("Kevin");
			user3.setLastName("Bowersox");
			user3.setAge(20);
			user3.setBirthDate(new Date());
			user3.setCreatedBy("Kevin Bowersox");
			user3.setCreatedDate(new Date());
			user3.setEmailAddress("kevin.bowersox@navy.mil");
			user3.setLastUpdatedDate(new Date());
			user3.setLastUpdatedBy("Kevin Bowersox");

			Credential credential = new Credential();
			credential.setPassword("kevinspassword");
			credential.setUsername("kmb385");
			
			credential.setUser3(user3);
			/** Only persist the credential. Because we have @OneToOne(cascade=CascadeType.ALL) in Credential class
			 *  both credential and user3 will both be persisted. */
			user3.setCredential(credential);
			
			session.save(credential);
			transaction.commit();
			
			User3 dbUser3 = (User3) session.get(User3.class, credential.getUser3().getUserId());
			System.out.println(dbUser3.getFirstName());
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			HibernateUtil.getSessionFactory().close();
		}
	}

	
}
