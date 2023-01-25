interface ReservationConditionsInterface{
    banGaveBlood:boolean;
    banPenalties: boolean;
    
}

export class ReservationConditions implements ReservationConditionsInterface{
    banGaveBlood:boolean;
    banPenalties: boolean;
    
    constructor(obj:ReservationConditionsInterface){
        this.banGaveBlood=obj.banGaveBlood;
        this.banPenalties=obj.banPenalties;
    } 
} 
