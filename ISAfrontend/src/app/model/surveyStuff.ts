import { DonationTerms } from "./donationTerms";
import { RegisteredUser } from "./registeredUser";

interface SurveyStuffInterface {
    id: number;
    numberOfDonator: string;
    date: string;
    firstName: string;
    lastName: string;
    dateOfBirth: string;
    sex: string;
    address: string;
    city: string;
    mobile: string;
    p1: string;
    p2: string;
    p3: string;
    p4: string;
    p5: string;
    p6: string;
    p7: string;
    p8: string;
    //donationTerm: DonationTerms;
    bloodA: number;
    bloodB: number;
    bloodAB: number;
    bloodO: number;

}

export class StuffSurvey implements SurveyStuffInterface
{
    id: number;
    numberOfDonator: string;
    date: string;
    firstName: string;
    lastName: string;
    dateOfBirth: string;
    sex: string;
    address: string;
    city: string;
    mobile: string;
    p1: string;
    p2: string;
    p3: string;
    p4: string;
    p5: string;
    p6: string;
    p7: string;
    p8: string;
   donationTerm: DonationTerms;
    bloodA: number;
    bloodB: number;
    bloodAB: number;
    bloodO: number;

    constructor(obj:SurveyStuffInterface)
    {
    this.id=obj.id;
    this.numberOfDonator=obj.numberOfDonator;
    this.date=obj.date;
    this.firstName=obj.firstName;
    this.lastName=obj.lastName;
    this.dateOfBirth = obj.dateOfBirth;
    this.sex = obj.sex;
    this.address=obj.address;
    this.city=obj.city;
    this.mobile= obj.mobile;
    this.p1= obj.p1;
    this.p2= obj.p2;
    this.p3= obj.p3;
    this.p4= obj.p4;
    this.p5= obj.p5;
    this.p6= obj.p6;
    this.p7= obj.p7;
    this.p8= obj.p8;
    //this.donationTerm= obj.donationTerm;
    this.bloodA = obj.bloodA;
    this.bloodB = obj.bloodB;
    this.bloodAB = obj.bloodAB;
    this.bloodO = obj.bloodO;

    }
    
}