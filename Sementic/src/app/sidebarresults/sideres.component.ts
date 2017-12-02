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
export class State {
  constructor(public name: string, public population: string, public flag: string) { }
}

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
  intent:any="default";
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
 

  constructor(
    private route: ActivatedRoute,
    private router: Router,
 private usersApi:DisplayService,private _stompService: SocketService)  {
}

  

  ngOnInit() {
    
    this.domain = this.route.snapshot.paramMap.get('domain');
    console.log(this.domain);
    if (this.domain=="java")
    this.flagJava=true;
    if (this.domain=="finance")
    this.flagInvest=true;
    

    


  }
 
  public send(query): void {
    this.start = new Date().getTime();
    console.log(query)
    this.concept=query;
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
           
         });
         

    this.responseTime = new Date().getTime() - this.start;
    // this.anjali=false;
    // this.fake(query);
    console.log("SEND END");
    this.respTime = false;
  }

}




