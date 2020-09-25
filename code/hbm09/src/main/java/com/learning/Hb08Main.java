package com.learning;

import org.hibernate.Session;

import java.util.List;
import java.util.Set;

import static java.lang.System.*;

public class Hb08Main {
    public static void main(String[] args) {
        try(Session session = HbUtil.getCurrentSession()) {
            HbUtil.beginTransaction();
            Dept dept = new Dept();
            HbUtil.commitTransaction();
        }
        catch (Exception e) {
            e.printStackTrace();
            HbUtil.rollbackTransaction();
        }
        HbUtil.shutdown();
    }
}
