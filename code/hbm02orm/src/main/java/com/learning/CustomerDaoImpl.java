package com.learning;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class CustomerDaoImpl implements AutoCloseable {
    private Session session;

    public void open() {
        session = HbUtil.getSessionFactory().openSession();
    }

    public void close() {
        if (session != null)
            session.close();
    }

    public Customer findById(Integer id) {
        Customer cust = session.get(Customer.class, id);
        return cust;
    }

    public void addCustomer(Customer customer) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(customer);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }


    public void updateCustomer(Customer customer) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(customer);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }


    public void deleteById(int id) {
        Transaction tx = null;
        try {
            tx = session.beginTransaction(); // JDBC con.setAutoCommit(false);
            Customer cust = session.get(Customer.class, id);
            if(cust != null)
                session.delete(cust);
            tx.commit(); // JDBC con.commit();
        } catch (Exception e) {
            tx.rollback(); // JDBC con.rollback();
        }
    }
}
