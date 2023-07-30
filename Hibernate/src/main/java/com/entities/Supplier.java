package com.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "supplier")
public class Supplier {
    @Id
    @Column(name = "s_code",length = 25)
    private String s_code;
    @Column(name = "s_num",length = 25,nullable = false)
    private String s_num;
    @Column(name = "name",length = 25,nullable = false)
    private String name;
    @Column(name = "E_mail",length = 25,nullable = false)
    private String E_mail;
    @Column(name = "ph_no",length = 25)
    private String ph_no;

    public Supplier() {
    }

    public Supplier(String s_code, String s_num, String name, String e_mail, String ph_no) {
        this.s_code = s_code;
        this.s_num = s_num;
        this.name = name;
        E_mail = e_mail;
        this.ph_no = ph_no;
    }


    @Override
    public String toString() {
        return "Supplier{" +
                "s_code='" + s_code + '\'' +
                ", s_num='" + s_num + '\'' +
                ", name='" + name + '\'' +
                ", E_mail='" + E_mail + '\'' +
                ", ph_no='" + ph_no + '\'' +
                '}';
    }

    public String getS_num() {
        return s_num;
    }

    public void setS_num(String s_num) {
        this.s_num = s_num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getE_mail() {
        return E_mail;
    }

    public void setE_mail(String e_mail) {
        E_mail = e_mail;
    }

    public String getPh_no() {
        return ph_no;
    }

    public void setPh_no(String ph_no) {
        this.ph_no = ph_no;
    }
}
