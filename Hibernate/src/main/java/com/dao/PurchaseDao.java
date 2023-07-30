package com.dao;

import com.entities.Doctor;
import com.entities.Purchase;
import com.entities.User_Registration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class PurchaseDao {
    public  void getAllData(){
        SessionFactory factory=null;
        Session session=null;
        try {
            factory=new Configuration().configure().buildSessionFactory();
            String query="from Purchase";
            session=factory.openSession();

            Query query1 = session.createQuery(query);
            List<Purchase[]> list=query1.list();
            for (int i=0;i<list.size();i++){
                System.out.println(list.get(i));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (factory.isClosed()){
                System.out.println("All Data Printed successfully");
            }
        }

    }
    public void descTable(){
        SessionFactory factory=null;
        Session session=null;
        try {
            factory=new Configuration().configure().buildSessionFactory();
            String query="desc purchase";
            session=factory.openSession();
            NativeQuery nq=session.createSQLQuery(query);
            List<Object[] >list=nq.list();
            System.out.println("Field"+"    "+"Type"+"     "+"Null"+"    "+"Key"+"    "+"Default");
            System.out.println("-----------------------------------------------");
            for (Object[] u :list){
                for (int i=0;i< u.length;i++){
                    System.out.print(u[i]+"     ");
                }
                System.out.println();
                System.out.println("--------------------------------------------");
                session.close();
                factory.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if (factory.isClosed()){
                System.out.println("Described Successfully!!");
            }
        }

    }
    public void insertData(){
        Scanner sc=new Scanner(System.in).useDelimiter("\n");
        Random random=new Random();
        int p_num=random.nextInt(10,50);
        System.out.println("Enter the id of table:");
        String pur_no=sc.next();
        System.out.println("Enter the amount of medicine:");
        int amount=sc.nextInt();
        System.out.println("Enter the discount on medicine:");
        int discount=sc.nextInt();
        int total_discount=amount-(discount*100/amount);
        SessionFactory factory=null;
        Session session=null;
        try {
            factory=new Configuration().configure().buildSessionFactory();
            session= factory.openSession();
            Transaction tx= session.beginTransaction();
            Purchase purchase=new Purchase(p_num,pur_no,amount,discount,total_discount);
            session.save(purchase);
            tx.commit();
            session.close();
            factory.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (factory.isClosed()){
                System.out.println("Data Inserted Successfully!!");
            }
        }
    }
    public void updateData(){
        Scanner sc=new Scanner(System.in).useDelimiter("\n");
        while (true) {
            System.out.println("Press  the number which you want to update!!");
            System.out.println("1: Update Purchase Number");
            System.out.println("2: Update Amount");
            System.out.println("3: Update Discount");
            System.out.println("4: Exit");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.println("Enter the serial number of the table:");
                int s_no=sc.nextInt();
                System.out.println("Enter the new Purchase Number:");
                sc.nextLine();
                String pur_no = sc.next();
                SessionFactory factory = null;
                Session session = null;
                int r = 0;
                try {
                    factory = new Configuration().configure().buildSessionFactory();
                    session = factory.openSession();
                    Transaction tx = session.beginTransaction();
                    String query = "update Purchase set pur_no=:n where p_num=:i";
                    Query query1 = session.createQuery(query);
                    query1.setParameter("n", pur_no);
                    query1.setParameter("i", s_no);
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
                System.out.println("Enter the Purchase Id of the table:");
                String pur_no=sc.next();
                System.out.println("Enter the Amount of table:");
                int amount=sc.nextInt();
                SessionFactory factory = null;
                Session session = null;
                int r = 0;
                try {
                    factory = new Configuration().configure().buildSessionFactory();
                    session = factory.openSession();
                    Transaction tx = session.beginTransaction();
                    String query = "update Purchase set amount=:n,total_amount=:f where pur_no=:i";
                    Query query1 = session.createQuery(query);
                    query1.setParameter("n", amount);
                    query1.setParameter("i", pur_no);
                    Purchase purchase=(Purchase)session.get(Purchase.class,pur_no);
                    int discount= purchase.getDiscount();
                    int total_amount=amount-(discount*100)/amount;
                    query1.setParameter("f",total_amount);
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
                System.out.println("Enter the Purchase Number of the table:");
                String p_num=sc.next();
                System.out.println("Enter the Discount:");
                int discount=sc.nextInt();
                SessionFactory factory = null;
                Session session = null;
                int r = 0;
                try {
                    factory = new Configuration().configure().buildSessionFactory();
                    session = factory.openSession();
                    Transaction tx = session.beginTransaction();
                    String query = "update Purchase set discount=:n,total_amount=:t where pur_no=:i";
                    Query query1 = session.createQuery(query);
                    Purchase p=(Purchase) session.get(Purchase.class,p_num);
                    query1.setParameter("n", discount);
                    query1.setParameter("i", p_num);
                    int amount=p.getAmount();
                    int total_amount=amount-(discount*100)/amount;
                    query1.setParameter("t",total_amount);
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
            } else if (choice == 4) {
                break;
            }

        }
    }
    public void delete(){
        Scanner sc=new Scanner(System.in).useDelimiter("\n");
        System.out.println("Enter the Purchase Number of the table:");
        String p_num=sc.next();
        SessionFactory factory = null;
        Session session = null;
        int r = 0;
        try {
            factory = new Configuration().configure().buildSessionFactory();
            session = factory.openSession();
            Transaction tx = session.beginTransaction();
            String query = "delete from Purchase  where pur_no=:i";
            Query query1 = session.createQuery(query);
            query1.setParameter("i", p_num);
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
