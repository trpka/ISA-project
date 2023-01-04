import { BloodCenter } from "./bloodCenter";
import { Calendar } from "./calendar";


interface DefinedDonationTermsInterface{
    date:string;
    reservationStart:string;
    reservationEnd:string;
    duration: number;
    calendar: Calendar;
    bloodCenter: BloodCenter;
}

export class DefinedDonationTerms implements DefinedDonationTermsInterface{
    date:string;
    reservationStart:string;
    reservationEnd:string;
    duration: number;
    calendar:Calendar;
    bloodCenter: BloodCenter;

    constructor(obj:DefinedDonationTermsInterface){
        this.date=obj.date;
        this.reservationStart=obj.reservationStart;
        this.reservationEnd=obj.reservationEnd;
        this.duration=obj.duration;
        this.calendar=obj.calendar;
        this.bloodCenter=obj.bloodCenter;
    } 
} 