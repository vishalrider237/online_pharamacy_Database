package com.dao;

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

public class MedicineDao {
    public  void getAllData(){
        SessionFactory factory=null;
        Session session=null;
        try {
            factory=new Configuration().configure().buildSessionFactory();
            String query="from Medicine";
            session=factory.openSession();

            Query query1 = session.createQuery(query);
            List<Medicine[]> list=query1.list();
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
            String query="desc medicine";
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
        int m_no=random.nextInt(50);
        System.out.println("Enter the name:");
        String name=sc.next();
        System.out.println("Enter the id of the table:");
        sc.nextLine();
        String m_id= sc.next();
        System.out.println("Enter the amount:");
        int amount=sc.nextInt();
        System.out.println("Enter the expiry date:");
        sc.nextLine();
        String expiry=sc.next();
        System.out.println("Enter the manufacture date:");
        sc.nextLine();
        String manufacture=sc.next();
        System.out.println("Enter the purpose of medicine:");
        sc.nextLine();
        String purpose=sc.next();
        SessionFactory factory=null;
        Session session=null;
        try {
            factory=new Configuration().configure().buildSessionFactory();
            session= factory.openSession();
            Transaction tx= session.beginTransaction();
            Medicine medicine=new Medicine(m_no,name,m_id,amount,expiry,manufacture,purpose);
            session.save(medicine);
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
            System.out.println("1: Update Id");
            System.out.println("2: Update Name");
            System.out.println("3: Update Amount");
            System.out.println("4: Update Expiry date");
            System.out.println("5: Update Manufacture date");
            System.out.println("6: Update purpose of medicine");
            System.out.println("7: Exit");
            int choice = sc.nextInt();
            if (choice == 1) {
                System.out.println("Enter the serial number of table:");
                int m_no = sc.nextInt();
                System.out.println("Enter the new  id of the table:");
                String m_id=sc.next();
                SessionFactory factory = null;
                Session session = null;
                int r = 0;
                try {
                    factory = new Configuration().configure().buildSessionFactory();
                    session = factory.openSession();
                    Transaction tx = session.beginTransaction();
                    String query = "update Medicine set m_id=:i where m_no=:s";
                    Query query1 = session.createQuery(query);
                    query1.setParameter("i", m_id);
                    query1.setParameter("s", m_no);
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
                System.out.println("Enter the id of the table:");
                String m_id=sc.next();
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
                    String query = "update Medicine set name=:n where m_id=:i";
                    Query query1 = session.createQuery(query);
                    query1.setParameter("n", name);
                    query1.setParameter("i", m_id);
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
                System.out.println("Enter the id of the table:");
                String m_id=sc.next();
                System.out.println("Enter the new  Amount:");
                int amount=sc.nextInt();
                SessionFactory factory = null;
                Session session = null;
                int r = 0;
                try {
                    factory = new Configuration().configure().buildSessionFactory();
                    session = factory.openSession();
                    Transaction tx = session.beginTransaction();
                    String query = "update Medicine set amount=:n where m_id=:i";
                    Query query1 = session.createQuery(query);
                    query1.setParameter("n", amount);
                    query1.setParameter("i", m_id);
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
                String m_id=sc.next();
                System.out.println("Enter the new  Expiry Date:");
                sc.nextLine();
                String expiry = sc.next();
                SessionFactory factory = null;
                Session session = null;
                int r = 0;
                try {
                    factory = new Configuration().configure().buildSessionFactory();
                    session = factory.openSession();
                    Transaction tx = session.beginTransaction();
                    String query = "update Medicine set expiry=:n where m_id=:i";
                    Query query1 = session.createQuery(query);
                    query1.setParameter("n", expiry);
                    query1.setParameter("i", m_id);
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
                System.out.println("Enter the id of the table:");
                String m_id=sc.next();
                System.out.println("Enter the new  Manufacturing date:");
                sc.nextLine();
                String manufacture = sc.next();
                SessionFactory factory = null;
                Session session = null;
                int r = 0;
                try {
                    factory = new Configuration().configure().buildSessionFactory();
                    session = factory.openSession();
                    Transaction tx = session.beginTransaction();
                    String query = "update Medicine set manufacture=:n where m_id=:i";
                    Query query1 = session.createQuery(query);
                    query1.setParameter("n", manufacture);
                    query1.setParameter("i", m_id);
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
            } else if (choice == 6) {
                System.out.println("Enter the id of the table:");
                String m_id= sc.next();
                System.out.println("Enter the Purpose of medicine:");
                sc.nextLine();
                String purpose=sc.next();
                SessionFactory factory = null;
                Session session = null;
                int r = 0;
                try {
                    factory = new Configuration().configure().buildSessionFactory();
                    session = factory.openSession();
                    Transaction tx = session.beginTransaction();
                    String query = "update Medicine set purpose=:n where m_id=:i";
                    Query query1 = session.createQuery(query);
                    query1.setParameter("n", purpose);
                    query1.setParameter("i", m_id);
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
            }

            else if (choice==7){
                break;
            }
        }
    }
    public void delete(){
        Scanner sc=new Scanner(System.in).useDelimiter("\n");
        System.out.println("Enter the id of the table:");
        String m_id=sc.next();
        SessionFactory factory = null;
        Session session = null;
        int r = 0;
        try {
            factory = new Configuration().configure().buildSessionFactory();
            session = factory.openSession();
            Transaction tx = session.beginTransaction();
            String query = "delete from Medicine  where m_id=:i";
            Query query1 = session.createQuery(query);
            query1.setParameter("i", m_id);
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
