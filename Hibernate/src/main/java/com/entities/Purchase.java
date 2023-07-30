package com.entities;

import javax.persistence.*;

@Entity
@Table(name = "purchase")
public class Purchase {
    private int p_num;
    @Id
    @Column(name = "pur_no",length = 25)
    private String pur_no;
    @Column(name = "amount")
    private int amount;
    @Column(name = "discount")
    private int discount;
    @Column(name = "total_amount")
    private int total_amount;

    public Purchase() {
    }

    public Purchase(int p_num,String pur_no, int amount, int discount, int total_discount) {
        this.p_num=p_num;
        this.pur_no = pur_no;
        this.amount = amount;
        this.discount = discount;
        this.total_amount = total_discount;
    }

    public String getPur_no() {
        return pur_no;
    }

    public void setPur_no(String pur_no) {
        this.pur_no = pur_no;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getTotal_discount() {
        return total_amount;
    }

    public void setTotal_discount(int total_discount) {
        this.total_amount = total_discount;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "p_num=" + p_num +
                ", pur_no='" + pur_no + '\'' +
                ", amount=" + amount +
                ", discount=" + discount +
                ", total_discount=" + total_amount +
                '}';
    }
}
