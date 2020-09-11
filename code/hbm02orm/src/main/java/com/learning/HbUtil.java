package com.learning;

import lombok.Data;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class HbUtil {
    private final static SessionFactory factory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration cfg = new Configuration();
            cfg.configure();
            return cfg.buildSessionFactory();
        } catch (HibernateException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }

    public static SessionFactory getSessionFactory() {
        return factory;
    }

    public static Session getCurrentSession() {
        return factory.getCurrentSession();
    }

    public static void beginTransaction() {
        Session session = factory.getCurrentSession();
        Transaction tx = session.getTransaction();
        tx.begin();
    }

    public static void commitTransaction() {
        Session session = factory.getCurrentSession();
        Transaction tx = session.getTransaction();
        tx.commit();
    }

    public static void rollbackTransaction() {
        Session session = factory.getCurrentSession();
        Transaction tx = session.getTransaction();
        tx.rollback();
    }

    public static void shutdown() {
        factory.close();
    }
}


