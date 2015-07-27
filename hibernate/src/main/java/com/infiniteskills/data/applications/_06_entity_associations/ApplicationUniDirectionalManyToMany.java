package com.infiniteskills.data.applications._06_entity_associations;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

import com.infiniteskills.data.entities._06_entity_associations.*;
import com.infiniteskills.data.utilities.HibernateUtil;
import org.hibernate.Session;

public class ApplicationUniDirectionalManyToMany {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		try {
			org.hibernate.Transaction transaction = session.beginTransaction();
			
			AccountUniDirectionalManyToMany account = createNewAccount();
			AccountUniDirectionalManyToMany account2 = createNewAccount();
			UserBidirectionalOneToOne user = createUser();
			UserBidirectionalOneToOne user2 = createUser();

			account.getUsers().add(user);
			account.getUsers().add(user2);
			account2.getUsers().add(user);
			account2.getUsers().add(user2);
			
			session.save(account);
			session.save(account2);
			
			transaction.commit();
			
			AccountUniDirectionalManyToMany dbAccount = (AccountUniDirectionalManyToMany) session.
					get(AccountUniDirectionalManyToMany.class, account.getAccountId());
			System.out.println(dbAccount.getUsers().iterator().next().getEmailAddress());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			HibernateUtil.getSessionFactory().close();
		}
	}

	private static UserBidirectionalOneToOne createUser() {
        UserBidirectionalOneToOne user = new UserBidirectionalOneToOne();
		Address address = createAddress();
		user.setAddress(Arrays.asList(new Address[]{createAddress()}));
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

	private static CredentialBiDirectionalOneToOne createCredential(UserBidirectionalOneToOne user) {
		CredentialBiDirectionalOneToOne credential = new CredentialBiDirectionalOneToOne();
		credential.setUser(user);
		credential.setUsername("test_username");
		credential.setPassword("test_password");
		return credential;
	}

	private static Address createAddress() {
		Address address = new Address();
		address.setAddressLine1("101 Address Line");
		address.setAddressLine2("102 Address Line");
		address.setCity("New York");
		address.setState("PA");
		address.setZipCode("10000");
		return address;
	}

	private static TransactionUniDirectionalManyToMany createNewBeltPurchase(AccountUniDirectionalManyToMany account) {
        TransactionUniDirectionalManyToMany beltPurchase = new TransactionUniDirectionalManyToMany();
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

	private static TransactionUniDirectionalManyToMany createShoePurchase(AccountUniDirectionalManyToMany account) {
        TransactionUniDirectionalManyToMany shoePurchase = new TransactionUniDirectionalManyToMany();
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

	private static AccountUniDirectionalManyToMany createNewAccount() {
		AccountUniDirectionalManyToMany account = new AccountUniDirectionalManyToMany();
		account.setCloseDate(new Date());
		account.setOpenDate(new Date());
		account.setCreatedBy("Kevin Bowersox");
		account.setInitialBalance(new BigDecimal("50.00"));
		account.setName("Savings Account");
		account.setCurrentBalance(new BigDecimal("100.00"));
		account.setLastUpdatedBy("Kevin Bowersox");
		account.setLastUpdatedDate(new Date());
		account.setCreatedDate(new Date());
		return account;
	}
	
}
