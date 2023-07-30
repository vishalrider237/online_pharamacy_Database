package com.dao;

import com.entities.Billing;
import com.entities.Purchase;
import com.entities.User_Registration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BillingDao {
    public void getAllData() {
        SessionFactory factory = null;
        Session session = null;
        try {
            factory = new Configuration().configure().buildSessionFactory();
            String query = "from Billing";
            session = factory.openSession();

            Query query1 = session.createQuery(query);
            List<Billing[]> list = query1.list();
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (factory.isClosed()) {
                System.out.println("All Data Printed successfully");
            }
        }
    }

    public void descTable() {
        SessionFactory factory = null;
        Session session = null;
        try {
            factory = new Configuration().configure().buildSessionFactory();
            String query = "desc billing";
            session = factory.openSession();
            NativeQuery nq = session.createSQLQuery(query);
            List<Object[]> list = nq.list();
            System.out.println("Field" + "    " + "Type" + "     " + "Null" + "    " + "Key" + "    " + "Default");
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
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        Random random = new Random();
        int bill_no = random.nextInt(10, 50);
        System.out.println("Enter the id of table:");
        String ord_no = sc.next();
        System.out.println("Enter the total amount of medicine:");
        int amount = sc.nextInt();
        SessionFactory factory = null;
        Session session = null;
        try {
            factory = new Configuration().configure().buildSessionFactory();
            session = factory.openSession();
            Transaction tx = session.beginTransaction();
            Billing billing = new Billing(bill_no, ord_no, amount);
            session.save(billing);
            tx.commit();
            session.close();
            factory.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (factory.isClosed()) {
                System.out.println("Data Inserted Successfully!!");
            }
        }
    }
    public void updateData(){
        Scanner sc=new Scanner(System.in).useDelimiter("\n");
        while (true) {
            System.out.println("Press  the number which you want to update!!");
            System.out.println("1: Update Bill Number");
            System.out.println("2: Update Total Amount");
            System.out.println("3: Exit");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.println("Enter the bill number:");
                int bill_no=sc.nextInt();
                System.out.println("Enter the Order number of the table:");
                String ord_no=sc.next();
                SessionFactory factory = null;
                Session session = null;
                int r = 0;
                try {
                    factory = new Configuration().configure().buildSessionFactory();
                    session = factory.openSession();
                    Transaction tx = session.beginTransaction();
                    String query = "update Billing set ord_no=:n where bill_no=:i";
                    Query query1 = session.createQuery(query);
                    query1.setParameter("n", ord_no);
                    query1.setParameter("i", bill_no);
                    r = query1.executeUpdate();
                    tx.commit();
                    session.close();
                    factory.close();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (factory.isClosed()) {
                        System.out.println(r + " Updated successfully");
                    }
                }
            } else if (choice == 2) {
                System.out.println("Enter the Order Number of the table:");
                String ord_no=sc.next();
                System.out.println("Enter the total Amount of table:");
                int total_amount=sc.nextInt();
                SessionFactory factory = null;
                Session session = null;
                int r = 0;
                try {
                    factory = new Configuration().configure().buildSessionFactory();
                    session = factory.openSession();
                    Transaction tx = session.beginTransaction();
                    String query = "update Billing set total_amt=:n where ord_no=:i";
                    Query query1 = session.createQuery(query);
                    query1.setParameter("n", total_amount);
                    query1.setParameter("i", ord_no);
                    r = query1.executeUpdate();
                    tx.commit();
                    session.close();
                    factory.close();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (factory.isClosed()) {
                        System.out.println(r + " Updated successfully");
                    }
                }
            } else if (choice == 3) {
                break;
            }

        }
    }
    public void delete() {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Enter the Billing Id of the table:");
        String ord_num = sc.next();
        SessionFactory factory = null;
        Session session = null;
        int r = 0;
        try {
            factory = new Configuration().configure().buildSessionFactory();
            session = factory.openSession();
            Transaction tx = session.beginTransaction();
            String query = "delete from Billing  where ord_no=:i";
            Query query1 = session.createQuery(query);
            query1.setParameter("i", ord_num);
            r = query1.executeUpdate();
            tx.commit();
            session.close();
            factory.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (factory.isClosed()) {
                System.out.println(r + " Deleted successfully");
            }
        }

    }
}