package com.entities;

import javax.persistence.*;

@Entity
@Table(name = "doctor")
public class Doctor {
    @Id
    private int d_num;
    @Column(name = "name",length = 25)
    private String name;
    @Column(name = "specilyst",length = 25)
    private String specilyst;
    @Column(name = "ph_no",length = 25)
    private String ph_no;
    @Column(name = "address",length = 25)
    private String address;

    public Doctor() {
    }

    public Doctor(int d_num,String name, String specilyst, String ph_no, String address) {
        this.d_num=d_num;
        this.name = name;
        this.specilyst = specilyst;
        this.ph_no = ph_no;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "d_num=" + d_num +
                ", name='" + name + '\'' +
                ", specilyst='" + specilyst + '\'' +
                ", ph_no='" + ph_no + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecilyst() {
        return specilyst;
    }

    public void setSpecilyst(String specilyst) {
        this.specilyst = specilyst;
    }

    public String getPh_no() {
        return ph_no;
    }

    public void setPh_no(String ph_no) {
        this.ph_no = ph_no;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
