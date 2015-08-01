package com.infiniteskills.data.applications._11_criteria_api;

import com.infiniteskills.data.entities._07_hibernate_api.TransactionHibernateAPI;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class AppJPAPaging {

	public static void main(String[] args) {

		EntityManagerFactory factory = null;
		EntityManager em = null;
		EntityTransaction tx = null;
		int pageNumber = 1;
		int pageSize = 5;

		try {
			factory = Persistence.createEntityManagerFactory("infinite-finances");
			em = factory.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			
			//select t from transaction t
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<TransactionHibernateAPI> criteriaQuery = cb.createQuery(TransactionHibernateAPI.class);

			Root<TransactionHibernateAPI> root = criteriaQuery.from(TransactionHibernateAPI.class);
            // Select all of the fields on the transaction.
			criteriaQuery.select(root);
			
			TypedQuery<TransactionHibernateAPI> query = em.createQuery(criteriaQuery);
			query.setFirstResult((pageNumber - 1) * pageSize );
            query.setMaxResults(pageSize);

			List<TransactionHibernateAPI> transactions = query.getResultList();

			for (TransactionHibernateAPI t : transactions) {
				System.out.println(t.getTitle());
			}

			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
			factory.close();
		}
	}
}
