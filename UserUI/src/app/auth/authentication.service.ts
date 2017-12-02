 import { LinksService } from './links.service';
import { Component, Injectable } from '@angular/core';
import { Http, Headers } from '@angular/http';
import { Observable } from 'rxjs/Observable';

import { Subject } from 'rxjs/Subject';
import {UserDetailsService} from './userdetails.service'



import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/do';
import 'rxjs/add/operator/filter';



@Injectable()
export class AuthenticationService {
    headers: any;
    baseurl = this.linksService.authServiceLink;
    url: any;
    data: any;
    error: any;

   constructor(private http: Http, private _userservice: UserDetailsService,
                private linksService: LinksService
    ) {}

   login(body: any) {
        this.headers = new Headers();
        this.headers.append('Content-Type', 'application/x-www-form-urlencoded');
        this.headers.append('Authorization', 'Basic ' + btoa('my-trusted-client:secret'));
        this.url = this.baseurl + '/oauth/token?' + 'grant_type=password&username=' + body.email + '&password=' + body.password;
    console.log('inside auth service');
       return this.http.post(this.url, null, { headers: this.headers })
            .map(response => {
                this.data = response.json();
                if (this.data.access_token != null) {
                    this._userservice.setToken(this.data.access_token);
                    this._userservice.setEmail(body.email);
                    localStorage.setItem('currentUser', JSON.stringify(this.data.access_token));
                    localStorage.setItem('UserId', body.email);
                    return true;
                } else {
                    return false;
                }
            },
            err => {
                this.error = err.json();
                return Observable.throw(err.error);
            }

        );

    }



   register(json: any) {
        this.headers = new Headers();
         this.headers.append('Content-Type', 'application/json');
        this.headers.append('Authorization', 'Basic ' + btoa('my-trusted-client:secret'));
        this.url = this.baseurl + '/register';

       return this.http.post(this.url, json, { headers: this.headers })
            .map(response => {
                this.data = response;
                if (this.data._body === 'New user created.') {
                    return true;
                }
                if (this.data._body === 'User Already Exists') {
                  return false;
                }
            },
            err => {
                Observable.throw(err);
            }
        );
    }

   logout() {
        this.headers = new Headers();
        this.headers.append('Content-Type', 'application/x-www-form-urlencoded');
        this.headers.append('Authorization', 'Bearer ' + this._userservice.getToken());
        console.log(this._userservice.getToken());
        this.url = this.baseurl + '/logout';
       return this.http.get(this.url, { headers: this.headers })
            .map(response => {
                this.data = response;
                console.log(this.data);
                if (this.data._body === 'Access token revoked') {
                  this._userservice.setToken(null);
                  this._userservice.setUserName(null);
                  this._userservice.setEmail(null);
                  this._userservice.setPsaId(null);
                  this._userservice.setRoles(null);
                  localStorage.removeItem('currentUser');
                  console.log(this._userservice.getUserName());
                    return true;
                } else {
                    return false;
                }
            },
            err => {
                return Observable.throw(err);
            }
        );
    }
}
