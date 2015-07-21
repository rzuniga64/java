package com.infiniteskills.data.applications;

import com.infiniteskills.data.entities.User2;
import com.infiniteskills.data.utilities.HibernateUtil;
import org.hibernate.Session;

import java.util.Date;

public class AppCallingPersistenceMethods {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();

        User2 user = new User2();
        user.setBirthDate(new Date());
        user.setCreatedDate(new Date());
        user.setCreatedBy("Kevin");
        user.setEmailAddress("kmb385@yahoo.com");
        user.setFirstName("Kevin");
        user.setLastName("Powersox");
        user.setLastUpdatedDate(new Date());
        user.setLastUpdatedBy("Kevin");

        session.save(user);
        session.getTransaction().commit();
        session.close();
    }
}