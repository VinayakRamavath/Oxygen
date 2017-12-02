export  class UserProfile  {
    
    firstName:String ;
    lastName:String ;
    phoneNumber:number ;
    email:String ;
    age:number ;
    address:String ;
    pincode:number ;
    maritalStatus:String ;
    spouseName:String ;
    numberOfKids:number ;
    
    constructor(fisrtName:String,lastName:String ,phoneNumber:number,email:String,age:number,address:String,pincode:number,maritalStatus:String,
    spouseName:String,numberOfKids:number,)
    {
        this.firstName = fisrtName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.age = age;
        this.address = address;
        this.pincode = pincode;
        this.maritalStatus = maritalStatus;
        this.spouseName = spouseName;
        this.numberOfKids = numberOfKids;
    }
}