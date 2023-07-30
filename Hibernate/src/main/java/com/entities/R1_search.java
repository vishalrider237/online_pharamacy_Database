package com.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "r1_search")
public class R1_search {
    @Id
    private int id;
    @Column(name = "M_id",length = 25)
    private String M_id;

    public R1_search() {
    }

    public R1_search(int id, String m_id) {
        this.id = id;
        M_id = m_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getM_id() {
        return M_id;
    }

    public void setM_id(String m_id) {
        M_id = m_id;
    }
}
