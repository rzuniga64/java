package com.infiniteskills.data.applications.basic_value_types;

import com.infiniteskills.data.utilities.HibernateUtil;
import org.hibernate.Session;

public class AppUsingXML {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.close();
    }
}