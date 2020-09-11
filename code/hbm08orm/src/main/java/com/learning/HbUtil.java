package com.learning;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class HbUtil {
    private final static SessionFactory factory = buildSessionFactory();
    static StandardServiceRegistry standardServiceRegistry;

    private static SessionFactory buildSessionFactory() {
        try {

//            create service registry
            standardServiceRegistry = new StandardServiceRegistryBuilder()
//                    .applySettings()//send multiple settings to a map
                    .applySetting("hibernate.format_sql", true)
                    .configure()
                    .build();

            Metadata metadata = new MetadataSources(standardServiceRegistry)// ORM from hibernate.cfg.xml
                    .addPackage("com.learning")//.addPackage("sh.entities") // all classes in given package with @Entity will be configured
//                    .addAnnotatedClass(Customer.class)//.addAnnotatedClass(Customer.class) // a given class with @Entity is configured.
//                    .addResource("sh/Book.hbm.xml")//.addResource("sh/Book.hbm.xml") // a given ORM XML file is configured
                    .getMetadataBuilder()
                    .build();

            return metadata.buildSessionFactory();
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
        standardServiceRegistry.close();
    }
}