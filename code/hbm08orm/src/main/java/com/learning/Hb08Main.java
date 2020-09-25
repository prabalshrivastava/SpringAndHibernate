package com.learning;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.*;

import static java.lang.System.*;

public class Hb08Main {
    public static void main(String[] args) {
        try (Session session = HbUtil.getCurrentSession()) {
            HbUtil.beginTransaction();
            //case 1
//            Dept dept = session.get(Dept.class, 10);
//            Emp emp = session.get(Emp.class, 7782);
//            out.println(emp);
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


//            out.println(session.find(Emp.class,7900));
//            out.println(session.find(Dept.class,10));

            //native query
//            NativeQuery nativeQuery = session.createSQLQuery("select distinct author from books");
//            List resultList = nativeQuery.getResultList();
//            out.println(resultList);


            //hql
//            Query hql = session.createQuery("select distinct b.subject from Book b");
//            out.println(hql.getResultList());


//            String hql = "from Book b where b.subject=:p_subject";
//            Query<Book> q = session.createQuery(hql);
//            q.setParameter("p_subject", "JAVA");
//            out.println(q.getResultList());


//            String hql = "from Book b where b.subject=?1";
//            Query<Book> q = session.createQuery(hql);
//            q.setParameter(1, "JAVA");
//            out.println(q.getResultList());

//            String hql = "select b.id,b.name,b.author from Book b where b.subject=?1";
//            Query<Book> q = session.createQuery(hql);
//            q.setParameter(1, "JAVA");
//            List resultList = q.getResultList();
//            resultList.forEach(a ->out.println(Arrays.deepToString((Object[]) a)));

//            String hql = "select new Book(b.id,b.name,b.author) from Book b where b.subject=?1";
//            Query<Book> q = session.createQuery(hql);
//            q.setParameter(1, "JAVA");
//            List<Book> resultList = q.getResultList();
//            out.println(resultList);


//            String hql = "select b.subject,sum(b.price) from Book b";
//            Query<Object[]> q = session.createQuery(hql);
//            List<Object[]> resultList = q.getResultList();
//            HashMap<String, Double> hashMap = new HashMap<>();
//            for (Object[] row : resultList) {
//                hashMap.put((String) row[0], (Double) row[1]);
//            }
//            out.println(hashMap);


//            String hql = "select e.ename,d.dname from Emp e inner join e.deptno d";
//            Query<Object[]> q = session.createQuery(hql);
//            List<Object[]> resultList = q.getResultList();
//            HashMap<String, String> hashMap = new HashMap<>();
//            for (Object[] row : resultList) {
//                hashMap.put((String) row[0], (String) row[1]);
//            }
//            out.println(hashMap);


//            String hql = "select e.ename,d.dname from Dept d inner join d.empList e";
//            Query<Object[]> q = session.createQuery(hql);
//            List<Object[]> resultList = q.getResultList();
//            HashMap<String, String> hashMap = new HashMap<>();
//            for (Object[] row : resultList) {
//                hashMap.put((String) row[0], (String) row[1]);
//            }
//            out.println(hashMap);


            //implicit join syntax
//            String hql = "select e.ename,e.deptno.dname from Emp e";
//            Query<Object[]> q = session.createQuery(hql);
//            List<Object[]> resultList = q.getResultList();
//            HashMap<String, String> hashMap = new HashMap<>();
//            for (Object[] row : resultList) {
//                hashMap.put((String) row[0], (String) row[1]);
//            }
//            out.println(hashMap);


            //update
//            String hql = "update Book b set b.price=b.price*1.10";
//            Query<Object[]> q = session.createQuery(hql);
//            int isUpdated = q.executeUpdate();//returns number rows are updated.
//            out.println(isUpdated);


            //delete
//            String hql = "delete from Book b";
//            Query<Object[]> q = session.createQuery(hql);
//            int isUpdated = q.executeUpdate();//returns number rows are updated.
//            out.println(isUpdated);


            //named query
//            Query<Book> q = session.getNamedQuery("bookSummary");
//            q.setParameter(1, "JAVA");
//            List<Book> resultList = q.getResultList();
//            out.println(resultList);


//            Query<Book> q = session.getNamedQuery("bookSummary1");
//            q.setParameter("p_subject", "JAVA");
//            out.println(q.getResultList());


            //calling Stored procedure with in parameters
//            NativeQuery<Book> myStoredProcedureCall = session.getNamedNativeQuery("myStoredProcedureCall");
//            myStoredProcedureCall.setParameter("pmin", 10);
//            myStoredProcedureCall.setParameter("pmax", 400);
//            out.println(myStoredProcedureCall.getResultList());


            //calling Stored procedure with in and out parameters
//            BookDaoImpl bookDao = new BookDaoImpl();
//            double price = bookDao.getPriceOfBook(11);
//            double price1 = bookDao.getPriceOfBookUsingStoredProcedureCall(11);
//            double price2 = bookDao.getPriceOfBookUsingNamedStoredProcedureCall(11);
//            System.out.println("Book Price: " + price);
//            System.out.println("Book Price: " + price1);
//            System.out.println("Book Price: " + price2);



            /*
		try(Session session = HbUtil.openSession()) {
			Filter filter = session.enableFilter("bookFilter");
 			filter.setParameter("minPrice", 300.0);
 			filter.setParameter("maxPrice", 600.0);
 			filter.setParameter("subjectVal", "JAVA");
			Query<Book> q = session.createQuery("from Book b");
 			List<Book> list = q.getResultList();
 			list.forEach(System.out::println);
 			session.disableFilter("bookFilter");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		*/

		/*
		try(Session session = HbUtil.openSession()) {
 			Book b1 = session.find(Book.class, 22);
 			System.out.println("Found -- " + b1);
 			Book b2 = session.find(Book.class, 22);
 			System.out.println("Found -- " + b2);
 			System.out.println("b1 & b2 are same objects: " + (b1 == b2));
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		try(Session session = HbUtil.openSession()) {
 			Book b3 = session.find(Book.class, 22);
 			System.out.println("Found -- " + b3);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		*/

//            try(Session session = HbUtil.openSession()) {
//                Query<Book> q = session.createQuery("from Book b");
//                q.setCacheable(true);
//                List<Book> list = q.getResultList();
//                list.forEach(System.out::println);
//            }
//            catch (Exception e) {
//                e.printStackTrace();
//            }
//            System.out.println();
//
//            try(Session session = HbUtil.openSession()) {
//                Query<Book> q = session.createQuery("from Book b");
//                q.setCacheable(true);
//                List<Book> list = q.getResultList();
//                list.forEach(System.out::println);
//            }
//            catch (Exception e) {
//                e.printStackTrace();
//            }
//
//            System.out.println();
//
//            HbUtil.shutdown();

        } catch (Exception e) {
            e.printStackTrace();
            HbUtil.rollbackTransaction();
        }

        HbUtil.shutdown();
    }
}
