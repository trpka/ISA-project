import { DonationTerms } from '../model/donationTerms';

interface CalendarInterface{
    id:number;
    listOfDefinedTerms: DonationTerms[];
}


export class Calendar implements CalendarInterface{
    id:number;
    listOfDefinedTerms: DonationTerms[];

    constructor(obj:CalendarInterface){
        this.id=obj.id;
        this.listOfDefinedTerms = obj.listOfDefinedTerms;
    } 
} 