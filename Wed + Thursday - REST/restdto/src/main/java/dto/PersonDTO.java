/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.Person;

/**
 *
 * @author mattg
 */
public class PersonDTO {

    private int id;
    private String fName;
    private String lName;
    private String phone;
    private String street;
    private String zip;
    private String city;

    public PersonDTO(Person p) {
        this.id = p.getId();
        this.fName = p.getfName();
        this.lName = p.getlName();
        this.phone = p.getPhone();
    }

    public PersonDTO(String fn, String ln, String phone, String street, String zip, String city) {
        this.fName = fn;
        this.lName = ln;
        this.phone = phone;
        this.street = street;
        this.zip = zip;
        this.city = city;
    }

    public PersonDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
