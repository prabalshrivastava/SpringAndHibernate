package com.learning;

import org.hibernate.Session;

import java.util.Date;

public class Hb05Main {
    public static void main(String[] args) {
//        try (CustomerDaoImpl customerDao = new CustomerDaoImpl()) {
//            customerDao.open();
//            HbUtil.beginTransaction();
////            Customer customer = customerDao.findById(2);
////            customerDao.addCustomer(new Customer(6,"vishal","pune","vishal","1234568798","vishal@gamil.com",new Date(),100));
////            customerDao.updateCustomer(new Customer(6,"prabal","pune","vishal","1234568798","vishal@gamil.com",new Date(),100));
////            System.out.println("Found " + customer);
//            Customer customer = customerDao.findByEmail("vishal@gamil.com");
//            System.out.println("found : " + customer);
//            HbUtil.commitTransaction();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        HbUtil.shutdown();



        try(Session session = HbUtil.getCurrentSession()) {
            HbUtil.beginTransaction();
            Student stud = session.find(Student.class, new StdRoll(2, 1));
            System.out.println(stud);
            HbUtil.commitTransaction();
        }
        catch (Exception e) {
            e.printStackTrace();
            HbUtil.rollbackTransaction();
        }

        HbUtil.shutdown();
    }
}
