package com.infiniteskills.data.applications._06_entity_associations;

import java.math.BigDecimal;
import java.util.Date;

import com.infiniteskills.data.entities._06_entity_associations.AccountUniDirectionalOneToMany;
import com.infiniteskills.data.entities._06_entity_associations.TransactionUniDirectionalOneToMany;
import com.infiniteskills.data.utilities.HibernateUtil;
import org.hibernate.Session;

public class ApplicationUniDirectionalOneToMany {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		try {
			org.hibernate.Transaction transaction = session.beginTransaction();
			
			AccountUniDirectionalOneToMany account = createNewAccount();
			account.getTransactions().add(createNewBeltPurchase());
			account.getTransactions().add(createShoePurchase());
			session.save(account);
			
			transaction.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			HibernateUtil.getSessionFactory().close();
		}
	}

	private static TransactionUniDirectionalOneToMany createNewBeltPurchase() {
		TransactionUniDirectionalOneToMany beltPurchase = new TransactionUniDirectionalOneToMany();
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

	private static TransactionUniDirectionalOneToMany createShoePurchase() {
		TransactionUniDirectionalOneToMany shoePurchase = new TransactionUniDirectionalOneToMany();
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

	private static AccountUniDirectionalOneToMany createNewAccount() {
		AccountUniDirectionalOneToMany account = new AccountUniDirectionalOneToMany();
		account.setCloseDate(new Date());
		account.setOpenDate(new Date());
		account.setCreatedBy("Kevin Bowersox");
		account.setInitialBalance(new BigDecimal("50.00"));
		account.setName("Savings AccountHibernateAPI");
		account.setCurrentBalance(new BigDecimal("100.00"));
		account.setLastUpdatedBy("Kevin Bowersox");
		account.setLastUpdatedDate(new Date());
		account.setCreatedDate(new Date());
		return account;
	}
	
}
