package com.example.ISAproject.model;

import javax.persistence.*;

@Entity
public class StuffSurvey
{
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
    private String dateOfBirth;
    @Column
    private String address;
    @Column
    private String city;
    @Column
    private String mobile;

    @Column
    private String p1;
    @Column
    private String p2;
    @Column
    private String p3;
    @Column
    private String p4;
    @Column
    private String p5;
    @Column
    private String p6;
    @Column
    private String p7;
    @Column
    private String p8;

    private double A;
    private double B;
    private double AB;
    private double O;


    @OneToOne
    private DonationTerms donationTerms;


    public StuffSurvey(Long id, String numberOfDonator, String date, String firstName, String lastName,
                       String dateOfBirth, String address, String city, String mobile, String p1,
                       String p2, String p3, String p4, String p5, String p6, String p7,
                       String p8, DonationTerms donationTerms)
    {
        this.id = id;
        this.numberOfDonator = numberOfDonator;
        this.date = date;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.city = city;
        this.mobile = mobile;
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
        this.p5 = p5;
        this.p6 = p6;
        this.p7 = p7;
        this.p8 = p8;
        this.donationTerms = donationTerms;
    }

    public StuffSurvey(Long id,   String firstName,
                       String lastName, String dateOfBirth, String address, String city,
                       String mobile, String p1, String p2, String p3, String p4, String p5,
                       String p6, String p7, String p8)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.city = city;
        this.mobile = mobile;
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
        this.p5 = p5;
        this.p6 = p6;
        this.p7 = p7;
        this.p8 = p8;
    }
    //Konstruktor koji ce stvarno da treba
    public StuffSurvey(Long id, String p1, String p2, String p3, String p4, String p5, String p6,
                       String p7, String p8, double a, double b, double AB, double o,
                       DonationTerms donationTerms)
    {
        this.id = id;
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
        this.p5 = p5;
        this.p6 = p6;
        this.p7 = p7;
        this.p8 = p8;
        A = a;
        B = b;
        this.AB = AB;
        O = o;
        this.donationTerms = donationTerms;
    }

    public StuffSurvey()
    {
    }

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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getP5() {
        return p5;
    }

    public void setP5(String p5) {
        this.p5 = p5;
    }

    public String getP6() {
        return p6;
    }

    public void setP6(String p6) {
        this.p6 = p6;
    }

    public String getP7() {
        return p7;
    }

    public void setP7(String p7) {
        this.p7 = p7;
    }

    public String getP8() {
        return p8;
    }

    public void setP8(String p8) {
        this.p8 = p8;
    }

    public DonationTerms getDonationTerms() {
        return donationTerms;
    }

    public void setDonationTerms(DonationTerms donationTerms) {
        this.donationTerms = donationTerms;
    }



    public double getA() {
        return A;
    }

    public void setA(double a) {
        A = a;
    }

    public double getB() {
        return B;
    }

    public void setB(double b) {
        B = b;
    }

    public double getAB() {
        return AB;
    }

    public void setAB(double AB) {
        this.AB = AB;
    }

    public double getO() {
        return O;
    }

    public void setO(double o) {
        O = o;
    }
}
