import { NgForm, FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs/Observable';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import { AuthenticationService } from '../auth/authentication.service';
import { UserDetailsService } from '../auth/userdetails.service';
import { Component } from '@angular/core';


@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SigninComponent {

  loginForm: FormGroup;
  data: any;
  emailRegex = '[a-zA-Z0-9.]+@cgi.com';
  passwordRegex = '^.+$';
  failedlogin = false;
  hide= false;
  constructor(formbuilder: FormBuilder,
      private _authenticationservice: AuthenticationService,
      private router: Router,
      private _userservice: UserDetailsService,
      // private chatService: ChatService,
      // private navService: NavigationService,
      // private searchService: SearchService,
      private route: ActivatedRoute
      ) {
      this.loginForm = formbuilder.group({
          'email': [null, Validators.compose([Validators.required, Validators.pattern(this.emailRegex)])],
          'password': [null, Validators.compose([Validators.required, Validators.pattern(this.passwordRegex)])]
      });
      console.log(this.route);
      console.log(this.route.snapshot.routeConfig.path);

  }

  ngOnInit() {
    window.history.pushState( {} , 'Home', '/final' );
    window.history.pushState( {} , 'login', '/login' ); }

  submitForm(value: any) {
      this._authenticationservice.login(value)
          .subscribe( response => {
              this.data = response;
              if (this.data) {
                  this.getDetails();
              }
              
          },
          err => {
              this.data = err.json();
              this.failedlogin = true;
              return Observable.throw(err.error);
          }
      );

  }


  getDetails() {

    setTimeout(() => {

      this._userservice.getuserdetails()
      .subscribe( response => {
        this.data = response;
          console.log(this.data);
          let email = this._userservice.getEmail();
     
          this.router.navigate(['sidebardomain']);
      },
      err => {
        this.data = err.json();

      }

     );

    }, 500);

  }




}
