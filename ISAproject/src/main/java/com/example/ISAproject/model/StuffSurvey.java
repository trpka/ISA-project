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
    @Column
    private String purposed_donation;
    @Column
    private String donation_type;
    @Column
    private String baso4_level;
    @Column
    private String checked_heart_lunges;
    @Column
    private boolean user_gave_blood;


    @OneToOne
    private DonationTerms donationTerms;

    public StuffSurvey(Long id, double a, double b, double AB, double o, String blood_type, String accepted_exam,
                       double blood_quantity, String extra_note, String reason_ejection, String arm, String purposed_donation,
                       String donation_type, String baso4_level, String checked_heart_lunges, boolean user_gave_blood,
                       DonationTerms donationTerms)
    {
        this.id = id;
        A = a;
        B = b;
        this.AB = AB;
        O = o;
        this.blood_type = blood_type;
        this.accepted_exam = accepted_exam;
        this.blood_quantity = blood_quantity;
        this.extra_note = extra_note;
        this.reason_ejection = reason_ejection;
        this.arm = arm;
        this.purposed_donation = purposed_donation;
        this.donation_type = donation_type;
        this.baso4_level = baso4_level;
        this.checked_heart_lunges = checked_heart_lunges;
        this.user_gave_blood = false;
        this.donationTerms = donationTerms;
    }

    public StuffSurvey(Long id, double a, double b, double AB, double o, String blood_type, String accepted_exam,
                       double blood_quantity, String extra_note, String reason_ejection, String arm, String purposed_donation,
                       String donation_type, String baso4_level, String checked_heart_lunges, DonationTerms donationTerms)
    {
        this.id = id;
        A = a;
        B = b;
        this.AB = AB;
        O = o;
        this.blood_type = blood_type;
        this.accepted_exam = accepted_exam;
        this.blood_quantity = blood_quantity;
        this.extra_note = extra_note;
        this.reason_ejection = reason_ejection;
        this.arm = arm;
        this.purposed_donation = purposed_donation;
        this.donation_type = donation_type;
        this.baso4_level = baso4_level;
        this.checked_heart_lunges = checked_heart_lunges;
        this.donationTerms = donationTerms;
    }

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

    public String getPurposed_donation() {
        return purposed_donation;
    }

    public void setPurposed_donation(String purposed_donation) {
        this.purposed_donation = purposed_donation;
    }

    public String getDonation_type() {
        return donation_type;
    }

    public void setDonation_type(String donation_type) {
        this.donation_type = donation_type;
    }

    public String getBaso4_level() {
        return baso4_level;
    }

    public void setBaso4_level(String baso4_level) {
        this.baso4_level = baso4_level;
    }

    public String getChecked_heart_lunges() {
        return checked_heart_lunges;
    }

    public void setChecked_heart_lunges(String checked_heart_lunges) {
        this.checked_heart_lunges = checked_heart_lunges;
    }

    public boolean isUser_gave_blood() {
        return user_gave_blood;
    }

    public void setUser_gave_blood(boolean user_gave_blood) {
        this.user_gave_blood = user_gave_blood;
    }
}
