package com.example.ISAproject.dto;

import com.example.ISAproject.model.Survey;

public class ScheduleDonationTerm1DTO {
    private Long donationTermId;
    private Long registeredUserId;
    private Survey survey;

    public Long getDonationTermId() {
        return donationTermId;
    }

    public void setDonationTermId(Long donationTermId) {
        this.donationTermId = donationTermId;
    }

    public Long getRegisteredUserId() {
        return registeredUserId;
    }

    public void setRegisteredUserId(Long registeredUserId) {
        this.registeredUserId = registeredUserId;
    }

    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    public ScheduleDonationTerm1DTO(Long donationTermId, Long registeredUserId, Survey survey) {
        this.donationTermId = donationTermId;
        this.registeredUserId = registeredUserId;
        this.survey = survey;
    }
    public ScheduleDonationTerm1DTO(){}
}
