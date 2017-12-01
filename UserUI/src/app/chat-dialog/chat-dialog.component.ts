import { Component, OnInit } from "@angular/core";
import { ChatService, Message } from "../chat.service";
import { Observable } from "rxjs/Observable";
// import { MaterialModule } from '@angular/material';
import "rxjs/add/operator/scan";

import { ElementRef, ViewChild } from "@angular/core";
import {
  FormGroup,
  FormControl,
  FormBuilder,
  Validators
} from "@angular/forms";
// import { AudioFileService } from "../../shared/_services/audio-file.service";
// import { NotificationService } from '../../shared/utils/notification.service';
// import { ConfigService } from '../../shared/utils/config.service';
import { Router } from "@angular/router";
import {
  Http,
  Response,
  Headers,
  RequestOptions,
  URLSearchParams
} from "@angular/http";
import { IWindow } from "./../webkit.component";
import "rxjs/add/operator/toPromise";
import { AudioService } from "../audio.service";

declare let $: any;
declare let recorderObject: any;

@Component({
  selector: "chat-dialog",
  templateUrl: "./chat-dialog.component.html",
  styleUrls: ["./chat-dialog.component.scss"]
})
export class ChatDialogComponent implements OnInit {
  messages: Observable<Message[]>;
  assertMe:boolean;
  breadcrum: string;
  dashboardIcon: string;
  audioIcon: string;
  vartext: string;
  value: string;
  data: any;
  i='1';
  message: string;
message2:string;
  constructor(public chat: ChatService, private service: AudioService) {}

  
  ngOnInit() {
    // appends to array after each new message is added to feedSource
    this.messages = this.chat.conversation
      .asObservable()
      .scan((acc, val) => acc.concat(val));
    this.checkformessage();
    
      
        $('#live-chat header').on('click', function() {
      
          $('.chat').slideToggle(300, 'swing');
          // $('.chat-message-counter').fadeToggle(300, 'swing');
      
        });
      
        $('.chat-close').on('click', function(e) {
      
          e.preventDefault();
          $('#live-chat').fadeOut(300);
      
        });


      //   $("#live-chat header").click(function(){
      //     if($(this).html() == "-"){
      //         $(this).html("+");
      //     }
      //     else{
      //         $(this).html("-");
      //     }
      //     $(".chat").slideToggle();
      //  });
      
    
  }

  

  checkformessage(){
    setTimeout(()=>{
      if(this.assertMe){
this.assertMe=false;
      }
      if(!this.assertMe){
        this.checkformessage();
      }
   }, 300);
  }

  sendMessage(formValue) {
    this.message = formValue;
    console.log(this.message);
    this.chat.converse(this.message);
  }
 


  startRecognition(): void {
    console.log("recording voice");
    let headers = new Headers({
      "Content-Type": "application/json",
      "Access-Control-Allow-Origin": "* hi"
    });
    let final_transcript = "";
    const { webkitSpeechRecognition }: IWindow = <IWindow>window;
    const recognition = new webkitSpeechRecognition();
    recognition.continuous = false;
    recognition.interimResults = false;
    recognition.lang = "en-GB";
    recognition.start();

    recognition.onstart = (event) => {

      console.log("event started");
    };
      recognition.onresult = (event) => {
        let interim_transcript = "";

        for (let i = event.resultIndex; i < event.results.length; ++i) {
          if (event.results[i].isFinal) {
            final_transcript += event.results[i][0].transcript;
          } else {
            interim_transcript += event.results[i][0].transcript;
          }
        }

        this.vartext = final_transcript;

        console.log(this.vartext);
      this.sendMessage(this.vartext);
      this.assertMe=true;
        // this.show(this.vartext);
      };

      
      // recognition.onend=function(){
        
      //   console.log(new Date(Date.now()));
      //   console.log('recogniton ended');
      //   console.log(this.vartext)
      //   this.message=this.vartext;
       
      //   this.message2="ananth";
      //   console.log(this.message2);
      //   console.log("i message",this.i)
      //   setTimeout(() =>{
      //     this.i='2';
      //     console.log(this.i);
      //   },1000)
        
      // };

      
      

    

  }

  
}
