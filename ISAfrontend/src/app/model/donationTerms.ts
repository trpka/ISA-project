interface DonationTermsInterface{
    id:number;
    LocalDateTime: Date;
    duration: number;
    isFree: boolean;
    reservationStart: Date;
    reservationEnd: Date;
    description:string;
    //bloodCenter:BloodCenter;
    // treba jos polja fali
}

export class DonationTerms implements DonationTermsInterface{
    id:number;
    LocalDateTime: Date;
    duration: number;
    isFree: boolean;
    reservationStart: Date;
    reservationEnd: Date;
    description:string;
    //bloodCenter:BloodCenter;

    constructor(obj:DonationTermsInterface){
        this.id=obj.id;
        this.LocalDateTime=obj.LocalDateTime;
        this.duration=obj.duration;
        this.reservationStart=obj.reservationStart;
        this.reservationEnd=obj.reservationEnd;
        this.description=obj.description;
        //this.bloodCenter = obj.bloodCenter;
    } 
} 