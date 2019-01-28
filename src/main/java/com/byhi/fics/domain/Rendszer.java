package com.byhi.fics.domain;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "rendszer")
public class Rendszer {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name",columnDefinition="varchar2(32)", unique = true)
    private String name;

    @Column(name = "desc",columnDefinition="varchar2(2000)")
    private String desc;

    @OneToMany(mappedBy = "r_id", cascade = CascadeType.ALL)
    private Set<Modul> moduls;

    public Rendszer(String name, String desc) {
        this.name = name;
        this.desc = desc;
        this.moduls = new LinkedHashSet<Modul>();
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

    public Set<Modul> getModuls() {
        return moduls;
    }

    public void setModuls(Set<Modul> moduls) {
        this.moduls = moduls;
    }
}
