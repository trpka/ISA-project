import { BloodCenter } from "./bloodCenter";

interface StuffInterface{
    id:number;
    username: string ;
    password: string ;
    email: string;
    firstName: string;
    lastName: string;
    mobile:string;
    enabled:boolean;
    //fali
    bloodCenter: BloodCenter;
    firstLogin: boolean;
    
}
export class Stuff implements StuffInterface{
    id:number;
    firstName: string;
    lastName: string;
    email: string;
    username: string ;
    password: string ;
    mobile:string;
    enabled:boolean;
    bloodCenter: BloodCenter;
    firstLogin: boolean;

    constructor(obj:StuffInterface){
        this.id=obj.id;
        this.firstName=obj.firstName;
        this.lastName=obj.lastName;
        this.email=obj.email;
        this.username=obj.username;
        this.password=obj.password;
        this.mobile = obj.mobile;
        this.enabled = obj.enabled;
        this.bloodCenter = obj.bloodCenter;
        this.firstLogin = obj.firstLogin;
  
    } 
}