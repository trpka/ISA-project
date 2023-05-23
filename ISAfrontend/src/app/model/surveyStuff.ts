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

    purposed_donation: string;
    donation_type: string;
    

    baso4_level: string;
    checked_heart_lunges: string;
    user_gave_blood: boolean;

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

    purposed_donation: string;
    donation_type: string;
    

    baso4_level: string;
    checked_heart_lunges: string;
    user_gave_blood: boolean;

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

    this.purposed_donation = obj.purposed_donation;
    this.donation_type = obj.donation_type;
    
    this.checked_heart_lunges = obj.checked_heart_lunges;
    this.baso4_level = obj.baso4_level;
    this.user_gave_blood = obj.user_gave_blood;
    

    }
    
}