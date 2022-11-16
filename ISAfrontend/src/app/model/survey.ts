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
    p1:string;
    p2:string;
    p3:string;
    p4:string;
    p5:string;
    p6:string;
    p7:string;
    p8:string;
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
    p1:string;
    p2:string;
    p3:string;
    p4:string;
    p5:string;
    p6:string;
    p7:string;
    p8:string;
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
        this.p1=obj.p1;
        this.p2=obj.p2;
        this.p3=obj.p3;
        this.p4=obj.p4;
        this.p5=obj.p5;
        this.p6=obj.p6;
        this.p7=obj.p7;
        this.p8=obj.p8;
        //this.answers = obj.answers;
    } 
}