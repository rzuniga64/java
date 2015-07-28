package com.infiniteskills.data.applications._08_jpa_api;

import com.infiniteskills.data.entities._07_hibernate_api.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

public class AppModifyingEntities {

	public static void main(String[] args) {

        EntityManagerFactory factory = null;
        EntityManager em = null;
        EntityTransaction tx = null;

        try{
            // Create an EntityManagerFactory
            factory = Persistence.createEntityManagerFactory("infinite-finances");
            // Create an entity manager which is like a session
            em = factory.createEntityManager();

            tx =  em.getTransaction();

            tx.begin();

			// Return an entity from the database. We are executing a SELECT against the database and having that
			// result set turned into either a list of entities or a single entity.
			BankHibernateAPI bank = em.getReference(BankHibernateAPI.class, 1L);
			System.out.println(em.contains(bank));

            // The entity is dirty so when we commit our transaction Hibernate will synch our entity model with the
            // database.
            bank.setName("Another Demonstration");

            // Cause the persistence manager to flush all of the changes to the database and it will synchronize
            // our entity model and our database.
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }finally {
            em.close();
            factory.close();
        }
	}

	private static BankHibernateAPI createBank() {
		BankHibernateAPI bankHibernateAPI = new BankHibernateAPI();
		bankHibernateAPI.setName("First United Federal");
		bankHibernateAPI.setAddressLine1("103 Washington Plaza");
		bankHibernateAPI.setAddressLine2("Suite 332");
		bankHibernateAPI.setAddressType("PRIMARY");
		bankHibernateAPI.setCity("New York");
		bankHibernateAPI.setCreatedBy("Kevin Bowersox");
		bankHibernateAPI.setCreatedDate(new Date());
		bankHibernateAPI.setInternational(false);
		bankHibernateAPI.setLastUpdatedBy("Kevin Bowersox");
		bankHibernateAPI.setLastUpdatedDate(new Date());
		bankHibernateAPI.setState("NY");
		bankHibernateAPI.setZipCode("10000");
		return bankHibernateAPI;
	}

	private static UserHibernateAPI createUser() {
		UserHibernateAPI user = new UserHibernateAPI();
		AddressHibernateAPI address = createAddress();
		user.setAddresses(Arrays.asList(new AddressHibernateAPI[]{createAddress()}));
		user.setBirthDate(new Date());
		user.setCreatedBy("Kevin Bowersox");
		user.setCreatedDate(new Date());
		user.setCredential(createCredential(user));
		user.setEmailAddress("test@test.com");
		user.setFirstName("John");
		user.setLastName("Doe");
		user.setLastUpdatedBy("system");
		user.setLastUpdatedDate(new Date());
		return user;
	}

	private static CredentialHibernateAPI createCredential(UserHibernateAPI user) {
		CredentialHibernateAPI credential = new CredentialHibernateAPI();
		credential.setUser(user);
		credential.setUsername("test_username");
		credential.setPassword("test_password");
		return credential;
	}

	private static AddressHibernateAPI createAddress() {
		AddressHibernateAPI address = new AddressHibernateAPI();
		address.setAddressLine1("101 AddressHibernateAPI Line");
		address.setAddressLine2("102 AddressHibernateAPI Line");
		address.setCity("New York");
		address.setState("PA");
		address.setZipCode("10000");
		address.setAddressType("PRIMARY");
		return address;
	}

	private static TransactionHibernateAPI createNewBeltPurchase(AccountHibernateAPI account) {
		TransactionHibernateAPI beltPurchase = new TransactionHibernateAPI();
		beltPurchase.setAccount(account);
		beltPurchase.setTitle("Dress Belt");
		beltPurchase.setAmount(new BigDecimal("50.00"));
		beltPurchase.setClosingBalance(new BigDecimal("0.00"));
		beltPurchase.setCreatedBy("Kevin Bowersox");
		beltPurchase.setCreatedDate(new Date());
		beltPurchase.setInitialBalance(new BigDecimal("0.00"));
		beltPurchase.setLastUpdatedBy("Kevin Bowersox");
		beltPurchase.setLastUpdatedDate(new Date());
		beltPurchase.setNotes("New Dress Belt");
		beltPurchase.setTransactionType("Debit");
		return beltPurchase;
	}

	private static TransactionHibernateAPI createShoePurchase(AccountHibernateAPI account) {
		TransactionHibernateAPI shoePurchase = new TransactionHibernateAPI();
		shoePurchase.setAccount(account);
		shoePurchase.setTitle("Work Shoes");
		shoePurchase.setAmount(new BigDecimal("100.00"));
		shoePurchase.setClosingBalance(new BigDecimal("0.00"));
		shoePurchase.setCreatedBy("Kevin Bowersox");
		shoePurchase.setCreatedDate(new Date());
		shoePurchase.setInitialBalance(new BigDecimal("0.00"));
		shoePurchase.setLastUpdatedBy("Kevin Bowersox");
		shoePurchase.setLastUpdatedDate(new Date());
		shoePurchase.setNotes("Nice Pair of Shoes");
		shoePurchase.setTransactionType("Debit");
		return shoePurchase;
	}

	private static AccountHibernateAPI createNewAccount() {
		AccountHibernateAPI accountHibernateAPI = new AccountHibernateAPI();
		accountHibernateAPI.setCloseDate(new Date());
		accountHibernateAPI.setOpenDate(new Date());
		accountHibernateAPI.setCreatedBy("Kevin Bowersox");
		accountHibernateAPI.setInitialBalance(new BigDecimal("50.00"));
		accountHibernateAPI.setName("Savings AccountHibernateAPI");
		accountHibernateAPI.setCurrentBalance(new BigDecimal("100.00"));
		accountHibernateAPI.setLastUpdatedBy("Kevin Bowersox");
		accountHibernateAPI.setLastUpdatedDate(new Date());
		accountHibernateAPI.setCreatedDate(new Date());
		return accountHibernateAPI;
	}
}
