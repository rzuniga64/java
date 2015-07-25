package com.infiniteskills.data.applications.entity_associations;

import java.math.BigDecimal;
import java.util.Date;

import com.infiniteskills.data.entities.entity_associations.AccountBiDirectionalOneToMany;
import com.infiniteskills.data.entities.entity_associations.BudgetJoinTable;
import com.infiniteskills.data.entities.entity_associations.TransactionBiDirectionalOneToMany;
import com.infiniteskills.data.utilities.HibernateUtil;
import org.hibernate.Session;

public class ApplicationJoinTable {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		try {
			org.hibernate.Transaction transaction = session.beginTransaction();

			/** Create an account and use that account to create two transactions and we are putting those transactions
			 *  within the transactions composed within the Budget entity. All this should persist. */
			AccountBiDirectionalOneToMany account = createNewAccount();

			BudgetJoinTable budget = new BudgetJoinTable();
			budget.setGoalAmount(new BigDecimal("10000.00"));
			budget.setName("Emergency Fund");
			budget.setPeriod("Yearly");
			
			budget.getTransactions().add(createNewBeltPurchase(account));
			budget.getTransactions().add(createShoePurchase(account));

            session.save(account);
			session.save(budget);
			transaction.commit();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			HibernateUtil.getSessionFactory().close();
		}
	}

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
