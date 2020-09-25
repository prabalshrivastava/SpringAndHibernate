package com.learning;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Data
@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class EmpAddress {
    @Id
    private int empId;
    private String addr;
    private String country;


    //Approach 1
//    @PrimaryKeyJoinColumn
//    @OneToOne

    //Approach 2
    @OneToOne(mappedBy = "empAddress")
    Emp emp;
}
