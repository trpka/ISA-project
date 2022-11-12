import { BooleanInput } from "@angular/cdk/coercion";
import { BloodCenter } from "./bloodCenter";

interface DonationTermsInterface{
    id?:number;
    date: Date;
    duration: number;
    free: boolean;
    reservationStart: Date;
    reservationEnd: Date;
    bloodCenter: BloodCenter;
    //description:string;
    
    // treba jos polja fali
}

export class DonationTerms implements DonationTermsInterface{
    id?:number;
    date: Date;
    duration: number;
    free: boolean;
    reservationStart: Date;
    reservationEnd: Date;
    bloodCenter: BloodCenter;
    //description:string;
    //bloodCenter:BloodCenter;

    constructor(obj:DonationTermsInterface){
        this.id=obj.id;
        this.date=obj.date;
        this.duration=obj.duration;
        this.free = obj.free;
        this.reservationStart=obj.reservationStart;
        this.reservationEnd=obj.reservationEnd;
        this.bloodCenter = obj.bloodCenter;
        //this.description=obj.description;
        //this.bloodCenter = obj.bloodCenter;
    } 
} 