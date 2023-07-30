package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import java.util.List;

public class R6_referredDao {
    public void getAllData(){
        SessionFactory factory = null;
        Session session = null;
        try {
            factory = new Configuration().configure().buildSessionFactory();
            String query = "select * from r6_referred";
            session = factory.openSession();
            NativeQuery nq = session.createSQLQuery(query);
            List<Object[]> list = nq.list();
            System.out.println("o_no" + "    " + "s_code");
            System.out.println("-----------------------------------------------");
            for (Object[] u : list) {
                for (int i = 0; i < u.length; i++) {
                    System.out.print(u[i] + "     ");
                }
                System.out.println();
                System.out.println("--------------------------------------------");
                session.close();
                factory.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (factory.isClosed()) {
                System.out.println("Described Successfully!!");
            }
        }

    }
    public void descTable() {
        SessionFactory factory = null;
        Session session = null;
        try {
            factory = new Configuration().configure().buildSessionFactory();
            String query = "desc r6_referred";
            session = factory.openSession();
            NativeQuery nq = session.createSQLQuery(query);
            List<Object[]> list = nq.list();
            System.out.println("Field" + "       " + "Type" + "       " + "Null" + "      " + "Key" + "      " + "Default");
            System.out.println("-----------------------------------------------");
            for (Object[] u : list) {
                for (int i = 0; i < u.length; i++) {
                    System.out.print(u[i] + "     ");
                }
                System.out.println();
                System.out.println("--------------------------------------------");
                session.close();
                factory.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (factory.isClosed()) {
                System.out.println("Described Successfully!!");
            }
        }

    }
    public void insertData() {
        System.out.println("Foreign Key Constraint!! Can not be Inserted");
    }
    public void updateData() {
        System.out.println("Foreign Key Constraint!! Can not be Updated");
    }
    public void deleteData() {
        System.out.println("Foreign Key Constraint!! Can not be Deleted");
    }
}
