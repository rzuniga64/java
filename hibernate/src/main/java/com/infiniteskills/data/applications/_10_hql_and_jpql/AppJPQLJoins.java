package com.infiniteskills.data.applications._10_hql_and_jpql;

import com.infiniteskills.data.entities._07_hibernate_api.AccountHibernateAPI;
import com.infiniteskills.data.entities._09_advanced_mappings_and_configuration.AccountEnumeratedTypes;
import com.infiniteskills.data.entities._09_advanced_mappings_and_configuration.TransactionEnumeratedTypes;
import org.hibernate.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;


public class AppJPQLJoins {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		EntityManagerFactory factory = null;
		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			factory = Persistence.createEntityManagerFactory("infinite-finances");
			em = factory.createEntityManager();
			tx = em.getTransaction();
			tx.begin();

            // This form of the join is known as the explicit form of the join.
            // This is the preferred method of doing a query.
            TypedQuery<AccountEnumeratedTypes> query = em.createQuery(
                    "select distinct a from TransactionEnumeratedTypes t"
                            + " join t.account a "
                            + "where t.amount > 500 and t.transactionType = 'Deposit'", AccountEnumeratedTypes.class);

			List<AccountEnumeratedTypes> accounts = query.getResultList();

			for (AccountEnumeratedTypes account : accounts)
				System.out.println(account.getName());

			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			em.close();
			factory.close();
		}
	}
}
