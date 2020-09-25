package com.learning;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

@Data
@Entity
@Table
public class Dept {
    @Id
    private int deptno;
    private String dname;
    private String loc;
    @OneToMany(mappedBy = "deptno")
    private List<Emp> empList;

    @OneToMany(mappedBy = "deptno")
    private Set<Emp> empSet;

    @OneToMany(mappedBy = "deptno")
    private Map<String, Emp> empMap;

//    @OneToMany(mappedBy = "deptno")
//    private Emp[] empArray;
//    @OneToMany(mappedBy = "deptno")
//    private Queue<Emp> empQueue;


}