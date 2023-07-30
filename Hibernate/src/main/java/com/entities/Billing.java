package com.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "billing")
public class Billing {
    @Column(name = "bill_no")
    private int bill_no;
    @Id
    @Column(name = "ord_no")
    private String ord_no;
    @Column(name = "total_amt")
    private int total_amt;

    public Billing() {
    }

    public Billing(int bill_no, String ord_no, int total_amt) {
        this.bill_no = bill_no;
        this.ord_no = ord_no;
        this.total_amt = total_amt;
    }

    public int getBill_no() {
        return bill_no;
    }

    public void setBill_no(int bill_no) {
        this.bill_no = bill_no;
    }

    public String getOrd_no() {
        return ord_no;
    }

    public void setOrd_no(String ord_no) {
        this.ord_no = ord_no;
    }

    public int getTotal_amt() {
        return total_amt;
    }

    public void setTotal_amt(int total_amt) {
        this.total_amt = total_amt;
    }
}
