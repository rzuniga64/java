package com.infiniteskills.data.applications._07_hibernate_api;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

import com.infiniteskills.data.entities._07_hibernate_api.*;
import com.infiniteskills.data.utilities.HibernateUtil;
import org.hibernate.Session;

public class ApplicationFlushPersistenceContext {

	public static void main(String[] args) {
		// Open Persistence Context 1
		Session session = HibernateUtil.getSessionFactory().openSession();
        // When we want to write changes to the database we need a connection. A transaction houses that
        // connection. With a transaction we want to perform all the work as one atomic unit.  If one of the operations
        // fails we need to rollback everything. That's the whole point of a transaction. So every time we are working
        // with a session we are working with a transaction.
		org.hibernate.Transaction transaction = session.beginTransaction();
		try {
			// Put the entity in the persistence context which keeps track of all changes to all entities.
			BankHibernateAPI bank = (BankHibernateAPI) session.get(BankHibernateAPI.class, 1L);
			bank.setName("Something Different");
			System.out.println("Calling Flush");

            // When flush is called we want Hibernate to take all the changes within our persistence context and synch
            // them with the database.
			session.flush();

            // Make a second change to the entity after calling flush.
			bank.setAddressLine1("Another Address Line");
			System.out.println("Calling commit");
			// Persist the entity to the database. When we work with a transaction one of the ways we cause
            // all of the changes to be made on the database is to call the commit method on the transaction.
            // This commit is forcing a flush on the session. There are three times when a flush will be called on a
            // session:
            // 1. Call session.flush()
            // 2. When a commit is called on a transaction.
            // 3. Sometimes when we run a SELECT operation a flush will occur before it.
			transaction.commit();
		} catch (Exception e) {
            // Make sure that if that there are any exceptions then rollback the transaction.
			transaction.rollback();
			e.printStackTrace();
		}finally{
			// Close Persistence Context.
			session.close();
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
