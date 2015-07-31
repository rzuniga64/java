package com.infiniteskills.data.applications._10_hql_and_jpql;

import com.infiniteskills.data.entities._09_advanced_mappings_and_configuration.TransactionEnumeratedTypes;
import com.infiniteskills.data.utilities.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class AppHQLExpressionsAndOperatorss {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        SessionFactory factory = null;
        Session session = null;
        org.hibernate.Transaction tx = null;

        try {
            factory = HibernateUtil.getSessionFactory();
            session = factory.openSession();
            tx = session.beginTransaction();

            // Expressions and operators allow add more logic to queries.
            Query query = session.createQuery("select t from TransactionEnumeratedTypes t "
                    + "where t.amount > 75 and t.transactionType = 'Withdrawl'");

            List<TransactionEnumeratedTypes> transactions = query.list();

            for (TransactionEnumeratedTypes transaction : transactions) {
                System.out.println(transaction.getTitle());
            }

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            session.close();
            factory.close();
        }
    }
}
