import { BooleanInput } from "@angular/cdk/coercion";
import { BloodCenter } from "./bloodCenter";
import { RegisteredUser } from "./registeredUser";
import { Calendar } from "./calendar";
import { Survey } from "./survey";

interface DonationTermsInterface{
    id:number;
    date: Date;
    duration: number;
    freeTerm: boolean;
    reservationStart: Date;
    reservationEnd: Date;
    bloodCenter: BloodCenter;
    registeredUser: RegisteredUser;
    registeredUserCome: boolean;
    calendar: Calendar;
    survey: Survey;
    user_gave_blood: boolean;
    //description:string;
    
    // treba jos polja fali
}

export class DonationTerms implements DonationTermsInterface{
    id:number;
    date: Date;
    duration: number;
    freeTerm: boolean;
    reservationStart: Date;
    reservationEnd: Date;
    bloodCenter: BloodCenter;
    registeredUser: RegisteredUser;
    registeredUserCome: boolean;
    calendar: Calendar;
    survey: Survey;
    user_gave_blood: boolean;

    //description:string;
    //bloodCenter:BloodCenter;

    constructor(obj:DonationTermsInterface){
        this.id=obj.id;
        this.date=obj.date;
        this.duration=obj.duration;
        this.freeTerm = obj.freeTerm;
        this.reservationStart=obj.reservationStart;
        this.reservationEnd=obj.reservationEnd;
        this.bloodCenter = obj.bloodCenter;
        this.registeredUser = obj.registeredUser;
        this.registeredUserCome = obj.registeredUserCome;
        this.calendar=obj.calendar;
        this.survey=obj.survey;
        this.user_gave_blood = obj.user_gave_blood;
        //this.description=obj.description;
        //this.bloodCenter = obj.bloodCenter;
    } 
} 