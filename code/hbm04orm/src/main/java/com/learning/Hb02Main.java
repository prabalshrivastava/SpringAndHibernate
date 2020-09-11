package com.learning;

import java.util.Date;

public class Hb02Main {
    public static void main(String[] args) {
        try(CustomerDaoImpl customerDao = new CustomerDaoImpl()){
            customerDao.open();
//            Customer customer = customerDao.findById(2);
//            customerDao.addCustomer(new Customer(6,"vishal","pune","vishal","1234568798","vishal@gamil.com",new Date(),100));
//            customerDao.updateCustomer(new Customer(6,"prabal","pune","vishal","1234568798","vishal@gamil.com",new Date(),100));
//            System.out.println("Found " + customer);
        }catch (Exception e){
            e.printStackTrace();
        }
        HbUtil.shutdown();
    }
}
