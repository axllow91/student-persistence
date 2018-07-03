package com.mrn.students.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class AbstractStudent {
    @Column(name="country")
    protected String country;
    @Column(name="zip_code")
    protected int zipCode;

    public AbstractStudent() {
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }
}
