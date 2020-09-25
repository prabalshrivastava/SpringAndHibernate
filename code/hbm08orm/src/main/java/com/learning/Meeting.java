package com.learning;

import lombok.Data;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Data
@Entity
@Table(name = "meeting")
public class Meeting {
    @TableGenerator(name = "gen", table = "empsys_idgen", pkColumnName = "entity", valueColumnName = "id", initialValue = 10, allocationSize = 1)
    @GeneratedValue(generator = "gen", strategy = GenerationType.TABLE)
    @Id
    @Column(name = "id")
    private int meetid;
    @Column
    private String subject;
    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date meetDate;

//    Approach 1
//    @ManyToMany
//    @JoinTable(name = "empmeeting",
//            joinColumns = @JoinColumn(name = "meetingid"),
//            inverseJoinColumns = @JoinColumn(name = "empid")
//    )

    //    Approach 2
    @ManyToMany(mappedBy = "meetingList")
    List<Emp> empList;


    public Meeting() {
    }

    public Meeting(int meetid, String subject, Date meetDate) {
        this.meetid = meetid;
        this.subject = subject;
        this.meetDate = meetDate;
    }

    @Override
    public String toString() {
        return "Meeting [meetid=" + meetid + ", subject=" + subject + ", meetDate=" + meetDate + "]";
    }
}