package com.infiniteskills.data.applications._11_criteria_api;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.infiniteskills.data.entities._07_hibernate_api.TransactionHibernateAPI;

public class AppJPASimpleSelections {

	public static void main(String[] args) {

		EntityManagerFactory factory = null;
		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			factory = Persistence.createEntityManagerFactory("infinite-finances");
			em = factory.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			
			//select t from transaction t
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<TransactionHibernateAPI> criteriaQuery = cb.createQuery(TransactionHibernateAPI.class);

			// A Root is a means of qualifying access to attributes. The root must be added to criteria query.
			// The root is saying when a query is executedand you want to access a property (title on transaction)
            // it can be done with root.get("title").
			Root<TransactionHibernateAPI> root = criteriaQuery.from(TransactionHibernateAPI.class);
            // Select all of the fields on the transaction.
			criteriaQuery.select(root);
			
			TypedQuery<TransactionHibernateAPI> query = em.createQuery(criteriaQuery);
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
