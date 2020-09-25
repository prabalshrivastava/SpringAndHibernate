package com.learning;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
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

    public Emp(int empno, String ename, double sal) {
        this.empno = empno;
        this.ename = ename;
        this.sal = sal;
    }

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Integer getMgr() {
        return mgr;
    }

    public void setMgr(Integer mgr) {
        this.mgr = mgr;
    }

    public Date getHire() {
        return hire;
    }

    public void setHire(Date hire) {
        this.hire = hire;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public Double getComm() {
        return comm;
    }

    public void setComm(Double comm) {
        this.comm = comm;
    }

    public Dept getDeptno() {
        return deptno;
    }

    public void setDeptno(Dept deptno) {
        this.deptno = deptno;
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
                ", meeting=" + meetingList +
                '}';
    }
}