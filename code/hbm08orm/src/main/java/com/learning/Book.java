package com.learning;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Cache;
import javax.persistence.Entity;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@NamedQueries(
        {

                @NamedQuery(
                        name = "bookSummary",
                        query = "select new Book(b.id,b.name,b.author) from Book b where b.subject=?1"
                ),
                @NamedQuery(
                        name = "bookSummary1",
                        query = "select new Book(b.id,b.name,b.author) from Book b where b.subject=:p_subject"
                )
        }
)
@NamedNativeQueries(
        {
                @NamedNativeQuery(
                        name = "myStoredProcedureCall",
                        query = "call sp_books_in_range(:pmin,:pmax)",
                        hints = {
                                @QueryHint(name = "org.hibernate.CallableStatement", value = "true")
                        },
                        resultClass = Book.class
                )
        }
)
@NamedStoredProcedureQueries(
        {
                @NamedStoredProcedureQuery(
                        name = "spBooksInRange", procedureName = "sp_get_book_price"
                )
        }
)
@FilterDef(
        name = "bookFilter",
        parameters = {
                @ParamDef(name = "minPrice", type = "double"),
                @ParamDef(name = "maxPrice", type = "double"),
                @ParamDef(name = "subjectVal", type = "string")
        }
)
@Filters({
        @Filter(name = "bookFilter", condition = "price >= :minPrice and price <= :maxPrice"),
        @Filter(name = "bookFilter", condition = "subject = :subjectVal")
})
@Entity
@Table(name = "books")
public class Book {
    @Id
    @Column(name = "id")
    private int id;
    @Column
    private String name;
    @Column
    private String author;
    @Column
    private String subject;
    @Column
    private double price;

    public Book() {

    }

    public Book(int id, String name, String author, String subject, double price) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.subject = subject;
        this.price = price;
    }

    public Book(int id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", name=" + name + ", author=" + author + ", subject=" + subject + ", price=" + price
                + "]";
    }
}