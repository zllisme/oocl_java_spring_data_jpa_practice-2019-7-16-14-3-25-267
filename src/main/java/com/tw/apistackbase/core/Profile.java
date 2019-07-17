package com.tw.apistackbase.core;

import javax.persistence.*;

@Entity
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String registeredCapital;
    private String certId;

    public Profile(String registeredCapital, String certId) {
        this.registeredCapital = registeredCapital;
        this.certId = certId;
    }

    public Profile() {
    }

    public String getRegisteredCapital() {
        return registeredCapital;
    }

    public void setRegisteredCapital(String registeredCapital) {
        this.registeredCapital = registeredCapital;
    }

    public String getCertId() {
        return certId;
    }

    public void setCertId(String certId) {
        this.certId = certId;
    }
}
