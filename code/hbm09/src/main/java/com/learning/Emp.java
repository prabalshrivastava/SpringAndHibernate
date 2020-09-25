package com.learning;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table
public class Emp {
    @Id
    int empno;
    String ename;
    String job;
    Integer mgr;
    Date hire;
    double sal;
    Double comm;
    int deptno;
}