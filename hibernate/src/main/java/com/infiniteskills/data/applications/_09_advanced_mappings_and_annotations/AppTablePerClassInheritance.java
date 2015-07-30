package com.infiniteskills.data.applications._09_advanced_mappings_and_annotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

import com.infiniteskills.data.entities._07_hibernate_api.AddressHibernateAPI;
import com.infiniteskills.data.entities._07_hibernate_api.BankHibernateAPI;
import com.infiniteskills.data.entities._07_hibernate_api.CredentialHibernateAPI;
import com.infiniteskills.data.entities._07_hibernate_api.UserHibernateAPI;
import com.infiniteskills.data.entities._09_advanced_mappings_and_configuration.PortfolioTablePerClassInheritance;
import com.infiniteskills.data.entities._09_advanced_mappings_and_configuration.InvestmentTablePerClassInheritance;
import com.infiniteskills.data.entities._09_advanced_mappings_and_configuration.StockTablePerClassInheritance;
import com.infiniteskills.data.entities._09_advanced_mappings_and_configuration.BondTablePerClassInheritance;
import com.infiniteskills.data.entities._09_advanced_mappings_and_configuration.TransactionEnumeratedTypes;
import com.infiniteskills.data.entities._09_advanced_mappings_and_configuration.AccountEnumeratedTypes;
import com.infiniteskills.data.utilities.HibernateUtil;

public class AppTablePerClassInheritance {

	public static void main(String[] args) {

        SessionFactory sessionFactory = null;
        Session session = null;
        org.hibernate.Transaction tx = null;

        try{
            // Create an SessionFactory
            sessionFactory = HibernateUtil.getSessionFactory();
            // Create a session, open Persistence Context 1
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            PortfolioTablePerClassInheritance portfolio = new PortfolioTablePerClassInheritance();
            portfolio.setName("First Investments");

            // create transient stock entity
            StockTablePerClassInheritance stock = createStock();
            // set portfolio on stock entity
            stock.setPortfolio(portfolio);
//            session.save(stock);

            // create transient bond entity
            BondTablePerClassInheritance bond = createBond();
            // set portfolio on bond entity
            bond.setPortfolio(portfolio);
//            session.save(bond);

            // now we manage both sides of the relationship by adding the stock and bond to the collection of
            // investments on the portfolio.
            portfolio.getInvestements().add(stock);
            portfolio.getInvestements().add(bond);

            // make stock and bond entity persistent, we will allow them to persist the portfolio through the cascade.
            session.save(portfolio);

            // Persist the entities to the database
            tx.commit();

            PortfolioTablePerClassInheritance dbPortfolio = (PortfolioTablePerClassInheritance) session.
                    get(PortfolioTablePerClassInheritance.class, portfolio.getPortfolioId());
            session.refresh(dbPortfolio);

//            for (InvestmentTablePerClassInheritance investment:dbPortfolio.getInvestements())
//                System.out.println(investment.getName());

        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }finally {
            // Close Persistent Context 1
            session.close();
            sessionFactory.close();
        }
	}

    private static BondTablePerClassInheritance createBond() {
		BondTablePerClassInheritance bond = new BondTablePerClassInheritance();
        bond.setInterestRate(new BigDecimal("123.22"));
        bond.setIssuer("JP Morgan Chase");
        bond.setMaturityDate(new Date());
        bond.setPurchaseDate(new Date());
        bond.setName("Long Term Bond Purchases");
        bond.setValue(new BigDecimal("10.22"));
        return bond;
    }

    private static StockTablePerClassInheritance createStock(){
		StockTablePerClassInheritance stock = new StockTablePerClassInheritance();
        stock.setIssuer("Allen Edmonds");
        stock.setName("Private American Stock Purchases");
        stock.setPurchaseDate(new Date());
        stock.setQuantity(new BigDecimal("1922"));
        stock.setSharePrice(new BigDecimal("100.00"));
        return stock;
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

	private static TransactionEnumeratedTypes createNewBeltPurchase(AccountEnumeratedTypes account) {
        TransactionEnumeratedTypes beltPurchase = new TransactionEnumeratedTypes();
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

	private static TransactionEnumeratedTypes createShoePurchase(AccountEnumeratedTypes account) {
        TransactionEnumeratedTypes shoePurchase = new TransactionEnumeratedTypes();
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

	private static AccountEnumeratedTypes createNewAccount() {
		AccountEnumeratedTypes accountHibernateAPI = new AccountEnumeratedTypes();
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
