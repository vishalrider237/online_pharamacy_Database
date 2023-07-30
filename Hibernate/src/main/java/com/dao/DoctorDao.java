package com.dao;

import com.entities.Doctor;
import com.entities.Medicine;
import com.entities.User_Registration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class DoctorDao {
    public  void getAllData(){
        SessionFactory factory=null;
        Session session=null;
        try {
            factory=new Configuration().configure().buildSessionFactory();
            String query="from Doctor";
            session=factory.openSession();

            Query query1 = session.createQuery(query);
            List<Doctor[]> list=query1.list();
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
            String query="desc doctor";
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
        System.out.println("Enter the id of table:");
        int d_num=sc.nextInt();
        System.out.println("Enter the name:");
        String name=sc.next();
        System.out.println("Enter the specilyst of doctor:");
        sc.nextLine();
        String specilyst= sc.next();
        System.out.println("Enter the phone number:");
        sc.nextLine();
        String ph_no=sc.next();
        System.out.println("Enter the address:");
        sc.nextLine();
        String address=sc.next();
        SessionFactory factory=null;
        Session session=null;
        try {
            factory=new Configuration().configure().buildSessionFactory();
            session= factory.openSession();
            Transaction tx= session.beginTransaction();
            Doctor doctor=new Doctor(d_num,name,specilyst,ph_no,address);
            session.save(doctor);
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
            System.out.println("1: Update Name");
            System.out.println("2: Update Specialist of doctor");
            System.out.println("3: Update Phone number of doctor");
            System.out.println("4: Update Address of doctor");
            System.out.println("5: Exit");
            int choice = sc.nextInt();

             if (choice == 1) {
                System.out.println("Enter the serial number of the table:");
                int d_num=sc.nextInt();
                System.out.println("Enter the new  name:");
                sc.nextLine();
                String name = sc.next();
                SessionFactory factory = null;
                Session session = null;
                int r = 0;
                try {
                    factory = new Configuration().configure().buildSessionFactory();
                    session = factory.openSession();
                    Transaction tx = session.beginTransaction();
                    String query = "update Doctor set name=:n where d_num=:i";
                    Query query1 = session.createQuery(query);
                    query1.setParameter("n", name);
                    query1.setParameter("i", d_num);
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
                System.out.println("Enter the serial number of the table:");
                int d_num=sc.nextInt();
                System.out.println("Enter the Specialist of table:");
                sc.nextLine();
                String specilyst=sc.next();
                SessionFactory factory = null;
                Session session = null;
                int r = 0;
                try {
                    factory = new Configuration().configure().buildSessionFactory();
                    session = factory.openSession();
                    Transaction tx = session.beginTransaction();
                    String query = "update Doctor set specilyst=:n where d_num=:i";
                    Query query1 = session.createQuery(query);
                    query1.setParameter("n", specilyst);
                    query1.setParameter("i", d_num);
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
                System.out.println("Enter the serial number of the table:");
                int d_num=sc.nextInt();
                System.out.println("Enter the new  Phone number:");
                sc.nextLine();
                String ph_no = sc.next();
                SessionFactory factory = null;
                Session session = null;
                int r = 0;
                try {
                    factory = new Configuration().configure().buildSessionFactory();
                    session = factory.openSession();
                    Transaction tx = session.beginTransaction();
                    String query = "update Doctor set ph_no=:n where d_num=:i";
                    Query query1 = session.createQuery(query);
                    query1.setParameter("n", ph_no);
                    query1.setParameter("i", d_num);
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
                System.out.println("Enter the id of the table:");
                int d_num=sc.nextInt();
                System.out.println("Enter the new  Address:");
                sc.nextLine();
                String address = sc.next();
                SessionFactory factory = null;
                Session session = null;
                int r = 0;
                try {
                    factory = new Configuration().configure().buildSessionFactory();
                    session = factory.openSession();
                    Transaction tx = session.beginTransaction();
                    String query = "update Doctor set address=:n where d_num=:i";
                    Query query1 = session.createQuery(query);
                    query1.setParameter("n", address);
                    query1.setParameter("i", d_num);
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
            } else if (choice == 5) {
                break;
        }

    }
    }
    public void delete(){
        Scanner sc=new Scanner(System.in).useDelimiter("\n");
        System.out.println("Enter the serial number of the table:");
        int d_num=sc.nextInt();
        SessionFactory factory = null;
        Session session = null;
        int r = 0;
        try {
            factory = new Configuration().configure().buildSessionFactory();
            session = factory.openSession();
            Transaction tx = session.beginTransaction();
            String query = "delete from Doctor  where d_num=:i";
            Query query1 = session.createQuery(query);
            query1.setParameter("i", d_num);
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
