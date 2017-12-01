import { Http } from '@angular/http'; 
import { Injectable, OnInit } from '@angular/core'; 
import { StompService } from 'ng2-stomp-service'; 
import { SocketMessage } from './socket-message'; 
import { Observable } from 'rxjs/Rx';
import { Subject }    from 'rxjs/Subject'; 
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/toPromise';
import { UrlRelation } from './urlrelation';
import { ListUrls } from './listurls';
@Injectable()
export class SocketService {
 stompClient:any;
 socketMessageSource = new Subject<ListUrls>();
 socketUrl = 'http://13.126.183.132:3000/gs-guide-websocket';
 socket: any;
 messageSubscription:any;
 socketMessage: String = "Default";
 socketMessages = this.socketMessageSource.asObservable();
 numberSubscription:any;
 socketNumber:number;
 nameSubscription : any;
 taskNames : Array<String> = [];
 socketNameSource = new Subject<String>();
 socketNames = this.socketNameSource.asObservable();
constructor(
   private http:Http,
   private stomp: StompService) {  
   this.connect();
 } 
 
connect(){
 this.stomp.configure({
   host: this.socketUrl,
   debug: true,
   queue: {'init': false}
 });
 this.stomp.startConnect().then(() => {
   this.stomp.done('init');
  //  this.subscribe();
 });
}
subscribe(message:any){
 if(this.messageSubscription != null)
       this.messageSubscription.unsubscribe();
 
    this.messageSubscription = this.stomp.subscribe('/topic/greetings/'+message,(response:ListUrls) => {
       let temp = response;
       this.socketMessageSource.next(temp);
       console.log(temp);
     });
 
}
sendMessage(message: any) {
   let socketMessage = new SocketMessage(message);
   console.log(message);
   this.stomp.send('/app/hello/'+message,{"name":message});
   this.subscribe(message);
 }
disconnect(){
   this.stomp.send('/app/hello',{"message":"logout notification"});
   this.stomp.disconnect().then(() => {
     console.log( 'Connection closed' )
   });
 }
}











// import { Http } from '@angular/http'; 
// import { Injectable, OnInit } from '@angular/core'; 
// import { StompService } from 'ng2-stomp-service'; 
// import { SocketMessage } from './socket-message'; 
// import { Observable } from 'rxjs/Rx';
// import { Subject }    from 'rxjs/Subject'; 
// import 'rxjs/add/operator/map';
// import 'rxjs/add/operator/catch';
// import 'rxjs/add/operator/toPromise';
// import { UrlRelation } from './urlrelation';
// import { ListUrls } from './listurls';
// @Injectable()
// export class SocketService {
//  stompClient:any;
//  socketMessageSource = new Subject<UrlRelation[]>();
//  socketUrl = 'http://172.23.238.157:8088/gs-guide-websocket';
//  socket: any;
//  messageSubscription:any;
//  socketMessage: String = "Default";
//  socketMessages = this.socketMessageSource.asObservable();
//  numberSubscription:any;
//  socketNumber:number;
//  nameSubscription : any;
//  taskNames : Array<String> = [];
//  socketNameSource = new Subject<String>();
//  socketNames = this.socketNameSource.asObservable();
// constructor(
//    private http:Http,
//    private stomp: StompService) {  
//    this.connect();
//  } 
// connect(){
//  this.stomp.configure({
//    host: this.socketUrl,
//    debug: true,
//    queue: {'init': false}
//  });
//  this.stomp.startConnect().then(() => {
//    this.stomp.done('init');
//    this.subscribe();
//  });
// }
// subscribe(){
//  if(this.messageSubscription != null)
//        this.messageSubscription.unsubscribe();
 
//     this.messageSubscription = this.stomp.subscribe('/topic/greetings',(response:ListUrls) => {
//        let temp = response.result;
//        this.socketMessageSource.next(temp);
//        console.log("temp"+temp);
//      });
 
// }

// sendMessage(message: any) {
//    let socketMessage = new SocketMessage(message);
//    console.log(message);
//    this.stomp.send('/app/hello',{"name":message});
//    this.subscribe();
//  }
// disconnect(){
//    this.stomp.send('/app/hello',{"message":"logout notification"});
//    this.stomp.disconnect().then(() => {
//      console.log( 'Connection closed' )
//    });
//  }
// }
