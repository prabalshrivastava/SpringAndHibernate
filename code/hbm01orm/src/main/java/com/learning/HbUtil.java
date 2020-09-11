package com.learning;

import lombok.Data;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
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

    public static void shutdown() {
        factory.close();
    }
}
