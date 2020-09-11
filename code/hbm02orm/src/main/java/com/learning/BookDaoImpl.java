package com.learning;

import org.hibernate.Session;

import java.awt.print.Book;

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
		if(b != null) 
			session.delete(b);
	}
}
