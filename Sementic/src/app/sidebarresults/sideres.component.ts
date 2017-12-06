import { UrlRelation } from './urlrelation';
import { SocketService } from './socket.service';
import { Component, OnInit,Input } from '@angular/core';
import { DisplayService } from '../display.service';
import {MatTabsModule} from '@angular/material/tabs';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { Subscription } from 'rxjs';
import { Conceptdomain } from '../sidebardomain/conceptdomain';
import { FormControl } from '@angular/forms';
import { Observable } from 'rxjs/Observable';
import { startWith } from 'rxjs/operator/startWith';
import { map } from 'rxjs/operator/map';


@Component({
  selector: 'app-sideres',
  templateUrl: './sideres.component.html',
  styleUrls: ['./sideres.component.css']
})
export class SideResComponent implements OnInit {

  
  panelOpenState: boolean = false;
  searchdone: boolean= true;
  fetchedUrls;
  concept:any;
  domain:any;
  query1;
  scores:any[];
  intent:any="default";
  intentscore:any[]=[];
 anjali:boolean=false;
 inputfield:any;
  public serverResponse: UrlRelation[];
  busy: Subscription;
  showLoader: Boolean = false;
  query:any;
  correctedquery:any;
  text:any;
  noresults:any;
 flagJava:boolean=false;
 flagInvest:boolean=false;
  start:any;
  responseTime:any;
  respTime:boolean=false;
 var :Observable<string> = null;
  myControl: FormControl = new FormControl();
  filteredOptions: Observable<string[]>;

    options = [
    'one','two','three'
     ];
     
     step = 0;
     
       setStep(index: number) {
         this.step = index;
       }
     
       nextStep() {
         this.step++;
       }
     
       prevStep() {
         this.step--;
       }

  constructor(
    private route: ActivatedRoute,
    private router: Router,
 private usersApi:DisplayService,private _stompService: SocketService)  {
   
}


  ngOnInit() { 
    
    this.domain = this.route.snapshot.paramMap.get('domain');
    console.log(this.domain);
    if (this.domain=="java"){
    this.flagJava=true;}
    if (this.domain=="finance"){
    this.flagInvest=true;}

    this.filteredOptions = this.myControl.valueChanges
    .pipe(
      // startWith(''),
      // map(val => this.filter(val))
    );


  }

 filter(val: string): string[] {
    return this.options.filter(option =>
      option.toLowerCase().indexOf(val.toLowerCase()) === 0);
  }


  public send(query): void {
    
    this.start = Date.now();
    console.log(query)
    this.query1=query;
    this.serverResponse=null;
    this.correctedquery=null;
    this.text=null;
    this.noresults=null;
    if(query==""){
    this.showLoader=false;
    }
    else{
    this.showLoader=true;
    }
    this.searchdone = false;
    this.query=query;
    
    this.usersApi.postquery(query,this.intent).then((res)=>{
      
        // this.fetchedUrls = res;
        console.log(res);
      
    })
 
 
    this._stompService.sendMessage(query);
    this.busy = this._stompService.socketMessages.subscribe( data => {
      console.log("data"+data);
      
        console.log("INSIDE QUERY");
        
           this.serverResponse =data.result;
           this.intent=data.intent;
           this.concept=data.concept;
           this.respTime = true;
           if(this.serverResponse.length<1){
            this.respTime=false
            this.text="no results available for the query";
           }
           else{
             this.text="showing results for";
           this.correctedquery=data.correctedquery;
           this.noresults="About "+this.serverResponse.length+" results"
           
           }
           this.showLoader=false;
           console.log("serverresponse"+this.serverResponse)
           this.responseTime = Date.now() - this.start;
         });
         

    
    // this.anjali=false;
    // this.fake(query);
    console.log("SEND END");
    this.respTime = false;
  }

}




