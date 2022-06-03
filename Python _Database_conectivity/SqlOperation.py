import mysql.connector
import mysql.connector as c


class MyProject:
    def __init__(self):
        self.con = c.connect(host="localhost", user="root", passwd="vishal9743", database="online_pharamacy",
                             auth_plugin='vishal9743')
        query1 = 'show tables'
        cur = self.con.cursor()
        cur.execute(query1)
        list = []
        for row in cur:
            list.append(row)
        print(list)
        print()

             ######TABLE USER_REGISTRATION########

    def DescribeTable(self):
        try:
            query="desc user_registration"
            print(query)
            cur=self.con.cursor()
            cur.execute(query)
            for row in cur:
                print(row)
            print()
        except mysql.connector.Error as error:
            print("Failed to describe table mysql {}".format(error))
        finally:
            if(self.con.is_connected()):
                cur.close()
                self.con.close()
                print("Connection is sucessfully closed")
            print()

    def ReadTable(self):
        try:
            query="select * from user_registration"
            print(query)
            cur=self.con.cursor()
            cur.execute(query)
            for row in cur:
                print("S_number",":",row[0])
                print("Id",":",row[1])
                print("Name",":",row[2])
                print("Gender",":",row[3])
                print("Password",":",row[4])
                print("Phone_no",":",row[5])
                print("Age",":",row[6])
                print("E_mail",":",row[7])
                print()
            print("Read table successfully")

        except mysql.connector.Error as error:
            print("Failed to read".format(error))
        finally:
            if(self.con.is_connected()):
                cur.close()
                self.con.close()
                print("Conection is being closed")



    def Insert(self,s_no,id,name,gender,password,ph_no,age,E_mail):
        try:
            query="insert into user_registration(s_no,id,name,gender,password,ph_no,age,E_mail) values({},{},'{}','{}','{}','{}',{},'{}')".format(
                s_no,id,name,gender,password,ph_no,age,E_mail)
            print(query)
            cur=self.con.cursor()
            cur.execute(query)
            self.con.commit()
            print("Data inserted successfully into database")
            print()
        except mysql.connector.Error as error:
            print("failed to insert value mysql {}".format(error))
        finally:
            if(self.con.is_connected()):
                cur.close()
                self.con.close()
                print("mysql connection is closed")
                print()

    def Delete(self,s_no):
        try:
            query="delete from user_registration where s_no={}".format(s_no)
            print(query)
            cur=self.con.cursor()
            cur.execute(query)
            self.con.commit()
            print("Data deleted successfully from database")
        except mysql.connector.Error as error:
            print("Failed to delete value mysql {}".format(error))
        finally:
            if(self.con.is_connected()):
                cur.close()
                self.con.close()
                print("mysql connection is closed")
                print()

    def Update(self,s_no,id,name,gender,password,ph_no,age,E_mail):
        try:
            query="update user_registration set id={},name='{}',gender='{}',password='{}',ph_no='{}',age={},E_mail='{}' where s_no={}".format(id,name,gender,password,ph_no,age,E_mail,s_no)
            print(query)
            cur=self.con.cursor()
            cur.execute(query)
            self.con.commit()
            print("Data successfully updated in the databases")
        except mysql.connector.Error as error:
            print("Failed to update value mysql {}".format(error))
        finally:
            if(self.con.is_connected()):
                cur.close()
                self.con.close()
                print("mysql connection is closed")
                print()

                ###############MEDICINE TABLE##############

    def DescribeTable1(self):
        try:
            query="desc medicine"
            print(query)
            cur=self.con.cursor()
            cur.execute(query)
            for row in cur:
                print(row)
            print()
        except mysql.connector.Error as error:
            print("Failed to describe table mysql {}".format(error))
        finally:
            if(self.con.is_connected()):
                cur.close()
                self.con.close()
                print("Connection is successfully closed")
            print()

    def ReadTable1(self):
        try:
            query="select * from medicine"
            print(query)
            cur=self.con.cursor()
            cur.execute(query)
            for row in cur:
                print("M_number",":",row[0])
                print("Name",":",row[1])
                print("M_id",":",row[2])
                print("Amount",":",row[3])
                print("Expiry",":",row[4])
                print("Manufacture",":",row[5])
                print("Purpose",":",row[6])
                print()
            print("Read table successfully")

        except mysql.connector.Error as error:
            print("Failed to read".format(error))
        finally:
            if(self.con.is_connected()):
                cur.close()
                self.con.close()
                print("Connection is being closed")

    def Insert1(self,m_no,name,m_id,amount,expiry,manufacture,purpose):
        try:
            query="insert into medicine(m_no,name,m_id,amount,expiry,manufacture,purpose) values({},'{}','{}',{},'{}','{}','{}')".format(
                m_no,name,m_id,amount,expiry,manufacture,purpose)
            print(query)
            cur=self.con.cursor()
            cur.execute(query)
            self.con.commit()
            print("Data inserted successfully into database")
            print()
        except mysql.connector.Error as error:
            print("failed to insert value mysql {}".format(error))
        finally:
            if(self.con.is_connected()):
                cur.close()
                self.con.close()
                print("mysql connection is closed")
                print()

    def Delete1(self,m_no):
        try:
            query="delete from medicine where m_no={}".format(m_no)
            print(query)
            cur=self.con.cursor()
            cur.execute(query)
            self.con.commit()
            print("Data deleted successfully from database")
        except mysql.connector.Error as error:
            print("Failed to delete value mysql {}".format(error))
        finally:
            if(self.con.is_connected()):
                cur.close()
                self.con.close()
                print("mysql connection is closed")
                print()

    def Update1(self,m_no,name,m_id,amount,expiry,manufactury,purpose):
        try:
            query="update medicine set name='{}',m_id='{}',amount={},expiry='{}',manufacture='{}',purpose='{}' where m_no={}".format(name,m_id,amount,expiry,manufactury,purpose,m_no)
            print(query)
            cur=self.con.cursor()
            cur.execute(query)
            self.con.commit()
            print("Data successfully updated in the databases")
        except mysql.connector.Error as error:
            print("Failed to update value mysql {}".format(error))
        finally:
            if(self.con.is_connected()):
                cur.close()
                self.con.close()
                print("mysql connection is closed")
                print()

                #############PURCHASE TABLE##########

    def DescribeTable2(self):
        try:
            query="desc purchase"
            print(query)
            cur=self.con.cursor()
            cur.execute(query)
            for row in cur:
                print(row)
            print()
        except mysql.connector.Error as error:
            print("Failed to describe table mysql {}".format(error))
        finally:
            if(self.con.is_connected()):
                cur.close()
                self.con.close()
                print("Connection is sucessfully closed")
            print()

    def ReadTable2(self):
        try:
            query="select * from purchase"
            print(query)
            cur=self.con.cursor()
            cur.execute(query)
            for row in cur:
                print("P_number",":",row[0])
                print("Pur_number",":",row[1])
                print("amount",":",row[2])
                print("Discount",":",row[3])
                print("Total_amount",":",row[4])
                print()
            print("Read table successfully")

        except mysql.connector.Error as error:
            print("Failed to read".format(error))
        finally:
            if(self.con.is_connected()):
                cur.close()
                self.con.close()
                print("Conection is being closed")


    def Insert2(self,p_num,pur_no,amount,discount,total_amount):
        try:
            query="insert into purchase(p_num,pur_no,amount,discount,total_amount) values({},'{}',{},{},{})".format(
                p_num,pur_no,amount,discount,total_amount)
            print(query)
            cur=self.con.cursor()
            cur.execute(query)
            self.con.commit()
            print("Data inserted successfully into database")
            print()
        except mysql.connector.Error as error:
            print("failed to insert value mysql {}".format(error))
        finally:
            if(self.con.is_connected()):
                cur.close()
                self.con.close()
                print("mysql connection is closed")
                print()
    def Delete2(self,p_num):
        try:
            query="delete from purchase where p_num={}".format(p_num)
            print(query)
            cur=self.con.cursor()
            cur.execute(query)
            self.con.commit()
            print("Data deleted successfully from database")
        except mysql.connector.Error as error:
            print("Failed to delete value mysql {}".format(error))
        finally:
            if(self.con.is_connected()):
                cur.close()
                self.con.close()
                print("mysql connection is closed")
                print()
    def Update2(self,p_num,pur_no,amount,discount,total_amount):
        try:
            query="update purchase set pur_no='{}',amount={},discount={},total_amount={} where p_num={}".format(pur_no,amount,discount,total_amount,p_num)
            print(query)
            cur=self.con.cursor()
            cur.execute(query)
            self.con.commit()
            print("Data successfully updated in the databases")
        except mysql.connector.Error as error:
            print("Failed to update value mysql {}".format(error))
        finally:
            if(self.con.is_connected()):
                cur.close()
                self.con.close()
                print("mysql connection is closed")
                print()

           ########DOCTOR TABLE############


    def DescribeTable3(self):
        try:
            query="desc doctor"
            print(query)
            cur=self.con.cursor()
            cur.execute(query)
            for row in cur:
                print(row)
            print()
        except mysql.connector.Error as error:
            print("Failed to describe table mysql {}".format(error))
        finally:
            if(self.con.is_connected()):
                cur.close()
                self.con.close()
                print("Connection is sucessfully closed")
            print()

    def ReadTable3(self):
        try:
            query="select * from doctor"
            print(query)
            cur=self.con.cursor()
            cur.execute(query)
            for row in cur:
                print("D_number",":",row[0])
                print("Name",":",row[1])
                print("Specilyst",":",row[2])
                print("Phone_no",":",row[3])
                print("Address",":",row[4])
                print()
            print("Read table successfully")

        except mysql.connector.Error as error:
            print("Failed to read".format(error))
        finally:
            if(self.con.is_connected()):
                cur.close()
                self.con.close()
                print("Conection is being closed")


    def Insert3(self,d_num,name,specilyst,ph_no,address):
        try:
            query="insert into doctor(d_num,name,specilyst,ph_no,address) values({},'{}','{}','{}','{}')".format(
                d_num,name,specilyst,ph_no,address)
            print(query)
            cur=self.con.cursor()
            cur.execute(query)
            self.con.commit()
            print("Data inserted successfully into database")
            print()
        except mysql.connector.Error as error:
            print("failed to insert value mysql {}".format(error))
        finally:
            if(self.con.is_connected()):
                cur.close()
                self.con.close()
                print("mysql connection is closed")
                print()
    def Delete3(self,d_num):
        try:
            query="delete from doctor where d_num={}".format(d_num)
            print(query)
            cur=self.con.cursor()
            cur.execute(query)
            self.con.commit()
            print("Data deleted successfully from database")
        except mysql.connector.Error as error:
            print("Failed to delete value mysql {}".format(error))
        finally:
            if(self.con.is_connected()):
                cur.close()
                self.con.close()
                print("mysql connection is closed")
                print()
    def Update3(self,d_num,name,specilyst,ph_no,address):
        try:
            query="update doctor set name='{}',specilyst='{}',ph_no='{}',address='{}' where d_num={}".format(name,specilyst,ph_no,address,d_num)
            print(query)
            cur=self.con.cursor()
            cur.execute(query)
            self.con.commit()
            print("Data successfully updated in the databases")
        except mysql.connector.Error as error:
            print("Failed to update value mysql {}".format(error))
        finally:
            if(self.con.is_connected()):
                cur.close()
                self.con.close()
                print("mysql connection is closed")
                print()

         #######CANCELLATION TABLE########

    def DescribeTable4(self):
        try:
            query = "desc cancellation"
            print(query)
            cur = self.con.cursor()
            cur.execute(query)
            for row in cur:
                print(row)
            print()
        except mysql.connector.Error as error:
            print("Failed to describe table mysql {}".format(error))
        finally:
            if (self.con.is_connected()):
                cur.close()
                self.con.close()
                print("Connection is sucessfully closed")
            print()

    def ReadTable4(self):
        try:
            query = "select * from cancellation"
            print(query)
            cur = self.con.cursor()
            cur.execute(query)
            for row in cur:
                print("Order_no", ":", row[0])
                print("user_id", ":", row[1])
                print("Cancellation_no", ":", row[2])
                print()
            print("Read table successfully")

        except mysql.connector.Error as error:
            print("Failed to read".format(error))
        finally:
            if (self.con.is_connected()):
                cur.close()
                self.con.close()
                print("Conection is being closed")

    def Insert4(self, o_num, user_id, can_no,):
        try:
            query = "insert into cancellation(o_num,user_id,can_no) values({},{},'{}')".format(
                o_num, user_id, can_no)
            print(query)
            cur = self.con.cursor()
            cur.execute(query)
            self.con.commit()
            print("Data inserted successfully into database")
            print()
        except mysql.connector.Error as error:
            print("failed to insert value mysql {}".format(error))
        finally:
            if (self.con.is_connected()):
                cur.close()
                self.con.close()
                print("mysql connection is closed")
                print()

    def Delete4(self, o_num):
        try:
            query = "delete from cancellation where o_num={}".format(o_num)
            print(query)
            cur = self.con.cursor()
            cur.execute(query)
            self.con.commit()
            print("Data deleted successfully from database")
        except mysql.connector.Error as error:
            print("Failed to delete value mysql {}".format(error))
        finally:
            if (self.con.is_connected()):
                cur.close()
                self.con.close()
                print("mysql connection is closed")
                print()

    def Update4(self, o_num, user_id, can_no):
        try:
            query = "update cancellation set user_id={},can_no='{}' where o_num={}".format(user_id,can_no,o_num)
            print(query)
            cur = self.con.cursor()
            cur.execute(query)
            self.con.commit()
            print("Data successfully updated in the databases")
        except mysql.connector.Error as error:
            print("Failed to update value mysql {}".format(error))
        finally:
            if (self.con.is_connected()):
                cur.close()
                self.con.close()
                print("mysql connection is closed")
                print()

                    #######BILLING TABLE#########

    def DescribeTable5(self):
        try:
            query = "desc billing"
            print(query)
            cur = self.con.cursor()
            cur.execute(query)
            for row in cur:
                print(row)
            print()
        except mysql.connector.Error as error:
            print("Failed to describe table mysql {}".format(error))
        finally:
            if (self.con.is_connected()):
                cur.close()
                self.con.close()
                print("Connection is sucessfully closed")
            print()

    def ReadTable5(self):
        try:
            query = "select * from billing"
            print(query)
            cur = self.con.cursor()
            cur.execute(query)
            for row in cur:
                print("Bill_no", ":", row[0])
                print("Order_no", ":", row[1])
                print("Total_amt", ":", row[2])
                print()
            print("Read table successfully")

        except mysql.connector.Error as error:
            print("Failed to read".format(error))
        finally:
            if (self.con.is_connected()):
                cur.close()
                self.con.close()
                print("Conection is being closed")

    def Insert5(self, bill_no, ord_no, total_amt):
        try:
            query = "insert into billing(bill_no,ord_no,total_amt) values({},'{}',{})".format(
                bill_no, ord_no, total_amt)
            print(query)
            cur = self.con.cursor()
            cur.execute(query)
            self.con.commit()
            print("Data inserted successfully into database")
            print()
        except mysql.connector.Error as error:
            print("failed to insert value mysql {}".format(error))
        finally:
            if (self.con.is_connected()):
                cur.close()
                self.con.close()
                print("mysql connection is closed")
                print()

    def Delete5(self, bill_no):
        try:
            query = "delete from billing where bill_no={}".format(bill_no)
            print(query)
            cur = self.con.cursor()
            cur.execute(query)
            self.con.commit()
            print("Data deleted successfully from database")
        except mysql.connector.Error as error:
            print("Failed to delete value mysql {}".format(error))
        finally:
            if (self.con.is_connected()):
                cur.close()
                self.con.close()
                print("mysql connection is closed")
                print()

    def Update5(self, bill_no, ord_no, total_amt):
        try:
            query = "update billing set ord_no='{}',total_amt={} where bill_no={}".format(ord_no, total_amt, bill_no)
            print(query)
            cur = self.con.cursor()
            cur.execute(query)
            self.con.commit()
            print("Data successfully updated in the databases")
        except mysql.connector.Error as error:
            print("Failed to update value mysql {}".format(error))
        finally:
            if (self.con.is_connected()):
                cur.close()
                self.con.close()
                print("mysql connection is closed")
                print()

            #######SUPPLIER TABLE#########

    def DescribeTable6(self):
        try:
            query = "desc supplier"
            print(query)
            cur = self.con.cursor()
            cur.execute(query)
            for row in cur:
                print(row)
            print()
        except mysql.connector.Error as error:
            print("Failed to describe table mysql {}".format(error))
        finally:
            if (self.con.is_connected()):
                cur.close()
                self.con.close()
                print("Connection is sucessfully closed")
            print()

    def ReadTable6(self):
        try:
            query = "select * from supplier"
            print(query)
            cur = self.con.cursor()
            cur.execute(query)
            for row in cur:
                print("S_code", ":", row[0])
                print("S_num", ":", row[1])
                print("Name", ":", row[2])
                print("E_mail", ":", row[3])
                print("Ph_no", ":", row[4])
                print()
            print("Read table successfully")

        except mysql.connector.Error as error:
            print("Failed to read".format(error))
        finally:
            if (self.con.is_connected()):
                cur.close()
                self.con.close()
                print("Conection is being closed")

    def Insert6(self, s_code, s_num, name,E_mail,ph_no):
        try:
            query = "insert into supplier(s_code,s_num,name,E_mail,ph_no) values('{}','{}','{}','{}','{}')".format(
                s_code, s_num, name,E_mail,ph_no)
            print(query)
            cur = self.con.cursor()
            cur.execute(query)
            self.con.commit()
            print("Data inserted successfully into database")
            print()
        except mysql.connector.Error as error:
            print("failed to insert value mysql {}".format(error))
        finally:
            if (self.con.is_connected()):
                cur.close()
                self.con.close()
                print("mysql connection is closed")
                print()

    def Delete6(self, s_code):
        try:
            query = "delete from supplier where s_code='{}'".format(s_code)
            print(query)
            cur = self.con.cursor()
            cur.execute(query)
            self.con.commit()
            print("Data deleted successfully from database")
        except mysql.connector.Error as error:
            print("Failed to delete value mysql {}".format(error))
        finally:
            if (self.con.is_connected()):
                cur.close()
                self.con.close()
                print("mysql connection is closed")
                print()

    def Update6(self, s_code, s_num, name,E_mail,ph_no):
        try:
            query = "update supplier set s_num='{}',name='{}',E_mail='{}',ph_no='{}' where s_code='{}'".format(s_num,name,E_mail,ph_no,s_code)
            print(query)
            cur = self.con.cursor()
            cur.execute(query)
            self.con.commit()
            print("Data successfully updated in the databases")
        except mysql.connector.Error as error:
            print("Failed to update value mysql {}".format(error))
        finally:
            if (self.con.is_connected()):
                cur.close()
                self.con.close()
                print("mysql connection is closed")
                print()

                      ######R1_SEARCH TABLE##############

    def DescribeTable7(self):
        try:
            query = "desc  R1_Search"
            print(query)
            cur = self.con.cursor()
            cur.execute(query)
            for row in cur:
                print(row)
            print()
        except mysql.connector.Error as error:
            print("Failed to describe table mysql {}".format(error))
        finally:
            if (self.con.is_connected()):
                cur.close()
                self.con.close()
                print("Connection is sucessfully closed")
            print()

    def ReadTable7(self):
        try:
            query = "select * from  R1_Search"
            print(query)
            cur = self.con.cursor()
            cur.execute(query)
            for row in cur:
                print("Id", ":", row[0])
                print("M_id", ":", row[1])
                print()
            print("Read table successfully")

        except mysql.connector.Error as error:
            print("Failed to read".format(error))
        finally:
            if (self.con.is_connected()):
                cur.close()
                self.con.close()
                print("Conection is being closed")

    def Insert7(self, id, M_id):
        try:
            query = "insert into  R1_Search(id,M_id) values({},'{}')".format(
                id,M_id)
            print(query)
            cur = self.con.cursor()
            cur.execute(query)
            self.con.commit()
            print("Data inserted successfully into database")
            print()
        except mysql.connector.Error as error:
            print("failed to insert value mysql {}".format(error))
        finally:
            if (self.con.is_connected()):
                cur.close()
                self.con.close()
                print("mysql connection is closed")
                print()

    def Delete7(self, id):
        try:
            query = "delete from  R1_Search where id={}".format(id)
            print(query)
            cur = self.con.cursor()
            cur.execute(query)
            self.con.commit()
            print("Data deleted successfully from database")
        except mysql.connector.Error as error:
            print("Failed to delete value mysql {}".format(error))
        finally:
            if (self.con.is_connected()):
                cur.close()
                self.con.close()
                print("mysql connection is closed")
                print()

    def Update7(self, id,M_id):
        try:
            query = "update  R1_Search set M_id='{}' where id={}".format(M_id,id)
            print(query)
            cur = self.con.cursor()
            cur.execute(query)
            self.con.commit()
            print("Data successfully updated in the databases")
        except mysql.connector.Error as error:
            print("Failed to update value mysql {}".format(error))
        finally:
            if (self.con.is_connected()):
                cur.close()
                self.con.close()
                print("mysql connection is closed")
                print()

            ##########R2_HAS TABLE###########

    def DescribeTable8(self):
        try:
            query = "desc  R2_Has"
            print(query)
            cur = self.con.cursor()
            cur.execute(query)
            for row in cur:
                print(row)
            print()
        except mysql.connector.Error as error:
            print("Failed to describe table mysql {}".format(error))
        finally:
            if (self.con.is_connected()):
                cur.close()
                self.con.close()
                print("Connection is sucessfully closed")
            print()

    def ReadTable8(self):
        try:
            query = "select * from  R2_Has"
            print(query)
            cur = self.con.cursor()
            cur.execute(query)
            for row in cur:
                print("pur_no", ":", row[0])
                print("M_id", ":", row[1])
                print()
            print("Read table successfully")

        except mysql.connector.Error as error:
            print("Failed to read".format(error))
        finally:
            if (self.con.is_connected()):
                cur.close()
                self.con.close()
                print("Conection is being closed")

    def Insert8(self, pur_no, m_id):
        try:
            query = "insert into  R2_Has(pur_no,m_id) values('{}','{}')".format(
                pur_no,m_id)
            print(query)
            cur = self.con.cursor()
            cur.execute(query)
            self.con.commit()
            print("Data inserted successfully into database")
            print()
        except mysql.connector.Error as error:
            print("failed to insert value mysql {}".format(error))
        finally:
            if (self.con.is_connected()):
                cur.close()
                self.con.close()
                print("mysql connection is closed")
                print()

    def Delete8(self, pur_no):
        try:
            query = "delete from  R2_Has where pur_no='{}'".format(pur_no)
            print(query)
            cur = self.con.cursor()
            cur.execute(query)
            self.con.commit()
            print("Data deleted successfully from database")
        except mysql.connector.Error as error:
            print("Failed to delete value mysql {}".format(error))
        finally:
            if (self.con.is_connected()):
                cur.close()
                self.con.close()
                print("mysql connection is closed")
                print()

    def Update8(self, pur_no,m_id):
        try:
            query = "update  R2_Has set m_id='{}' where pur_no='{}'".format(m_id,pur_no)
            print(query)
            cur = self.con.cursor()
            cur.execute(query)
            self.con.commit()
            print("Data successfully updated in the databases")
        except mysql.connector.Error as error:
            print("Failed to update value mysql {}".format(error))
        finally:
            if (self.con.is_connected()):
                cur.close()
                self.con.close()
                print("mysql connection is closed")
                print()


            ##############R3_Has TABLE##################

    def DescribeTable9(self):
        try:
            query = "desc  R3_Has"
            print(query)
            cur = self.con.cursor()
            cur.execute(query)
            for row in cur:
                print(row)
            print()
        except mysql.connector.Error as error:
            print("Failed to describe table mysql {}".format(error))
        finally:
            if (self.con.is_connected()):
                cur.close()
                self.con.close()
                print("Connection is sucessfully closed")
            print()

    def ReadTable9(self):
        try:
            query = "select * from  R3_Has"
            print(query)
            cur = self.con.cursor()
            cur.execute(query)
            for row in cur:
                print("pur_no", ":", row[0])
                print("Can_no", ":", row[1])
                print()
            print("Read table successfully")

        except mysql.connector.Error as error:
            print("Failed to read".format(error))
        finally:
            if (self.con.is_connected()):
                cur.close()
                self.con.close()
                print("Conection is being closed")

    def Insert9(self, pur_no, can_no):
        try:
            query = "insert into  R3_Has(pur_no,can_no) values('{}','{}')".format(
                pur_no,can_no)
            print(query)
            cur = self.con.cursor()
            cur.execute(query)
            self.con.commit()
            print("Data inserted successfully into database")
            print()
        except mysql.connector.Error as error:
            print("failed to insert value mysql {}".format(error))
        finally:
            if (self.con.is_connected()):
                cur.close()
                self.con.close()
                print("mysql connection is closed")
                print()

    def Delete9(self, pur_no):
        try:
            query = "delete from  R3_Has where pur_no='{}'".format(pur_no)
            print(query)
            cur = self.con.cursor()
            cur.execute(query)
            self.con.commit()
            print("Data deleted successfully from database")
        except mysql.connector.Error as error:
            print("Failed to delete value mysql {}".format(error))
        finally:
            if (self.con.is_connected()):
                cur.close()
                self.con.close()
                print("mysql connection is closed")
                print()

    def Update9(self, pur_no,can_no):
        try:
            query = "update  R3_Has set can_no='{}' where pur_no='{}'".format(can_no,pur_no)
            print(query)
            cur = self.con.cursor()
            cur.execute(query)
            self.con.commit()
            print("Data successfully updated in the databases")
        except mysql.connector.Error as error:
            print("Failed to update value mysql {}".format(error))
        finally:
            if (self.con.is_connected()):
                cur.close()
                self.con.close()
                print("mysql connection is closed")
                print()

          ##############R4_HAS TABLE#############

    def DescribeTable10(self):
        try:
            query = "desc  R4_Has"
            print(query)
            cur = self.con.cursor()
            cur.execute(query)
            for row in cur:
                print(row)
            print()
        except mysql.connector.Error as error:
            print("Failed to describe table mysql {}".format(error))
        finally:
            if (self.con.is_connected()):
                cur.close()
                self.con.close()
                print("Connection is sucessfully closed")
            print()

    def ReadTable10(self):
        try:
            query = "select * from  R4_Has"
            print(query)
            cur = self.con.cursor()
            cur.execute(query)
            for row in cur:
                print("pur_no", ":", row[0])
                print("Order_no", ":", row[1])
                print()
            print("Read table successfully")

        except mysql.connector.Error as error:
            print("Failed to read".format(error))
        finally:
            if (self.con.is_connected()):
                cur.close()
                self.con.close()
                print("Conection is being closed")

    def Insert10(self, pur_no, ord_no):
        try:
            query = "insert into  R4_Has(pur_no,ord_no) values('{}','{}')".format(
                pur_no, ord_no)
            print(query)
            cur = self.con.cursor()
            cur.execute(query)
            self.con.commit()
            print("Data inserted successfully into database")
            print()
        except mysql.connector.Error as error:
            print("failed to insert value mysql {}".format(error))
        finally:
            if (self.con.is_connected()):
                cur.close()
                self.con.close()
                print("mysql connection is closed")
                print()

    def Delete10(self, pur_no):
        try:
            query = "delete from  R4_Has where pur_no='{}'".format(pur_no)
            print(query)
            cur = self.con.cursor()
            cur.execute(query)
            self.con.commit()
            print("Data deleted successfully from database")
        except mysql.connector.Error as error:
            print("Failed to delete value mysql {}".format(error))
        finally:
            if (self.con.is_connected()):
                cur.close()
                self.con.close()
                print("mysql connection is closed")
                print()

    def Update10(self, pur_no, ord_no):
        try:
            query = "update  R4_Has set ord_no='{}' where pur_no='{}'".format(ord_no, pur_no)
            print(query)
            cur = self.con.cursor()
            cur.execute(query)
            self.con.commit()
            print("Data successfully updated in the databases")
        except mysql.connector.Error as error:
            print("Failed to update value mysql {}".format(error))
        finally:
            if (self.con.is_connected()):
                cur.close()
                self.con.close()
                print("mysql connection is closed")
                print()

          ###########R5_Supply TABLE##############

    def DescribeTable11(self):
        try:
            query = "desc  R5_Supply"
            print(query)
            cur = self.con.cursor()
            cur.execute(query)
            for row in cur:
                print(row)
            print()
        except mysql.connector.Error as error:
            print("Failed to describe table mysql {}".format(error))
        finally:
            if (self.con.is_connected()):
                cur.close()
                self.con.close()
                print("Connection is sucessfully closed")
            print()

    def ReadTable11(self):
        try:
            query = "select * from  R5_Supply"
            print(query)
            cur = self.con.cursor()
            cur.execute(query)
            for row in cur:
                print("O_number", ":", row[0])
                print("S_code", ":", row[1])
                print()
            print("Read table successfully")

        except mysql.connector.Error as error:
            print("Failed to read".format(error))
        finally:
            if (self.con.is_connected()):
                cur.close()
                self.con.close()
                print("Conection is being closed")

    def Insert11(self, o_no, s_code):
        try:
            query = "insert into  R5_Supply(o_no,s_code) values('{}','{}')".format(
                o_no, s_code)
            print(query)
            cur = self.con.cursor()
            cur.execute(query)
            self.con.commit()
            print("Data inserted successfully into database")
            print()
        except mysql.connector.Error as error:
            print("failed to insert value mysql {}".format(error))
        finally:
            if (self.con.is_connected()):
                cur.close()
                self.con.close()
                print("mysql connection is closed")
                print()

    def Delete11(self, o_no):
        try:
            query = "delete from  R5_Supply where o_no='{}'".format(o_no)
            print(query)
            cur = self.con.cursor()
            cur.execute(query)
            self.con.commit()
            print("Data deleted successfully from database")
        except mysql.connector.Error as error:
            print("Failed to delete value mysql {}".format(error))
        finally:
            if (self.con.is_connected()):
                cur.close()
                self.con.close()
                print("mysql connection is closed")
                print()

    def Update11(self, o_no, s_code):
        try:
            query = "update  R5_Supply set s_code='{}' where o_no='{}'".format(s_code, o_no)
            print(query)
            cur = self.con.cursor()
            cur.execute(query)
            self.con.commit()
            print("Data successfully updated in the databases")
        except mysql.connector.Error as error:
            print("Failed to update value mysql {}".format(error))
        finally:
            if (self.con.is_connected()):
                cur.close()
                self.con.close()
                print("mysql connection is closed")
                print()

                 ###########R6_Referred TABLE#############

    def DescribeTable12(self):
        try:
            query = "desc  R6_Referred"
            print(query)
            cur = self.con.cursor()
            cur.execute(query)
            for row in cur:
                print(row)
            print()
        except mysql.connector.Error as error:
            print("Failed to describe table mysql {}".format(error))
        finally:
            if (self.con.is_connected()):
                cur.close()
                self.con.close()
                print("Connection is sucessfully closed")
            print()

    def ReadTable12(self):
        try:
            query = "select * from  R6_Referred"
            print(query)
            cur = self.con.cursor()
            cur.execute(query)
            for row in cur:
                print("M_id", ":", row[0])
                print("D_num", ":", row[1])
                print()
            print("Read table successfully")

        except mysql.connector.Error as error:
            print("Failed to read".format(error))
        finally:
            if (self.con.is_connected()):
                cur.close()
                self.con.close()
                print("Conection is being closed")

    def Insert12(self, m_id, d_num):
        try:
            query = "insert into  R6_Referred(m_id,d_num) values('{}',{})".format(
                m_id, d_num)
            print(query)
            cur = self.con.cursor()
            cur.execute(query)
            self.con.commit()
            print("Data inserted successfully into database")
            print()
        except mysql.connector.Error as error:
            print("failed to insert value mysql {}".format(error))
        finally:
            if (self.con.is_connected()):
                cur.close()
                self.con.close()
                print("mysql connection is closed")
                print()

    def Delete12(self, m_id):
        try:
            query = "delete from  R6_Referred where m_id='{}'".format(m_id)
            print(query)
            cur = self.con.cursor()
            cur.execute(query)
            self.con.commit()
            print("Data deleted successfully from database")
        except mysql.connector.Error as error:
            print("Failed to delete value mysql {}".format(error))
        finally:
            if (self.con.is_connected()):
                cur.close()
                self.con.close()
                print("mysql connection is closed")
                print()

    def Update12(self, m_id, d_num):
        try:
            query = "update  R6_Referred set d_num={} where m_id='{}'".format(d_num, m_id)
            print(query)
            cur = self.con.cursor()
            cur.execute(query)
            self.con.commit()
            print("Data successfully updated in the databases")
        except mysql.connector.Error as error:
            print("Failed to update value mysql {}".format(error))
        finally:
            if (self.con.is_connected()):
                cur.close()
                self.con.close()
                print("mysql connection is closed")
                print()
