interface SurveyInterface{
    id:number;
    numberOfDonator: string;
    date: string;
    firstName: string;
    lastName: string;
    jmbg: string;
    dateOfBirth:string;
    sex:string;
    adress:string;
    township: string ;
    city:string;
    mobile:string;
    company:string;
    profession: string;
    numberOfBoodDonations: string;
    //answers : [];
}

export class Survey implements SurveyInterface{
    id:number;
    numberOfDonator: string;
    date: string;
    firstName: string;
    lastName: string;
    jmbg: string;
    dateOfBirth:string;
    sex:string;
    adress:string;
    township: string ;
    city:string;
    mobile:string;
    company:string;
    profession: string;
    numberOfBoodDonations: string;
    //answers : [];

    constructor(obj:SurveyInterface){
        this.id=obj.id;
        this.numberOfDonator=obj.numberOfDonator;
        this.date=obj.date;
        this.firstName=obj.firstName;
        this.lastName=obj.lastName;
        this.jmbg=obj.jmbg;
        this.dateOfBirth = obj.dateOfBirth;
        this.sex = obj.sex;
        this.adress = obj.adress;
        this.township=obj.township;
        this.city=obj.city;
        this.mobile = obj.mobile;
        this.company = obj.company;
        this.profession = obj.profession;
        this.numberOfBoodDonations=obj.numberOfBoodDonations;
        //this.answers = obj.answers;
    } 
}