import { Stuff } from '../model/stuff';


interface BloodCenterInterface{
    id:number;
    centerName: string;
    address: string;
    city: string;
    startWork: string;
    endWork: string;
    description:string;
    averageGradeCentre:number;
    bloodA:number;
    bloodB: number ;
    bloodAB:number;
    bloodO:number;
    //freeAppointments:DonationTerms[];
    listOfStuffs: Stuff[];
}

export class BloodCenter implements BloodCenterInterface{
    id:number;
    centerName: string;
    address: string;
    city: string;
    startWork: string;
    endWork: string;
    description:string;
    averageGradeCentre:number;
    bloodA:number;
    bloodB: number ;
    bloodAB:number;
    bloodO:number;
    //freeAppointments:DonationTerms[];
    listOfStuffs: Stuff[];

    constructor(obj:BloodCenterInterface){
        this.id=obj.id;
        this.centerName=obj.centerName;
        this.address=obj.address;
        this.city=obj.city;
        this.startWork=obj.startWork;
        this.endWork=obj.endWork;
        this.description = obj.description;
        this.averageGradeCentre = obj.averageGradeCentre;
        this.bloodA = obj.bloodA;
        this.bloodB=obj.bloodB;
        this.bloodAB=obj.bloodAB;
        this.bloodO = obj.bloodO;
        this.listOfStuffs = obj.listOfStuffs;
    } 
} 
