package com.learning;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customers") //(name = "customers") if the name of the class is same as table.
public class Customer {

    @Id
    @Column(name = "id")
    private Integer custId;

    // because the name of the column is not given using (name = "name") the field name is automatically considered as column name
    @Column
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;

//    @Basic//By default hibernate maps the Date in DB to java.sql.Date @Basic Tells the same.
    //Temporal is used to map the DB Date type to the java Date type and we can explicitly mention the date type to be used in java
    @Temporal(TemporalType.DATE)
    @Column(name = "birth")
    private Date birth;//By default hibernate maps the Date in DB to java.sql.Date

    @Transient //indicates that this field is not mapped to DB and hence hibernate should ignore it.
    private int age;



}
