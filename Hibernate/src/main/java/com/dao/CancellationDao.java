package com.dao;

import com.entities.Billing;
import com.entities.Cancellation;
import com.entities.Doctor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CancellationDao {
    public  void getAllData(){
        SessionFactory factory=null;
        Session session=null;
        try {
            factory=new Configuration().configure().buildSessionFactory();
            String query="from Cancellation ";
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
            String query = "desc cancellation";
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
        int o_num = random.nextInt(10, 50);
        System.out.println("Enter the id of table which match with id of user registration table:");
        int user_id=sc.nextInt();
        System.out.println("Enter the cancellation number:");
        String can_no=sc.next();
        SessionFactory factory = null;
        Session session = null;
        try {
            factory = new Configuration().configure().buildSessionFactory();
            session = factory.openSession();
            Transaction tx = session.beginTransaction();
            String query="select id from user_registration";
            NativeQuery query1= session.createSQLQuery(query);
            List list=query1.list();
            if (list.contains(user_id)){
                Cancellation cancellation=new Cancellation(o_num,user_id,can_no);
                session.save(cancellation);
            }else{
                throw new Exception("User Not Found");
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
            System.out.println("1: Update User Id");
            System.out.println("2: Update Cancellation Number");
            System.out.println("3: Exit");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.println("Foreign Key Constraint!! Can not be updated");
            }

           else if (choice == 2) {
                System.out.println("Enter the User Id of the table:");
                int user_id=sc.nextInt();
                System.out.println("Enter the Cancellation number of table:");
                String canNo=sc.next();
                SessionFactory factory = null;
                Session session = null;
                int r = 0;
                try {
                    factory = new Configuration().configure().buildSessionFactory();
                    session = factory.openSession();
                    Transaction tx = session.beginTransaction();
                        String query = "update Cancellation set can_no=:n where user_id=:i";
                        Query query1 = session.createQuery(query);
                        query1.setParameter("n", canNo);
                        query1.setParameter("i", user_id);
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
    public void delete(){
        System.out.println("Foreign Key Constraint!! You can not delete it");

    }


}
