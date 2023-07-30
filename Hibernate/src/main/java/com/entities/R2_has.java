package com.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "r2_has")
public class R2_has {
    @Column(name = "pur_no",length = 25)
    private String pur_no;
    @Id
    @Column(name = "m_id",length = 25)
    private String m_id;

    public R2_has() {
    }

    public R2_has(String pur_no, String m_id) {
        this.pur_no = pur_no;
        this.m_id = m_id;
    }

    public String getPur_no() {
        return pur_no;
    }

    public void setPur_no(String pur_no) {
        this.pur_no = pur_no;
    }

    public String getM_id() {
        return m_id;
    }

    public void setM_id(String m_id) {
        this.m_id = m_id;
    }
}
