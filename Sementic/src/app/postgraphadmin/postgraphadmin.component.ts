import { Component, OnInit } from '@angular/core';
import { DisplayService } from '../display.service';

@Component({
  selector: 'app-postgraphadmin',
  templateUrl: './postgraphadmin.component.html',
  styleUrls: ['./postgraphadmin.component.css']
})
export class PostgraphadminComponent implements OnInit {

  constructor(private usersApi:DisplayService) {}

  ngOnInit() {
  }

  post(){
    console.log("HI");
    this.usersApi.postintentdomain().then((data)=>{console.log(data),
  this.usersApi.getindexer().then((data)=>console.log(data)),
  this.usersApi.getparser().then((data)=>console.log(data))
    }
  );
    this.usersApi.postintentsearch().then((data)=>console.log(data));
    this.usersApi.getclear().then((data)=>console.log(data));
  }
}
