import { Survey } from "./survey";

interface ScheduleDonationTerm1Interface{
    donationTermId:number;
    registeredUserId: number;
    survey:Survey;
}

export class ScheduleDonationTerm1 implements ScheduleDonationTerm1Interface{
    donationTermId:number;
    registeredUserId: number;
    survey:Survey;
    
    constructor(obj:ScheduleDonationTerm1Interface){
        this.donationTermId=obj.donationTermId;
        this.registeredUserId=obj.registeredUserId;
        this.survey=obj.survey;
    } 
} 
