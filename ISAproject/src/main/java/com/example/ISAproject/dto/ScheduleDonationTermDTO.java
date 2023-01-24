package com.example.ISAproject.dto;

import com.example.ISAproject.model.RegisteredUser;

public class ScheduleDonationTermDTO {
    private Long donationTermId;
    private Long registeredUserId;
    private Long surveyId;

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

    public Long getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(Long surveyId) {
        this.surveyId = surveyId;
    }


    public ScheduleDonationTermDTO(Long donationTermId, Long registeredUserId, Long surveyId) {
        this.donationTermId = donationTermId;
        this.registeredUserId = registeredUserId;
        this.surveyId = surveyId;
    }

    public ScheduleDonationTermDTO() {}
}
