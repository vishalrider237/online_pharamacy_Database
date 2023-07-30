package com.looping;

import com.dao.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class OnlinePharamacy {
    public static void Run() {
        System.out.println("**********ALL TABLES OF DATABASE*********");
        SessionFactory factory = null;
        Session session = null;
        try {
            factory = new Configuration().configure().buildSessionFactory();
            String query = "show tables";
            session = factory.openSession();
            NativeQuery nq = session.createSQLQuery(query);
            List list = nq.list();
            Collections.sort(list);
            System.out.println("-----------------------------------------------");
            System.out.println("1: Billing");
            System.out.println("2: Cancellation");
            System.out.println("3: Doctor");
            System.out.println("4: Medicine");
            System.out.println("5: Purchase");
            System.out.println("6: R1_Search");
            System.out.println("7: R2_Has");
            System.out.println("8: R3_Has");
            System.out.println("9: R4_Has");
            System.out.println("10: R5_Supply");
            System.out.println("11: R6_Referred");
            System.out.println("12: Supplier");
            System.out.println("13: User_Registration");
            System.out.println("14: Exit");
            System.out.println(list);
            System.out.println();
            System.out.println("--------------------------------------------");
            session.close();
            factory.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (factory.isClosed()) {
                System.out.println("All Tables Shown Successfully");
            }
        }
        Scanner sc=new Scanner(System.in);
        while (true){
            System.out.println("Enter the Tables number which you want to perform Operations:");
            int Table_no= sc.nextInt();
            if (Table_no==1){
                System.out.println("-------------------BILLING TABLE---------------------------");
                BillingDao billingDao=new BillingDao();
                System.out.println("1: Describe Table");
                System.out.println("2: Show All Data");
                System.out.println("3: Insert Data");
                System.out.println("4: Update Data");
                System.out.println("5: Delete");
                System.out.println("6: Exit");
                System.out.println("-----------------------------------------------");
                System.out.println("Enter the keys which you want to perform operations on Table:");
                int keys=sc.nextInt();
                if (keys==1){
                    billingDao.descTable();
                } else if (keys==2) {
                    billingDao.getAllData();
                } else if (keys==3) {
                    billingDao.insertData();
                } else if (keys==4) {
                    billingDao.updateData();
                } else if (keys==5) {
                    billingDao.delete();
                } else if (keys==6) {
                    break;
                }
            }
            else if (Table_no==2){
                System.out.println("-------------------CANCELLATION TABLE---------------------------");
                CancellationDao cancellationDao=new CancellationDao();
                System.out.println("1: Describe Table");
                System.out.println("2: Show All Data");
                System.out.println("3: Insert Data");
                System.out.println("4: Update Data");
                System.out.println("5: Delete");
                System.out.println("6: Exit");
                System.out.println("-----------------------------------------------");
                System.out.println("Enter the keys which you want to perform operations on Table:");
                int keys=sc.nextInt();
                if (keys==1){
                    cancellationDao.descTable();
                } else if (keys==2) {
                    cancellationDao.getAllData();
                } else if (keys==3) {
                    cancellationDao.insertData();
                } else if (keys==4) {
                    cancellationDao.updateData();
                } else if (keys==5) {
                    cancellationDao.delete();
                } else if (keys==6) {
                    break;
                }
            }
            else if (Table_no==3){
                System.out.println("-------------------DOCTOR TABLE---------------------------");
                DoctorDao doctorDao=new DoctorDao();
                System.out.println("1: Describe Table");
                System.out.println("2: Show All Data");
                System.out.println("3: Insert Data");
                System.out.println("4: Update Data");
                System.out.println("5: Delete");
                System.out.println("6: Exit");
                System.out.println("-----------------------------------------------");
                System.out.println("Enter the keys which you want to perform operations on Table:");
                int keys=sc.nextInt();
                if (keys==1){
                    doctorDao.descTable();
                } else if (keys==2) {
                    doctorDao.getAllData();
                } else if (keys==3) {
                    doctorDao.insertData();
                } else if (keys==4) {
                    doctorDao.updateData();
                } else if (keys==5) {
                    doctorDao.delete();
                } else if (keys==6) {
                    break;
                }
            } else if (Table_no==4) {
                System.out.println("-------------------MEDICINE TABLE---------------------------");
                MedicineDao medicineDao=new MedicineDao();
                System.out.println("1: Describe Table");
                System.out.println("2: Show All Data");
                System.out.println("3: Insert Data");
                System.out.println("4: Update Data");
                System.out.println("5: Delete");
                System.out.println("6: Exit");
                System.out.println("-----------------------------------------------");
                System.out.println("Enter the keys which you want to perform operations on Table:");
                int keys=sc.nextInt();
                if (keys==1){
                    medicineDao.descTable();
                } else if (keys==2) {
                    medicineDao.getAllData();
                } else if (keys==3) {
                    medicineDao.insertData();
                } else if (keys==4) {
                    medicineDao.updateData();
                } else if (keys==5) {
                    medicineDao.delete();
                } else if (keys==6) {
                    break;
                }
            } else if (Table_no==5) {
                System.out.println("-------------------PURCHASE TABLE---------------------------");
                PurchaseDao purchaseDao=new PurchaseDao();
                System.out.println("1: Describe Table");
                System.out.println("2: Show All Data");
                System.out.println("3: Insert Data");
                System.out.println("4: Update Data");
                System.out.println("5: Delete");
                System.out.println("6: Exit");
                System.out.println("-----------------------------------------------");
                System.out.println("Enter the keys which you want to perform operations on Table:");
                int keys=sc.nextInt();
                if (keys==1){
                    purchaseDao.descTable();
                } else if (keys==2) {
                    purchaseDao.getAllData();
                } else if (keys==3) {
                    purchaseDao.insertData();
                } else if (keys==4) {
                    purchaseDao.updateData();
                } else if (keys==5) {
                    purchaseDao.delete();
                } else if (keys==6) {
                    break;
                }
            } else if (Table_no==6) {
                System.out.println("-------------------R1_SEARCH TABLE---------------------------");
                R1_searchDao r1SearchDao=new R1_searchDao();
                System.out.println("1: Describe Table");
                System.out.println("2: Show All Data");
                System.out.println("3: Insert Data");
                System.out.println("4: Update Data");
                System.out.println("5: Delete");
                System.out.println("6: Exit");
                System.out.println("-----------------------------------------------");
                System.out.println("Enter the keys which you want to perform operations on Table:");
                int keys=sc.nextInt();
                if (keys==1){
                    r1SearchDao.descTable();
                } else if (keys==2) {
                    r1SearchDao.getAllData();
                } else if (keys==3) {
                    r1SearchDao.insertData();
                } else if (keys==4) {
                    r1SearchDao.updateData();
                } else if (keys==5) {
                    r1SearchDao.deleteData();
                } else if (keys==6) {
                    break;
                }
            } else if (Table_no==7) {
                System.out.println("-------------------R2_HAS TABLE---------------------------");
                R2_hasDao r2HasDao=new R2_hasDao();
                System.out.println("1: Describe Table");
                System.out.println("2: Show All Data");
                System.out.println("3: Insert Data");
                System.out.println("4: Update Data");
                System.out.println("5: Delete");
                System.out.println("6: Exit");
                System.out.println("-----------------------------------------------");
                System.out.println("Enter the keys which you want to perform operations on Table:");
                int keys=sc.nextInt();
                if (keys==1){
                    r2HasDao.descTable();
                } else if (keys==2) {
                    r2HasDao.getAllData();
                } else if (keys==3) {
                    r2HasDao.insertData();
                } else if (keys==4) {
                    r2HasDao.updateData();
                } else if (keys==5) {
                    r2HasDao.deleteData();
                } else if (keys==6) {
                    break;
                }
            } else if (Table_no==8) {
                System.out.println("-------------------R3_HAS TABLE---------------------------");
                R3_hasDao r3HasDao=new R3_hasDao();
                System.out.println("1: Describe Table");
                System.out.println("2: Show All Data");
                System.out.println("3: Insert Data");
                System.out.println("4: Update Data");
                System.out.println("5: Delete");
                System.out.println("6: Exit");
                System.out.println("-----------------------------------------------");
                System.out.println("Enter the keys which you want to perform operations on Table:");
                int keys=sc.nextInt();
                if (keys==1){
                    r3HasDao.descTable();
                } else if (keys==2) {
                    r3HasDao.getAllData();
                } else if (keys==3) {
                    r3HasDao.insertData();
                } else if (keys==4) {
                    r3HasDao.updateData();
                } else if (keys==5) {
                    r3HasDao.deleteData();
                } else if (keys==6) {
                    break;
                }
            } else if (Table_no==9) {
                System.out.println("-------------------R4_HAS TABLE---------------------------");
                R4_hasDao r4HasDao=new R4_hasDao();
                System.out.println("1: Describe Table");
                System.out.println("2: Show All Data");
                System.out.println("3: Insert Data");
                System.out.println("4: Update Data");
                System.out.println("5: Delete");
                System.out.println("6: Exit");
                System.out.println("-----------------------------------------------");
                System.out.println("Enter the keys which you want to perform operations on Table:");
                int keys=sc.nextInt();
                if (keys==1){
                    r4HasDao.descTable();
                } else if (keys==2) {
                    r4HasDao.getAllData();
                } else if (keys==3) {
                    r4HasDao.insertData();
                } else if (keys==4) {
                    r4HasDao.updateData();
                } else if (keys==5) {
                    r4HasDao.deleteData();
                } else if (keys==6) {
                    break;
                }
            } else if (Table_no==11) {
                System.out.println("-------------------R6_REFERRED TABLE---------------------------");
                R6_referredDao r6ReferredDao=new R6_referredDao();
                System.out.println("1: Describe Table");
                System.out.println("2: Show All Data");
                System.out.println("3: Insert Data");
                System.out.println("4: Update Data");
                System.out.println("5: Delete");
                System.out.println("6: Exit");
                System.out.println("-----------------------------------------------");
                System.out.println("Enter the keys which you want to perform operations on Table:");
                int keys=sc.nextInt();
                if (keys==1){
                    r6ReferredDao.descTable();
                } else if (keys==2) {
                    r6ReferredDao.getAllData();
                } else if (keys==3) {
                    r6ReferredDao.insertData();
                } else if (keys==4) {
                    r6ReferredDao.updateData();
                } else if (keys==5) {
                    r6ReferredDao.deleteData();
                } else if (keys==6) {
                    break;
                }
            } else if (Table_no==10) {
                System.out.println("-------------------R5_SUPPLY TABLE---------------------------");
                R5_supplyDao r5SupplyDao=new R5_supplyDao();
                System.out.println("1: Describe Table");
                System.out.println("2: Show All Data");
                System.out.println("3: Insert Data");
                System.out.println("4: Update Data");
                System.out.println("5: Delete");
                System.out.println("6: Exit");
                System.out.println("-----------------------------------------------");
                System.out.println("Enter the keys which you want to perform operations on Table:");
                int keys=sc.nextInt();
                if (keys==1){
                    r5SupplyDao.descTable();
                } else if (keys==2) {
                    r5SupplyDao.getAllData();
                } else if (keys==3) {
                    r5SupplyDao.insertData();
                } else if (keys==4) {
                    r5SupplyDao.updateData();
                } else if (keys==5) {
                    r5SupplyDao.deleteData();
                } else if (keys==6) {
                    break;
                }
            } else if (Table_no==12) {
                System.out.println("-------------------SUPPLIER TABLE---------------------------");
                SupplierDao supplierDao=new SupplierDao();
                System.out.println("1: Describe Table");
                System.out.println("2: Show All Data");
                System.out.println("3: Insert Data");
                System.out.println("4: Update Data");
                System.out.println("5: Delete");
                System.out.println("6: Exit");
                System.out.println("-----------------------------------------------");
                System.out.println("Enter the keys which you want to perform operations on Table:");
                int keys=sc.nextInt();
                if (keys==1){
                    supplierDao.descTable();
                } else if (keys==2) {
                    supplierDao.getAllData();
                } else if (keys==3) {
                    supplierDao.insertData();
                } else if (keys==4) {
                    supplierDao.updateData();
                } else if (keys==5) {
                    supplierDao.delete();
                } else if (keys==6) {
                    break;
                }
            } else if (Table_no==13) {
                System.out.println("-------------------USER REGISTRATION TABLE---------------------------");
                User_RegisterationDao userRegisterationDao=new User_RegisterationDao();
                System.out.println("1: Describe Table");
                System.out.println("2: Show All Data");
                System.out.println("3: Insert Data");
                System.out.println("4: Update Data");
                System.out.println("5: Delete");
                System.out.println("6: Exit");
                System.out.println("-----------------------------------------------");
                System.out.println("Enter the keys which you want to perform operations on Table:");
                int keys=sc.nextInt();
                if (keys==1){
                    userRegisterationDao.descTable();
                } else if (keys==2) {
                    userRegisterationDao.getAllData();
                } else if (keys==3) {
                    userRegisterationDao.insertData();
                } else if (keys==4) {
                    userRegisterationDao.updateData();
                } else if (keys==5) {
                    userRegisterationDao.delete();
                } else if (keys==6) {
                    break;
                }
            } else if (Table_no==14) {
                break;
            }
        }

    }
}
