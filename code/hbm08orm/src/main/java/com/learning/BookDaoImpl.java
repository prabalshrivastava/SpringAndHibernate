package com.learning;

import org.hibernate.Session;
import org.hibernate.jdbc.ReturningWork;
import org.hibernate.procedure.ProcedureCall;

import javax.persistence.ParameterMode;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class BookDaoImpl implements AutoCloseable {
    private Session session;

    public void open() {
        session = HbUtil.getCurrentSession();
    }

    public void close() {
        // session will be closed automatically
    }

    public Book findById(int id) {
        Book cust = session.get(Book.class, id);
        return cust;
    }

    public void addBook(Book b) {
        session.save(b);
    }

    public void updateBook(Book b) {
        session.update(b);
    }

    public void deleteById(int id) {
        Book b = session.get(Book.class, id);
        if (b != null)
            session.delete(b);
    }

    public double getPriceOfBook(int id) {
        Session session = HbUtil.getCurrentSession();
        double price = session.doReturningWork(new ReturningWork<Double>() {
            @Override
            public Double execute(Connection con) throws SQLException {
                // JDBC code to execute stored procedure
                double price = 0.0;
                try (CallableStatement stmt = con.prepareCall("CALL sp_get_book_price(?,?)")) {
                    stmt.setInt(1, id);
                    stmt.registerOutParameter(2, Types.DOUBLE);
                    stmt.execute();
                    price = stmt.getDouble(2);
                }
                return price;
            }
        });
        return price;
    }

    public double getPriceOfBookUsingStoredProcedureCall(int id) {
        Session session = HbUtil.getCurrentSession();
        ProcedureCall procedureCall = session.createStoredProcedureCall("sp_get_book_price");
        procedureCall.registerStoredProcedureParameter("p_id", Integer.class, ParameterMode.IN);
        procedureCall.registerStoredProcedureParameter("p_price", Double.class, ParameterMode.OUT);
        procedureCall.setParameter("p_id", id);
        procedureCall.execute();
        return (Double) procedureCall.getOutputParameterValue("p_price");
    }


    public double getPriceOfBookUsingNamedStoredProcedureCall(int id) {
        Session session = HbUtil.getCurrentSession();
        ProcedureCall procedureCall = session.getNamedProcedureCall("spBooksInRange");
        procedureCall.registerStoredProcedureParameter("p_id", Integer.class, ParameterMode.IN);
        procedureCall.registerStoredProcedureParameter("p_price", Double.class, ParameterMode.OUT);
        procedureCall.setParameter("p_id", id);
        procedureCall.execute();
        return (Double) procedureCall.getOutputParameterValue("p_price");
    }
}
