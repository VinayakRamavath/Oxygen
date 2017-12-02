// import { Observable } from 'rxjs/Rx';
import { Component, Injectable } from '@angular/core';
import { Http, Headers } from '@angular/http';
import { Observable } from 'rxjs/Observable';

import { Subject } from 'rxjs/Subject';


import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/do';
import 'rxjs/add/operator/filter';
import { LinksService } from './links.service';

@Injectable()
export class UserDetailsService {

  headers: any;
  // tmp json of users
  baseurl = this.linksService.userServiceLink;

  data: any;
  url: any;
  access_token: string;
  emailid: string;
  username: string;
  psaid: number;
  role: string;
  error: any;


  constructor(private _http: Http, private linksService: LinksService) {

  }

  setEmail(emailid: string) {
    this.emailid = emailid;
  }

  getEmail() {
    return this.emailid;
  }

  setToken(access_token: string) {
    this.access_token = access_token;
  }

  getToken() {
    return this.access_token;
  }

  setUserName(username: string) {
    this.username = username;
  }

  getUserName() {
    return this.username;
  }

  setPsaId(psaid: number) {
    this.psaid = psaid;
  }

  getPsaId() {
    return this.psaid;
  }

  setRoles(role: string) {
    this.role = role;
  }

  getRoles() {
    return this.role;

  }



  getuserdetails(): Observable<any> {

    this.headers = new Headers();

    this.headers.append('Authorization', 'Bearer ' + this.getToken());
    this.url = this.baseurl + this.getEmail();
    return this._http.get(this.url, { headers: this.headers })
      .map(response => {
        this.data = response.json();
        this.setUserName(this.data.username);
        this.setPsaId(this.data.psaid);
        this.setRoles(this.data.roles[0].rolename);
        return this.data;
      },
      err => {
        return Observable.throw(err);
      }
      );
  }

  isLoggedIn(): boolean {
    if (this.getEmail() != null && this.getToken() != null) {
      return true;
    } else {
      return false;
    }

  }



}
