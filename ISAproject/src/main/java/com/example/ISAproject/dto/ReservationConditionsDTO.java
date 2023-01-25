package com.example.ISAproject.dto;

public class ReservationConditionsDTO {

    private boolean banGaveBlood;
    private boolean banPenalties;

    public boolean isBanGaveBlood() {
        return banGaveBlood;
    }

    public void setBanGaveBlood(boolean banGaveBlood) {
        this.banGaveBlood = banGaveBlood;
    }

    public boolean isBanPenalties() {
        return banPenalties;
    }

    public void setBanPenalties(boolean banPenalties) {
        this.banPenalties = banPenalties;
    }

    public ReservationConditionsDTO(boolean banGaveBlood, boolean banPenalties) {
        this.banGaveBlood = banGaveBlood;
        this.banPenalties = banPenalties;
    }

    public ReservationConditionsDTO() {

    }


}
