package com.infiniteskills.data.applications._10_hql_and_jpql;

import com.infiniteskills.data.entities._09_advanced_mappings_and_configuration.TransactionEnumeratedTypes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.Query;


public class AppJPQL {

	public static void main(String[] args) {

		EntityManagerFactory factory = null;
		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			factory = Persistence.createEntityManagerFactory("infinite-finances");
			em = factory.createEntityManager();
			tx = em.getTransaction();
			tx.begin();

            //Query query = em.createQuery("from TransactionEnumeratedTypes t order by t.title");

			TypedQuery<TransactionEnumeratedTypes> query = em.createQuery(
					"from TransactionEnumeratedTypes t"
					+ " where (t.amount between 75 and 100) and t.title like '%s'"
					+ " order by t.title", TransactionEnumeratedTypes.class);
			
			List<TransactionEnumeratedTypes> transactions = query.getResultList();

			for (TransactionEnumeratedTypes transaction : transactions) {
				System.out.println(transaction.getTitle());
			}

			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			em.close();
			factory.close();
		}
	}
}
