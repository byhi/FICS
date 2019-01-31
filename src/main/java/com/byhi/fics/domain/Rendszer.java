package com.byhi.fics.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "rendszer")
public class Rendszer {
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

    @OneToMany(mappedBy = "r_id", cascade = CascadeType.ALL)
    private Set<Modul> moduls;

    public Rendszer(String name, String desc) {
        this.name = name;
        this.desc = desc;
        this.moduls = new LinkedHashSet<Modul>();
    }

    public Rendszer() {
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

    @Override
    public String toString() {
        return "Rendszer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
