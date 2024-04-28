package com.mudit.zeepham.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.mudit.zeepham.entity.User;


@Repository
public class UserRepo {
    @Autowired
    private SessionFactory sessionFactory;

    public boolean registerUser(User user){
        Transaction tx=null;
        try (Session session=sessionFactory.openSession()) {
            tx=session.beginTransaction();
            session.save(user);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
