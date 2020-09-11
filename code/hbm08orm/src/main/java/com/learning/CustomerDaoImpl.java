package com.learning;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

public class CustomerDaoImpl implements AutoCloseable {
    private Session session;

    public void open() {
        session = HbUtil.getSessionFactory().openSession();
    }

    public void close() {
        if (session != null)
            session.close();
    }

    public Customer findByEmail(String email) {
        Criteria cr = session.createCriteria(Customer.class);
        cr.add(Restrictions.eq("email", email));
        return (Customer) cr.uniqueResult();
    }


//    public Customer findByAuthorAndSubjct(String author,String subject) {
//        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class);
//        detachedCriteria.
//        cr.add(Restrictions.eq("email", email));
//        return (Customer) cr.uniqueResult();
//    }

}
