package com.dao;

import com.entities.Cancellation;
import com.entities.Supplier;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class SupplierDao {
    public  void getAllData(){
        SessionFactory factory=null;
        Session session=null;
        try {
            factory=new Configuration().configure().buildSessionFactory();
            String query="from Supplier";
            session=factory.openSession();

            Query query1 = session.createQuery(query);
            List list=query1.list();
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
    public void descTable() {
        SessionFactory factory = null;
        Session session = null;
        try {
            factory = new Configuration().configure().buildSessionFactory();
            String query = "desc supplier";
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
        Random random=new Random();
      //  System.out.println("Enter the id of the table:");
        String s_code=String.valueOf(random.nextInt(1000,9999));
        System.out.println("Enter the supplier code number:");
        String s_num=sc.next();
        System.out.println("Enter the name:");
        sc.nextLine();
        String name=sc.next();
        System.out.println("Enter the Email Id:");
        sc.nextLine();
        String E_mail=sc.next();
        System.out.println("Enter the phone number:");
        sc.nextLine();
        String ph_no=sc.next();
        SessionFactory factory = null;
        Session session = null;
        try {
            factory = new Configuration().configure().buildSessionFactory();
            session = factory.openSession();
            Transaction tx = session.beginTransaction();
            String query="select pur_no from purchase";
            NativeQuery query1= session.createSQLQuery(query);
            List list=query1.list();
            if (list.contains(s_num)){
                Supplier supplier=new Supplier(s_code,s_num,name,E_mail,ph_no);
                session.save(supplier);
            }else{
                throw new Exception("Foreign Key Constraint!! Can not be inserted");
            }

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
            System.out.println("1: Update Supplier Code");
            System.out.println("2: Update Supplier Number code");
            System.out.println("3: Update Name");
            System.out.println("4: Update Supplier E-mail");
            System.out.println("5: Update Supplier Phone Number");
            System.out.println("6: Exit");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.println("Enter the Supplier Number Code of the table which matches with purchase number:");
                String s_num = sc.next();
                System.out.println("Enter the Supplier code:");
                sc.nextLine();
                String s_code = sc.next();
                SessionFactory factory = null;
                Session session = null;
                int r = 0;
                try {
                    factory = new Configuration().configure().buildSessionFactory();
                    session = factory.openSession();
                    Transaction tx = session.beginTransaction();
                    String query = "select pur_no from purchase";
                    NativeQuery query1 = session.createSQLQuery(query);
                    List list = query1.list();
                    if (list.contains(s_num)) {
                        String query2 = "update Supplier set s_code=:n where s_num=:i";
                        Query query3 = session.createQuery(query2);
                        query3.setParameter("n", s_code);
                        query3.setParameter("i", s_num);
                        r = query3.executeUpdate();
                    }

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
                System.out.println("Foreign Key Constraint!! Can not be updated");
            } else if (choice == 3) {
                System.out.println("Enter the Supplier Number Code of the table which matches with purchase number:");
                String s_num = sc.next();
                System.out.println("Enter the Name of Suppler:");
                sc.nextLine();
                String name = sc.next();
                SessionFactory factory = null;
                Session session = null;
                int r = 0;
                try {
                    factory = new Configuration().configure().buildSessionFactory();
                    session = factory.openSession();
                    Transaction tx = session.beginTransaction();
                    String query = "select pur_no from purchase";
                    NativeQuery query1 = session.createSQLQuery(query);
                    List list = query1.list();
                    if (list.contains(s_num)) {
                        String query2 = "update Supplier set name=:n where s_num=:i";
                        Query query3 = session.createQuery(query2);
                        query3.setParameter("n", name);
                        query3.setParameter("i", s_num);
                        r = query3.executeUpdate();
                    }

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
                System.out.println("Enter the Supplier Number Code of the table which matches with purchase number:");
                String s_num = sc.next();
                System.out.println("Enter the Email of Suppler:");
                sc.nextLine();
                String email = sc.next();
                SessionFactory factory = null;
                Session session = null;
                int r = 0;
                try {
                    factory = new Configuration().configure().buildSessionFactory();
                    session = factory.openSession();
                    Transaction tx = session.beginTransaction();
                    String query = "select pur_no from purchase";
                    NativeQuery query1 = session.createSQLQuery(query);
                    List list = query1.list();
                    if (list.contains(s_num)) {
                        String query2 = "update Supplier set E_mail=:n where s_num=:i";
                        Query query3 = session.createQuery(query2);
                        query3.setParameter("n", email);
                        query3.setParameter("i", s_num);
                        r = query3.executeUpdate();
                    }

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

            } else if (choice == 5) {
                System.out.println("Enter the Supplier Number Code of the table which matches with purchase number:");
                String s_num = sc.next();
                System.out.println("Enter the Phone Number of Suppler:");
                sc.nextLine();
                String ph_no = sc.next();
                SessionFactory factory = null;
                Session session = null;
                int r = 0;
                try {
                    factory = new Configuration().configure().buildSessionFactory();
                    session = factory.openSession();
                    Transaction tx = session.beginTransaction();
                    String query = "select pur_no from purchase";
                    NativeQuery query1 = session.createSQLQuery(query);
                    List list = query1.list();
                    if (list.contains(s_num)) {
                        String query2 = "update Supplier set ph_no=:n where s_num=:i";
                        Query query3 = session.createQuery(query2);
                        query3.setParameter("n", ph_no);
                        query3.setParameter("i", s_num);
                        r = query3.executeUpdate();
                    }

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
            } else if (choice==6) {
                break;
            }
        }
    }
    public void delete(){
        System.out.println("Foreign Key Constraint!! You can not delete it");

    }
}
