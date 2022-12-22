interface DefinedDonationTermsInterface{
    date:string;
    reservationStart:string;
    duration: number;
}

export class DefinedDonationTerms implements DefinedDonationTermsInterface{
    date:string;
    reservationStart:string;
    duration: number;

    constructor(obj:DefinedDonationTermsInterface){
        this.date=obj.date;
        this.reservationStart=obj.reservationStart;
        this.duration=obj.duration;
    } 
} 