package com.infiniteskills.data.applications._07_hibernate_api;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

import com.infiniteskills.data.entities._07_hibernate_api.*;
import com.infiniteskills.data.utilities.HibernateUtil;
import org.hibernate.Session;

public class ApplicationSaveOrUpdate {

	public static void main(String[] args) {
		try {
			// Open Persistence Context 1
			Session session = HibernateUtil.getSessionFactory().openSession();
			org.hibernate.Transaction transaction = session.beginTransaction();
			// Put the entity in the persistence context
			BankHibernateAPI detachedBank = (BankHibernateAPI) session.get(BankHibernateAPI.class, 1L);
			// Persist the entity to the database
			transaction.commit();
			// Close Persistence Context 1. This bank entity's state is detached.
			session.close();

            // Create a new bank entity using new operator and constructor.
            // This bank entity's state is transient.
			BankHibernateAPI transientBank = createBank();

            // Open Persistence Context 2
			Session session2 = HibernateUtil.getSessionFactory().openSession();
			org.hibernate.Transaction transaction2 = session2.beginTransaction();

            // saveOrUpdate is flexible method that handles both detached and transient entity states.
            // Hibernate looks at the identifier property for the entity and using the presence or lack
            // of identifier the API is smart enough to route the method invocation to the appropriate
            // method saveOrUpdate.
			session2.saveOrUpdate(transientBank);
			session2.saveOrUpdate(detachedBank);
			detachedBank.setName("Test Bank 2");
            // Persist the entity to the database
			transaction2.commit();
            // Close Persistence Context 2.
			session2.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			HibernateUtil.getSessionFactory().close();
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