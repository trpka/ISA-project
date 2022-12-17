package com.example.ISAproject.dto;

public class SurveyRegisteredUserDTO {

    private Long surveyId;
    private Long registeredUserId;

    public Long getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(Long surveyId) {
        this.surveyId = surveyId;
    }

    public Long getRegisteredUserId() {
        return registeredUserId;
    }

    public void setRegisteredUserId(Long registeredUserId) {
        this.registeredUserId = registeredUserId;
    }

    public SurveyRegisteredUserDTO(Long surveyId, Long registeredUserId) {
        this.surveyId = surveyId;
        this.registeredUserId = registeredUserId;
    }

    public SurveyRegisteredUserDTO() {}

}
