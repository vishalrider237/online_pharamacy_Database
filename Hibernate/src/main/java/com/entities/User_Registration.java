package com.entities;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user_registration")
public class User_Registration {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private int s_no;
    @Id
    private int id;
    @Column(length = 25)
    private String name;
    @Column(length = 25)
    private String gender;
    @Column(length = 20)
    private String password;
    @Column(length = 25)
    private String ph_no;
    private int age;
    @Column(length = 50)
    private String E_mail;
    /*@OneToOne(mappedBy = "userRegistration")
    private Cancellation cancellation;*/
    public User_Registration(int s_no, int id, String name, String gender, String password, String ph_no, int age, String e_mail) {
        this.s_no = s_no;
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.password = password;
        this.ph_no = ph_no;
        this.age = age;
        E_mail = e_mail;

    }

   /* public User_Registration(int id, String name, String gender, String password, String ph_no, int age, String e_mail, Cancellation cancellation) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.password = password;
        this.ph_no = ph_no;
        this.age = age;
        E_mail = e_mail;
        this.cancellation = cancellation;
    }

    public Cancellation getCancellation() {
        return cancellation;
    }

    public void setCancellation(Cancellation cancellation) {
        this.cancellation = cancellation;
    }*/

    public User_Registration() {

    }

    @Override
    public String toString() {
        return "User_Registration{" +
                "s_no=" + s_no +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", password='" + password + '\'' +
                ", ph_no='" + ph_no + '\'' +
                ", age=" + age +
                ", E_mail='" + E_mail + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPh_no() {
        return ph_no;
    }

    public void setPh_no(String ph_no) {
        this.ph_no = ph_no;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getE_mail() {
        return E_mail;
    }

    public void setE_mail(String e_mail) {
        E_mail = e_mail;
    }


}
