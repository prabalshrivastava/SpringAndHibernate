package sh08;

import static java.lang.System.*;

public class Hb03Main {
    public static void main(String[] args) {
        try (
                CustomerDaoImpl customerDao = new CustomerDaoImpl();
//                BookDaoImpl bookDao = new BookDaoImpl()
        ) {
            customerDao.open();
//            bookDao.open();
            HbUtil.beginTransaction();
            out.println(customerDao.findById(1));
//            out.println(bookDao.findById(1));
            HbUtil.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
        }
        HbUtil.shutdown();
    }
}
