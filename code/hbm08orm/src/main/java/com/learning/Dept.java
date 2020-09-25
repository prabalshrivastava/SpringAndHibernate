package com.learning;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.*;

@Entity
@Table
@ToString
@NoArgsConstructor
public class Dept {
    @Id
    private int deptno;
    private String dname;
    private String loc;
    @OneToMany(mappedBy = "deptno"
            , fetch = FetchType.EAGER       //by default lazy
//            , cascade = CascadeType.PERSIST     //insert into the DB automatically the data of the employees will be persisted
            , cascade = CascadeType.REFRESH     //insert into the DB automatically the data of the employees will be persisted
    )
    private List<Emp> empList;

    public Dept(int deptno, String dname, String loc) {
        this.deptno = deptno;
        this.dname = dname;
        this.loc = loc;
        this.empList = new ArrayList<Emp>();
    }

    public void addEmp(Emp emp){
        empList.add(emp);
    }

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public List<Emp> getEmpList() {
        return empList;
    }

    public void setEmpList(List<Emp> empList) {
        this.empList = empList;
    }
}