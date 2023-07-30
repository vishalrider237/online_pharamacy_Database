package com.entities;

import javax.persistence.*;

@Entity
@Table(name = "medicine")
public class Medicine {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int m_no;
    @Column(length = 30)
    private String name;
    @Id
    private String m_id;
    private int amount;
    @Column(length = 30)
    private String expiry;
    @Column(length = 30)
    private String manufacture;
    @Column(length = 100)
    private String purpose;

    public Medicine() {
    }

    public Medicine(int m_no,String name, String m_id, int amount, String expiry, String manufacture, String purpose) {
        this.m_no=m_no;
        this.name = name;
        this.m_id = m_id;
        this.amount = amount;
        this.expiry = expiry;
        this.manufacture = manufacture;
        this.purpose = purpose;

    }

    @Override
    public String toString() {
        return "Medicine{" +
                "m_no=" + m_no +
                ", name='" + name + '\'' +
                ", m_id='" + m_id + '\'' +
                ", amount=" + amount +
                ", expiry='" + expiry + '\'' +
                ", manufacture='" + manufacture + '\'' +
                ", purpose='" + purpose + '\'' +

                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getM_id() {
        return m_id;
    }

    public void setM_id(String m_id) {
        this.m_id = m_id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getExpiry() {
        return expiry;
    }

    public void setExpiry(String expiry) {
        this.expiry = expiry;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }


}
