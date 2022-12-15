package com.example.ISAproject.dto;

import com.example.ISAproject.model.RegisteredUser;

public class ScheduleDonationTermDTO {
    private Long donationTermId;
    private Long registeredUserId;

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
    /* public RegisteredUser getRegisteredUserId() {
        return registeredUserId;
    }

    public void setRegisteredUserId(Long registeredUserId) {
        this.registeredUserId = registeredUserId;
    }*/

    public ScheduleDonationTermDTO(Long donationTermId, Long registeredUserId) {
        this.donationTermId = donationTermId;
        this.registeredUserId = registeredUserId;
    }
    public ScheduleDonationTermDTO() {}
}
