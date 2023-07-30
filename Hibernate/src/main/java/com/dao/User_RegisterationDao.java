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

public class User_RegisterationDao {
    public  void getAllData(){
        SessionFactory factory=null;
        Session session=null;
        try {
            factory=new Configuration().configure().buildSessionFactory();
            String query="from User_Registration";
            session=factory.openSession();

            Query query1 = session.createQuery(query);
            List<User_Registration[]> list=query1.list();
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
            String query="desc user_registration";
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
        int s_no=random.nextInt(50);
        System.out.println("Enter the id of the table:");
        int id= sc.nextInt();
        System.out.println("Enter the name:");
        String name=sc.next();
        System.out.println("Enter the gender:");
        sc.nextLine();
        String gender=sc.next();
        System.out.println("Enter the password:");
        sc.nextLine();
        String password=sc.next();
        System.out.println("Enter the phone number:");
        sc.nextLine();
        String ph_no=sc.next();
        System.out.println("Enter the age:");
        int age=sc.nextInt();
        System.out.println("Enter the email:");
        sc.nextLine();
        String E_mail=sc.next();

        SessionFactory factory=null;
        Session session=null;
      try {
           factory=new Configuration().configure().buildSessionFactory();
           session= factory.openSession();
          Transaction tx= session.beginTransaction();
          Medicine medicine=new Medicine();
          User_Registration userRegistration=new User_Registration(s_no,id,name,gender,password,ph_no,age,E_mail);
          session.save(userRegistration);
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
            System.out.println("3: Update Gender");
            System.out.println("4: Update Password");
            System.out.println("5: Update Phone Number");
            System.out.println("6: Update age");
            System.out.println("7: Update E-mail");
            System.out.println("8: Exit");
            int choice = sc.nextInt();
            if (choice == 1) {
                System.out.println("Enter the serial number of table:");
                int s_no = sc.nextInt();
                System.out.println("Enter the new  id of the table:");
                int id = sc.nextInt();
                SessionFactory factory = null;
                Session session = null;
                int r = 0;
                try {
                    factory = new Configuration().configure().buildSessionFactory();
                    session = factory.openSession();
                    Transaction tx = session.beginTransaction();
                    String query = "update User_Registration set id=:i where s_no=:s";
                    Query query1 = session.createQuery(query);
                    query1.setParameter("i", id);
                    query1.setParameter("s", s_no);
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
                int id = sc.nextInt();
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
                    String query = "update User_Registration set name=:n where id=:i";
                    Query query1 = session.createQuery(query);
                    query1.setParameter("n", name);
                    query1.setParameter("i", id);
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
                int id = sc.nextInt();
                System.out.println("Enter the new  Gender:");
                sc.nextLine();
                String gender = sc.next();
                SessionFactory factory = null;
                Session session = null;
                int r = 0;
                try {
                    factory = new Configuration().configure().buildSessionFactory();
                    session = factory.openSession();
                    Transaction tx = session.beginTransaction();
                    String query = "update User_Registration set gender=:n where id=:i";
                    Query query1 = session.createQuery(query);
                    query1.setParameter("n", gender);
                    query1.setParameter("i", id);
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
                int id = sc.nextInt();
                System.out.println("Enter the new  Password:");
                sc.nextLine();
                String password = sc.next();
                SessionFactory factory = null;
                Session session = null;
                int r = 0;
                try {
                    factory = new Configuration().configure().buildSessionFactory();
                    session = factory.openSession();
                    Transaction tx = session.beginTransaction();
                    String query = "update User_Registration set password=:n where id=:i";
                    Query query1 = session.createQuery(query);
                    query1.setParameter("n", password);
                    query1.setParameter("i", id);
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
                int id = sc.nextInt();
                System.out.println("Enter the new  Phone Number:");
                sc.nextLine();
                String ph_no = sc.next();
                SessionFactory factory = null;
                Session session = null;
                int r = 0;
                try {
                    factory = new Configuration().configure().buildSessionFactory();
                    session = factory.openSession();
                    Transaction tx = session.beginTransaction();
                    String query = "update User_Registration set ph_no=:n where id=:i";
                    Query query1 = session.createQuery(query);
                    query1.setParameter("n", ph_no);
                    query1.setParameter("i", id);
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
                int id = sc.nextInt();
                System.out.println("Enter the new Age:");
                int age = sc.nextInt();
                SessionFactory factory = null;
                Session session = null;
                int r = 0;
                try {
                    factory = new Configuration().configure().buildSessionFactory();
                    session = factory.openSession();
                    Transaction tx = session.beginTransaction();
                    String query = "update User_Registration set age=:n where id=:i";
                    Query query1 = session.createQuery(query);
                    query1.setParameter("n", age);
                    query1.setParameter("i", id);
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
            } else if (choice == 7) {
                System.out.println("Enter the id of the table:");
                int id = sc.nextInt();
                System.out.println("Enter the new Email:");
                sc.nextLine();
                String E_mail = sc.next();
                SessionFactory factory = null;
                Session session = null;
                int r = 0;
                try {
                    factory = new Configuration().configure().buildSessionFactory();
                    session = factory.openSession();
                    Transaction tx = session.beginTransaction();
                    String query = "update User_Registration set E_mail=:n where id=:i";
                    Query query1 = session.createQuery(query);
                    query1.setParameter("n", E_mail);
                    query1.setParameter("i", id);
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
            else if (choice==8){
                break;
        }
    }

    }
    public void delete(){
        Scanner sc=new Scanner(System.in).useDelimiter("\n");
        System.out.println("Enter the id of the table:");
        int id = sc.nextInt();
        SessionFactory factory = null;
        Session session = null;
        int r = 0;
        try {
            factory = new Configuration().configure().buildSessionFactory();
            session = factory.openSession();
            Transaction tx = session.beginTransaction();
            String query = "delete from User_Registration  where id=:i";
            Query query1 = session.createQuery(query);
            query1.setParameter("i", id);
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
