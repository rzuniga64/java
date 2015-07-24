package com.infiniteskills.data.applications.entity_associations;

import java.util.Date;

import com.infiniteskills.data.entities.entity_associations.CredentialUniDirectionalOneToOne;
import com.infiniteskills.data.entities.entity_associations.UserUnidirectionalOneToOne;
import com.infiniteskills.data.utilities.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AppUniDirectionalOneToOneAssociation {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		try {
			Transaction transaction = session.beginTransaction();
			
			UserUnidirectionalOneToOne user = new UserUnidirectionalOneToOne();
			user.setFirstName("Kevin");
			user.setLastName("Bowersox");
			user.setAge(20);
			user.setBirthDate(new Date());
			user.setCreatedBy("Kevin Bowersox");
			user.setCreatedDate(new Date());
			user.setEmailAddress("kevin.bowersox@navy.mil");
			user.setLastUpdatedDate(new Date());
			user.setLastUpdatedBy("Kevin Bowersox");

			CredentialUniDirectionalOneToOne credential = new CredentialUniDirectionalOneToOne();
            credential.setPassword("kevinspassword");
            credential.setUsername("kmb385");

            credential.setUser(user);
			/** Only persist the credential. Because we have @OneToOne(cascade=CascadeType.ALL) in Credential class
			 *  both credentialUniDirectionalOneToOne and user will both be persisted. */
			session.save(credential);
			transaction.commit();
			
			UserUnidirectionalOneToOne dbUser = (UserUnidirectionalOneToOne)
					session.get(UserUnidirectionalOneToOne.class, user.getUserId());
			System.out.println(dbUser.getFirstName());
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			HibernateUtil.getSessionFactory().close();
		}
	}

	
}
