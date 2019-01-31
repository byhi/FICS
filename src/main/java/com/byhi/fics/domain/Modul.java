package com.byhi.fics.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "modul")
public class Modul {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "id")
    private Long id;

    @Size(max=32)
    @Column(name = "name", columnDefinition = "varchar2", unique = true)
    private String name;
    @Size(max=2000)
    @Column(name = "desc", columnDefinition = "varchar2")
    private String desc;

    @ManyToOne
    @JoinColumn
    private Rendszer r_id;

    public Modul(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public Modul() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Rendszer getR_id() {
        return r_id;
    }

    public void setR_id(Rendszer r_id) {
        this.r_id = r_id;
    }

    @Override
    public String toString() {
        return "Modul{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", r_id=" + r_id +
                '}';
    }
}
