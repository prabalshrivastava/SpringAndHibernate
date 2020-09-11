package com.learning;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENTS")
public class Student {
    @Embedded
    private StdRoll stdRoll;
    @Column
    private String name;
    @Column
    private double marks;

    public Student() {
        this.stdRoll = new StdRoll();
    }

    public Student(StdRoll stdRoll, String name, double marks) {
        this.stdRoll = stdRoll;
        this.name = name;
        this.marks = marks;
    }

    public StdRoll getStdRoll() {
        return stdRoll;
    }

    public void setStdRoll(StdRoll stdRoll) {
        this.stdRoll = stdRoll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student [stdRoll=" + stdRoll + ", name=" + name + ", marks=" + marks + "]";
    }
}