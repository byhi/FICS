package com.byhi.fics.domain;

import javax.persistence.*;

@Entity
@Table(name = "modul")
public class Modul {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name",columnDefinition="varchar2(32)", unique = true)
    private String name;

    @Column(name = "desc",columnDefinition="varchar2(2000)")
    private String desc;

    @ManyToOne
    @JoinColumn
    private Rendszer r_id;

    public Modul(String name, String desc) {
        this.name = name;
        this.desc = desc;
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
}
