package com.byhi.fics.dao;

public class SystemUnit {
    Long modulid;
    String systemname;
    String systemdisc;
    String modulname;
    String moduldisc;

    public SystemUnit(Long modulid, String systemname, String systemdisc, String modulname, String moduldisc) {
        this.modulid = modulid;
        this.systemname = systemname;
        this.systemdisc = systemdisc;
        this.modulname = modulname;
        this.moduldisc = moduldisc;
    }

    public SystemUnit() {
    }

    public Long getModulid() {
        return modulid;
    }

    public void setModulid(Long modulid) {
        this.modulid = modulid;
    }

    public String getSystemname() {
        return systemname;
    }

    public void setSystemname(String systemname) {
        this.systemname = systemname;
    }

    public String getSystemdisc() {
        return systemdisc;
    }

    public void setSystemdisc(String systemdisc) {
        this.systemdisc = systemdisc;
    }

    public String getModulname() {
        return modulname;
    }

    public void setModulname(String modulname) {
        this.modulname = modulname;
    }

    public String getModuldisc() {
        return moduldisc;
    }

    public void setModuldisc(String moduldisc) {
        this.moduldisc = moduldisc;
    }
}
