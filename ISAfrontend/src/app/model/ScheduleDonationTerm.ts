interface ScheduleDonationTermInterface{
    donationTermId:number;
    registeredUserId: number;
    surveyId:number;
}

export class ScheduleDonationTerm implements ScheduleDonationTermInterface{
    donationTermId:number;
    registeredUserId: number;
    surveyId:number;
    
    constructor(obj:ScheduleDonationTermInterface){
        this.donationTermId=obj.donationTermId;
        this.registeredUserId=obj.registeredUserId;
        this.surveyId=obj.surveyId;
    } 
} 
