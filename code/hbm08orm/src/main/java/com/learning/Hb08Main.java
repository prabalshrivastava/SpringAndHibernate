package com.learning;

import org.hibernate.Session;

import java.util.Date;

public class Hb08Main {
    public static void main(String[] args) {
        try(Session session = HbUtil.getCurrentSession()) {
            HbUtil.beginTransaction();
            Dept dept = session.get(Dept.class, 10);
            System.out.println(dept);
            HbUtil.commitTransaction();
        }
        catch (Exception e) {
            e.printStackTrace();
            HbUtil.rollbackTransaction();
        }

        HbUtil.shutdown();
    }
}
