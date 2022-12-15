interface ScheduleDonationTermInterface{
    donationTermId:number;
    registeredUserId: number;
}

export class ScheduleDonationTerm implements ScheduleDonationTermInterface{
    donationTermId:number;
    registeredUserId: number;
    
    constructor(obj:ScheduleDonationTermInterface){
        this.donationTermId=obj.donationTermId;
        this.registeredUserId=obj.registeredUserId;
    } 
} 
