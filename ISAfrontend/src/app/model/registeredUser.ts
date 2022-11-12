interface RegisteredUserInterface{
    id:number;
    username: string ;
    password: string ;
    firstName: string;
    lastName: string;
    email: string;
    mobile:string;
    adress: string;
    city: string;
    state: string;
    jmbg: string;
    sex:string;
    profession:string;
    organizationInformation:string;
    enabled:boolean;
    //fali
    
}
export class RegisteredUser implements RegisteredUserInterface{
    id:number;
    username: string ;
    password: string ;
    firstName: string;
    lastName: string;
    email: string;
    mobile:string;
    adress: string;
    city: string;
    state: string;
    jmbg: string;
    sex:string;
    profession:string;
    organizationInformation:string;
    enabled:boolean;
    //fali

    constructor(obj:RegisteredUserInterface){
        this.id=obj.id;
        this.username=obj.username;
        this.password=obj.password;
        this.firstName=obj.firstName;
        this.lastName=obj.lastName;
        this.email=obj.email;
        this.mobile = obj.mobile;
        this.adress=obj.adress;
        this.city=obj.city;
        this.state=obj.state;
        this.jmbg=obj.jmbg;
        this.sex=obj.sex;
        this.profession=obj.profession;
        this.organizationInformation=obj.organizationInformation;
        this.enabled = obj.enabled;
  
    } 
}