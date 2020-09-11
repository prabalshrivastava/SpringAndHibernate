package com.learning;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

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
}