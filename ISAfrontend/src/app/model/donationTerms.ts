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
        //this.description=obj.description;
        //this.bloodCenter = obj.bloodCenter;
    } 
} 