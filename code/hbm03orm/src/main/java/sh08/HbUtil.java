package sh08;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class HbUtil {
    private static final SessionFactory factory = buildSessionFactory();

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

    public static void beginTransaction() {
        Session session = factory.getCurrentSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
    }

    public static void commitTransaction() {
        Session session = factory.getCurrentSession();
        Transaction transaction = session.getTransaction();
        transaction.commit();
    }

    public static void rollbackTransaction() {
        Session session = factory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        transaction.rollback();
    }

    public static Session getCurrentSession() {
        return factory.getCurrentSession();
    }

    public static void shutdown() {
        factory.close();
    }
}
