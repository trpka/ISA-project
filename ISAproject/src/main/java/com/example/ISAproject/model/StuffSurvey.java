package com.example.ISAproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class StuffSurvey
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double A;
    private double B;
    private double AB;
    private double O;
    @Column
    private String blood_type;
    @Column
    private String accepted_exam;
    @Column
    private double blood_quantity;
    @Column
    private String extra_note;
    @Column
    private String reason_ejection;
    @Column
    private String arm;



    @OneToOne
    private DonationTerms donationTerms;


    public StuffSurvey(Long id, double a, double b, double AB, double o, String blood_type, String accepted_exam,
                       double blood_quantity, String extra_note, String reason_ejection, String arm, DonationTerms donationTerms) {
        this.id = id;
        this.A = a;
        this.B = b;
        this.AB = AB;
        this.O = o;
        this.blood_type = blood_type;
        this.accepted_exam = accepted_exam;
        this.blood_quantity = blood_quantity;
        this.extra_note = extra_note;
        this.reason_ejection = reason_ejection;
        this.arm = arm;
        this.donationTerms = donationTerms;
    }

    public StuffSurvey(Long id, double a, double b, double AB, double o, String blood_type, String accepted_exam,
                       double blood_quantity, String extra_note, String reason_ejection, String arm) {
        this.id = id;
        this.A = a;
        this.B = b;
        this.AB = AB;
        this.O = o;
        this.blood_type = blood_type;
        this.accepted_exam = accepted_exam;
        this.blood_quantity = blood_quantity;
        this.extra_note = extra_note;
        this.reason_ejection = reason_ejection;
        this.arm = arm;
    }


    public StuffSurvey(Long id,  DonationTerms donationTerms)
    {
        this.id = id;
        this.donationTerms = donationTerms;
    }

    //Konstruktor koji ce stvarno da treba
    public StuffSurvey(Long id,  double a, double b, double AB, double o,
                       DonationTerms donationTerms)
    {
        this.id = id;
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

    public String getBlood_type() {
        return blood_type;
    }

    public void setBlood_type(String blood_type) {
        this.blood_type = blood_type;
    }

    public String getAccepted_exam() {
        return accepted_exam;
    }

    public void setAccepted_exam(String accepted_exam) {
        this.accepted_exam = accepted_exam;
    }

    public double getBlood_quantity() {
        return blood_quantity;
    }

    public void setBlood_quantity(double blood_quantity) {
        this.blood_quantity = blood_quantity;
    }

    public String getExtra_note() {
        return extra_note;
    }

    public void setExtra_note(String extra_note) {
        this.extra_note = extra_note;
    }

    public String getReason_ejection() {
        return reason_ejection;
    }

    public void setReason_ejection(String reason_ejection) {
        this.reason_ejection = reason_ejection;
    }

    public String getArm() {
        return arm;
    }

    public void setArm(String arm) {
        this.arm = arm;
    }
}
