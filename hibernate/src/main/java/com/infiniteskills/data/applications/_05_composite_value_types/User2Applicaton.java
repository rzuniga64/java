package com.infiniteskills.data.applications._05_composite_value_types;

import com.infiniteskills.data.entities._05_composite_value_types.Address;
import com.infiniteskills.data.entities._05_composite_value_types.User2;
import com.infiniteskills.data.utilities.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;

public class User2Applicaton {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction transaction = session.beginTransaction();

            User2 user = new User2();
            Address address = new Address();
            user.setAge(22);
            user.setBirthDate(new Date());
            user.setCreatedBy("Kevin");
            user.setCreatedDate(new Date());
            user.setEmailAddress("kmb3@yahoo.com");
            user.setFirstName("kevin");
            user.setLastName("bowersox");
            user.setLastUpdatedBy("kmb");
            user.setLastUpdatedDate(new Date());

            address.setAddressLine1("line 1");
            address.setAddressLine2("line2");
            address.setCity("Philadelphia");
            address.setState("PA");
            address.setZipCode("12345");

            user.setAddress(address);
            session.save(user);

            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            session.close();
            HibernateUtil.getSessionFactory().close();
        }
    }
}