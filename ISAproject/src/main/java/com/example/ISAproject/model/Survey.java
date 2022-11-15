package com.example.ISAproject.model;

import javax.persistence.*;

@Entity
public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String numberOfDonator;
    @Column
    private String date;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String jmbg;
    @Column
    private String dateOfBirth;
    @Column
    private String sex;
    @Column
    private String adress;
    @Column
    private String township;
    @Column
    private String city;
    @Column
    private String mobile;
    @Column
    private String company;
    @Column
    private String profession;
    @Column
    private String numberOfBoodDonations;
    @Column
    private String p1;
    @Column
    private String p2;
    @Column
    private String p3;
    @Column
    private String p4;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumberOfDonator() {
        return numberOfDonator;
    }

    public void setNumberOfDonator(String numberOfDonator) {
        this.numberOfDonator = numberOfDonator;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getTownship() {
        return township;
    }

    public void setTownship(String township) {
        this.township = township;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getNumberOfBoodDonations() {
        return numberOfBoodDonations;
    }

    public void setNumberOfBoodDonations(String numberOfBoodDonations) {
        this.numberOfBoodDonations = numberOfBoodDonations;
    }

    public String getP1() {
        return p1;
    }

    public void setP1(String p1) {
        this.p1 = p1;
    }

    public String getP2() {
        return p2;
    }

    public void setP2(String p2) {
        this.p2 = p2;
    }

    public String getP3() {
        return p3;
    }

    public void setP3(String p3) {
        this.p3 = p3;
    }

    public String getP4() {
        return p4;
    }

    public void setP4(String p4) {
        this.p4 = p4;
    }

    public Survey(Long id, String numberOfDonator, String date, String firstName, String lastName, String jmbg, String dateOfBirth, String sex, String adress, String township, String city, String mobile, String company, String profession, String numberOfBoodDonations, String p1, String p2, String p3, String p4) {
        this.id = id;
        this.numberOfDonator = numberOfDonator;
        this.date = date;
        this.firstName = firstName;
        this.lastName = lastName;
        this.jmbg = jmbg;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.adress = adress;
        this.township = township;
        this.city = city;
        this.mobile = mobile;
        this.company = company;
        this.profession = profession;
        this.numberOfBoodDonations = numberOfBoodDonations;
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
    }

    public Survey() {}
}
