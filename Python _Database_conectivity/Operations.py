import mysql

from SqlOperation import MyProject


def Main():

    while (True):
     #   print("***********All TABLES OF THIS DATABASE*************")
        Object=MyProject()
        print()
        table = int(input('plz enter the table number which you want to perform operation: '))
        if (table == 12):

            print('press 1 to describe table:')
            print('press 2 to insert new user')
            print('press 3 to display all user')
            print('press 4 to delete user')
            print('press 5 to update user')
            print('press 6 to quit')
            print()
            print()
            choice = int(input('enter the choice:'))
            try:
                if(choice==1):
                    Object.DescribeTable()
                    pass
                elif(choice==2):
                    s_no=int(input("enter the new serial number to be inserted:"))
                    id=int(input(("enter the new id to be inserted:")))
                    name=input("enter the new name to be inserted:")
                    gender=input("enter the your gender:")
                    password=input("enter the password:")
                    ph_no=input("enter your phone number:")
                    age=int(input("enter your age:"))
                    E_mail=input("enter your new email:")
                    Object.Insert(s_no,id,name,gender,password,ph_no,age,E_mail)
                    pass
                elif(choice==3):
                    Object.ReadTable()
                    pass
                elif(choice==4):
                    s_no=int(input("enter the serial number which you want to delete:"))
                    Object.Delete(s_no)
                    pass
                elif(choice==5):
                    s_no = int(input("enter the serial number to be updated:"))
                    id = int(input(("enter the new id to be updated:")))
                    name = input("enter the new name to be updated:")
                    gender = input("enter the your gender:")
                    password = input("enter the password:")
                    ph_no = input("enter your phone number:")
                    age = int(input("enter your age:"))
                    E_mail = input("enter your new email:")
                    Object.Update(s_no,id,name,gender,password,ph_no,age,E_mail)
                    pass
                elif(choice==6):
                    break
            except mysql.MyProject as error:
                print("Failed".format(error))

        elif(table==3):
            print('press 1 to describe table:')
            print('press 2 to insert new user')
            print('press 3 to display all user')
            print('press 4 to delete user')
            print('press 5 to update user')
            print('press 6 to quit')
            print()
            print()
            choice = int(input('enter the choice:'))
            try:
                if (choice == 1):
                    Object.DescribeTable1()
                    pass
                elif (choice == 2):
                    m_no = int(input("enter the new medicine number to be inserted:"))
                    name = input("enter the new name to be inserted:")
                    m_id = input("enter the new medicine id to be inserted:")
                    amount = int(input("enter the  price of medicine:"))
                    expiry= input("enter the expiry date of medine:")
                    manufacture = input("enter manufactury date of medicine:")
                    purpose = input("enter the purpose of this medicine:")
                    Object.Insert1(m_no, name, m_id, amount, expiry, manufacture, purpose)
                    pass
                elif(choice==3):
                    Object.ReadTable1()
                    pass
                elif(choice==4):
                    m_no=int(input("enter the medicine number is to be deleted:"))
                    Object.Delete1(m_no)
                    pass
                elif (choice == 5):
                    m_no = int(input("enter the medicine number to be updated:"))
                    name = input("enter the new name to be updated:")
                    m_id = input("enter the new medicine id to be updated:")
                    amount = int(input("enter the new price of medicine to be updated:"))
                    expiry = input("enter the new expiry of medicine:")
                    manufacture = input("enter the manufactury date:")
                    purpose = input("enter the purpose of this medicine:")
                    Object.Update1(m_no, name, m_id, amount, expiry, manufacture, purpose)
                    pass
                elif(choice==6):
                    break
            except mysql.MyProject as error:
                print("Failed".format(error))

        elif(table==4):
            print('press 1 to describe table:')
            print('press 2 to insert new user')
            print('press 3 to display all user')
            print('press 4 to delete user')
            print('press 5 to update user')
            print('press 6 to quit')
            print()
            print()
            choice = int(input('enter the choice:'))
            try:
                if (choice == 1):
                    Object.DescribeTable2()
                    pass
                elif (choice==2):
                    p_num = int(input("enter the new purchase number(serial number) to be inserted:"))
                    pur_no = input("enter the purchase number to be inserted:")
                    amount = int(input("enter the amount to be inserted:"))
                    discount = int(input("enter the  discount of the medicine:"))
                    total_amount = int(input("enter the total amount after discount that is to be inserted:"))
                    Object.Insert2(p_num,pur_no,amount,discount,total_amount)
                elif(choice==3):
                    Object.ReadTable2()
                    pass
                elif(choice==4):
                    p_num=int(input("enter the purchase number(serial number) is to be deleted:"))
                    Object.Delete2(p_num)
                    pass
                elif(choice==5):
                    p_num = int(input("enter the  purchase number(serial number) to be updated:"))
                    pur_no = input("enter the purchase number to be purchase:")
                    amount = int(input("enter the amount to be updated:"))
                    discount = int(input("enter the  discount of the medicine to be updated:"))
                    total_amount = int(input("enter the total amount after discount that is to be updated:"))
                    Object.Update2(p_num,pur_no,amount,discount,total_amount)
                elif(choice==6):
                    break
            except mysql.MyProject as error:
                print("Failed".format(error))

        elif(table==2):
            print('press 1 to describe table:')
            print('press 2 to insert new user')
            print('press 3 to display all user')
            print('press 4 to delete user')
            print('press 5 to update user')
            print('press 6 to quit')
            print()
            print()
            choice = int(input('enter the choice:'))
            try:
                if (choice == 1):
                    Object.DescribeTable3()
                    pass
                elif (choice == 2):
                    d_num = int(input("enter the new doctor number(serial number) to be inserted:"))
                    name = input("enter the name of the doctor is to be inserted:")
                    specilyst = input("enter the specilyst of the doctor:")
                    ph_no = input("enter the  phone number of the doctor:")
                    address = input("enter the address of the doctor to be inserted:")
                    Object.Insert3(d_num, name, specilyst, ph_no, address)
                elif (choice == 3):
                    Object.ReadTable3()
                    pass
                elif (choice == 4):
                    d_num = int(input("enter the doctor number(serial number) is to be deleted:"))
                    Object.Delete3(d_num)
                    pass
                elif (choice == 5):
                    d_num = int(input("enter the new doctor number(serial number) to be updated:"))
                    name = input("enter the new name of the doctor is to be updated:")
                    specilyst = input("enter the specilyst of the doctor:")
                    ph_no = input("enter the  phone number of the doctor:")
                    address = input("enter the address of the doctor to be updated:")
                    Object.Update3(d_num, name, specilyst, ph_no, address)
                elif (choice == 6):
                    break
            except mysql.MyProject as error:
                print("Failed".format(error))

        elif(table==1):
            print('press 1 to describe table:')
            print('press 2 to insert new user')
            print('press 3 to display all user')
            print('press 4 to delete user')
            print('press 5 to update user')
            print('press 6 to quit')
            print()
            print()
            choice = int(input('enter the choice:'))
            try:
                if (choice == 1):
                    Object.DescribeTable4()
                    pass
                elif (choice == 2):
                    o_num = int(input("enter the new order number(serial number) to be inserted:"))
                    user_id = int(input("enter the user id is to be inserted:"))
                    can_no = input("enter the cancellation number is to be inserted:")
                    Object.Insert4(o_num, user_id, can_no)
                    pass
                elif (choice == 3):
                    Object.ReadTable4()
                    pass
                elif (choice == 4):
                    o_num = int(input("enter the order number(serial number) is to be deleted:"))
                    Object.Delete4(o_num)
                    pass
                elif (choice == 5):
                    o_num = int(input("enter the new order number(serial number) to be inserted:"))
                    user_id = int(input("enter the user id is to be inserted:"))
                    can_no = input("enter the cancellation number is to be inserted:")
                    Object.Update4(o_num, user_id, can_no)
                    pass
                elif (choice == 6):
                    break
            except mysql.MyProject as error:
                print("Failed".format(error))

        elif(table==0):
            print('press 1 to describe table:')
            print('press 2 to insert new user')
            print('press 3 to display all user')
            print('press 4 to delete user')
            print('press 5 to update user')
            print('press 6 to quit')
            print()
            print()
            choice = int(input('enter the choice:'))
            try:
                if (choice == 1):
                    Object.DescribeTable5()
                    pass
                elif (choice == 2):
                    bill_no = int(input("enter the new bill number(serial number) to be inserted:"))
                    ord_no = input("enter the order number is to be inserted:")
                    total_amt = int(input("enter the total amount is to be inserted:"))
                    Object.Insert5(bill_no, ord_no, total_amt)
                    pass
                elif (choice == 3):
                    Object.ReadTable5()
                    pass
                elif (choice == 4):
                    bill_no = int(input("enter the bill number(serial number) is to be deleted:"))
                    Object.Delete5(bill_no)
                    pass
                elif (choice == 5):
                    bill_no = int(input("enter the new bill number(serial number) to be updated:"))
                    ord_no = input("enter the order number is to be updated:")
                    total_amt = int(input("enter the total amount is to be updated:"))
                    Object.Update5(bill_no, ord_no, total_amt)
                    pass
                elif (choice == 6):
                    break
            except mysql.MyProject as error:
                print("Failed".format(error))

        elif(table==11):
            print('press 1 to describe table:')
            print('press 2 to insert new user')
            print('press 3 to display all user')
            print('press 4 to delete user')
            print('press 5 to update user')
            print('press 6 to quit')
            print()
            print()
            choice = int(input('enter the choice:'))
            try:
                if (choice == 1):
                    Object.DescribeTable6()
                    pass
                elif (choice == 2):
                    s_code = input("enter the new supplier code number to be inserted:")
                    s_num = input("enter the supplier number is to be inserted:")
                    name = input("enter the supplier name is to be inserted:")
                    E_mail = input("enter the supplier Email:")
                    ph_no = input("enter the supplier phone number:")
                    Object.Insert6(s_code, s_num, name,E_mail,ph_no)
                    pass
                elif (choice == 3):
                    Object.ReadTable6()
                    pass
                elif (choice == 4):
                    s_code = input("enter the supplier code  is to be deleted:")
                    Object.Delete6(s_code)
                    pass
                elif (choice == 5):
                    s_code = input("enter the new supplier code number to be updated:")
                    s_num = input("enter the supplier number is to be updated:")
                    name = input("enter the supplier name is to be updated:")
                    E_mail = input("enter the supplier Email:")
                    ph_no = input("enter the supplier phone number:")
                    Object.Update6(s_code,s_num,name,E_mail,ph_no)
                    pass
                elif (choice == 6):
                    break
            except mysql.MyProject as error:
                print("Failed".format(error))

        elif(table==5):
            print('press 1 to describe table:')
            print('press 2 to insert new user')
            print('press 3 to display all user')
            print('press 4 to delete user')
            print('press 5 to update user')
            print('press 6 to quit')
            print()
            print()
            choice = int(input('enter the choice:'))
            try:
                if (choice == 1):
                    Object.DescribeTable7()
                    pass
                elif (choice == 2):
                    id = int(input("enter the new id number to be inserted:"))
                    M_id = input("enter the new medicine id is to be inserted:")
                    Object.Insert7(id,M_id)
                    pass
                elif (choice == 3):
                    Object.ReadTable7()
                    pass
                elif (choice == 4):
                    id = int(input("enter the id  is to be deleted:"))
                    Object.Delete7(id)
                    pass
                elif (choice == 5):
                    id = int(input("enter the new id number to be updated:"))
                    M_id = input("enter the new medicine id is to be updated:")
                    Object.Update7(id,M_id)
                    pass
                elif (choice == 6):
                    break
            except mysql.MyProject as error:
                print("Failed".format(error))

        elif(table==6):
            print('press 1 to describe table:')
            print('press 2 to insert new user')
            print('press 3 to display all user')
            print('press 4 to delete user')
            print('press 5 to update user')
            print('press 6 to quit')
            print()
            print()
            choice = int(input('enter the choice:'))
            try:
                if (choice == 1):
                    Object.DescribeTable8()
                    pass
                elif (choice == 2):
                    pur_no = input("enter the new purchase  number to be inserted:")
                    m_id = input("enter the new medicine id is to be inserted:")
                    Object.Insert8(pur_no, m_id)
                    pass
                elif (choice == 3):
                    Object.ReadTable8()
                    pass
                elif (choice == 4):
                    pur_no = input("enter the id  is to be deleted:")
                    Object.Delete8(pur_no)
                    pass
                elif (choice == 5):
                    pur_no = input("enter the new purchase number to be updated:")
                    m_id = input("enter the new medicine id is to be updated:")
                    Object.Update8(pur_no, m_id)
                    pass
                elif (choice == 6):
                    break
            except mysql.MyProject as error:
                print("Failed".format(error))

        elif(table==7):
            print('press 1 to describe table:')
            print('press 2 to insert new user')
            print('press 3 to display all user')
            print('press 4 to delete user')
            print('press 5 to update user')
            print('press 6 to quit')
            print()
            print()
            choice = int(input('enter the choice:'))
            try:
                if (choice == 1):
                    Object.DescribeTable9()
                    pass
                elif (choice == 2):
                    pur_no = input("enter the new purchase  number to be inserted:")
                    can_no = input("enter the new cancellation number is to be inserted:")
                    Object.Insert9(pur_no, can_no)
                    pass
                elif (choice == 3):
                    Object.ReadTable9()
                    pass
                elif (choice == 4):
                    pur_no = input("enter the purchase number  is to be deleted:")
                    Object.Delete9(pur_no)
                    pass
                elif (choice == 5):
                    pur_no = input("enter the new purchase number to be updated:")
                    can_no = input("enter the new Cancellation number is to be updated:")
                    Object.Update9(pur_no, can_no)
                    pass
                elif (choice == 6):
                    break
            except mysql.MyProject as error:
                print("Failed".format(error))

        elif(table==8):
            print('press 1 to describe table:')
            print('press 2 to insert new user')
            print('press 3 to display all user')
            print('press 4 to delete user')
            print('press 5 to update user')
            print('press 6 to quit')
            print()
            print()
            choice = int(input('enter the choice:'))
            try:
                if (choice == 1):
                    Object.DescribeTable10()
                    pass
                elif (choice == 2):
                    pur_no = input("enter the new purchase  number to be inserted:")
                    ord_no = input("enter the new order number is to be inserted:")
                    Object.Insert10(pur_no, ord_no)
                    pass
                elif (choice == 3):
                    Object.ReadTable10()
                    pass
                elif (choice == 4):
                    pur_no = input("enter the purchase number  is to be deleted:")
                    Object.Delete10(pur_no)
                    pass
                elif (choice == 5):
                    pur_no = input("enter the new purchase number to be updated:")
                    ord_no = input("enter the new order number is to be updated:")
                    Object.Update10(pur_no, ord_no)
                    pass
                elif (choice == 6):
                    break
            except mysql.MyProject as error:
                print("Failed".format(error))

        elif(table==9):
            print('press 1 to describe table:')
            print('press 2 to insert new user')
            print('press 3 to display all user')
            print('press 4 to delete user')
            print('press 5 to update user')
            print('press 6 to quit')
            print()
            print()
            choice = int(input('enter the choice:'))
            try:
                if (choice == 1):
                    Object.DescribeTable11()
                    pass
                elif (choice == 2):
                    o_no = input("enter the new order  number to be inserted:")
                    s_code = input("enter the new supplier code is to be inserted:")
                    Object.Insert11(o_no, s_code)
                    pass
                elif (choice == 3):
                    Object.ReadTable11()
                    pass
                elif (choice == 4):
                    o_no = input("enter the order number  is to be deleted:")
                    Object.Delete11(o_no)
                    pass
                elif (choice == 5):
                    o_no = input("enter the new order number to be updated:")
                    s_code = input("enter the new supplier code is to be updated:")
                    Object.Update11(o_no, s_code)
                    pass
                elif (choice == 6):
                    break
            except mysql.MyProject as error:
                print("Failed".format(error))


        elif(table==10):
            print('press 1 to describe table:')
            print('press 2 to insert new user')
            print('press 3 to display all user')
            print('press 4 to delete user')
            print('press 5 to update user')
            print('press 6 to quit')
            print()
            print()
            choice = int(input('enter the choice:'))
            try:
                if (choice == 1):
                    Object.DescribeTable12()
                    pass
                elif (choice == 2):
                    m_id = input("enter the new medicine id is to be inserted:")
                    d_num = int(input("enter the new doctor num(serial number) is to be inserted:"))
                    Object.Insert12(m_id, d_num)
                    pass
                elif (choice == 3):
                    Object.ReadTable12()
                    pass
                elif (choice == 4):
                    m_id = input("enter the medicine id  is to be deleted:")
                    Object.Delete12(m_id)
                    pass
                elif (choice == 5):
                    m_id = input("enter the new medicine id is to be updated:")
                    d_num = int(input("enter the new doctor number(serial number) is to be updated:"))
                    Object.Update12(m_id, d_num)
                    pass
                elif (choice == 6):
                    break
            except mysql.MyProject as error:
                print("Failed".format(error))
        else:
            print("There are 13 tables in the database ,so plz type from 1 to 13!!")

if __name__ == '__main__':
    Main()
