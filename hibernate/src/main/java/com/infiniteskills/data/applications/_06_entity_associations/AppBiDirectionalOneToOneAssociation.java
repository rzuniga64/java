package com.infiniteskills.data.applications._06_entity_associations;

import com.infiniteskills.data.entities._06_entity_associations.CredentialBiDirectionalOneToOne;
import com.infiniteskills.data.entities._06_entity_associations.UserBidirectionalOneToOne;
import com.infiniteskills.data.utilities.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;

public class AppBiDirectionalOneToOneAssociation {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		try {
			Transaction transaction = session.beginTransaction();
			
			UserBidirectionalOneToOne user = new UserBidirectionalOneToOne();
			user.setFirstName("Kevin");
			user.setLastName("Bowersox");
			user.setAge(20);
			user.setBirthDate(new Date());
			user.setCreatedBy("Kevin Bowersox");
			user.setCreatedDate(new Date());
			user.setEmailAddress("kevin.bowersox@navy.mil");
			user.setLastUpdatedDate(new Date());
			user.setLastUpdatedBy("Kevin Bowersox");

			CredentialBiDirectionalOneToOne credential = new CredentialBiDirectionalOneToOne();
			credential.setPassword("kevinspassword");
			credential.setUsername("kmb385");

			/** Now we have a bidirectional relationship so we need to manage both sides of the relationship.
			 * 	We set the userHibernateAPI field on the credential and set the credential field on the userHibernateAPI. */
			credential.setUser(user);
            user.setCredential(credential);

			session.save(credential);
			transaction.commit();

            /** To prove that bidirectional relationship is working we are going to pull a userHibernateAPI from the database and
             *  grab the userHibernateAPI from the credential that we are persisting and then get the userid.  We are demonstrating
             *  that we are grabbing the userHibernateAPI and proving that we are able to access that other side of the
             *  relationship. So we can access the source entity from the target and print some information out.
             */
			UserBidirectionalOneToOne dbUser = (UserBidirectionalOneToOne)
					session.get(UserBidirectionalOneToOne.class, credential.getUser().getUserId());
			System.out.println(dbUser.getFirstName());
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			HibernateUtil.getSessionFactory().close();
		}
	}

	
}
