
import { Router } from '@angular/router';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Component } from '@angular/core';
import { MatDialog, MatTooltip } from '@angular/material';
import 'rxjs/add/operator/map';
import { AuthenticationService } from '../auth/authentication.service';

@Component({
    selector: 'app-register',
    templateUrl: './register.component.html',
    styleUrls: ['./register.component.css']
})
export class RegisterComponent {
     registerForm: FormGroup;

    private emailRegex = '[a-zA-Z0-9.]+@cgi.com';
    private passwordRegex = '^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[#$@!%&*?])[A-Za-z0-9#$@!%&*?]{8,60}$';
    private json: string;
    private data: any;
     registrationsuccessful= false;
     registrationfailed=  false;



    constructor(formbuilder: FormBuilder,
      private _authenticationservice: AuthenticationService,
      private router: Router, public dialog: MatDialog) {
        this.registerForm = formbuilder.group({
          
            'name' : [null, Validators.compose([Validators.required])],
            'email': [null, Validators.compose([Validators.required, Validators.pattern(this.emailRegex)])],
            'password': [null, Validators.compose([Validators.required, Validators.pattern(this.passwordRegex)])]

        });

    }
    private submitForm(value: any) {

        this.json = this.jsonstringify(value);

        this._authenticationservice.register(this.json)
            .subscribe( response => {
                this.data = response;

                if (this.data) {
                    this.registrationsuccessful = true;
                }
                if (!this.data) {
                  this.registrationfailed = true;
                }
                if (this.registrationsuccessful) {
                  setTimeout(() => {
                    this.router.navigate(['login']);
                    this.registerForm.reset();
                  }, 3000);
            }


            }
        );

    }
    private jsonstringify(value: any): string {

        return JSON.stringify({
            'username': value.name,
            'password': value.password,
            'email': value.email,
            'roles': [
                {
                    'rolename': 'ROLE_USER'
                }
            ]
        });


    }
}


