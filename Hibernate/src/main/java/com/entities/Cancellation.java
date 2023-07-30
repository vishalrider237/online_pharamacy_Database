package com.entities;

import javax.persistence.*;

@Entity
@Table(name = "cancellation")
public class Cancellation {
    private int o_num;
    @Column(name = "user_id")
    private int user_id;
    @Id
    @Column(name = "can_no")
    private String can_no;
   /* @OneToOne(mappedBy = "cancellation")
    private User_Registration userRegistration;*/

    public Cancellation() {
    }

    public Cancellation(int o_num, int user_id, String can_no) {
        this.o_num = o_num;
        this.user_id = user_id;
        this.can_no = can_no;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getCan_no() {
        return can_no;
    }

    public void setCan_no(String can_no) {
        this.can_no = can_no;
    }


}
