import { SocketService } from './../sidebarresults/socket.service';
import { UrlRelation } from './../sidebarresults/urlrelation';
import { Component, OnInit,Input } from '@angular/core';
import { DisplayService } from '../display.service';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { Conceptdomain } from './conceptdomain';
@Component({
  selector: 'app-sidebardomain',
  templateUrl: './sidebardomain.component.html',
  styleUrls: ['./sidebardomain.component.css']
})
export class SidebarDomainComponent implements OnInit {

   
  @Input() fetchedUrls;
  domain:any;
  concept:any;
  anjali:any;
  showLoader:Boolean=false;
  alert;
  alert1;
  javaconcepts:Conceptdomain[];
  financeconcepts:Conceptdomain[];
  registrationsuccessful:Boolean=false;
  registrationsuccessful1:Boolean=false;
  public inputField = '<enter some text>!';
  public serverResponse: UrlRelation[];
  java;
  finance;
  constructor(private _stompService: SocketService,
    private route: ActivatedRoute,
    private router: Router,
private usersApi:DisplayService) { }
  
  ngOnInit() {
    
    this.loadconcepts();
  }


  loadconcepts(){
    this.usersApi.getjava().then((res)=>{
      
      this.javaconcepts=res;
      if(this.javaconcepts.length>0){
      console.log("java"+this.javaconcepts);
    this.java=true;  
    }

   })

   this.usersApi.getfinance().then((res)=>{
    
    this.financeconcepts=res;
    if(this.financeconcepts.length>0){
    console.log("finance"+this.financeconcepts);
      this.finance=true;
  }
 })
  }

  onClick(domain:any,concept:any) {
    this.showLoader=true;
console.log("VALUES")
console.log(domain);
console.log(concept)
    this.usersApi.postquery1(domain,concept).then((res)=>{
     
        // this.fetchedUrls = res;
        console.log(res);
        this.alert=res;
        this.registrationsuccessful=true;
        this.showLoader=false;
    this.loadconcepts();
    })
  }

  onClickUrl(domain:any,concept:any,url:any) {
    this.showLoader=true;
console.log("VALUES")
console.log(domain);
console.log(concept)
console.log(url)
    this.usersApi.posturl(domain,concept,url).then((res)=>{
     
        // this.fetchedUrls = res;
        console.log(res);
        this.alert1=res;
        this.registrationsuccessful1=true;
        this.showLoader=false;
       
    })
  }
  
}
