package com.ifacture.beans;


import com.ifacture.outils.Other;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "t_pays", schema = Other.DATEBASE_NAME)
public class Pays implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "label")
    private String label;

    public Pays() {
    }

    public Pays(String id, String label) {
        this.id = id;
        this.label = label;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "Pays{" +
                "id='" + id + '\'' +
                ", label='" + label + '\'' +
                '}';
    }
}
