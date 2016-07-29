package com.wavemaker.hibernate.pojos;

import com.sun.jndi.cosnaming.IiopUrl;

import javax.persistence.*;

/**
 * Created by venkateswarluk on 28/7/16.
 */
@Entity
@Table(name = "address")
public class Address {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int aid;

    private String street;
    private String state;
    private String city;


    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
