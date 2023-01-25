import { BloodCenter } from "./bloodCenter";
import { Calendar } from "./calendar";
import { RegisteredUser } from "./registeredUser";
import { Survey } from "./survey";


interface DefinedDonationTermsInterface{
    date:string;
    reservationStart:string;
    reservationEnd:string;
    free: boolean;
    duration: number;
    registeredUser: RegisteredUser;
    calendar: Calendar;
    bloodCenter: BloodCenter;
    survey:Survey;
}

export class DefinedDonationTerms implements DefinedDonationTermsInterface{
    date:string;
    reservationStart:string;
    reservationEnd:string;
    free:boolean;
    duration: number;
    registeredUser: RegisteredUser;
    calendar:Calendar;
    bloodCenter: BloodCenter;
    survey:Survey;

    constructor(obj:DefinedDonationTermsInterface){
        this.date=obj.date;
        this.reservationStart=obj.reservationStart;
        this.reservationEnd=obj.reservationEnd;
        this.free=obj.free;
        this.duration=obj.duration;
        this.registeredUser=obj.registeredUser;
        this.calendar=obj.calendar;
        this.bloodCenter=obj.bloodCenter;
        this.survey=obj.survey;
    } 
} 