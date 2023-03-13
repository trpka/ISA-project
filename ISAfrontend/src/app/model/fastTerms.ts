import { BloodCenter } from "./bloodCenter";
import { Calendar } from "./calendar";
import { RegisteredUser } from "./registeredUser";
import { Stuff } from "./stuff";
import { Survey } from "./survey";


interface AddFastDonationTermsInterface{
    date:string;
    reservationStart:string;
    reservationEnd:string;
    free: boolean;
    duration: number;
    registeredUser: RegisteredUser;
    calendar: Calendar;
    bloodCenter: BloodCenter;
    survey:Survey;
    stuff: Stuff;
    
}

export class AddFastDonationTerms implements AddFastDonationTermsInterface{
    date:string;
    reservationStart:string;
    reservationEnd:string;
    free:boolean;
    duration: number;
    registeredUser: RegisteredUser;
    calendar:Calendar;
    bloodCenter: BloodCenter;
    survey:Survey;
    stuff: Stuff;
    

    constructor(obj:AddFastDonationTermsInterface){
        this.date=obj.date;
        this.reservationStart=obj.reservationStart;
        this.reservationEnd=obj.reservationEnd;
        this.free=obj.free;
        this.duration=obj.duration;
        this.registeredUser=obj.registeredUser;
        this.calendar=obj.calendar;
        this.bloodCenter=obj.bloodCenter;
        this.survey=obj.survey;
        this.stuff = obj.stuff;
        
    } 
} 