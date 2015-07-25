package com.infiniteskills.data.applications.entity_associations;

import java.math.BigDecimal;
import java.util.Date;

import com.infiniteskills.data.entities.entity_associations.AccountBiDirectionalOneToMany;
import com.infiniteskills.data.entities.entity_associations.TransactionBiDirectionalOneToMany;
import com.infiniteskills.data.utilities.HibernateUtil;
import org.hibernate.Session;

public class ApplicationBiDirectionalOneToMany {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		try {
			org.hibernate.Transaction transaction = session.beginTransaction();
			
			AccountBiDirectionalOneToMany account = createNewAccount();
            /** Transactions get set on account and the account gets set on the transaction. An important where
             *  you will hit an exception at leason one time and it can be hard to debug. */
			account.getTransactions().add(createNewBeltPurchase(account));
			account.getTransactions().add(createShoePurchase(account));
			session.save(account);
			
			transaction.commit();
			
			TransactionBiDirectionalOneToMany dbTransaction = (TransactionBiDirectionalOneToMany)session.
					get(TransactionBiDirectionalOneToMany.class, account.getTransactions().get(0).getTransactionId());
			System.out.println(dbTransaction.getAccount().getName());
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			HibernateUtil.getSessionFactory().close();
		}
	}

    /** We need to manage both sides of the relationship. On our transaction we need to set the account. */
	private static TransactionBiDirectionalOneToMany createNewBeltPurchase(AccountBiDirectionalOneToMany account) {
		TransactionBiDirectionalOneToMany beltPurchase = new TransactionBiDirectionalOneToMany();
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

    /** We need to manage both sides of the relationship. On our transaction we need to set the account. */
	private static TransactionBiDirectionalOneToMany createShoePurchase(AccountBiDirectionalOneToMany account) {
		TransactionBiDirectionalOneToMany shoePurchase = new TransactionBiDirectionalOneToMany();
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

	private static AccountBiDirectionalOneToMany createNewAccount() {
		AccountBiDirectionalOneToMany account = new AccountBiDirectionalOneToMany();
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
