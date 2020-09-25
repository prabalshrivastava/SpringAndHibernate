package com.learning;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Data
@Table
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Emp {
    @Id
    int empno;
    String ename;
    String job;
    Integer mgr;
    Date hire;
    double sal;
    Double comm;

    @ManyToOne
    @JoinColumn(name = "deptno") //FK column name
            Dept deptno;

    @ManyToMany
    @JoinTable(
            name = "empmeeting",
            joinColumns = {@JoinColumn(name = "empid")},
            inverseJoinColumns = {@JoinColumn(name = "meetingid")}
    )
    List<Meeting> meetingList;


    @OneToOne
    @PrimaryKeyJoinColumn
    EmpAddress empAddress;

    public Emp(int empno, String ename, double sal) {
        this.empno = empno;
        this.ename = ename;
        this.sal = sal;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "empno=" + empno +
                ", ename='" + ename + '\'' +
                ", job='" + job + '\'' +
                ", mgr=" + mgr +
                ", hire=" + hire +
                ", sal=" + sal +
                ", comm=" + comm +
                ", deptname=" + deptno.getDname() +
                ", deptno=" + deptno.getDeptno() +
                ", meetingList=" + meetingList +
                ", EmpAddress{" +
                "empId=" + empAddress.getEmpId() +
                ", addr='" + empAddress.getAddr() + '\'' +
                ", country='" + empAddress.getCountry() + '\'' +
                '}';
    }
}