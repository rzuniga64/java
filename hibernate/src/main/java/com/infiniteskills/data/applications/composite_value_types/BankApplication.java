package com.infiniteskills.data.applications.composite_value_types;

import java.util.Date;

import com.infiniteskills.data.utilities.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.infiniteskills.data.entities.composite_value_types.Bank;

public class BankApplication {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		try {
			Transaction transaction = session.beginTransaction();
			
			Bank bank = new Bank();
			bank.setName("Federal Trust");
			bank.setAddressLine1("33 Wall Street");
			bank.setAddressLine2("Suite 233");
			bank.setCity("New York");
			bank.setState("NY");
			bank.setZipCode("12345");
			bank.setInternational(false);
			bank.setCreatedBy("Kevin");
			bank.setCreatedDate(new Date());
			bank.setLastUpdatedBy("Kevin");
			bank.setLastUpdatedDate(new Date());
			bank.getContacts().add("Joe");
			bank.getContacts().add("Mary");
			session.save(bank);
			
			transaction.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			HibernateUtil.getSessionFactory().close();
		}
	}
	
}
