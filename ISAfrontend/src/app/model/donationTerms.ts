import { BloodCenter } from "./bloodCenter";

interface DonationTermsInterface{
    id:number;
    LocalDateTime: Date;
    duration: number;
    isFree: boolean;
    reservationStart: Date;
    reservationEnd: Date;
    bloodCenter: BloodCenter;
    //description:string;
    
    // treba jos polja fali
}

export class DonationTerms implements DonationTermsInterface{
    id:number;
    LocalDateTime: Date;
    duration: number;
    isFree: boolean;
    reservationStart: Date;
    reservationEnd: Date;
    bloodCenter: BloodCenter;
    //description:string;
    //bloodCenter:BloodCenter;

    constructor(obj:DonationTermsInterface){
        this.id=obj.id;
        this.LocalDateTime=obj.LocalDateTime;
        this.duration=obj.duration;
        this.isFree = obj.isFree;
        this.reservationStart=obj.reservationStart;
        this.reservationEnd=obj.reservationEnd;
        this.bloodCenter = obj.bloodCenter;
        //this.description=obj.description;
        //this.bloodCenter = obj.bloodCenter;
    } 
} 