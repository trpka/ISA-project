import { DefinedDonationTerms } from "./definedDonationTerms";
import { DonationTerms } from "./donationTerms";
import { RegisteredUser } from "./registeredUser";
import { Survey } from "./survey";

interface SurveyStuffInterface {

    id : number;
    Survey: Survey;
    donationTerms: DonationTerms;
    
   
    blood_type: string;
    accepted_exam: string;
    blood_quantity : number;
    
    extra_note: string;
    reason_ejection: string;
    arm: string;

    donation_type: string;
    dedication_type: string;

    heart_and_lungs: string;
    hemoglobin: string;

}

export class StuffSurvey implements SurveyStuffInterface
{
    id: number;
    Survey: Survey;
    donationTerms: DonationTerms;
   
    blood_type: string;
    accepted_exam: string;
    blood_quantity: number;

    extra_note: string;
    reason_ejection: string;
    arm: string;

    donation_type: string;
    dedication_type: string;

    heart_and_lungs: string;
    hemoglobin: string;

    constructor(obj:SurveyStuffInterface)
    {
   
    this.id = obj.id;
    this.Survey = obj.Survey;
    this.donationTerms = obj.donationTerms;
   
  
    this.blood_type = obj.blood_type;
    this.accepted_exam = obj.accepted_exam;
    this.blood_quantity = obj.blood_quantity;

    this.extra_note = obj.extra_note;
    this.reason_ejection = obj.reason_ejection;
    this.arm = obj.arm;

    this.donation_type = obj.donation_type;
    this.dedication_type = obj.dedication_type;

    this.heart_and_lungs = obj.heart_and_lungs;
    this.hemoglobin = obj.hemoglobin;
    

    }
    
}