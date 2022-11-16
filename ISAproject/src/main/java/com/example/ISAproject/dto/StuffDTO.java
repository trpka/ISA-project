package com.example.ISAproject.dto;

import com.example.ISAproject.model.BloodCenter;

public class StuffDTO {
    private Long id;
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String mobile;
    private String adress;
    private String city;
    private String state;
    private String jmbg;
    private String sex;
    private String profession;
    private String organizationInformation;
    private String role;
    private boolean isFirstLogin;
    private BloodCenter bloodCenter;

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public void setOrganizationInformation(String organizationInformation) {
        this.organizationInformation = organizationInformation;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setFirstLogin(boolean firstLogin) {
        isFirstLogin = firstLogin;
    }

    public void setBloodCenter(BloodCenter bloodCenter) {
        this.bloodCenter = bloodCenter;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMobile() {
        return mobile;
    }

    public String getAdress() {
        return adress;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getJmbg() {
        return jmbg;
    }

    public String getSex() {
        return sex;
    }

    public String getProfession() {
        return profession;
    }

    public String getOrganizationInformation() {
        return organizationInformation;
    }

    public String getRole() {
        return role;
    }

    public boolean isFirstLogin() {
        return isFirstLogin;
    }

    public BloodCenter getBloodCenter() {
        return bloodCenter;
    }

    public StuffDTO(Long id, String username, String password, String email, String firstName, String lastName, String mobile, String adress, String city, String state, String jmbg, String sex, String profession, String organizationInformation, String role, boolean isFirstLogin, BloodCenter bloodCenter) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobile = mobile;
        this.adress = adress;
        this.city = city;
        this.state = state;
        this.jmbg = jmbg;
        this.sex = sex;
        this.profession = profession;
        this.organizationInformation = organizationInformation;
        this.role = role;
        this.isFirstLogin = isFirstLogin;
        this.bloodCenter = bloodCenter;
    }

    public StuffDTO() {
    }
}
