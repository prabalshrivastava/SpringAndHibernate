package com.learning;

import org.hibernate.Session;

import java.util.List;
import java.util.Set;

import static java.lang.System.*;

public class Hb08Main {
    public static void main(String[] args) {
        try (Session session = HbUtil.getCurrentSession()) {
            HbUtil.beginTransaction();
            //case 1
//            Dept dept = session.get(Dept.class, 10);
//            List<Emp> empList = dept.getEmpList();
//            Emp[] empArray = dept.getEmpArray();
//            Set<Emp> empSet = dept.getEmpSet();
//            out.println(dept);
//            out.println(empList.getClass());
//            out.println(empSet.getClass());
//            out.println(empArray.getClass());

            //case 2
//            Dept dept = new Dept(50, "TRAINING", "PUNE");
//            dept.addEmp(new Emp(1000, "NILESH", 5233, 50));
//            dept.addEmp(new Emp(1001, "AMIT", 4231, 50));
//            dept.addEmp(new Emp(1002, "SANDEEP", 6443, 50));
//            session.persist(dept);
//            HbUtil.commitTransaction();
//            Dept dept = session.find(Dept.class, 10);
            //case 3 Refresh
//            session.refresh(dept);


            out.println(session.find(Emp.class,7900));
//            out.println(session.find(Dept.class,10));

        } catch (Exception e) {
            e.printStackTrace();
            HbUtil.rollbackTransaction();
        }

        HbUtil.shutdown();
    }
}
