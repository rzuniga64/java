package com.infiniteskills.data.applications.entity_associations;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

import com.infiniteskills.data.entities.entity_associations.*;
import com.infiniteskills.data.utilities.HibernateUtil;
import org.hibernate.Session;

public class AppBiDirectionalManyToMany {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		try {
			org.hibernate.Transaction transaction = session.beginTransaction();

			AccountBiDirectionalManyToMany account = createNewAccount();
            AccountBiDirectionalManyToMany account2 = createNewAccount();
			UserBiDirectionalManyToMany user = createUser();
			UserBiDirectionalManyToMany user2 = createUser();
			
			account.getUsers().add(user);
			account.getUsers().add(user2);
			user.getAccounts().add(account);
			user2.getAccounts().add(account);

            /** Establish relationship from Account to User */
			account2.getUsers().add(user);
			account2.getUsers().add(user2);
            /** Establish relationship from User to Account. If not done there will be errors! */
			user.getAccounts().add(account2);
			user2.getAccounts().add(account2);

			session.save(user);
			session.save(user2);
			
			transaction.commit();

            UserBiDirectionalManyToMany dbUser = (UserBiDirectionalManyToMany) session.
					get(UserBiDirectionalManyToMany.class, user.getUserId());
			System.out.println(dbUser.getAccounts().iterator().next().getName());
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			HibernateUtil.getSessionFactory().close();
		}
	}

	private static UserBiDirectionalManyToMany createUser() {
        UserBiDirectionalManyToMany user = new UserBiDirectionalManyToMany();
		Address address = createAddress();
		user.setAddresses(Arrays.asList(new Address[]{createAddress()}));
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

	private static CredentialBiDirectionalManyToMany createCredential(UserBiDirectionalManyToMany user) {
        CredentialBiDirectionalManyToMany credential = new CredentialBiDirectionalManyToMany();
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

	private static TransactionBiDirectionalManyToMany createNewBeltPurchase(AccountBiDirectionalManyToMany account) {
        TransactionBiDirectionalManyToMany beltPurchase = new TransactionBiDirectionalManyToMany();
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

	private static TransactionBiDirectionalManyToMany createShoePurchase(AccountBiDirectionalManyToMany account) {
        TransactionBiDirectionalManyToMany shoePurchase = new TransactionBiDirectionalManyToMany();
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

	private static AccountBiDirectionalManyToMany createNewAccount() {
        AccountBiDirectionalManyToMany account = new AccountBiDirectionalManyToMany();
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
